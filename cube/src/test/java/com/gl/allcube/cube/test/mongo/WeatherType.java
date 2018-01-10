package com.gl.allcube.cube.test.mongo;

public enum WeatherType {
	UNKOWN(-1),//
	SUNNY(0),//
	RAINY(1),//
	CLOUDY(2),//
	SNOWY(4);
	int _val;
	
	WeatherType(int val){
		_val = val;
	}

	public int getVal() {
		return _val;
	}
	
	public static WeatherType getType(int val) {
		switch(val) {
		case 0:
			return SUNNY;
		case 1:
			return RAINY;
		case 2:
			return CLOUDY;
		case 4:
			return SNOWY;
		default:
			return UNKOWN;
		}
	}
}
 