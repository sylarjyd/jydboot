package com.jyd.common.enumeration;

public enum AccountEnum {

	PERSONAL("0","个人"),
	ENTERPRISE("1","企业");

	AccountEnum(String nameEn, String nameCh) {
		this.nameEn = nameEn;
		this.nameCh = nameCh;
	}

	private String nameEn;
	private String nameCh;

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNameCh() {
		return nameCh;
	}

	public void setNameCh(String nameCh) {
		this.nameCh = nameCh;
	}
}
