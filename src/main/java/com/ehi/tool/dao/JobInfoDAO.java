package com.ehi.tool.dao;

import com.ehi.tool.domain.JobInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobInfoDAO {
    List<JobInfo> getJobDetails();
    JobInfo getJobById(@Param("jobId") Integer jobId);
}
