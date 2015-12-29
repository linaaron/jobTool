package com.ehi.tool.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskJobOne {
    private static final Logger LOG = LoggerFactory.getLogger(TaskJobOne.class);

    @Scheduled(cron = "${jobOne}")
    public void jobOne() {
        LOG.info("==========================jobOne");
    }

}
