package models;

import java.io.Serializable;

public class Person implements Serializable {
    private int _id;
    private String _name;
    private double _salary;
    private Address _address;

    public int getID() {
        return _id;
    }
    public void setID(int id) {
        this._id = id;
    }
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }
    public double getSalary() {
        return _salary;
    }
    public void setSalary(double salary) {
        if(salary >= 0){
            this._salary = salary;
        }
        else{
            // selber eine Exception werfen (throw)
            throw new IllegalArgumentException("Gehalt darf nicht negativ sein");
        }

    }

    public Address getAddress() {
        return _address;
    }
    public void setAddress(Address address) {
        if(address != null){
            this._address = address;
        }
    }

    public Person() { this(0, "", 0.0);}
    public Person(int id, String name, double salary){
        this.setID(id);
        this.setName(name);
        this.setSalary(salary);
    }

    @Override
    public String toString(){
        return this.getID() + " " + this.getName() + " " + this.getSalary();
    }

}
