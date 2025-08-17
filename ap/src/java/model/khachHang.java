package model;

import java.io.Serializable;

public class khachHang implements Serializable{
	private int id;
        private Account ac;
	private String name;
	private String address;
	private String tel;
	private String email;
	
	public khachHang() {
		super();
	}
	
	public khachHang(String name, String address, String tel, String email, Account ac) {
		super();
		this.name = name;
		this.address = address;
		this.tel = tel;
                this.ac = ac;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        public void setAccount(Account ac){
            this.ac = ac;
        }
        public Account getAccount(){
            return this.ac;
        }
}
