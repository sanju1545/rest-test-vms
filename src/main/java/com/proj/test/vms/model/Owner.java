/**
 * 
 */
package com.proj.test.vms.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@XmlRootElement
public class Owner {

	private String ownerId;
	private String firstName;
	private String lastName;
	private String faltNo;
	private char block;
	private List<Link> linkList = new ArrayList<>();
	
	public Owner() {
		
	}
	
	public Owner(String id, String fName, String lName, String fNumber, char blk) {
		this.ownerId=id;
		this.firstName=fName;
		this.lastName=lName;
		this.faltNo=fNumber;
		this.block=blk;
	}
	
	public Owner(String fName, String lName, String fNumber, char blk) {
		this.firstName=fName;
		this.lastName=lName;
		this.faltNo=fNumber;
		this.block=blk;
	}
	/**
	 * @return the ownerId
	 */
	public String getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the faltNo
	 */
	public String getFaltNo() {
		return faltNo;
	}
	/**
	 * @param faltNo the faltNo to set
	 */
	public void setFaltNo(String faltNo) {
		this.faltNo = faltNo;
	}
	/**
	 * @return the block
	 */
	public char getBlock() {
		return block;
	}
	/**
	 * @param block the block to set
	 */
	public void setBlock(char block) {
		this.block = block;
	}
	
	public List<Link> getLinkList() {
		return linkList;
	}

	public void setLinkList(List<Link> linkList) {
		this.linkList = linkList;
	}
	
	public void addLink(String lnk, String rel) {
		Link link = new Link();
		link.setLink(lnk);
		link.setRel(rel);
		linkList.add(link);
	}
}
