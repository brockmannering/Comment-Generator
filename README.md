Comment Generator Read-me
Author: Brock Mannering

The CommentGenerator class has the main method in this project.

This program's purpose is to create a queue of theoretical people, or real people,
that will have random comments generated about them via adjectives from the Adjectives.txt
file. 

The commands for the program are entering a random number (seed), entering a first name,
entering an age, and whether or not this person is a student or faculty member via
"S" or "F" commands. After that, the user will type "D" to be done and compile the queue
of people, or type "C" to continue and queue another name and random comment.

Limitations: 
1. The text file will be read one line at a time so the file adjectives have to be
one per line, however they can be multiple words.
2. You will get an inputMismatchException if you do not input a number when it is
asking for one and it will crash. 
3. You will get another inputMismatchException if you do not input a viable letter command
when asked for one.

Using inheritance: The Person class is a parent class and the classes Student
 and Faculty are Person's abstract classes. 