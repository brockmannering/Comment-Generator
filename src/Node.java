/**
 * Course:      CS300 - Summer 2020
 * Program:     Comment Generator - FINAL PROJECT
 * Name:        Brock Mannering
 * Wisc Email:      bmannering@gmail.com
 * Web Sources:      Old Assignment references only
 * Personal Help:   None
 */

public class Node<T> {
    private Person p;
    private Node next;

    public Node(Person p) {
      this.p = p;
      this.next = null;
    }

    public Node(Person p, Node next) {
      this.p = p;
      this.next = next;
    }

    public Person getPerson() {
      return p;
    }

    public Node getNext() {
      return next;
    }

    public void setNext(Node next) {
      this.next = next;
    }
    
    public static void main(String []args) {
        
    }
}

