package com.ehi.tool.controller;

import com.ehi.tool.domain.JobInfo;
import com.ehi.tool.service.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobInfoService jobInfoService;

    @RequestMapping("/list")
    public String jobList(Model model) {
        List<JobInfo> jobInfoList = jobInfoService.getJobDetails();
        model.addAttribute("jobInfoList", jobInfoList);
        return "jobList";
    }

    @RequestMapping(value = "/detail/{jobId}", method = RequestMethod.GET)
    public
    @ResponseBody
    JobInfo jobDetails(@PathVariable String jobId) {
        return jobInfoService.getJobBoId(jobId);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveJob(JobInfo jobInfo, Model model) {
        model.addAttribute("result", jobInfoService.saveJob(jobInfo));
        return jobList(model);
    }

    @RequestMapping(value = "/del/{jobId}", method = RequestMethod.POST)
    public
    @ResponseBody
    boolean delJob(@PathVariable String jobId) {
        return jobInfoService.delJob(jobId);
    }
}
