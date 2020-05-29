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
            System.out.print(
                    "1: views students list\n" +
                    "2: register new student\n" +
                    "3: exit\n\n" +
                    "please enter an option: ");
            
            try {
                option = scanner.nextInt();
            } catch(Exception ex) {
                System.err.print(ex.getMessage());
                option = -1;
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
                default:
                    System.out.println("\n[Opcion invalida]");
                break;
            }
            
            if (option > 0 && option < 3) {
                System.out.print("\n\nPress <enter> key to continue...");
                System.in.read();
                System.out.println("\n\n\n");
            }
            
            scanner.reset();
        } while (option != 3);
        
        scanner.close();
    }
}
