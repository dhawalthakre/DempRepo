package com.advantage.datastructures.OptumOne;


/**
 * Data Structure to hold variables for Login
 */
public class LoginDetails {
	public String sUserName, sPassword;
	

	/**
	 * Constructor for Login
	 * 
	 * @param sUserName - User Name
	 * @param sPassword - Password
	 */
	public LoginDetails(String sUserName, String sPassword)
	{
		// No language assume English user
		set(sUserName, sPassword);
	}

	

	/**
	 * Sets all the variables.
	 * 
	 * @param sUserName - User Name
	 * @param sPassword - Password	
	 */
	private void set(String sUserName, String sPassword)
	{
		this.sUserName = sUserName;
		this.sPassword = sPassword;		
	}



	@Override
	public String toString() {
		return "LoginDetails [sUserName=" + sUserName + ", sPassword="
				+ sPassword + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sPassword == null) ? 0 : sPassword.hashCode());
		result = prime * result
				+ ((sUserName == null) ? 0 : sUserName.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDetails other = (LoginDetails) obj;
		if (sPassword == null) {
			if (other.sPassword != null)
				return false;
		} else if (!sPassword.equals(other.sPassword))
			return false;
		if (sUserName == null) {
			if (other.sUserName != null)
				return false;
		} else if (!sUserName.equals(other.sUserName))
			return false;
		return true;
	}

	
}