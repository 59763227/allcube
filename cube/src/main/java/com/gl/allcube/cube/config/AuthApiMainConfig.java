package com.gl.allcube.cube.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.gl.rainbow.auth.api"})
@EnableAutoConfiguration
public class AuthApiMainConfig {

}
