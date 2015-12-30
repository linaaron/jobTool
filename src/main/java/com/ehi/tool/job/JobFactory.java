package com.ehi.tool.job;

import com.ehi.tool.domain.JobInfo;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@DisallowConcurrentExecution
public class JobFactory implements org.quartz.Job {
    private static final Logger LOG = LoggerFactory.getLogger(JobFactory.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobInfo JobInfo = (JobInfo) context.getMergedJobDataMap().get("jobInfo");
        LOG.info("job begin = [" + JobInfo.getJobName() + "]");
        try {
            Class<?> taskJob = Class.forName(JobInfo.getTargetObject());
            Method[] methods = taskJob.getMethods();
            for (Method method : methods) {
                if (method.getName().equals(JobInfo.getTargetMethod())) {
                    method.invoke(taskJob.newInstance(), null);
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            LOG.error("JobFactory.execute error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            LOG.error("JobFactory.execute error: " + e.getMessage());
        } catch (InvocationTargetException e) {
            LOG.error("JobFactory.execute error: " + e.getMessage());
        } catch (InstantiationException e) {
            LOG.error("JobFactory.execute error: " + e.getMessage());
        }
        LOG.info("job end = [" + JobInfo.getJobName() + "]");
    }
}
