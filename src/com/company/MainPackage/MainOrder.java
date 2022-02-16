package com.company.MainPackage;

import com.company.Management.DrinkManagement;
import com.company.Management.OrderManagement;
import com.company.Model.Drink;

import java.io.IOException;
import java.util.Scanner;

public class MainOrder {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        DrinkManagement drinkManagement = new DrinkManagement();
        OrderManagement orderManagement = new OrderManagement();
        System.out.println("Nhập ID drink: ");
        String id = scanner.nextLine();
        int index = drinkManagement.findDrinkByID(id);
        Drink order = drinkManagement.getDrink(index);
        if (index != -1) {
            System.out.println("Thông tin đồ uống cần tìm: " + drinkManagement.getDrink(index));
        } else System.err.println("Không tìm thấy tên");
        System.out.println("Nhập số lượng: ");
        Integer amount = scanner.nextInt();
        order.setAmount(amount);
        order.setPrice(order.getPrice());
        System.out.println("In hóa đơn: ");
        orderManagement.addNewDrinkToOrder(order);
        orderManagement.printBill(order);

        try {
            orderManagement.writeBillFileText("billOrder.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
