package com.ehi.tool.service;

import com.ehi.tool.dao.JobInfoDAO;
import com.ehi.tool.domain.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class JobInfoService {

    @Autowired
    private JobInfoDAO jobInfoDAO;

    public List<JobInfo> getJobDetails() {
        return jobInfoDAO.getJobDetails();
    }

    public JobInfo getJobBoId(String jobId) {
        return jobInfoDAO.getJobById(jobId);
    }

    public boolean saveJob(JobInfo jobInfo) {
        try {
            if (StringUtils.isEmpty(jobInfo.getJobId())) {
                jobInfo.setJobId(UUID.randomUUID().toString());
                jobInfoDAO.createJob(jobInfo);
            } else {
                jobInfoDAO.updateJob(jobInfo);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delJob(String jobId) {
        try {
            jobInfoDAO.delJob(jobId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
