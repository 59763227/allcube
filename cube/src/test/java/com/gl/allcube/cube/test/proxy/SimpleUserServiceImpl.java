package com.gl.allcube.cube.test.proxy;

public class SimpleUserServiceImpl implements SimpleUserService {

	public SimpleUser getUser(int id) {
		SimpleUser u = new SimpleUser();
		u.setPassword("123456");
		u.setUsername("abcdefg");
		return u;
	}

}
