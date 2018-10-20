package the_game_ver1;

import java.lang.Math;
import java.util.Scanner;

public class The_game_ver1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = 0, x1 =0;
        int y = 0, y1 =0;
        boolean OK = true; //работа программы, пока есть свободные клетки
        int count = 0; // считает занятые клетки
        boolean WinPlayer = false; //отвечает за выигрыш игрока
        boolean WinSystem = false; //отвечает за выигрыш системы
        String a[][] = new String[1000][1000]; // поле
        int win = 0;

        System.out.println("Приветствуем Вас в игре крестики-нолики");
        System.out.println("Задайте размер поля от 3 до 1000");

        int N = in.nextInt();
        for (int i = 0; i < N; i++) //фигачим поле
            for (int j = 0; j < N; j++)
                a[i][j] = "o";

        System.out.println("Это ваше поле, где о - пустые клетки ");

        for (int i = 0; i < N; i++) { //выводим поле на экран
            for (int j = 0; j < N; j++)
                System.out.print(a[i][j] + " ");
            System.out.println(" ");
        }

        System.out.println("Введите Х(в английской раскладке), если вы будете играть крестиками.");
        System.out.println("Или 0, если будете играть ноликами.");
        String Player = in.next();

        String Bot = "nothing";

        if (Player.equals("X"))
            Bot = "0";
        if (Player.equals("0"))
            Bot = "X";

        while (OK == true & WinPlayer == false & WinSystem == false) {

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (a[i][j].equals("X") | a[i][j].equals("0"))
                        count++;
            if (count == N * N) {
                OK = false;
                System.out.println("Ничья"); //наличие свободных клеток
            }
            count = 0;


            System.out.println("Введите номер места и номер столбца, куда хотите сходить");
            System.out.println("Учтите, места нумируются сверху вниз, а столбцы слева на право");
            y = in.nextInt();
            x = in.nextInt();
            a[y - 1][x - 1] = Player;

            for (int i = 0; i < N; i++) { //выводим поле на экран
                for (int j = 0; j < N; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println(" ");
            }
            System.out.println(" ");
            // до этого момента все работает

            for (int i = 0; i < N; i++) { // проверка, что выиграл игрок по горизонтали
                for (int j = 0; j < N; j++)
                    if (a[i][j].equals(Player))
                        win++;

                if (win == N) {
                    WinPlayer = true;
                    System.out.println("Вы победили!");
                } else
                    win = 0;
            }


            for (int j = 0; j < N; j++) { // проверка, что выиграл игрок по вертикали
                for (int i = 0; i < N; i++)
                    if (a[i][j].equals(Player))
                        win++;

                if (win == N) {
                    WinPlayer = true;
                    System.out.println("Вы победили!");
                } else
                    win = 0;
            }


            for (int i = 0, j = 0; i < N && j < N; i++, j++)// проверка, что игрок выиграл по 1 диагонали
                if (a[i][j].equals(Player))
                    win++;
            if (win == N) {
                WinPlayer = true;
                System.out.println("Вы победили!");
            } else
                win = 0;


            for (int i = N - 1, j = 0; i >= 0 && j < N; i--, j++)// проверка, что игрок выиграл по 2 диагонали
                if (a[i][j].equals(Player))
                    win++;
            if (win == N) {
                WinPlayer = true;
                System.out.println("Вы победили!");
            } else
                win = 0;

            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    if (a[i][j].equals("X") | a[i][j].equals("0"))
                        count++;
            if (count == N * N) {
                OK = false;
                System.out.println("Ничья"); //наличие свободных клеток
            }
            count = 0;

            // теперь ходит бот

            for (int i = 0; i == 0; ) { // ищем свободную клетку
                x1 = 1 + (int) (Math.random() * (N - 1));
                y1 = 1 + (int) (Math.random() * (N - 1));

                if (a[y1 - 1][x1 - 1].equals("o"))
                    i=1;
            }


            a[y1-1][x1-1] = Bot;

            for (int i = 0 ; i < N ; i++) { //выводим поле на экран
                for (int j = 0; j < N; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println(" ");
            }

            System.out.println(" ");
            for(int i=0 ; i < N ; i++){ // проверка, что выиграл бот по горизонтали
                for(int j=0; j < N ; j++)
                    if (a[i][j].equals(Bot))
                        win++;

                if(win == N){
                    WinSystem = true;
                    System.out.println("Вы проиграли");
                }
                else
                    win = 0;
            }


            for(int j=0 ; j < N ; j++){ // проверка, что выиграл бот по вертикали
                for(int i=0; i < N ; i++)
                    if (a[i][j].equals(Bot))
                        win++;

                if(win == N){
                    WinSystem = true;
                    System.out.println("Вы проиграли!");
                }
                else
                    win = 0;
            }


            for (int i=0, j=0; i<N && j<N; i++ ,j++)// проверка, что бот выиграл по 1 диагонали
                if (a[i][j].equals(Bot))
                    win++;
            if(win == N){
                WinSystem = true;
                System.out.println("Вы проиграли");
            }
            else
                win = 0;


            for (int i=N-1, j=0; i>=0 && j<N; i-- ,j++)// проверка, что бот выиграл по 2 диагонали
                if (a[i][j].equals(Bot))
                    win++;
            if(win == N){
                WinSystem = true;
                System.out.println("Вы проиграли!");
            }
            else
                win = 0;
        }
    }
}
