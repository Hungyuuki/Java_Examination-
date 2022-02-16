package com.company.Management;

import com.company.IOFile.ReadFile;
import com.company.IOFile.WriteFile;
import com.company.Model.Drink;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DrinkManagement implements ReadFile, WriteFile {
    private static List<Drink> drinks = new ArrayList<>();

    public DrinkManagement() {
        try {
            readFile("Drink List.txt");
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public Drink getDrink(int index) {
        return drinks.get(index);
    }

    public int totalDrink() {
        return drinks.size();
    }

    public void displayAllDrinkMenu() {
        for (Drink drink : drinks
        ) {
            System.out.println(drink);
        }
    }

    public void addNewDrinkToMenu(Drink drink) {
        this.drinks.add(drink);
        try {
            writeFile("Drink List.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String orderDrink(Drink drink) {
        String string = String.format("%-10s %-15s %-10d %-10d", drink.getId(), drink.getName(), drink.getAmount(), drink.getPrice());
        return string;
    }

    public void removeDrink(String id) {
        this.drinks.remove(id);

    }

    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < drinks.size(); i++) {
            total += drinks.get(i).getPrice();
        }
        return total;
    }

    public int findDrinkByID(String id) {
        int index = -1;
        for (int i = 0; i < drinks.size(); i++) {
            if (drinks.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean updateDrinkInfo(String id, Drink drink) {
        int index = findDrinkByID(id);
        if (index != -1) {
            drinks.set(index, drink);
            return true;
        }
        return false;
    }

    public String printBill(Drink drink) {
        String string = String.format("%-10s %-15s %-10d", drink.getId(), drink.getName(), drink.getPrice());
        return string;
    }

    public boolean removeDrinkByID(String id) {
        int index = findDrinkByID(id);
        if (index != -1) {
            drinks.remove(index);
            try {
                writeFile("Drink List.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }

    public static void writeMenuFileText(String path) throws IOException {
        FileWriter menuFileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(menuFileWriter);
        bufferedWriter.write("そこよー、CÀ PHÊ - SÁCH ĐÔNG TÂYようこそー\n");
        bufferedWriter.write("\t\t\t\tWELCOME\n");
        bufferedWriter.write("***************************************\n");
        bufferedWriter.write("ID\t\t\tĐồ Uống\t\tSố Lượng\t\tĐơn Giá\n");
        for (Drink drink : drinks) {
            bufferedWriter.write(drink.getId() + "\t\t\t" + drink.getName()
                    + "\t\t\t" + drink.getAmount() + "\t\t\t" + drink.getPrice() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write("***************************************\n");
        bufferedWriter.close();
        menuFileWriter.close();
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        drinks = (List<Drink>) objectInputStream.readObject();
        is.close();
        objectInputStream.close();
    }

    public void writeFile(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(drinks);
        outputStream.close();
        objectOutputStream.close();
    }
}





