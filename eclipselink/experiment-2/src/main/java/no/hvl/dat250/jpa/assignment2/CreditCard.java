package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Override
	public String toString() {
		return "CreditCard [id=" + id + ", myBank=" + myBank + ", number=" + number + ", limit=" + limit + ", balance="
				+ balance + ", pincode=" + pincode + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity=Bank.class)
    private Bank myBank;
    private Integer number;
    private Integer limit;
    private Integer balance;
    private Pincode pincode;
    
    public Integer getNumber() {
    	return number;
    }
    
    public void setNumber(Integer number) {
    	this.number = number;
    }
    
    public Pincode getPincode() {
    	return pincode;
    }
    
    public void setPincode(Pincode pincode) {
    	this.pincode = pincode;
    }
    
	public Bank getOwningBank() {
		return myBank;
	}
	public void setOwningBank(Bank myBank) {
		this.myBank = myBank;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}   
}
