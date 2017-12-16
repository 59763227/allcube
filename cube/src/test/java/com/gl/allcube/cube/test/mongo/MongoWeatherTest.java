package com.gl.allcube.cube.test.mongo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoWeatherTest {
	private static final Logger log = LoggerFactory.getLogger(MongoWeatherTest.class);
	static String mongoHost = "192.168.0.107";
	static int mongoPort = 9700;
	static String databaseName = "cube";

	static String mongoUri = String.format("mongodb://%s:%d", mongoHost, mongoPort);

	MongoClient mongoClient;
	MongoDatabase database;

	@Before
	public void setUp() {
		log.debug("create mongo client connect to {}", mongoUri);
		mongoClient = new MongoClient(new MongoClientURI(mongoUri));
		database = mongoClient.getDatabase(databaseName);

		Assert.assertNotNull("mongo database cannot be null", database);
	}

	@Test
	public void testInitWeatherData() {
		log.debug("init weather data");
		String collectionName = "test." + Weather.class.getSimpleName();

		CodecRegistry defCodecRegistry = MongoClient.getDefaultCodecRegistry();
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(pojoCodecProvider);
		CodecRegistry weatherCodecReg = CodecRegistries.fromRegistries(defCodecRegistry, pojoCodecRegistry);
		MongoCollection<Document> collection = database.getCollection(collectionName)
				.withCodecRegistry(weatherCodecReg);
		MongoCollection<Weather> weatherCollection = collection.withDocumentClass(Weather.class);

		Assert.assertNotNull("weather collection should not be null", weatherCollection);

		log.debug("clean weather collection");

		weatherCollection.deleteMany(Filters.exists("weatherType"));

		int pageSize = 1000;
		int pageCount = 1000;

		for (int page = 0; page < pageCount; page++) {
			log.debug("start to insert {} weather records", pageSize);
			weatherCollection.insertMany(buildWeathers(pageSize));
			log.debug("finished insert {} weather records", pageSize);
		}
	}

	private List<Weather> buildWeathers(int size) {
		List<Weather> weathers = new ArrayList<Weather>();
		for (int i = 0; i < size; i++) {
			weathers.add(buildWeather());
		}

		return weathers;
	}

	private Weather buildWeather() {
		Weather w = new Weather();
//		w.setId(new ObjectId(UUID.randomUUID().toString()));
//		w.set_id(UUID.randomUUID().toString());
		w.setCity("SZ");
		w.setRecordDate(new Date());
		w.setTemperature(new Random().nextDouble() * 100);
		w.setWeatherType(WeatherType.values()[new Random().nextInt(4)].getVal());

		return w;
	}

}
