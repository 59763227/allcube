package com.gl.allcube.cube.test.mongo;

import java.util.Date;

import org.bson.types.ObjectId;

import com.gl.allcube.cube.common.dto.Dto;

public class Weather extends Dto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ObjectId id;

	private Date recordDate;

	private int weatherType;

	private double temperature;

	private String city;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public int getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(int weatherType) {
		this.weatherType = weatherType;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
