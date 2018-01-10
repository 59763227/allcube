package com.gl.allcube.cube.test.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MongoPersonTests {
	private static final Logger log = LoggerFactory.getLogger(MongoPersonTests.class);
	static String HOST = "192.168.0.107";
	static int PORT = 9700;
	static String DB = "cube";

	static String COLLECTION_PREFIX = "test.";

	static long PERSON_INIT_SIZE = 1000L;

	MongoClient client;
	MongoDatabase db;

	MongoCollection<Person> personCollection;

	@Before
	public void setUp() {
		CodecRegistry defCodecRegistry = MongoClient.getDefaultCodecRegistry();
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromProviders(pojoCodecProvider);
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(defCodecRegistry, pojoCodecRegistry);

		ServerAddress serverAddr = new ServerAddress(HOST, PORT);
		MongoClientOptions clientOptions = MongoClientOptions.builder().codecRegistry(codecRegistry).build();

		client = new MongoClient(serverAddr, clientOptions);

		Assert.assertNotNull("mongo client should not be null", client);

		db = client.getDatabase(DB);
		Assert.assertNotNull("db should not be null", db);

		personCollection = db.getCollection(buildCollectionName(Person.class), Person.class);
	}

	@After
	public void tearDown() {
		if (client != null) {
			client.close();
		}
	}

	@Test
	public void test100InitPersonData() {
		personCollection.drop();

		List<Person> persons = buildPersons();

		personCollection.insertMany(persons);

		log.info("total {} records of {} inserted", persons.size(), Person.class.getName());
	}

	@Test
	public void test101FindPerson() {
		String personId = "id-100";
		
		Person p = personCollection.find(Filters.eq("personId", personId)).first();
		
		Assert.assertEquals("verify person ID", personId,p.getPersonId());
		
		log.info("Person:{}",p);
	}

	private String buildCollectionName(Class<?> clz) {
		return COLLECTION_PREFIX + clz.getSimpleName();
	}

	private List<Person> buildPersons() {
		List<Person> persons = new ArrayList<Person>();

		for (long i = 0L; i < PERSON_INIT_SIZE; i++) {
			persons.add(buildPerson(i));
		}

		return persons;
	}

	private Person buildPerson(long index) {
		Person p = new Person();
		p.setAddress(buildAddress());
		p.setAge((int) index % 100);
		p.setName("name-" + index);
		p.setPersonId("id-" + index);
		return p;
	}

	private Address buildAddress() {
		Address addr = new Address();
		addr.setCity("深圳");
		addr.setStreet("南新路");
		addr.setZip("518000");

		return addr;
	}
}
