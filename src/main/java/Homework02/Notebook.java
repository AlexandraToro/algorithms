//Класс Notebook содержит поля:
//
//        Стоимость - price, double [100, 200, 300, 400, 500, 600, 700, 800]
//        Оперативная память - ram, integer [4, 8, 16, 20, 24, 28, 32]
//        Производитель - brand, enum Перечисление Brand может принимать следующие значения: Lenuvo, Asos, MacNote, Eser, Xamiou.
//        Сортировать нужно в этом же порядке (т.е. Lenuvo имеет наивысший приоритет).
//        Отсортировать по стоимости, по памяти, по перечислению (в таком порядке)


package Homework02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Notebook {
    private static double[] PRICE = {100, 200, 300, 400, 500, 600, 700, 800};
    private static int[] RAM = {4, 8, 16, 20, 24, 28, 32};

    enum Brand {
        LENUVO("Lenuvo"),
        ASOS("Asos"),
        MACNOTE("MacNote"),
        ESER("Eser"),
        XAMIOU("Xamiou");

        private String title;

        Brand(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return this.title;
        }
    }


    private static Brand[] BRAND = Brand.values();

    private double price;
    private int ram;
    private Brand brand;

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public Brand getBrand() {
        return brand;
    }

    public Notebook() {
        Random rnd = new Random();
        price = PRICE[rnd.nextInt(PRICE.length)];
        ram = RAM[rnd.nextInt(RAM.length)];
        brand = BRAND[rnd.nextInt(BRAND.length)];
    }

    @Override
    public String toString() {
        return "Notebook{"
                + "price=" + price
                + " ram=" + ram
                + " brand=" + brand
                + '}';
    }

    public static Notebook[] getNotebooks(int count) {
        Notebook[] notebooks = new Notebook[count];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook();
        }
        return notebooks;
    }


    public static void main(String[] args) {
        Notebook[] notebooks = Notebook.getNotebooks(100);
        System.out.println(Arrays.toString(notebooks));
        Comparator<Notebook> priceComparator = Comparator.comparing(Notebook::getPrice);
        Comparator<Notebook> ramComparator = Comparator.comparing(Notebook::getRam);
        Comparator<Notebook> brandComparator = Comparator.comparing(Notebook::getBrand);
        Comparator<Notebook> allComparator = priceComparator.thenComparing(ramComparator).thenComparing(brandComparator);
        Arrays.sort(notebooks, allComparator);
        System.out.println("Sorted notebooks: \n ");
        System.out.println(Arrays.toString(notebooks));
    }
}
