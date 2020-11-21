/**
 * Course:      CS300 - Summer 2020
 * Program:     Comment Generator - FINAL PROJECT
 * Name:        Brock Mannering
 * Wisc Email:      bmannering@gmail.com
 * Web Sources:      Old Assignment references only
 * Personal Help:   None
 */

import java.util.NoSuchElementException;

public class PersonQueue implements QueueADT <Person> {

    Node back;
    Node front;
    int numOfPeople;
    
    public PersonQueue() {
        front = null;
        back = null;
        this.numOfPeople = 0;
    }
    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public int size() {
        return numOfPeople;
    }

    @Override
    public void enqueue(Person newPerson) {
       Node personNode = new Node(newPerson);
       
        if (isEmpty()) {
            numOfPeople++;
            front = personNode;
            back = personNode;
        } else {
            numOfPeople++;
            back.setNext(personNode);
            back = personNode;
        }
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        this.numOfPeople = 0;
    }

    @Override
    public Person peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.getPerson();
    }

    @Override
    public Person dequeue() {
        if (numOfPeople == 0) {
            throw new NoSuchElementException();
        }
        Person personToReturn = front.getPerson();
        numOfPeople--;
        front = front.getNext();
        
        return personToReturn;
    }
    
    public String toString() {
        String s;
        if (numOfPeople == 1) {
            s = "There is now " + numOfPeople + " person in the queue for "
                + "a random comment\n";
        }
        else {
            s = "There are now " + numOfPeople + " people in the queue for "
                + "a random comment\n";
        }
        return s;
    }

}
