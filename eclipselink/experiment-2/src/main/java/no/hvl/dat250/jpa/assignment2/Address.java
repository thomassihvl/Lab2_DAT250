package no.hvl.dat250.jpa.assignment2;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    private Set<Person> owners;
    
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Set<Person> getOwners() {
		return owners;
	}
	public void setOwners(Set<Person> ownerSet) {
		this.owners = ownerSet;
	}
	@Override
	public String toString() {
		String ownerList = "";
		for (Person owner : owners) {
			//System.out.print(owner.getName());
			ownerList+=owner.getName();
		}
		return "Address [id=" + id + ", street=" + street + ", number=" + number + ", owners=" + ownerList + "]";
	}
}
