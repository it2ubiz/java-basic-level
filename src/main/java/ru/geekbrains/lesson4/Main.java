package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    private static final char PLAYER_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';
    private static final int TO_WIN = 3;

    private static final char[][] map = new char[SIZE][SIZE];

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        /* 1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
        2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
        3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
        Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока. */

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("Player win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(AI_DOT)) {
                System.out.println("Artificial intelligence win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
        }
    }

    public static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setSymbol(int y, int x, char symbol) {
        map[y][x] = symbol;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("Enter coordinates in X Y format: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSymbol(y, x, PLAYER_DOT);
    }

    public static void aiTurn() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    setSymbol(i, j, AI_DOT);
                    if (checkWin(AI_DOT)) return;
                    setSymbol(i, j, EMPTY_DOT);
                }
            }
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    setSymbol(i, j, PLAYER_DOT);
                    if (checkWin(PLAYER_DOT)) {
                        setSymbol(i, j, AI_DOT);
                        return;
                    }
                    setSymbol(i, j, EMPTY_DOT);
                }
            }
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        setSymbol(y, x, AI_DOT);
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE - 1 || y > SIZE - 1) return false;
        return map[y][x] == EMPTY_DOT;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, symbol)) return true;
                if (checkLine(i, j, 1, 1, symbol)) return true;
                if (checkLine(i, j, 1, 0, symbol)) return true;
                if (checkLine(i, j, -1, 1, symbol)) return true;
            }
        }
        return false;
    }

    private static boolean checkLine(int y, int x, int yDirection, int xDirection, char symbol) {
        int wayX = x + (TO_WIN - 1) * xDirection;
        int wayY = y + (TO_WIN - 1) * yDirection;
        if (wayX < 0 || wayY < 0 || wayX > SIZE - 1 || wayY > SIZE - 1) return false;
        for (int i = 0; i < TO_WIN; i++) {
            if (map[y + i * yDirection][x + i * xDirection] != symbol) return false;
        }
        return true;
    }
}
