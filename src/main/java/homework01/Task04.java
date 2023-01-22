package homework01;

import java.util.Arrays;

//Реализовать сдвиг элементов в массиве на n влево или вправо.

public class Task04 {
    public static void main(String[] args) {
        int[] array = {5, 6, 7, 9, 8, 45, 9889};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(shift(array, 3)));
    }

    public static int[] shift(int[] array, int n) {
        int[] temp = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            if (i + n >= array.length) {
                temp[i + n - array.length] = array[i];
            } else if (i + n < 0) {
                temp[n + i + array.length] = array[i];
            } else {
                temp[i + n] = array[i];
            }
        }
        return temp;
    }

}
