package com.ehi.tool.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskJobTwo {
    private static final Logger LOG = LoggerFactory.getLogger(TaskJobTwo.class);

    //    @Scheduled(fixedRate = 1000 * 3)
    @Scheduled(cron = "${jobTwo}")
    public void print() {
        LOG.info("==========================jobTwo");
    }
}
