package ec.edu.espe.oopfiles.view;

import ec.edu.espe.oopfiles.model.Student;
import ec.edu.espe.oopfiles.controller.StudentsManager;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jon_m
 */
public class CollegeSystem {
    public static void main(String[] args) throws IOException {
        StudentsManager manager = new StudentsManager();
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            boolean wasInvalid = false;
            
            System.out.flush();                    
            System.out.print(
                    "1: views students list\n" +
                    "2: register new student\n" +
                    "3: exit\n\n");
            
            while (true) {
                System.out.print(
                    wasInvalid ? "Enter a valid option: " : "Enter an option: ");
                
                try {
                    option = Integer.parseInt(scanner.nextLine());
                } catch(Exception ex) {
                    option = -1;
                }
                
                if (option < 1 || option > 3) {
                    wasInvalid = true;
                    continue;
                }
                
                break;
            }
            
            System.out.println("\n\n");
            
            switch (option) {
                case 1: {
                    List<Student> students = manager.getAllStudents();
                    
                    if (students.size() == 0) {
                        System.out.println("No records found");
                    }

                    for (Student student : students) {
                        System.out.println(student);
                        System.out.println();
                    }
                }
                break;
                case 2: {
                    manager.register();
                }
                break;
                case 3:
                    System.out.println("exiting...");
                break;
                default: break;
            }
            
            if (option != 3) {
                System.out.print("\n\nPress <enter> key to continue...");
                System.in.read();
                System.out.println("\n\n\n");
            }
            
            scanner.nextLine();
        } while (option != 3);
        
        scanner.close();
    }
}
