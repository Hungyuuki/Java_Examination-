package com.company.MainPackage;

import com.company.Management.BookManagement;
import com.company.Model.Book;

import java.util.Scanner;

public class MainBook {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookManagement bookManagement = new BookManagement();

        int ChoiceMainMenu = -1;
        do {
            bookMainMenu();
            System.out.println("Nhập lựa chọn: ");
            ChoiceMainMenu = scanner.nextInt();
            scanner.nextLine();
            switch (ChoiceMainMenu) {
                case 1: {
                    showAllBook(bookManagement);
                    break;
                }
                case 2: {
                    showAddNewBook(bookManagement);
                    break;
                }
                case 3: {
                    showUpdateBookByID(bookManagement);
                    break;
                }
                case 4: {
                    showDeleteBookByID(bookManagement);
                    break;
                }
                case 5: {
                    int choiceSubMenuFind = -1;
                    do {
                        System.out.println("Tìm sách theo yêu cầu: ");
                        System.out.println("Nhập lựa chọn: ");
                        subMenu_FindBook();
                        choiceSubMenuFind = scanner.nextInt();
                        switch (choiceSubMenuFind) {
                            case 1: {
                                findBookByBookName(bookManagement);
                                break;
                            }
                            case 2: {
                                findBookByAuthorName(bookManagement);
                                break;
                            }
                            case 3: {
                                findBookByCategory(bookManagement);
                                break;
                            }
                            case 0:
                                break;
                        }
                    }
                    while (choiceSubMenuFind != 0);
                }
            }
        } while (ChoiceMainMenu != 0);
    }

    private static void findBookByBookName(BookManagement bookManagement) {
        System.out.println("Tìm sách theo tên đầu sách: ");
        System.out.println("Mời nhập chính xác tên sách: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        int index = bookManagement.findBookByName(name);
        if (index != -1) {
            System.out.println("Thông tin sách cần tìm: " + bookManagement.getBook(index));
        } else System.err.println("Không tìm thấy tên sách");
    }

    private static void findBookByAuthorName(BookManagement bookManagement) {
        System.out.println("Tìm sách theo tên tác giả: ");
        System.out.println("Nhập chính xác tên tác giả: ");
        scanner.nextLine();
        String author = scanner.nextLine();
        int index = bookManagement.findBookByAuthor(author);
        if (index != -1) {
            System.out.println("Sách theo tên tác giả: \n" + bookManagement.returnBookNameFromAuthor(author));
        } else System.err.println("Không tìm thấy tên tác giả");
    }

    private static void findBookByCategory(BookManagement bookManagement) {
        System.out.println("Tìm sách theo thể loại: ");
        System.out.println("Nhập chính xác thể loại: ");
        scanner.nextLine();
        String category = scanner.nextLine();
        int index = bookManagement.findBookByCategory(category);
        if (index != -1) {
            System.out.println("Sách theo tên thể loại: \n" + bookManagement.returnBookNameFromCategory(category));
        } else System.err.println("Không tìm thấy tên thể loại");
    }

    private static void subMenu_FindBook() {
        System.out.println("1. Tìm sách theo tên đầu sách: ");
        System.out.println("2. Tìm sách theo tên tác giả: ");
        System.out.println("3. Tìm sách theo thể loại: ");
        System.out.println("0. Quay lại Menu chính: ");
    }

    private static void showDeleteBookByID(BookManagement bookManagement) {
        System.out.println("Xóa thông tin sách:");
        System.out.println("Nhập ID sách cần xóa:");
        String id = scanner.nextLine();
        boolean isDeleted = bookManagement.removeBookByID(id);
        if (isDeleted)
            System.out.println("Xóa sách thành công");
        else System.err.println("Không xóa được vì không có ID này");
    }

    private static void showUpdateBookByID(BookManagement bookManagement) {
        System.out.println("Chỉnh sửa thông tin sách: ");
        System.out.println("Nhập id cần chỉnh sửa: ");
        String id = scanner.nextLine();
        int index = bookManagement.findBookByID(id);
        if (index != -1) {
            Book book = inputNewBookInfo();
            bookManagement.updateBookByID(id, book);
            System.out.println("Chỉnh sửa OK.");
        } else
            System.err.println("Không update được vì không có ID này.");
    }

    private static void showAddNewBook(BookManagement bookManagement) {
        System.out.println("Thêm sách mới: ");
        Book book = inputNewBookInfo();
        bookManagement.addNewBook(book);
    }

    private static void showAllBook(BookManagement bookManagement) {
        int total = bookManagement.totalBook();
        if (total == 0)
            System.out.println("Danh sách rỗng!!!");
        else
            bookManagement.displayAllBook();
    }

    private static Book inputNewBookInfo() {
        System.out.println("Nhập ID sách: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sách: ");
        String name = scanner.nextLine();
        System.out.println("Nhập số lượng: ");
        Integer amount = scanner.nextInt();
        System.out.println("Nhập tên tác giả: ");
        scanner.nextLine();
        String author = scanner.nextLine();
        System.out.println("Nhập thể loại: ");
        String category = scanner.nextLine();
        Book book = new Book(id, name, category, amount, author);
        return book;
    }

    private static void bookMainMenu() {
        System.out.println("へー、そこよー、CÀ PHÊ - SÁCH ĐÔNG TÂY　へ　ようこそー");
        System.out.println("1. Hiển thị danh sách Book: ");
        System.out.println("2. Thêm sách mới: ");
        System.out.println("3. Chỉnh sửa thông tin sách theo ID: ");
        System.out.println("4. Xóa sách theo ID: ");
        System.out.println("5. Tìm sách: ");
        System.out.println("0. Exit!!!");
    }
}
