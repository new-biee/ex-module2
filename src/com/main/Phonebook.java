package com.main;

import java.io.Serializable;

public class Phonebook implements Serializable {
    private String phoneNumber;
    private String groupOfContacts;
    private String fullName;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public Phonebook() {
    }

    public Phonebook(String phoneNumber, String groupOfContacts, String fullName, String gender, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.groupOfContacts = groupOfContacts;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroupOfContacts() {
        return groupOfContacts;
    }

    public void setGroupOfContacts(String groupOfContacts) {
        this.groupOfContacts = groupOfContacts;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", groupOfContacts='" + groupOfContacts + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
