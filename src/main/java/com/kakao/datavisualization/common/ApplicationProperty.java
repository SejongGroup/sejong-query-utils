package com.kakao.datavisualization.common;

public class ApplicationProperty {
	public static String authorName;
	public static String authorMail;
	public static String authorPhone;
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		ApplicationProperty.authorName = authorName;
	}
	public String getAuthorMail() {
		return authorMail;
	}
	public void setAuthorMail(String authorMail) {
		ApplicationProperty.authorMail = authorMail;
	}
	public String getAuthorPhone() {
		return authorPhone;
	}
	public void setAuthorPhone(String authorPhone) {
		ApplicationProperty.authorPhone = authorPhone;
	}
}
