package com.javaex.vo;

public class EmaillistVo {
  private int    no;
  private String last_name;
  private String first_name; 
  private String email;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getLast_name() {
    return last_name;
  }
  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }
  public String getFirst_name() {
    return first_name;
  }
  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  @Override
  public String toString() {
    return "emaillistVo [no=" + no + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
        + "]";
  }
  /**
   * @param last_name
   * @param first_name
   * @param email
   */
  public EmaillistVo(String last_name, String first_name, String email) {
    super();
    this.last_name = last_name;
    this.first_name = first_name;
    this.email = email;
  }
  /**
   * Default Constructor
   */
  public EmaillistVo() {
    super();
  }
  public EmaillistVo(int no, String lastName, String firstName, String email) {
    this.no = no;
    this.last_name = lastName;
    this.first_name = firstName;
    this.email = email;
    
  }
  public EmaillistVo(String email) {
	  super();
	    this.email = email;
	  }
}
