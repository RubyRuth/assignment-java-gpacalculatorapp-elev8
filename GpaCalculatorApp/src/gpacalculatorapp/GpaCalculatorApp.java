/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gpacalculatorapp;
import java.util.Scanner;
import java.util.ArrayList;
import gpacalculatorapp.Models.Course;
/**
 *
 * @author Hp
 */
public class GpaCalculatorApp {

    /**
     * @param args the command line arguments
     */
    public static GpaLogic gpl = new GpaLogic();
    
    public static Scanner scanner = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        ArrayList<Course> coursesBucket = new ArrayList<>();
        
        Course course = gpl.ProcessUserInput();
        
        gpl.updateCourseBucket(coursesBucket, course);
        
        System.out.println("Do you wish to add more courses? Yes/No");
        
        String likeToContinue = scanner.next();
        
        likeToContinue = likeToContinue.toUpperCase();
        
        // validate user input 
        while(likeToContinue.equals("YES")){
            course = gpl.ProcessUserInput();
            gpl.updateCourseBucket(coursesBucket, course);
            
            System.out.println("Do you wish to add more courses? Yes/No");
            likeToContinue = scanner.next();      
            likeToContinue = likeToContinue.toUpperCase();
        }
        
        double GPA = gpl.calculateGpa(coursesBucket);
        
        System.out.println("\n|-------------------------|------------------------|-------------|----------------------|-----------------|");
        System.out.println("|       COURSE & CODE      |        COURSE UNIT    |   GRADE    |        GRADE-UNIT      REMARK          |");
        System.out.println("|------------------------  |-----------------------|------------|---------------------|------------------|");

        for (Course course_item : coursesBucket) {
            System.out.printf("| %-25s  | %-13d        | %-5s    |%-11d      | %-14s          |\n", course_item.courseNameAndCode, course_item.courseUnit,
                    course_item.grade.grade, course_item.gradeUnit, course_item.grade.remark);
        }

        System.out.println("|----------------------------------------------------------------------------------------------------------|");
        System.out.printf("\nYour GPA is  %.2f to 2 decimal places.\n", GPA);
    }

}