package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("book1",250);
        Book book2 = new Book("book2",350);
        Book book3 = new Book("Clean code",450);
        Book book4 = new Book("book4",550);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book value : books) {
            System.out.println("Название книги: " + value.getTitle() + " страниц: " + value.getCount());
        }
        Book book5 = books[0];
        books[0] = books[3];
        books[3] = book5;
        System.out.println("");
        for (Book value:books
             ) {
            if (value.getTitle().equals("Clean code")){
                System.out.println("Название книги: " + value.getTitle() + " страниц: " + value.getCount());
            }
        }
    }
}
