package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Bank {
    @Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", creditCard=" + creditCard + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="myBank")
    private Set<CreditCard> creditCard;

    public Long getId() {
        return id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CreditCard> getOwnedCards() {
        return creditCard;
    }
}
