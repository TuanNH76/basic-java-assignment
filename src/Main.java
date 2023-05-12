import service.SortPercentService;
import service.StudentService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        SortPercentService sortPercentService = new SortPercentService();
        int key;
        boolean exit = false;
        try {
            Scanner scanner = new Scanner(System.in);
            while (!exit) {
                showMenu();
                key = scanner.nextInt();

                switch (key) {

                    case 1:
                        studentService.createStudent();
                        break;
                    case 2:
                        studentService.readStudentById();
                        break;
                    case 3:
                        studentService.updateStudentById();
                        break;
                    case 4:
                        studentService.deleteStudentById();
                        break;
                    case 5:
                        studentService.showStudentList();
                        break;
                    case 6:
                        sortPercentService.sortCapacityPercent();
                        break;
                    case 7:
                        sortPercentService.showGPAPercent();
                        break;
                    case 8:
                        studentService.searchByStudentCapacity();
                        break;
                    case 0:
                        System.out.println("Exit");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid value ! Choose the menu");
                        break;
                }
                if (exit) break;
            }
        } catch (InputMismatchException e) {
            System.err.println("ERROR!");
        }
    }

    public static void showMenu() {
        System.out.println("Menu");
        System.out.println("1.Create student");
        System.out.println("2.Read student");
        System.out.println("3.Update student");
        System.out.println("4.Delete student");
        System.out.println("5.Show list of student");
        System.out.println("6.Show Student Capacity Percentage");
        System.out.println("7.Show GPA Percentage");
        System.out.println("8.Search By Student Capacity");
        System.out.println("0.Exit");
    }
}
