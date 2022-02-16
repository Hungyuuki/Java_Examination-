package com.company.MainPackage;

import com.company.Management.DrinkManagement;
import com.company.Model.Drink;

import java.util.Scanner;

public class MainDrink {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        DrinkManagement drinkManagement = new DrinkManagement();

        int ChoiceMainMenu = -1;
        do {
            drinkMainMenu();
            System.out.println("Nhập lựa chọn: ");
            ChoiceMainMenu = scanner.nextInt();
            scanner.nextLine();
            switch (ChoiceMainMenu) {
                case 1: {
                    showAllDrink(drinkManagement);
                    break;
                }
                case 2: {
                    showAddNewDrink(drinkManagement);
                    break;
                }
                case 3: {
                    showUpdateDrinkByID(drinkManagement);
                    break;
                }
                case 4: {
                    showDeleteBookByID(drinkManagement);
                    break;
                }
                case 5: {
                    findDrinkByDrinkName(drinkManagement);
                    break;
                }
            }
        } while (ChoiceMainMenu != 0);
    }

    private static void findDrinkByDrinkName(DrinkManagement drinkManagement) {
        System.out.println("Tìm đồ uống theo tên: ");
        System.out.println("Mời nhập chính xác tên đồ uống: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        int index = drinkManagement.findDrinkByID(name);
        if (index != -1) {
            System.out.println("Thông tin đồ uống cần tìm: " + drinkManagement.getDrink(index));
        } else System.err.println("Không tìm thấy tên");
    }

    private static void showDeleteBookByID(DrinkManagement drinkManagement) {
        System.out.println("Xóa thông tin đồ uống:");
        System.out.println("Nhập ID món cần xóa:");
        String id = scanner.nextLine();
        boolean isDeleted = drinkManagement.removeDrinkByID(id);
        if (isDeleted)
            System.out.println("Xóa thành công");
        else System.err.println("Không xóa được vì không có ID này");
    }

    private static void showUpdateDrinkByID(DrinkManagement drinkManagement) {
        System.out.println("Chỉnh sửa thông tin đồ uống: ");
        System.out.println("Nhập id cần chỉnh sửa: ");
        String id = scanner.nextLine();
        int index = drinkManagement.findDrinkByID(id);
        if (index != -1) {
            Drink drink = inputNewDrinkInfo();
            drinkManagement.updateDrinkInfo(id, drink);
            System.out.println("Chỉnh sửa OK.");
        } else
            System.err.println("Không update được vì không có ID này.");
    }

    private static void showAddNewDrink(DrinkManagement drinkManagement) {
        System.out.println("Thêm drink mới: ");
        Drink drink = inputNewDrinkInfo();
        drinkManagement.addNewDrinkToMenu(drink);
    }

    private static void showAllDrink(DrinkManagement drinkManagement) {
        int total = drinkManagement.totalDrink();
        if (total == 0)
            System.out.println("Danh sách rỗng!!!");
        else
            drinkManagement.displayAllDrinkMenu();
    }

    private static Drink inputNewDrinkInfo() {
        System.out.println("Nhập ID drink: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên drink: ");
        String name = scanner.nextLine();
        System.out.println("Nhập đơn giá: ");
        Integer price = scanner.nextInt();
        System.out.println("Nhập số lượng: ");
        Integer amount = scanner.nextInt();
        Drink drink = new Drink(id, name, price, amount);
        return drink;
    }

    private static void drinkMainMenu() {
        System.out.println("へー、そこよー、CÀ PHÊ - SÁCH ĐÔNG TÂY　へ　ようこそー");
        System.out.println("1. Hiển thị danh sách đồ uống: ");
        System.out.println("2. Thêm đồ uống mới: ");
        System.out.println("3. Chỉnh sửa thông tin đồ uống theo ID: ");
        System.out.println("4. Xóa đồ uống theo ID: ");
        System.out.println("5. Tìm món: ");
        System.out.println("0. Exit!!!");
    }
}
