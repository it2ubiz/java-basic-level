package ru.geekbrains.lesson2;

public class Main {
    public static void main(String[] args) {

        /* 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        С помощью цикла и условия заменить 0 на 1, 1 на 0; */

        invertArray();//

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
        int[] arr = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] += j;
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println("\n");
    }

    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, h = arr[i].length; j < arr[i].length; j++, h--) {
                if (i == j || i == (h - 1)) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\r\n");
        }
        System.out.println();
    }

    public static void searchMaxMin() {
        int[] arr = {1, 5, 8, 9, 21, 2, 6, 19, 4, 55};

        int max = arr[0];
        int min = arr[0];

        for (int j : arr) {
            if (j > max) {
                max = j;
            } else {
                min = j;
            }
        }

        System.out.println("Max: " + max + " Min: " + min + "\n");
    }

    public static boolean checkBalance(int[] arrParam) {
        int lSum, rSum;

        for (int i = 0; i < arrParam.length + 1; i++) {
            lSum = 0;
            rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arrParam[j];
            }

            for (int j = i; j < arrParam.length; j++) {
                rSum += arrParam[j];
            }

            if (lSum == rSum) return true;
        }
        return false;
    }

    public static void shiftOfNumbers(int[] arrParam, int n) {
        if (n > 0) {
            for (int x = 0; x < n; x++) {
                int buf = arrParam[arrParam.length - 1];
                System.arraycopy(arrParam, 0, arrParam, 1, arrParam.length - 1);
                arrParam[0] = buf;

                for (int i : arrParam) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        } else if (n < 0) {
            for (int x = 0; x > n; x--) {
                int buf = arrParam[0];
                System.arraycopy(arrParam, 1, arrParam, 0, arrParam.length - 1);
                arrParam[arrParam.length - 1] = buf;

                for (int i : arrParam) {
                    System.out.print(i + " ");
                }
                System.out.print("\r\n");
            }
        }
    }
}
