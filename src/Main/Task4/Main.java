package Main.Task4;

import java.time.Month;
import java.util.ArrayList;

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
        ArrayList<String> name = new ArrayList<String>();
        name.add("cola");
        name.add("pepsi");

        ArrayList<Double> price = new ArrayList<Double>();
        for (int i = 0; i < 23; i++) {
            price.add(Math.random() * 20);
        }


        productList.addProducts(name, price);
        productList.print();
//        System.out.println(Month.of(1));

    }


}
