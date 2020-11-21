/**
 * Course:      CS300 - Summer 2020
 * Program:     Comment Generator - FINAL PROJECT
 * Name:        Brock Mannering
 * Wisc Email:      bmannering@gmail.com
 * Web Sources:      Old Assignment references only
 * Personal Help:   None
 */

public class Student extends Person {
    
    int age;
    String name;
    String role = "Student";
    String quality = "Intelligent";

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getQuality() {
        return quality;
    }
    
    public String getRole() {
        return role;
    }

}