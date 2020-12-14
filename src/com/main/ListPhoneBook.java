package com.main;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListPhoneBook {
    static ArrayList<Phonebook> phonebooks = new ArrayList<>();
    static View view = new View();

    public static void setListPhoneBooks(ArrayList<Phonebook> listPhoneBook) {
        ListPhoneBook.phonebooks = listPhoneBook;
    }

    public static ArrayList<Phonebook> getListPhoneBooks() {
        return phonebooks;
    }

    public Phonebook formAddPhone() {
        Phonebook phonebook = new Phonebook();
        phonebook.setPhoneNumber(view.inputPhoneNumber());
        phonebook.setGroupOfContacts(view.inputGroup());
        phonebook.setFullName(view.inputFullName());
        phonebook.setGender(view.inputGender());
        phonebook.setAddress(view.inputAddress());
        phonebook.setDateOfBirth(view.inputDateOfBirth());
        phonebook.setEmail(view.inputEmail());

        return phonebook;
    }

    public void addPhoneBook(Phonebook phonebook) {
        phonebooks.add(phonebook);
    }

    public void updateListPhoneBook() {
        IO.csvWriterPhoneBookUpdate("data/contacts.csv", ListPhoneBook.getListPhoneBooks());
    }

    public void updatePhoneBook(Phonebook phonebook) {
        for (Phonebook p : ListPhoneBook.getListPhoneBooks()) {
            if (p.getPhoneNumber().equals(phonebook.getPhoneNumber())) {
                p.setGroupOfContacts(phonebook.getGroupOfContacts());
                p.setFullName(phonebook.getFullName());
                p.setGender(phonebook.getGender());
                p.setAddress(phonebook.getAddress());
                p.setDateOfBirth(phonebook.getDateOfBirth());
                p.setEmail(phonebook.getEmail());
            }
        }
    }

    public ArrayList<Phonebook> removeOnePhone(String phoneNumber) {
        for (int i = 0; i < phonebooks.size(); i++) {
            if (phoneNumber.equals(phonebooks.get(i).getPhoneNumber())) {
                phonebooks.remove(i);
            }
        }
        return phonebooks;
    }

    public Phonebook findPhoneBookByPhoneNumber(String phoneNumber) {
        for (Phonebook p : phonebooks) {
            if (p.getPhoneNumber() == phoneNumber) {
                return p;
            }
        }
        return null;
    }


}
