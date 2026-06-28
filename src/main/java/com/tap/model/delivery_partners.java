package com.tap.model;

public class delivery_partners {

	 private int partner_id;
	 private String name;
	 private int phoneno;
	 private String vechile_number;
	 private String status;
	 
	 public delivery_partners() {
		 
	 }

	public delivery_partners(int partner_id, String name, int phoneno, String vechile_number, String status) {
		super();
		this.partner_id = partner_id;
		this.name = name;
		this.phoneno = phoneno;
		this.vechile_number = vechile_number;
		this.status = status;
	}

	public  int getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(int partner_id) {
		this.partner_id = partner_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getVechile_number() {
		return vechile_number;
	}

	public void setVechile_number(String vechile_number) {
		this.vechile_number = vechile_number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
}
