package com.company.Management;

import com.company.IOFile.ReadFile;
import com.company.IOFile.WriteFile;
import com.company.Model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement implements ReadFile, WriteFile {
    private List<Book> books = new ArrayList<>();

    public BookManagement() {
        try {
            readFile("BookList.txt");
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public int totalBook() {
        return books.size();
    }

    public List<Book> returnBookNameFromAuthor(String author) {
        List<Book> bookNameFromAuthor = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().equals(author)) {
                bookNameFromAuthor.add(books.get(i));
            }
            // viết code để lọc
            //// nếu cuốn sách nào của author đã nhập thì add vào list bookNameFromAuthor
        }
        return bookNameFromAuthor;
    }

    public List<Book> returnBookNameFromCategory(String category) {
        List<Book> bookNameFormCategory = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCategory().equals(category)) {
                bookNameFormCategory.add(books.get(i));
                //tương tự như tìm theo tên tác giả nhưng lần này là theo thể loại
            }
        }
        return bookNameFormCategory;
    }

    public void displayAllBook() {
        for (Book book :
                books) {
            System.out.println(book);
        }
    }

    public void addNewBook(Book book) {
        this.books.add(book);
        try {
            writeFile("BookList.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public int findBookByID(String id) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findBookByName(String name) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findBookByAuthor(String author) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().equals(author)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findBookByCategory(String category) {
        int index = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCategory().equals(category)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean updateBookByID(String id, Book book) {
        int index = findBookByID(id);
        if (index != -1) {
            books.set(index, book);
            try {
                writeFile("BookList.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    public boolean removeBookByID(String id) {
        int index = findBookByID(id);
        if (index != -1) {
            books.remove(index);
            try {
                writeFile("BookList.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }

    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        books = (List<Book>) objectInputStream.readObject();
        is.close();
        objectInputStream.close();
    }

    public void writeFile(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(books);
        outputStream.close();
        objectOutputStream.close();
    }
}
