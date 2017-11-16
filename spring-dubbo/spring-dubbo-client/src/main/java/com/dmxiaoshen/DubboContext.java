package com.dmxiaoshen;

import com.dmxiaoshen.base.AbstractDubboContext;

public class DubboContext extends AbstractDubboContext<DubboContext> {
    private static final String CONFIG = "classpath*:dubbo-consumer.xml";

    public DubboContext(String appName, String zkAddress) {
        this(appName, zkAddress, CONFIG);
    }

    public DubboContext(String appName, String zkAddress, String configPath) {
        super(appName, zkAddress, configPath);
    }
}
