package homework01;

// Найти n-ое число Фибоначчи за O(n).

public class Task02 {
    public static void main(String[] args) {
        getFibonacci(7);
    }

    public static void getFibonacci(int n) {
        int first =0;
        int sec = 1;
        for (int i = 0; i < n; i++) {
            int temp = sec;
            sec = sec + first;
            first = temp;
        }
        System.out.println(first);
    }

}
