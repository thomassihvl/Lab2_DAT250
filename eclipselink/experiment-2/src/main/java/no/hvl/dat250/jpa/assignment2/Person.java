package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Person {
    @Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", addresses=" + addresses + ", creditCards=" + creditCards
				+ "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    private List<Address> addresses;
    private List<CreditCard> creditCards;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
		this.name = name;
	}
    
	public Collection<Address> getAddresses() {
        return addresses;
    }
	
    public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }
}
