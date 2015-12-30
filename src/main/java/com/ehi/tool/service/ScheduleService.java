package com.ehi.tool.service;

import com.ehi.tool.domain.*;
import com.ehi.tool.dao.JobInfoDAO;
import com.ehi.tool.job.JobFactory;
import org.quartz.*;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleService.class);
    private static final String ACTIVE_JOB = "1";

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private JobInfoDAO jobDetailDAO;

    public void scheduleBuild() {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        List<JobInfo> jobInfoList = jobDetailDAO.getJobDetails();

        try {
            for (JobInfo jobInfo : jobInfoList) {
                TriggerKey triggerKey = TriggerKey.triggerKey(jobInfo.getJobName(), jobInfo.getJobGroup());

                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

                if (null == trigger) {
                    createTrigger(scheduler, jobInfo);
                } else {
                    updateTrigger(scheduler, trigger, triggerKey, jobInfo);
                }
            }
        } catch (SchedulerException e) {
            LOG.error("ScheduleService.scheduleBuild error: " + e.getMessage());
        }
    }

    private void createTrigger(Scheduler scheduler, JobInfo jobInfo) throws SchedulerException {
        if (!ACTIVE_JOB.equals(jobInfo.getJobStatus())) {
            return;
        }

        JobDetail jobDetail = JobBuilder.newJob(JobFactory.class)
                .withIdentity(jobInfo.getJobName(), jobInfo.getJobGroup()).build();
        jobDetail.getJobDataMap().put("jobInfo", jobInfo);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo
                .getCronExpression());

        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobInfo.getJobName(), jobInfo.getJobGroup()).withSchedule(scheduleBuilder).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    private void updateTrigger(Scheduler scheduler, CronTrigger trigger, TriggerKey triggerKey, JobInfo jobInfo) throws SchedulerException {
        if (!ACTIVE_JOB.equals(jobInfo.getJobStatus())) {
            JobKey jobKey = JobKey.jobKey(jobInfo.getJobName(), jobInfo.getJobGroup());
            scheduler.deleteJob(jobKey);
        }

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobInfo
                .getCronExpression());

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                .withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }

}
