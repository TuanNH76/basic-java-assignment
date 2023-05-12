package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID = 123456789L;
    private String studentCode;
    private String schoolName;
    private Integer yearOfAdmission;
    private Double GPA;
    private StudentCapacity studentCapacity;

    public Student() {
    }

    public Student(String name, LocalDate DoB, String address, float height, float weight, String studentCode, String schoolName, int yearOfAdmission, double GPA) {
        super(name, DoB, address, height, weight);
        this.studentCode = studentCode;
        this.schoolName = schoolName;
        this.yearOfAdmission = yearOfAdmission;
        this.GPA = GPA;
        this.studentCapacity = checkStudentCapacity();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(int yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public StudentCapacity getStudentCapacity() {
        return this.studentCapacity;
    }

    public void setStudentCapacity(StudentCapacity studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public StudentCapacity checkStudentCapacity() {
        if (this.GPA < 3) return StudentCapacity.POOR;
        if (this.GPA < 5) return StudentCapacity.BELOW_AVERAGE;
        if (this.GPA < 6.5) return StudentCapacity.AVERAGE;
        if (this.GPA < 7.5) return StudentCapacity.GOOD;
        if (this.GPA < 9) return StudentCapacity.VERY_GOOD;
        if (this.GPA <= 10) return StudentCapacity.EXCELLENT;
        return null;
    }

    @Override
    public String toString() {
        return super.toString()
                + "Student Code : " + this.studentCode + "\n"
                + "School Name : " + this.schoolName + "\n"
                + "Year of Admission : " + this.yearOfAdmission + "\n"
                + "GPA : " + this.GPA + "\n"
                + "Student Capacity : " + this.studentCapacity + "\n"
                ;
    }
}
