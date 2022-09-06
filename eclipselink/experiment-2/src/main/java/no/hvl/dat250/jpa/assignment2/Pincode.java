package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class Pincode {
    @Override
	public String toString() {
		return "Pincode [id=" + id + ", pinCode=" + pinCode + ", count=" + count + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pinCode;
    private Integer count;
    
	public Long getId() {
		return id;
	}
	public String getPincode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
