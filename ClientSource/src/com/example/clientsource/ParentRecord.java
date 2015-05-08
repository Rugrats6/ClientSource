package com.example.clientsource;


public class ParentRecord implements Comparable<ParentRecord> {

	public static final long INVALID_PARENT_ID = -1;
	
	private String lastName; 
	private String firstName; 
    private String dateofBirth; 
    private String seX;
    private String ssNumber;
    private String phoneNumber;
    private String childId;
    
    private long ParentId = INVALID_PARENT_ID; //(Database unique pk record id)
    
    
    private boolean mSelectable = true; 
    
    public ParentRecord (String last_name, String first_name, String dateof_birth, String sex, String ss_number, String phone_number, String child_id) {
        
        lastName = last_name;
        firstName = first_name;
        dateofBirth = dateof_birth;
        seX = sex;
        ssNumber = ss_number;
        phoneNumber = phone_number;
        childId = child_id;
       
    }
    
    public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getDateofBirth() {
		return dateofBirth;
	}



	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}



	public String getSeX() {
		return seX;
	}



	public void setSeX(String seX) {
		this.seX = seX;
	}



	public String getSsNumber() {
		return ssNumber;
	}



	public void setSsNumber(String ssNumber) {
		this.ssNumber = ssNumber;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getChildId() {
		return childId;
	}



	public void setChildId(String childId) {
		this.childId = childId;
	}



	public boolean ismSelectable() {
		return mSelectable;
	}



	public void setmSelectable(boolean mSelectable) {
		this.mSelectable = mSelectable;
	}



	

	
	@Override
	public int compareTo(ParentRecord other) {
		// TODO Auto-generated method stub
		return (int) ((this.ParentId)-(other.ParentId));
	}

	//public int compareTo(ChildRecord other) {
		// TODO Auto-generated method stub
		//return (int) ((this.ChildId)-(other.ChildId));

}
