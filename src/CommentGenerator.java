/**
 * Course:      CS300 - Summer 2020
 * Program:     Comment Generator - FINAL PROJECT
 * Name:        Brock Mannering
 * Wisc Email:      bmannering@gmail.com
 * Web Sources:      Old Assignment references only
 * Personal Help:   None
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class CommentGenerator {
    


    public static List<String> adjectivesToList() throws FileNotFoundException {
        List<String> tempList = new ArrayList<>();
        try {
            Scanner in = new Scanner(new File("Adjectives.txt"));
            while (in.hasNextLine()) {
                tempList.add(in.nextLine());
            }
            in.close();
            
        } catch (FileNotFoundException e) {
          System.out.println("File not found, make sure the name of the adjective"
              + " file is \"Adjectives.txt\"");
        }
        
        return tempList;
        
    }

    public static Student newStudent(String name, int age) {
        Student s1 = new Student(name, age);
        return s1;
    }

    public static Faculty newFaculty(String name, int age) {
        Faculty f1 = new Faculty(name, age);
        return f1;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        String name;
        int age;
        String personType;
        String command;
        boolean done = false;
        String comments = "";
        List<String> adjectives = new ArrayList<>();
        Random r;
        int randomNum;

        Scanner kb = new Scanner(System.in);
        PersonQueue line = new PersonQueue();
        
        adjectives = adjectivesToList();
        
        System.out.println("~~~ Hello, welcome to the random comment generator app! ~~~");
        
        System.out.println("\nEnter a random number:");

        r = new Random(kb.nextInt());
        randomNum = r.nextInt(adjectives.size());
        do {
            
            System.out.println("Enter a first name: ");
            name = kb.next();
            
            System.out.println("Enter an age: ");
            age = kb.nextInt();
            
            System.out.println("Type F if this person is a Faculty member or type "
                + "S if this person is a Student");

            personType = kb.next().substring(0, 1).toUpperCase();
            System.out.println();

            if (personType.contentEquals("S")) {
                line.enqueue(newStudent(name, age));
            } else if (personType.contentEquals("F")) {
                line.enqueue(newFaculty(name, age));
            } else {
                throw new InputMismatchException();
            }


            System.out.println(line.toString());
            System.out.println("Type D to be done and compile the "
                + "or type C to continue and queue another name!");
            command = kb.next().substring(0, 1).toUpperCase();
            if (command.contentEquals("C")) {
                System.out.println("Adding another random comment!\n");
            } else if (command.contentEquals("D")) {
                
                while (!line.isEmpty()) {
                    if (line.peek().getRole().contentEquals("Faculty")) {
                        comments = comments + "Hello, my name is " + line.peek().getName() + 
                            ". I am " + line.peek().getAge() + " years old, "
                                + "and I am in the faculty at the University of Wisconsin.\n"
                            + "I believe that most people on Earth are " + 
                            line.peek().getGenericQuality() + ". Among those people "
                            + "are student faculty, which I believe to be " +
                            line.peek().getQuality() + ".\nThat being said, I believe"
                                + " that I am more likely to be really " + adjectives.get(randomNum) +
                                " than " + line.peek().getQuality() + ".\n\n";
                        randomNum = r.nextInt(adjectives.size()); 
                    }
                    else if (line.peek().getRole().contentEquals("Student")) {
                        comments = comments + "Hello, I am " + line.peek().getName() + 
                            ". I am " + line.peek().getAge() + " years old, "
                                + "and I am a student at the University of Wisconsin.\n"
                            + "I believe that most people on Earth are " + 
                            line.peek().getGenericQuality() + ". Among those people "
                            + "are students at a university, which I believe to be " +
                            line.peek().getQuality() + ".\nThat being said, I believe"
                                + " that I am more likely to be really " + adjectives.get(randomNum) +
                                " than " + line.peek().getQuality() + ".\n\n";
                        randomNum = r.nextInt(adjectives.size());
                    }
                    line.dequeue();
                    
                }
                
                
                System.out.println(comments);
                System.out.println("That was fun\n");
                done = true;
            }
            else {
                throw new InputMismatchException();
            }
        } while (!done);
        
        System.out.println("~~~ Thanks for using the program! ~~~");
        kb.close();
    }
    
}
