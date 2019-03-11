package com.perfect.jinbao.boot;

/**
 * Created by Administrator on 2016/4/10.
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.io.File;


@Configuration
@ComponentScan({"com.perfect.jinbao.service", "com.perfect.jinbao.aop"})
@ImportResource(value = {"classpath:spring-jpa.xml"})
@EnableScheduling
@EnableAspectJAutoProxy
public class RootConfig {

    private static Log log = LogFactory.getLog(RootConfig.class);

    @PostConstruct
    public void init() {
        log.info("root start path " + new File(".").getAbsolutePath());
    }


}
