package com.example.clientsource;

public class TimeRecord implements Comparable<TimeRecord> {
	
	public static final long INVALID_TIME_ID = -1;
	
	private String daTe; 
	private String checkIn; 
    private String checkOut; 
  
    private long TimeId = INVALID_TIME_ID; //(Database unique pk record id)
    
    
    private boolean mSelectable = true; 
	
    public TimeRecord (String date, String check_in, String check_out) {
        
        daTe = date;
        checkIn = check_in;
        checkOut = check_out;
	
    }
	
	
	
	

	public String getDaTe() {
		return daTe;
	}





	public void setDaTe(String daTe) {
		this.daTe = daTe;
	}





	public String getCheckIn() {
		return checkIn;
	}





	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}





	public String getCheckOut() {
		return checkOut;
	}





	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}





	public boolean ismSelectable() {
		return mSelectable;
	}





	public void setmSelectable(boolean mSelectable) {
		this.mSelectable = mSelectable;
	}





	@Override
	public int compareTo(TimeRecord other) {
		// TODO Auto-generated method stub
		return (int) ((this.TimeId)-(other.TimeId));
	}

}

