package no.hvl.dat250.jpa.assignment2.driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import no.hvl.dat250.jpa.assignment2.Address;
import no.hvl.dat250.jpa.assignment2.Bank;
import no.hvl.dat250.jpa.assignment2.CreditCard;
import no.hvl.dat250.jpa.assignment2.Person;
import no.hvl.dat250.jpa.assignment2.Pincode;
import no.hvl.dat250.jpa.assignment2.pObjectRetriever;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";
    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        
        // Create Max Mustermann
        Person person = new Person();
        person.setName("Max Mustermann");

        // Create address
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        
        // Create pin code
        Pincode pincode = new Pincode();
        pincode.setPinCode("123");
        pincode.setCount(1);
        
        // Create credit card
        CreditCard creditCard = new CreditCard();
        creditCard.setNumber(12345);
        creditCard.setPincode(pincode);
        creditCard.setBalance(-5000);
        creditCard.setLimit(-10000);
        
        // Create credit card
        CreditCard creditCard2 = new CreditCard();
        creditCard2.setNumber(123);
        creditCard.setPincode(pincode);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);
        
        // Create bank
        Bank bank = new Bank();
        bank.setName("Pengebank");
        
        // Connect Person with Address
        List<Person> addressOwners = new ArrayList<Person>();
        addressOwners.add(person);
        // Convert to set because I'm lazy
        Set<Person> ownerSet = new HashSet<Person>(addressOwners);
        //System.out.print(ownerSet);
        
        address.setOwners(ownerSet);
        
        // Connect Address with Person
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        person.setAddresses(addresses);
        
        // Connect Person with credit cards
        List<CreditCard> creditCards = new ArrayList<CreditCard>();
        creditCards.add(creditCard);
        creditCards.add(creditCard2);
        person.setCreditCards(creditCards);
        
        // Connect pincode to credit cards
        creditCard.setPincode(pincode);
        creditCard2.setPincode(pincode);
        
        // Connect Bank to credit cards
        creditCard.setOwningBank(bank);
        creditCard2.setOwningBank(bank);
       
        // Begin transaction
        em.getTransaction().begin();
        
        // Persist objects
        em.persist(person);
        em.persist(address);
        em.persist(creditCard);
        em.persist(creditCard2);
        em.persist(pincode);
        em.persist(bank);
        
        em.getTransaction().commit();
        
        // Retrieve persisted objects from db and print
        pObjectRetriever or = new pObjectRetriever();
        
        List<String> classNames = new ArrayList<String>(
                List.of(
                		"Address",
                		"Person",
                		"CreditCard",
                		"Pincode",
                		"Bank"
                		)
                );
        
        for (String className : classNames) {
        	or.printFromDB(em, className);
        }
//      Query q = em.createQuery("select a from Address a");
//      List<Address> pAddresses = q.getResultList();
//      for (Address pAddress : pAddresses) {
//          System.out.println(pAddress);
//      }
//      System.out.println("Size: " + pAddresses.size());

      // em.getTransaction().begin();
        // System.out.println(db_url);

        em.close();
    }
}
