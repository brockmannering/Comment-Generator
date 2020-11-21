/**
 * Course:      CS300 - Summer 2020
 * Program:     Comment Generator - FINAL PROJECT
 * Name:        Brock Mannering
 * Wisc Email:      bmannering@gmail.com
 * Web Sources:      Old Assignment references only
 * Personal Help:   None
 */

public class Tester {
    public static void main(String[] args) {
        
        System.out.println(unitTestFaculty());
        System.out.println(unitTestStudent());
        System.out.println(unitTestPersonQueue());
    }
    
    
    private static boolean unitTestFaculty() {
        boolean works = true;
        Faculty s1 = new Faculty("Marg", 65);
        if (!s1.getQuality().contentEquals("Knowledgeable")) {
            works = false;
        }
        else if (!s1.getGenericQuality().contentEquals("Good willed")) {
            works = false;
        }
        return works;
        
    }
    
    private static boolean unitTestStudent() {
        boolean works = true;
        Student s1 = new Student("Derek", 22);
        if (!s1.getQuality().contentEquals("Intelligent")) {
            works = false;
        }
        else if (!s1.getGenericQuality().contentEquals("Good willed")) {
            works = false;
        }
        return works;
        
    }
    
    private static boolean unitTestPersonQueue() {
        boolean works = true;
        PersonQueue testQueue = new PersonQueue();
        Student s1 = new Student("Derek", 22);
        Faculty f1 = new Faculty("Marg", 65);
        Student s2 = new Student("john", 30);
        
        testQueue.enqueue(s1);
        testQueue.enqueue(f1);
        testQueue.enqueue(s2);
        testQueue.dequeue();
        
        if (!testQueue.peek().equals(f1)) {
            works = false;
        }
        testQueue.dequeue();
        if (!testQueue.dequeue().equals(s2)) {
            works = false;
        }
        
        
        
        return works;
    }

}
