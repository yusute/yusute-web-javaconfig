package com.yusute.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yusutehot on 3/29/2017.
 */
@Configuration
@ComponentScan(basePackages = { "com.yusute.web.service" })
public class RootConfig {
}
