package com.dvt.core.uuid;

import java.io.Serializable;
import java.net.InetAddress;

public class UUIDGenerator {
	
	private static final int IP;
	
	static {
		int ipadd;
		try {
			ipadd = BytesHelper.toInt(InetAddress.getLocalHost().getAddress());
			//System.out.println(InetAddress.getLocalHost().getAddress());
			//System.out.println(ipadd);
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}

	private static short counter = (short) 0;

	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	public UUIDGenerator() {
	}

	/**
	* Unique across JVMs on this machine (unless they load this class in the
	* same quater second - very unlikely)
	*/
	protected int getJVM() {
		return JVM;
	}

	/**
	* Unique in a millisecond for this JVM instance (unless there are >
	* Short.MAX_VALUE instances created in a millisecond)
	*/
	protected short getCount() {
		synchronized (UUIDGenerator.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	/**
	* Unique in a local network
	*/
	protected int getIP() {
		return IP;
	}

	/**
	* Unique down to millisecond
	*/
	protected short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	protected int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	private static final String SEPERATOR = "";

	protected String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuffer buf = new StringBuffer("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	protected String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuffer buf = new StringBuffer("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	public Serializable generate() {
	return new StringBuffer(36).append(format(getIP())).append(
		UUIDGenerator.SEPERATOR).append(format(getJVM())).append(
		UUIDGenerator.SEPERATOR).append(format(getHiTime())).append(
		UUIDGenerator.SEPERATOR).append(format(getLoTime())).append(
		UUIDGenerator.SEPERATOR).append(format(getCount())).toString();
	}

	public static void main(String[] args) throws Exception {
		for(int i=0;i<100;i++) {
			long l = System.currentTimeMillis();
			int jvm = (int) ( l >>> 8);
			System.out.println(l + "," + jvm + "," + Integer.toHexString(jvm));
		}
		
		
	}

}
