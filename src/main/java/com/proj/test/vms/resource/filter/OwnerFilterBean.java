package com.proj.test.vms.resource.filter;

import javax.ws.rs.MatrixParam;
import javax.ws.rs.QueryParam;

public class OwnerFilterBean {
	
	private @QueryParam("flatNo") String flatNo;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size; 
	private @MatrixParam("block") char block;
	/**
	 * @return the flatNo
	 */
	public String getFlatNo() {
		return flatNo;
	}
	/**
	 * @param flatNo the flatNo to set
	 */
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
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

}
