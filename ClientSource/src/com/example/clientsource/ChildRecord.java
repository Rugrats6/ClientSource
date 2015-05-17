package com.example.clientsource;



public class ChildRecord implements Comparable<ChildRecord>{ 
	
	public static final long INVALID_CHILD_ID = -1;
	
	private String lastName; 
    private String firstName; 
    private String dateofBirth; 
    private String seX;
    private String ssNumber;
    private String parentId;
    private String timeId;
    
    private long ChildId = INVALID_CHILD_ID; //(Database unique pk record id)
    
    
    private boolean mSelectable = true; 

    public ChildRecord (String last_name, String first_name, String dateof_birth, String sex, String ss_number, String parent_id, String time_id) {
    
    lastName = last_name;
    firstName = first_name;
    dateofBirth = dateof_birth;
    seX = sex;
    ssNumber = ss_number;
    parentId = parent_id;
    timeId = time_id;
}
    public ChildRecord (String last_name, String first_name, String dateof_birth, String sex, String ss_number) {
        
    lastName = last_name;
    firstName = first_name;
    dateofBirth = dateof_birth;
    seX = sex;
    ssNumber = ss_number;
}
    
    

	public ChildRecord(long invalidChildId) {
		// TODO Auto-generated constructor stub
	}



	public ChildRecord(String strchildName, String strchildType,
			String imageUriString, long imageId, long invalidChildId) {
		// TODO Auto-generated constructor stub
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



	public String getSex() {
		return seX;
	}



	public void setSex(String sex) {
		this.seX = sex;
	}



	public String getSsNumber() {
		return ssNumber;
	}



	public void setSsNumber(String ssNumber) {
		this.ssNumber = ssNumber;
	}



	public String getParentId() {
		return parentId;
	}



	public void setParentId(String parentId) {
		this.parentId = parentId;
	}



	public String getTimeId() {
		return timeId;
	}



	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}



	public boolean ismSelectable() {
		return mSelectable;
	}



	public void setmSelectable(boolean mSelectable) {
		this.mSelectable = mSelectable;
	}



	@Override
	public int compareTo(ChildRecord other) {
		// TODO Auto-generated method stub
		return (int) ((this.ChildId)-(other.ChildId));
		
		//   public int compareTo(PetRecord other) { 
        //return (int)((this.mPetId)-(other.mPetId));
	}
}
