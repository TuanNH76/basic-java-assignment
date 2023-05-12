package service;

import io.ReadAndWrite;
import model.Student;
import validation.Validate;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static model.Person.idCounter;


public class StudentService {
    static ReadAndWrite StudentReadAndWrite = new ReadAndWrite();
    public static List<Student> StudentList = StudentReadAndWrite.read();
    Scanner scn = new Scanner(System.in);

    public StudentService() {
    }

    public void createStudent() {
        idCounter = getMaxID();
        String name = inputName();
        LocalDate DoB = inputDoB();
        String address = inputAddress();
        float height = inputHeight();
        float weight = inputWeight();
        String StudentCode = inputStudentCode();
        String SchoolName = inputSchoolName();
        int YearOfAdmission = inputYearOfAdmission(DoB);
        double GPA = inputGPA();
        scn.nextLine();
        Student student = new Student(name, DoB, address, height, weight, StudentCode, SchoolName, YearOfAdmission, GPA);
        StudentList.add(student);
        StudentReadAndWrite.write(StudentList);
        System.out.println(student.toString());
    }

    public int searchByID(int ID) {
        int size = StudentList.size();
        for (int i = 0; i < size; i++) {
            if (StudentList.get(i).getId() == ID) return i;
        }
        return -1;
    }

    public void readStudentById() {
        if (StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
            return;
        }
        System.out.println("Enter ID for search student : ");
        try {
            int ID = scn.nextInt();
            int search = searchByID(ID);
            Student student = StudentList.get(search);
            if (student == null) {
                System.out.println("ID not found!");
                scn.nextLine();
            } else {
                System.out.println("Information of model.Student");
                showStudent(student);
            }
        } catch (InputMismatchException e) {
            System.err.println("Error!" + "ID is incorrect format!");
            scn.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error! " + "ID is out of value!");
            scn.nextLine();
        }
    }

    public void updateStudentById() {
        if (StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
            return;
        }
        int exit = 0;
        System.out.println("Enter ID number : ");
        try {
            int ID = scn.nextInt();
            scn.nextLine();
            int search = searchByID(ID);
            Student student = StudentList.get(search);
            if (student == null) {
                System.out.println("Not found!");
            } else {
                while (exit == 0) {
                    MenuEditStudent();
                    int choose = scn.nextInt();
                    scn.nextLine();
                    switch (choose) {
                        case 1:
                            student.setName(inputName());
                            break;
                        case 2:
                            student.setAddress(inputAddress());
                            break;
                        case 3:
                            student.setDoB(inputDoB());
                            break;
                        case 4:
                            student.setHeight(inputHeight());
                            break;
                        case 5:
                            student.setWeight(inputWeight());
                            break;
                        case 6:
                            student.setStudentCode(inputStudentCode());
                            break;
                        case 7:
                            student.setSchoolName(inputSchoolName());
                            break;
                        case 8:
                            student.setYearOfAdmission(inputYearOfAdmission(student.getDoB()));
                            break;
                        case 9:
                            student.setGPA(inputGPA());
                            student.setStudentCapacity(student.getStudentCapacity());
                            break;
                        case 0:
                            System.out.println("exit!");
                            StudentReadAndWrite.write(StudentList);
                            exit = 1;
                            break;
                        default:
                            System.out.println("Please choose number in Menu!");
                            break;
                    }

                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Error!" + "ID is incorrect format!");
            scn.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error! " + "ID is out of value!");
            scn.nextLine();
        }
    }

    public void deleteStudentById() {
        if (StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
            return;
        }
        System.out.println("Enter ID for delete student");
        try {
            int ID = scn.nextInt();
            scn.nextLine();
            int search = searchByID(ID);
            if (search == -1) {
                System.out.println("ID not found!");
            } else {
                StudentList.remove(search);
                System.out.println("Deleted!");
                StudentReadAndWrite.write(StudentList);
            }
        } catch (InputMismatchException e) {
            System.err.println("Error!" + "ID is incorrect format!");
            scn.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error! " + "ID is out of value!");
            scn.nextLine();
        }

    }

    public void showStudentList() {
        if (StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
        } else {
            System.out.println("List of Student");
            for (int i = 0; i < StudentList.size(); i++) {
                showStudent(StudentList.get(i));
            }
        }
    }

    public void searchByStudentCapacity() {
        if (StudentList.isEmpty()) {
            System.err.println("Student List is empty!");
            return;
        }
        String capacity = "";
        int countResult = 0;
        System.out.println("Enter Student Capacity");
        System.out.println("Student Capacity : EXCELLENT, VERY_GOOD, GOOD, AVERAGE, BELOW_AVERAGE, POOR");
        boolean inputValid = false;
        while (!inputValid) {
            capacity = scn.nextLine();
            inputValid = checkInputCapacity(capacity);
            if (!inputValid) {
                System.out.print("Incorrect! Enter again :");
            }
        }

        for (int i = 0; i < StudentList.size(); i++) {
            if (StudentList.get(i).getStudentCapacity().toString().equals(capacity)) {
                showStudent(StudentList.get(i));
                countResult++;
            }
        }
        if (countResult == 0) System.out.println("Not found any student!");

    }

    public boolean checkInputCapacity(String checkStr) {
        int keyCheck = 0;
        String[] arrayCheck = {"EXCELLENT", "VERY_GOOD", "GOOD", "AVERAGE", "BELOW_AVERAGE", "POOR"};
        for (String str : arrayCheck) {
            if (checkStr.equals(str)) keyCheck++;
        }
        if (keyCheck == 0) {
            return false;
        }
        return true;

    }

    public void showStudent(Student student) {
        System.out.println("ID : " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Date of Birth : " + student.getDoB());
        System.out.println("Address : " + student.getAddress());
        System.out.println("Height : " + student.getHeight());
        System.out.println("Weight : " + student.getWeight());
        System.out.println("Student Code : " + student.getStudentCode());
        System.out.println("School Name : " + student.getSchoolName());
        System.out.println("Year of Admission : " + student.getYearOfAdmission());
        System.out.println("GPA : " + student.getGPA());
        System.out.println("Student Capacity :" + student.getStudentCapacity());
        System.out.println("-----------------------------------------");
    }

    public void MenuEditStudent() {
        System.out.println("Menu Edit");
        System.out.println("1.Update Name ");
        System.out.println("2.Update Address ");
        System.out.println("3.Update Date of Birth ");
        System.out.println("4.Update Height ");
        System.out.println("5.Update Weight ");
        System.out.println("6.Update model.Student Code ");
        System.out.println("7.Update School Name ");
        System.out.println("8.Update Year of Admission ");
        System.out.println("9.Update GPA ");
        System.out.println("0.Exit ");
    }

    private String inputName() {
        String inputName = "";
        boolean inputValid = false;
        System.out.print("Enter Name :");
        while (!inputValid) {
            inputName = scn.nextLine();
            if (Validate.checkInputName(inputName)) {
                inputValid = true;
            } else {
                System.out.println("Incorrect Name format ! Enter again!");
            }
        }
        return inputName.trim();
    }

    private String inputAddress() {
        System.out.print("Enter address : ");
        String inputAddress = "";
        boolean inputValid = false;
        while (!inputValid) {
            inputAddress = scn.nextLine();
            if (Validate.checkInputAddress(inputAddress)) {
                inputValid = true;
            } else {
                System.out.println("Incorrect Address format ! Enter again!");
            }
        }
        return inputAddress.trim();
    }

    private LocalDate inputDoB() {
        String inputDate;
        LocalDate date = null;
        boolean inputValid = false;
        System.out.print("Enter date of birth (format yyyy-mm-dd) :");
        while (!inputValid) {
            try {
                inputDate = scn.nextLine();
                date = LocalDate.parse(inputDate);
                if (Validate.checkInputDoB(date)) {
                    inputValid = true;
                } else {
                    System.out.println("Year is out of value (1900< year < 2009) ! Enter again !");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input format ! Enter again !");

            }
        }
        return date;
    }

    private float inputHeight() {
        float height = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter height : ");
                height = scn.nextFloat();
                if (Validate.checkInputHeight(height)) {
                    inputValid = true;
                } else {
                    System.out.println("Height input is out of Value! Enter again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input ! Please enter height again!");
                scn.nextLine();
            }
        }
        return height;
    }

    private float inputWeight() {
        float weight = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter weight : ");
                weight = scn.nextFloat();
                scn.nextLine();
                if (Validate.checkInputWeight(weight)) {
                    inputValid = true;
                } else {
                    System.out.println("Weight input is out of Value! Enter again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input ! Please enter height again!");
                scn.nextLine();
            }
        }
        return weight;
    }

    private String inputStudentCode() {
        String StudentCode = "";
        boolean inputValid = false;
        while (!inputValid) {
            System.out.print("Enter student code : ");
            StudentCode = scn.nextLine();
            if (Validate.checkInputStudentCode(StudentCode)) {
                inputValid = true;
            } else {
                System.out.println("Incorrect Format of Student code ! Enter Again!");
            }
        }
        return StudentCode;
    }

    private int inputYearOfAdmission(LocalDate DoB) {
        int year = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter year of admission : ");
                year = scn.nextInt();
                if (Validate.checkInputYearOfAdmission(year, DoB)) {
                    inputValid = true;
                } else {
                    System.out.println("Input year is out of value ! Enter again !");
                    scn.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error ! Enter again !");
                scn.nextLine();
            }
        }
        return year;
    }

    private String inputSchoolName() {
        String SchoolName = "";
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter school name : ");
                SchoolName = scn.nextLine();
                if (Validate.checkInputSchoolName(SchoolName)) {
                    inputValid = true;
                } else {
                    System.out.println("Incorrect Format ! Enter again !");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error ! Enter again !");
                scn.nextLine();
            }
        }
        return SchoolName;
    }

    private double inputGPA() {
        double GPA = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Enter GPA : ");
                GPA = scn.nextDouble();
                if (Validate.checkInputGPA(GPA)) {
                    inputValid = true;
                } else {
                    System.out.println("GPA is out of value ! Enter again !");
                    scn.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error ! Enter again !");
                scn.nextLine();
            }
        }
        return GPA;
    }

    public Integer getMaxID() {
        if (StudentList.isEmpty()) {
            return 1;
        }
        Integer maxID = StudentList.get(0).getId();
        for (Student student : StudentList) {
            if (student.getId() > maxID) {
                maxID = student.getId();
            }
        }
        return maxID + 1;
    }
}
