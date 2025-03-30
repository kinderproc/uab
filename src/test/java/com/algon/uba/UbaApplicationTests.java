package com.algon.uba;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
class UbaApplicationTests {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private CassandraTemplate cassandraTemplate;

	@Test
	void testCassandra() {
		TestAction action = new TestAction();
		action.setUserId("1");
		action.setAction("test");
		action.setEventTime(LocalDateTime.now());
		cassandraTemplate.insert(action);
		System.out.println(cassandraTemplate.select(Query.empty(), TestAction.class));
	}

	@Test
	void testRedis() {
		redisTemplate.opsForValue().set("test:key", "Hello Redis!");
		String value = redisTemplate.opsForValue().get("test:key");
		System.out.println(value);
	}

	@Test
	void testMongo() {
		TestEvent event = new TestEvent();
		event.setMessage("Hello MongoDB!");
		mongoTemplate.save(event);
		System.out.println(mongoTemplate.findAll(TestEvent.class));
	}

}
