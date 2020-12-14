package com.main;

import java.util.List;
import java.util.Scanner;

public class ViewMain {
    static Scanner scanner = new Scanner(System.in);
    static View view = new View();

    public static void main(String[] args) {
        viewMain();
    }

    public static void viewMain() {
        ListPhoneBook listPhoneBook = new ListPhoneBook();
        ListPhoneBook.setListPhoneBooks(IO.readDataToListPhoneBook());
        Phonebook phonebook = null;

        while (true) {
            try {
                do {
                    System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
                    System.out.println("Chọn chức năng theo số (để tiếp tục):");
                    System.out.println("1. Xem danh sách");
                    System.out.println("2. Thêm mới");
                    System.out.println("3. Cập nhật");
                    System.out.println("4. Xóa");
                    System.out.println("5. Tìm kiếm");
                    System.out.println("6. Đọc từ file");
                    System.out.println("7. Ghi vào file");
                    System.out.println("8. Thoát");
                    int number = Integer.parseInt(scanner.nextLine());
                    switch (number) {
                        case 1:
                            view.showAllPhoneBook();
                            break;
                        case 2:
                            listPhoneBook.addPhoneBook(listPhoneBook.formAddPhone());
                            break;
                        case 3:
                            String inputPhoneNumberUpdate = view.inputPhoneNumber();
                            String groupUpdate = view.inputGroup();
                            String fullNameUpdate = view.inputFullName();
                            String genderUpdate = view.inputGender();
                            String addressUpdate = view.inputAddress();
                            String dataOfBirthUpdate = view.inputDateOfBirth();
                            String email = view.inputEmail();
                            phonebook = new Phonebook(inputPhoneNumberUpdate, fullNameUpdate, groupUpdate, genderUpdate, addressUpdate, dataOfBirthUpdate, email);
                            listPhoneBook.updatePhoneBook(phonebook);
                            listPhoneBook.updateListPhoneBook();
                            break;
                        case 4:
                            String inputRemovePhoneNumber = view.inputPhoneNumber();
                            listPhoneBook.removeOnePhone(inputRemovePhoneNumber);
//                            listPhoneBook.updateListPhoneBook();
                            break;
                        case 5:
                            String findPhoneNumber = view.inputPhoneNumber();
                            Phonebook phonebook1 = listPhoneBook.findPhoneBookByPhoneNumber(findPhoneNumber);
                            view.showOnePhone(phonebook1);
                            break;
                        case 6:
                            IO.csvWriterPhoneBook("data/contacts.csv", phonebook);
                            break;
                        case 7:
                            listPhoneBook.updateListPhoneBook();
                            break;
                        case 8:
                            System.out.println("Xin hẹn gặp lại!");
                            System.exit(0);
                        default:
                            System.out.println("Xin nhập đúng số từ 1 đến 8");
                            viewMain();
                    }
                } while (true);
            } catch (Exception e) {
                System.err.println(e);
                System.err.println("Xin nhập đúng số từ 1 đến 8");
            }
        }
    }
}