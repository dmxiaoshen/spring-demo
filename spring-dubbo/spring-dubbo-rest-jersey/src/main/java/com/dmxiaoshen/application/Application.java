package com.dmxiaoshen.application;

import com.dmxiaoshen.DubboContext;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

/**
 * Created by hzhsg on 2017/11/16.
 */
@ApplicationPath("/")
public class Application extends ResourceConfig{

    public Application(){
        packages("com.dmxiaoshen.resource");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        property(ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK, true);
        new DubboContext("dubbo-rest", "zookeeper://dmxiaoshen.zk.com:2888").start();
    }
}
