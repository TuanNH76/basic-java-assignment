package validation;

import java.time.LocalDate;

public class Validate {
    public static final int MAX_NAME_LENGTH = 100;
    public static final int MAX_ADDRESS_LENGTH = 300;
    public static final double MIN_HEIGHT = 50.0;
    public static final double MAX_HEIGHT = 300.0;
    public static final double MIN_WEIGHT = 5.0;
    public static final double MAX_WEIGHT = 1000.0;
    public static final int MAX_STUDENT_CODE_LENGTH = 10;
    public static final int MAX_SCHOOL_NAME_LENGTH = 200;
    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 10.0;
    public static final int MIN_YEAR = 1900;
    public static final int MAX_YEAR = 2009;
    public static final String NAME_REGEX = "^[a-zA-Z ]+$";
    public  static final String ADDRESS_REGEX = "^[a-zA-Z0-9,/ ]+$";
    public static final String SCHOOL_REGEX = "^[a-zA-Z0-9,/ ]+$";
    public static final String STUDENT_CODE_REGEX = "^[a-zA-Z0-9.]+$";
    public Validate() {
    }

    public static boolean checkInputName(String inputName) {
        if (inputName.length() < MAX_NAME_LENGTH && inputName.length() > 0 && inputName.matches(NAME_REGEX) && !inputName.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkInputAddress(String inputAddress) {
        if (inputAddress.length() < MAX_ADDRESS_LENGTH && inputAddress.length() > 0 && inputAddress.matches(ADDRESS_REGEX) && !inputAddress.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkInputDoB(LocalDate date) {
        if (date.getYear() > MIN_YEAR && date.getYear() < MAX_YEAR) {
            return true;
        }
        return false;
    }

    public static boolean checkInputHeight(float height) {
        if (height >= MIN_HEIGHT && height <= MAX_HEIGHT) {
            return true;
        }
        return false;
    }

    public static boolean checkInputWeight(float weight) {
        if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT) {
            return true;
        }
        return false;
    }

    public static boolean checkInputStudentCode(String StudentCode) {
        boolean check = checkDistinctStudentCode(StudentCode);
        if (StudentCode.length() == MAX_STUDENT_CODE_LENGTH && StudentCode.matches(STUDENT_CODE_REGEX) && check) {
            return true;
        }
        return false;
    }

    private static boolean checkDistinctStudentCode(String code) {
        int k = 0;
        char c;
        for (int i = 0; i < code.length(); i++) {
            c = code.charAt(i);
            for (int j = i + 1; j < code.length(); j++) {
                if (c == code.charAt(j)) {
                    k++;
                }
            }
        }
        if (k == 0) {
            return true;
        }
        return false;
    }

    public static boolean checkInputYearOfAdmission(int year, LocalDate DoB) {
        LocalDate localDate = LocalDate.now();
        if (year > DoB.getYear() + 15 && year <= localDate.getYear()) {
            return true;
        }
        return false;
    }

    public static boolean checkInputSchoolName(String schoolName) {
        if (schoolName.length() < MAX_SCHOOL_NAME_LENGTH && schoolName.length() > 0 && schoolName.matches(SCHOOL_REGEX) && !schoolName.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkInputGPA(double GPA) {
        if (GPA >= MIN_GPA && GPA <= MAX_GPA) {
            return true;
        }
        return false;
    }

}
