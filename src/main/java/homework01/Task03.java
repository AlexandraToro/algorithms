package homework01;

// Найти сумму элементов главной диагонали в двумерном массиве.
// Найти сумму элементов побочной диагонали в двумерном массиве.

public class Task03 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        findMainDiagonalSum(matrix);
        findSecDiagonalSum(matrix);
    }

    public static void findMainDiagonalSum(int[][] matrix) {
        int sum = 0;
        if (matrix[0].length != matrix.length)
            System.out.println("Количество строк должно быть равно количеству столбцов");
        else {
            for (int i = 0; i <= matrix.length - 1; i++) {
                sum += matrix[i][i];
            }
            System.out.println(sum);
        }
    }

    public static void findSecDiagonalSum(int[][] matrix) {
        int sum = 0;
        if (matrix[0].length != matrix.length)
            System.out.println("Количество строк должно быть равно количеству столбцов");
        else {
            for (int i = 0; i <= matrix.length - 1; i++) {
                sum += matrix[i][matrix.length - 1 - i];
            }
            System.out.println(sum);
        }
    }
}
