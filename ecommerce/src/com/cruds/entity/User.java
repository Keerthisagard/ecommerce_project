package com.cruds.entity;

public class User {
	
		private String username;
	    private String email;
	    private String password;
	    private String phoneNumber;
		
	    public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(String username, String email, String password, String phoneNumber) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
			this.phoneNumber = phoneNumber;
		}
		

	    public User(String email, String password) {
	        this.email = email;
	        this.password = password;
	    }

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		@Override
		public String toString() {
			return "User [username=" + username + ", email=" + email + ", password=" + password + ", phoneNumber="
					+ phoneNumber + "]";
		}
}
