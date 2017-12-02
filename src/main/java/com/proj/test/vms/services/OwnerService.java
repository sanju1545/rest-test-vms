package com.proj.test.vms.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.proj.test.vms.database.DatabaseClass;
import com.proj.test.vms.exception.DataNotFoundException;
import com.proj.test.vms.model.Owner;

public class OwnerService {

	private Map<String, Owner> owners = DatabaseClass.getOwners();
	
	public OwnerService() {
		owners.put("1", new Owner("1", "Ramesh", "Gupta", "S-38", 'D'));
		owners.put("2", new Owner("2", "Rakesh", "Bhagat", "F-72", 'F'));
	}

	public List<Owner> getAllOwner() {
		return new ArrayList<Owner>(owners.values());
	}
	
	public Owner getOwner(String id) {
		if(owners.get(id)==null) {
			throw new DataNotFoundException("Message with id: "+id+" not found.");
		}
		return owners.get(id);
	}
	
	public List<Owner> getOwnerByFlatNo(String flatNo) {
		List<Owner> ownerList = new ArrayList<Owner>();
		for (Owner owner : owners.values()) {
			if(owner.getFaltNo().equalsIgnoreCase(flatNo)) {
				ownerList.add(owner);
			}
		}
		return ownerList;
	}
	
	public List<Owner> getOwnerByBlock(char block) {
		List<Owner> ownerList = new ArrayList<Owner>();
		for (Owner owner : owners.values()) {
			if(owner.getBlock() == block) {
				ownerList.add(owner);
			}
		}
		return ownerList;
	}
	
	public List<Owner> getOwnerBySize(int start, int size) {
		List<Owner> ownerList = new ArrayList<Owner>(owners.values());
		if(start+size > ownerList.size()) {return new ArrayList<Owner>();}
		return ownerList.subList(start, start+size);
	}
	
	public Owner addOwner(Owner owner) {
		owner.setOwnerId(String.valueOf(owners.size()+1));
		owners.put(owner.getOwnerId(), owner);
		return owner;
	}
	
	public Owner updateOwner(Owner owner) {
		if(owner.getOwnerId()==null) {
			return null;
		}
		owners.put(owner.getOwnerId(), owner);
		return owner;
	}
	
	public void deleteOwner(String id) {
		owners.remove(id);
	}
}
