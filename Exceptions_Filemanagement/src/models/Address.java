package models;

import java.io.Serializable;

public class Address implements Serializable {
    private int _aID;
    private String _street;

    public int getAID() {
        return _aID;
    }
    public void setAID(int aID) {
        this._aID = aID;
    }
    public String getStreet() {
        return _street;
    }
    public void setStreet(String street) {
        this._street = street;
    }

    public Address(){
        this(0, "");
    }
    public Address(int aID, String street) {
        this.setAID(aID);
        this.setStreet(street);
    }

    @Override
    public String toString() {
        return this.getAID() + " " + this.getStreet();
    }
}
