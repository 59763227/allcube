package com.gl.allcube.cube.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gl.allcube.cube.test.mybatis.vo.User;

public interface UserDao {
	User selectUserByOid(@Param("oid") String oid);
	
	@Select("select * from user where gender = #{gender}")
	List<User> selectUsersByGender(@Param("gender") String gender);
}
