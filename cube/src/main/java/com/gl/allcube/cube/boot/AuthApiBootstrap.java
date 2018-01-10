package com.gl.allcube.cube.boot;

import org.springframework.boot.SpringApplication;

import com.gl.allcube.cube.config.AuthApiMainConfig;

public class AuthApiBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(AuthApiMainConfig.class, args);
	}

}
