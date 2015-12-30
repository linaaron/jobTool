package com.ehi.tool.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobOne {
    private static final Logger LOG = LoggerFactory.getLogger(JobOne.class);

    public void jobOne() {
        LOG.info("==========================jobOne");
    }

}
