package com.gl.allcube.cube.common.dto;

import java.io.Serializable;

import com.gl.allcube.cube.common.util.ReflectionUtil;

public abstract class Dto implements Serializable{

    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return ReflectionUtil.toString(this.getClass(), this);
    }

}
