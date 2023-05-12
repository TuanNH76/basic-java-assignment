package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    public static int idCounter =1;
    private int id;
    private String name;
    private LocalDate DoB;
    private String address;
    private Float height;
    private Float weight;

    public Person() {}
    public Person(String name, LocalDate DoB, String address, float height, float weight) {
        this.id = idCounter++;
        this.name = name;
        this.DoB = DoB;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Id : " + this.id +"\n"
                + "Name : " + this.name +"\n"
                + "Date of Birthday : " + this.DoB + "\n"
                + "Address : " + this.address + "\n"
                + "Height : " + this.height + "\n"
                + "Weight : " + this.weight + "\n"
                ;
    }


}
