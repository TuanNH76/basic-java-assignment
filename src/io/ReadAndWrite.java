package io;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    private static final String FILENAME="student.txt";
    public ReadAndWrite(){

    }

    public void write(List<Student> studentList){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            File file=new File(FILENAME);
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
        }catch (IOException e){
            System.err.println("Error!" +e.getMessage());
        }finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }catch (IOException ex) {
                System.err.println("Error closing file!" + ex.getMessage());
            }
        }
    }

    public List<Student> read(){
        List<Student> studentList=new ArrayList<>();
        FileInputStream fileInputStream = null ;
        ObjectInputStream objectInputStream =null ;

        try {
            File file = new File(FILENAME);
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Student>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println("Error!" +e.getMessage());
        }finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }catch (IOException ex) {
                System.err.println("Error closing file!" + ex.getMessage());
            }
        }
        return studentList;
    }
}
