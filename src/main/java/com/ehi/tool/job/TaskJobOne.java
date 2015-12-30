package com.ehi.tool.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskJobOne {
    private static final Logger LOG = LoggerFactory.getLogger(TaskJobOne.class);

    public void jobOne() {
        LOG.info("==========================jobOne");
    }

}
