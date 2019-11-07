package Main;

import java.time.Month;
import java.util.*;

public class ProductList {
    //variables
    private List<Product> list = new <Product>ArrayList();

    private class Product {
        String productName;
        Map<Month, Double> price = new <Month, Double>HashMap();

        public Product(String productName, Month month, double value) {
            this.productName = productName;
            this.price = new LinkedHashMap<>();
            this.price.put(month, value);
        }

        public double getPrice(Month month) {
            return price.get(month);
        }

        public void setPrice(Month month, double value) {
            price.put(month, value);
        }
    }

    /**
     * add Product to the ProductList, if it not already there, or set the price of the currently added product
     *
     * @param productName product Name
     * @param month       month
     * @param price       price
     */
    public void addValue(String productName, Month month, double price) {
        Product product = list.stream().filter(x -> x.productName.equals(productName)).findAny().orElse(null);
        if (null == product) {
            product = new Product(productName, month, price);
            list.add(product);
            return;
        }
        product.setPrice(month, price);
    }

    /**
     * get Price value for selected product.It will throw exceptions if something wrong
     *
     * @param productName product Name
     * @param month       month
     * @return price of the product
     * @throws NullPointerException if there is no expected product. or its value for a given month is not set
     */
    public double getValue(String productName, Month month) throws NullPointerException {
        Product product = list.stream().filter(x -> x.productName.equals(productName)).findAny().orElse(null);
        if (null == product)
            throw new NullPointerException(String.format("no %s product in current list", productName));
        try {
            return product.getPrice(month);
        } catch (NullPointerException e) {
//            e.printStackTrace();
            throw new NullPointerException(String.format("no price for %s product at %s", productName, month));
        }
    }


    public static void main(String[] args) {


        ProductList productList = new ProductList();
//        ProductList.Product product = productList.new Product("beer", Month.NOVEMBER, 20.2);
        productList.addValue("beer", Month.NOVEMBER, 20.2);
        System.out.println(productList.getValue("beer", Month.NOVEMBER));
        try {
            System.out.println(productList.getValue("beer", Month.DECEMBER));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(Month.of(0));

    }


}



