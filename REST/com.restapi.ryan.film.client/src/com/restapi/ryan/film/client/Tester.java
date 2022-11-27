package com.restapi.ryan.film.client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import com.restapi.ryan.film.*;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;


public class Tester {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
		// valid id in database
		Film film = new Film(11307, "Test", 2020, "Test", "Test Test", "Testing 123");
		ClientResponse response = service.path("rest").path("films").path(String.valueOf(film.getId())).accept(MediaType.APPLICATION_XML).put(ClientResponse.class, film);
		// Server code 201
		System.out.println(response.getStatus());
		
		System.out.println(service.path("rest").path("films").accept(
				MediaType.TEXT_XML).get(String.class));
		// Get JSON for application
		System.out.println(service.path("rest").path("films").accept(
				MediaType.APPLICATION_JSON).get(String.class));
		// Get XML for application
		System.out.println(service.path("rest").path("films").accept(
				MediaType.APPLICATION_XML).get(String.class));
		
		
		System.out.println(service.path("rest").path("films/11307").accept(
				MediaType.APPLICATION_XML).get(String.class));
		
		service.path("rest").path("films/11307").delete();
	
		System.out.println(service.path("rest").path("films").accept(
				MediaType.APPLICATION_XML).get(String.class));
			
		// Create a Film
		Form form = new Form();
		form.add("id", "0");
		form.add("title", "Demonstration of the client lib for forms");
		form.add("year", "1990");
		form.add("director", "Demonstration of the client lib for forms");
		form.add("stars", "Demonstration of the client lib for forms");
		form.add("review", "Demonstration of the client lib for forms");
		response = service.path("rest").path("films").type(MediaType.APPLICATION_FORM_URLENCODED)
								   .post(ClientResponse.class, form);
		System.out.println("Form response " + response.getEntity(String.class));
		
		System.out.println(service.path("rest").path("films").accept(
				MediaType.APPLICATION_XML).get(String.class));
		
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/com.restapi.ryan.film").build();
	}
}