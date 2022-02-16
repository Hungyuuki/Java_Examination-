package com.company.Management;

import com.company.IOFile.ReadFile;
import com.company.IOFile.WriteFile;
import com.company.Model.Drink;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManagement implements ReadFile, WriteFile {
    private List<Drink> order = new ArrayList<>();

    public Drink getDrink(int index) {
        return order.get(index);
    }

    public int totalDrink() {
        return order.size();
    }

    public void addNewDrinkToOrder(Drink drink) {
        this.order.add(drink);
        try {
            writeFile("Order List.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayAllDrinkBill() {
        for (Drink drink : order
        ) {
            System.out.println(drink);
        }
    }

    public String orderDrink(Drink drink) {
        String string = String.format("%-10s %-15s %-10d", drink.getId(), drink.getName(), drink.getAmount(), drink.getPrice());
        return string;
    }

    public void removeDrink(String id) {
        this.order.remove(id);

    }

    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < order.size(); i++) {
            total += order.get(i).getPrice();
        }
        return total;
    }

    public String printBill(Drink drink) {
        String string = String.format("%-10s %-15s %-10d %-10d", drink.getId(), drink.getName(), drink.getAmount(), drink.getPrice());
        return string;
    }

    public void writeBillFileText(String path) throws IOException {
        FileWriter billFileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(billFileWriter);
        bufferedWriter.write("そこよー、CÀ PHÊ - SÁCH ĐÔNG TÂY ようこそー\n");
        bufferedWriter.write("\t\t\t\tWELCOME\n");
        bufferedWriter.write("***************************************\n");
        bufferedWriter.write("ID\t\tĐồ Uống\t\tSố Lượng\t\tĐơn Giá\n");
        for (Drink drink : order) {
            bufferedWriter.write(drink.getId() + "\t\t" + drink.getName()
                    + "\t\t\t" + drink.getAmount() + "\t\t\t" + drink.getPrice() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write("***************************************\n");
        for (Drink drink : order) {
            bufferedWriter.write("Tổng là " + (totalPrice() * drink.getAmount()) + " VNĐ");
        }
        bufferedWriter.close();
        billFileWriter.close();
    }

    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        order = (List<Drink>) objectInputStream.readObject();
        is.close();
        objectInputStream.close();
    }

    public void writeFile(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(order);
        outputStream.close();
        objectOutputStream.close();
    }
}
