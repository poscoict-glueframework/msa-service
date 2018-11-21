package com.poscoict.sample.sp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private String deptno;
	private String dname;
	private String dloc;

	public Dept() {
	}

	public Dept(String deptno, String dname, String dloc) {
		this.deptno = deptno;
		this.dname = dname;
		this.dloc = dloc;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDloc() {
		return dloc;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

}
