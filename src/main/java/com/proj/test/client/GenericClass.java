package com.proj.test.client;


import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.proj.test.vms.model.Owner;

public class GenericClass {

	public GenericClass() {
	}

	public static void main(String[] args) {
		GenericClass demo = new GenericClass();
		List<Owner> list =demo.getOwnerBasedOnFlatNo("G-28");
		for (Owner owner : list) {
			System.out.println(owner.getFirstName());
		}
	}

	public List<Owner> getOwnerBasedOnFlatNo(String flatNo) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget =client.target("http://localhost:8080/vms/webapi/");
		WebTarget ownerTarget = baseTarget.path("owners");
		return ownerTarget
//				.queryParam("flatNo", flatNo)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Owner>>() {});
	}

}
