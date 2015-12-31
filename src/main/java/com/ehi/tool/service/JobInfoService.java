package com.ehi.tool.service;

import com.ehi.tool.dao.JobInfoDAO;
import com.ehi.tool.domain.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobInfoService {

    @Autowired
    private JobInfoDAO jobInfoDAO;

    public List<JobInfo> getJobDetails() {
        return jobInfoDAO.getJobDetails();
    }

    public JobInfo getJobBoId(Integer jobId) {
        return jobInfoDAO.getJobById(jobId);
    }
}
