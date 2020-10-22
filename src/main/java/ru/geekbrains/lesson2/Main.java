package ru.geekbrains.lesson2;

public class Main {
    public static void main(String[] args) {

        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0; */

        invertArray();

        ///////////////////////////////////////////////////////////////////////////////////

        /* 2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21; */

        fillArray();

        ///////////////////////////////////////////////////////////////////////////////////

        /* 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        пройти по нему циклом, и числа меньшие 6 умножить на 2; */

        changeArray();

        ///////////////////////////////////////////////////////////////////////////////////

        /* 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        и с помощью цикла(-ов) заполнить его диагональные элементы единицами; */

        fillDiagonal();

        ///////////////////////////////////////////////////////////////////////////////////

        /* 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета); */

        searchMaxMin();

        ///////////////////////////////////////////////////////////////////////////////////

        /* 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
        метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят. */

        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}) + "\n");

        ///////////////////////////////////////////////////////////////////////////////////

        /* 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
        Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        При каком n в какую сторону сдвиг можете выбирать сами. */

        shiftOfNumbers(new int[]{1, 2, 3}, 1);

        ///////////////////////////////////////////////////////////////////////////////////
    }

    public static void invertArray() {
        int[] array = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        printArray(array);
        System.out.println();
    }

    public static void fillArray() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }
        printArray(array);
        System.out.println();
    }

    public static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        printArray(array);
        System.out.println();
    }

    public static void fillDiagonal() {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
        for (int[] items : array) {
            for (int item : items) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void searchMaxMin() {
        int[] array = {1, 5, 8, 9, 21, 2, 6, 19, 4, 55};
        int max = array[0];
        int min = array[0];
        for (int j : array) {
            if (j > max) {
                max = j;
            } else {
                min = j;
            }
        }
        System.out.println("Max: " + max + " Min: " + min + "\n");
    }

    public static boolean checkBalance(int[] array) {
        int lSum, rSum;
        for (int i = 0; i < array.length + 1; i++) {
            lSum = 0;
            rSum = 0;
            for (int j = 0; j < i; j++) {
                lSum += array[j];
            }
            for (int j = i; j < array.length; j++) {
                rSum += array[j];
            }
            if (lSum == rSum) return true;
        }
        return false;
    }

    public static void shiftOfNumbers(int[] array, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int buffer = array[array.length - 1];
                System.arraycopy(array, 0, array, 1, array.length - 1);
                array[0] = buffer;
                printArray(array);
            }
        } else if (n < 0) {
            for (int i = 0; i > n; i--) {
                int buffer = array[0];
                System.arraycopy(array, 1, array, 0, array.length - 1);
                array[array.length - 1] = buffer;
                printArray(array);
            }
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
