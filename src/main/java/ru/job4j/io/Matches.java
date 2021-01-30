package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;
            while (true){
                int res = count - matches;
                if(res < 0 || matches > 3 || matches < 1){
                    System.out.println("Введите другое число");
                    matches = Integer.parseInt(input.nextLine());
                }else{
                    System.out.println("На столе осталось:" + res);
                    count = res;
                    break;
                }
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
