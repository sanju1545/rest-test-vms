package com.proj.test.vms.database;

import java.util.HashMap;
import java.util.Map;

import com.proj.test.vms.model.Owner;
import com.proj.test.vms.model.Visitor;

public class DatabaseClass {

	private static Map<String, Visitor> visitors = new HashMap<String, Visitor>();
	private static Map<String, Owner> owners = new HashMap<String, Owner>();
	
	public static Map<String, Visitor> getVisitors() {
		return visitors;
	}
	
	public static Map<String, Owner> getOwners() {
		return owners;
	}
}
