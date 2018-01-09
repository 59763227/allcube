package com.gl.allcube.cube.test.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.gl.allcube.cube.test.mybatis.vo.User;

public interface UserDao {
	User selectUserByOid(@Param("oid") String oid);
}
