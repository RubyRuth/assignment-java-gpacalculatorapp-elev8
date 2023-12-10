/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gpacalculatorapp;

import java.util.ArrayList;
import java.util.Scanner;

import gpacalculatorapp.Models.Course;
import gpacalculatorapp.Models.Grade;


public class GpaLogic {
    
    public static Course ProcessUserInput(){
        Scanner scanner = new Scanner(System.in);
        
            System.out.print("Enter course name and code: ");
            String courseNameAndCode = scanner.nextLine();
            
        int courseUnit = 100;
        while(courseUnit < 0 || courseUnit > 10){
            System.out.println("enter a valid course unit from 1 to 10: ");
            courseUnit = scanner.nextInt(); 
        }    
        int courseScore = 1000;    
        while(courseScore < 0 || courseScore > 100){
            System.out.println("enter a valid course score from 1 to 100: ");
            courseScore = scanner.nextInt(); 
        }
        
        scanner.nextLine(); // Consume the newline character

        Grade grade = calculateGrade(courseScore);
        int gradeUnit = grade.gradeUnit;
            
            
            
        Course course = new Course(courseNameAndCode, courseUnit, courseScore, grade, gradeUnit);
            
        return course;
}

  
    
    public void updateCourseBucket(ArrayList<Course> coursesBucket, Course course){
        coursesBucket.add(course);
    }
    
    public double calculateGpa(ArrayList<Course> coursesBucket){
        
        double totalQualityPoint = coursesBucket.stream().mapToDouble(course -> course.courseUnit * course.gradeUnit).sum();
        double totalGradeUnit = coursesBucket.stream().mapToInt(course -> course.courseUnit).sum();
        double gpa = totalQualityPoint / totalGradeUnit;

        return gpa;
    }
    
    public static Grade calculateGrade(int score) {
        if (score >= 70 && score <= 100) {
            return new Grade("A", 5, "Excellent");
        } else if (score >= 60 && score <= 69) {
            return new Grade("B", 4, "Very Good");
        } else if (score >= 50 && score <= 59) {
            return new Grade("C", 3, "Good");
        } else if (score >= 45 && score <= 49) {
            return new Grade("D", 2, "Fair");
        } else if (score >= 40 && score <= 44) {
            return new Grade("E", 1, "Pass");
        } else {
            return new Grade("F", 0, "Fail");
        }
    }
}
