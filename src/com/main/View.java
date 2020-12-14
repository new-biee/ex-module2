package com.main;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class View {
    static Scanner scanner = new Scanner(System.in);
    static boolean check = false;


    public String inputPhoneNumber() {

        while (true) {
            System.out.println("Enter phone number");
            String inputPhoneNumber = scanner.nextLine();
            String phoneNumberPattern = "^(09|01[2|6|8|9])+([0-9]{8})\\b";
            Pattern patternPhoneNumber = Pattern.compile(phoneNumberPattern);
            Matcher matcherPhoneNumber = patternPhoneNumber.matcher(inputPhoneNumber);
            try {
                if (matcherPhoneNumber.find()) {
                    check = true;
                    return inputPhoneNumber;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter again!");
            }
        }
    }

    public String inputGroup() {
        System.out.println("Enter group:");
        String inputGroup = scanner.nextLine();
        return inputGroup;
    }

    public String inputFullName() {
        System.out.println("Enter full name:");
        String inputFullName = scanner.nextLine();
        return inputFullName;
    }

    public String inputGender() {
        System.out.println("Enter gender:");
        String inputGender = scanner.nextLine();
        return inputGender;
    }

    public String inputAddress() {
        System.out.println("Enter address:");
        String inputAddress = scanner.nextLine();
        return inputAddress;
    }

    public String inputDateOfBirth() {
        System.out.println("Enter date of birth:");
        String inputDateOfBirth = scanner.nextLine();
        return inputDateOfBirth;
    }

    public String inputEmail() {
        while (true) {
            System.out.println("Enter email");
            String emailPattern = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            String inputEmail = scanner.nextLine();
            Pattern patternEmail = Pattern.compile(emailPattern);
            Matcher matcherEmail = patternEmail.matcher(inputEmail);
            try {
                if (matcherEmail.find()) {
                    check = true;
                    return inputEmail;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter again!");
            }
        }
    }

    public void showAllPhoneBook() {
        for (Phonebook p : ListPhoneBook.getListPhoneBooks()) {
            System.out.println(p);
        }
        System.out.println();
    }

    public void showOnePhone(Phonebook phonebook) {
        if (phonebook == null) {
            System.out.println("PhoneNumber Not available");
        } else {
            System.out.println(phonebook);
        }
    }
}
