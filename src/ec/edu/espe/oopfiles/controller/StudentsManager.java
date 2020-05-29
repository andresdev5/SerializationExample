package ec.edu.espe.oopfiles.controller;

import ec.edu.espe.oopfiles.model.Student;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author jon_m
 */
public class StudentsManager {    
    /**
     * Creates a new student
     * 
     * @return 
     */
    public Student register() {
        Student student = new Student();
        
        // set random id
        student.setId((int)(Math.random() * (9999)) + 1);
       
        // set student name
        String name;
        name = scanLine("ingresa un nombre");
        student.setName(name);
        
        // set age
        do {
            int age = 0;
            
            try {
                age = Integer.parseInt(scanLine("ingresa tu edad"));
            } catch (Exception exception) {
                System.out.println("\n[edad invalida]");
                continue;
            }
            
            if (age < 14 || age > 80) {
                System.out.println("\n[edad invalida]");
                continue;
            }
            
            student.setAge(age);
            break;
        } while (true);
        
        // set average
        double average = Double.parseDouble(scanLine("ingresa el promedio"));
        student.setAverage(average);
        
        // check and set scholarship (y/n)
        do {
            String option = scanLine("Tiene beca? [y/n]");
            
            if (!option.equalsIgnoreCase("y") 
                && !option.equalsIgnoreCase("n")) {
                System.out.print("\n[ingresa una opcion valida]\n");
                continue;
            }
            
            boolean hasSchoolarship = option.equalsIgnoreCase("y");
            student.setHasScholarship(hasSchoolarship);
            
            break;
        } while(true);
        
        saveRecord(student);
        
        return student;
    }
    
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        
        try {
            String databaseName = "database.txt";
            File database = new File(databaseName);
            
            if (!database.exists()) {
                System.out.println("No records found");
                return null;
            }
            
            Scanner scanner = new Scanner(database);
            
            while (scanner.hasNextLine()) {
                Student student = new Student();
                String line = scanner.nextLine();
                String[] tokens = line.split(";");
                
                if (tokens.length < 5) {
                    continue;
                }
                
                try {
                    student.setId(Integer.parseInt(tokens[0]));
                    student.setName(tokens[1]);
                    student.setAge(Integer.parseInt(tokens[2]));
                    student.setAverage(Double.parseDouble(tokens[3]));
                    student.setHasScholarship(Boolean.parseBoolean(tokens[4]));
                } catch (Exception exception) {
                    System.err.println(
                        "An error has ocurred while attempt to read a record");
                    System.err.println(exception.getMessage());
                }
                
                students.add(student);
            }
            
            scanner.close();
        } catch (Exception exception) {
            System.err.println(
                "An error has ocurred while attempt to read student records");
            System.err.println(exception.getMessage());
        }
        
        return students;
    }
    
    private void saveRecord(Student student) {
        try {
            String databaseName = "database.txt";
            File database = new File(databaseName);
            
            if (!database.exists()) {
                database.mkdirs();
                database.createNewFile();
            }
            
            FileWriter writer = new FileWriter(database, true);
            PrintWriter printWriter = new PrintWriter(writer);
            
            printWriter.println(student);
            printWriter.close();
            writer.close();
        } catch (Exception exception) {
            System.err.println(
                "An error has ocurred while attempt to save student record");
            System.err.println(exception.getMessage());
        }
    }
    
    private String scanLine(String label) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = true;
        String line;
        
        do {
            System.out.printf("%s: ", label);
            line = scanner.nextLine();
            
            if (line.contains(";")) {
                System.out.print("invalid character ';'");
                valid = false;
            }
        } while (!valid);
        
        return line;
    }
}
