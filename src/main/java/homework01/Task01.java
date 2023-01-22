package homework01;
// Рекурсивно найти n-ое число Фибоначчи. Определить сложность. (fn[0] = 0 или 1) [fn(n) = (fn(n - 1) + fn(n - 2)]

public class Task01 {
    public static void main(String[] args) {
        System.out.println(getFibonacci(7));
    }

    public static int getFibonacci(int n) {
        if (n == 0)
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else return (getFibonacci(n - 1) + getFibonacci(n - 2));
    }

    // сложность у данного алгоритма равна О(2^n) экспоненциальная. Безумный рост с увеличением числа.
}
