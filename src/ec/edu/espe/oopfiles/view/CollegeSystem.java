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
                    "2: register new student\n\n" +
                    "3: exit\n\n" +
                    "please enter an option: ");
            
            try {
                option = scanner.nextInt();
            } catch(Exception ex) {
                System.err.print(ex.getMessage());
                option = -1;
            }
            
            switch (option) {
                case 1: {
                    List<Student> students = manager.getAllStudents();

                    for (Student student : students) {
                        System.out.println(student);
                    }
                    
                    System.in.read();
                }
                break;
                case 2: {
                    manager.register();
                    System.in.read();
                }
                break;
                case 3:
                    System.out.println("exiting...");
                break;
                default:
                    System.out.println("\n[Opcion invalida]");
                break;
            }
            
            scanner.reset();
        } while (option != 3);
    }
}
