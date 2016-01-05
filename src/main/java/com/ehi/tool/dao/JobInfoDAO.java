package com.ehi.tool.dao;

import com.ehi.tool.domain.JobInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobInfoDAO {
    List<JobInfo> getJobDetails();

    JobInfo getJobById(@Param("jobId") String jobId);

    void createJob(JobInfo jobInfo);

    void updateJob(JobInfo jobInfo);

    void delJob(@Param("jobId") String jobId);
}
