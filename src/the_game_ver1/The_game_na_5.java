package the_game_ver1;

import java.util.Scanner;

public class The_game_na_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x1, x2, y1, y2; // координаты, которые будут вводить игроки
        String a[][] = new String[4][4]; // поле
        String Player1,Player2;
        boolean OK = true; //работа программы, пока есть свободные клетки
        int count = 0; // считает занятые клетки
        boolean WinPlayer1 = false; //отвечает за выигрыш игрока
        boolean WinPlayer2 = false; //отвечает за выигрыш системы


        System.out.println("Приветствуем Вас в игре крестики-нолики.");
        for (int i = 0; i < 3; i++) //фигачим поле
            for (int j = 0; j < 3; j++)
                a[i][j] = "o";

        for (int i = 0; i < 3; i++) { //выводим поле на экран
            for (int j = 0; j < 3; j++)
                System.out.print(a[i][j] + " ");
            System.out.println(" ");
        }
        System.out.println("Это ваше поле, где о - пустые клетки. ");

        System.out.println("Игрок 1,Введите Х(в английской раскладке), если вы будете играть крестиками.");
        System.out.println("Или 0, если будете играть ноликами.");
        Player1 = in.next();

        if (Player1.equals("X"))
            Player2 = "0";
        else Player2 = "X";

        System.out.println("Игрок 1, Вы играете: " + Player1);
        System.out.println("Игрок 2, Вы играете: " + Player2);



    }
}
