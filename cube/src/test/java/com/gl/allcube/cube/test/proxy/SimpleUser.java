package com.gl.allcube.cube.test.proxy;

import com.gl.allcube.cube.common.dto.Dto;

public class SimpleUser extends Dto{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
