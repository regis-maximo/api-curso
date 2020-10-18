package com.exemple.api;

import org.junit.jupiter.api.Test;
import static com.jayway.restassured.RestAssured.*;

class TestesAPI {

	public TestesAPI() {

		baseURI = "http://localhost:8080/curso/alunos";
	}

	/* chama o serviço pelo método POST */
	@Test
	void testgetAllUsers() {
		given().contentType("application/json")
		.when().get(baseURI)
		.then().statusCode(200);
	}

//	@Test
	void testGetStudent() {
		given().contentType("application/json")
		.when().get(baseURI+"/2")
		.then().statusCode(200);
	}
	
//	@Test
	void testDelStudent() {
		given()
		.when().delete(baseURI+"/2")
		.then().statusCode(200);
	}
	
	@Test
	void testSaveStudent() {
		
		String body = "{\r\n" + 
				"        \"id\": 5,\r\n" + 
				"        \"name\": \"Lucia\",\r\n" + 
				"        \"curso\": \"Engenharia civil\"\r\n" + 
				"    }";
		
		given().contentType("application/json")
		.when().body(body).post(baseURI)
		.then().statusCode(201);
	}
}
