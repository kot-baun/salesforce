package Main.Task4;

import java.time.Month;

public class Main {
    public static void main(String[] args) {

        ProductList productList = new ProductList();
        productList.addValue("beer", Month.NOVEMBER, 20.2);
        System.out.println(productList.getValue("beer", Month.NOVEMBER));
        try {
            System.out.println(productList.getValue("beer", Month.DECEMBER));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


//        System.out.println(Month.of(1));

    }


}
