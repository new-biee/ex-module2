package com.main;

import java.io.*;
import java.util.ArrayList;

public class IO {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void csvWriterPhoneBook(String path, Phonebook phonebook) {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }

            fileWriter = new FileWriter(file, true);
            fileWriter.append(String.valueOf(phonebook.getPhoneNumber()));
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phonebook.getGroupOfContacts());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phonebook.getFullName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phonebook.getGender());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phonebook.getAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phonebook.getDateOfBirth());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(phonebook.getEmail());
            fileWriter.append(NEW_LINE_SEPARATOR);

        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void csvWriterPhoneBookUpdate(String path, ArrayList<Phonebook> phonebooks) {
        File file = new File(path);
        FileWriter fileWriter = null;

        try {
            if (!file.exists()) {
                System.out.println("File not exits");
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);

            for (int i = 0; i < phonebooks.size(); i++) {
                fileWriter.write(String.valueOf(phonebooks.get(i).getPhoneNumber()));
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(phonebooks.get(i).getGroupOfContacts());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(phonebooks.get(i).getFullName());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(phonebooks.get(i).getGender());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(phonebooks.get(i).getAddress());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(phonebooks.get(i).getDateOfBirth());
                fileWriter.write(COMMA_DELIMITER);
                fileWriter.write(phonebooks.get(i).getEmail());
                fileWriter.write(NEW_LINE_SEPARATOR);
                fileWriter.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    System.out.println("Write success!");
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static ArrayList<Phonebook> readDataToListPhoneBook() {
        ArrayList<Phonebook> listPhoneBook = new ArrayList<>();
        String fileIn = "data/contacts.csv";
        String line = null;
        File file = new File(fileIn);
        FileReader fileReader = null;

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } else {
            try {
                fileReader = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException exception) {
                    System.out.println(exception);
                }
                String[] temp = line.split(COMMA_DELIMITER);

                String phoneNumber = temp[0];
                String groups = temp[1];
                String fullName = temp[2];
                String gender = temp[3];
                String address = temp[4];
                String dateOfBirth = temp[5];
                String email = temp[6];
                listPhoneBook.add(new Phonebook(phoneNumber, groups, fullName, gender, address, dateOfBirth, email));
            }
            try {
                bufferedReader.close();
            } catch (IOException exception) {
                exception.printStackTrace();
                return null;
            }
        }
        return listPhoneBook;
    }
}
