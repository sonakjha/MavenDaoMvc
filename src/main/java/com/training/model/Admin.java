package com.training.model;

public class Admin {
	private int id;
	private String name;
	private Long mobile_no;
	private int owner_id;
	private String email;
	private String password;
	public Admin() {
		super();
	}
	public Admin(int id, String name, Long mobile_no, int owner_id, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobile_no = mobile_no;
		this.owner_id = owner_id;
		this.email = email;
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the mobile_no
	 */
	public Long getMobile_no() {
		return mobile_no;
	}
	/**
	 * @param mobile_no the mobile_no to set
	 */
	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}
	/**
	 * @return the owner_id
	 */
	public int getOwner_id() {
		return owner_id;
	}
	/**
	 * @param owner_id the owner_id to set
	 */
	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", mobile_no=" + mobile_no + ", owner_id=" + owner_id + ", email="
				+ email + ", password=" + password + "]";
	}
	
	

}
