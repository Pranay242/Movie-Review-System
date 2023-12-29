package com.prog.entity;


public class adminPageAtributeCollector {
	public String Username;
	public String Password;
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String userId) {
		Username = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
		
	@Override
	public String toString() {
		return "Sys2 [UserId=" + Username + ", Password=" + Password + "]";
	}
	
	public adminPageAtributeCollector() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
