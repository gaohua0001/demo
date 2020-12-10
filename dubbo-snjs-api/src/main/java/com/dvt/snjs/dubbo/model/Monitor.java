package com.dvt.snjs.dubbo.model;

public class Monitor {

	private String qsrq;
	private String zzrq;
	private String lx = "dubbo";
	private String tabname;
	private long successrecords = 0;
	private long failedrecords = 0;
	
	public String getQsrq() {
		return qsrq;
	}
	public void setQsrq(String qsrq) {
		this.qsrq = qsrq;
	}
	public String getZzrq() {
		return zzrq;
	}
	public void setZzrq(String zzrq) {
		this.zzrq = zzrq;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}
	public long getSuccessrecords() {
		return successrecords;
	}
	public void setSuccessrecords(long successrecords) {
		this.successrecords = successrecords;
	}
	public long getFailedrecords() {
		return failedrecords;
	}
	public void setFailedrecords(long failedrecords) {
		this.failedrecords = failedrecords;
	}
	
}
