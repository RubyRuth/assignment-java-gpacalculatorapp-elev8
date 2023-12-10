/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gpacalculatorapp.Models;



public class Course {
    public String courseNameAndCode;
    public int courseUnit;
    public int courseScore;
    public Grade grade;
    public int gradeUnit;

    public Course(String courseNameAndCode, int courseUnit, int courseScore, Grade grade, int gradeUnit) {
        this.courseNameAndCode = courseNameAndCode;
        this.courseUnit = courseUnit;
        this.courseScore = courseScore;
        this.grade = grade;
        this.gradeUnit = gradeUnit;
    }
}
