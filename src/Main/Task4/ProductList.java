package Main.Task4;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductList {
    private List<Product> productList;

    public ProductList() {
        this.productList = new ArrayList<Product>();
    }

    public ProductList(List<String> productName, List<Double> productPrices) {
        this();
        addProducts(productName, productPrices);
    }

    /**
     * Add many products to the ProductList
     *
     * @param productName   list of products names
     * @param productPrices list of products prices
     */
    public void addProducts(List<String> productName, List<Double> productPrices) {
        if (productName.size() * 12 < productPrices.size())
            throw new IllegalArgumentException(String.format("Too many prices, too few products. There are %d products and %d prices.",
                    productName.size(), productPrices.size()));
        for (int i = 0; i < productName.size(); i++) {
            Product product = new Product(productName.get(i));
            int firstIndex = i + 12 * i;
            int lastIndex = i + 12 * i + 12;

            if (firstIndex > productPrices.size())
                throw new IndexOutOfBoundsException("Too many prices");
            //not prices noy for all year
            if (lastIndex > productPrices.size())
                product.addPrice(productPrices.subList(i + 12 * i, productPrices.size()));
            else
                product.addPrice(productPrices.subList(i + 12 * i, i + 12 * i + 12));
            productList.add(product);
        }
    }

    /**
     * Add single product to the ProductList, if it not already there, or set the price of the currently added product
     *
     * @param productName product Name
     * @param month       month
     * @param price       price
     */

    public void addValue(String productName, Month month, double price) {
        Product product = productList.stream().filter(x -> x.productName.equals(productName)).findAny().orElse(null);
        if (null == product) {
            product = new Product(productName, month, price);
            productList.add(product);
            return;
        }
        product.setPrice(month, price);
    }

    /**
     * get Price value for the selected product. It will throw exceptions if something wrong.
     *
     * @param productName product Name
     * @param month       month
     * @return price of the product
     * @throws NullPointerException if there is no expected product. or its value for a given month hasn't been established.
     */
    public double getValue(String productName, Month month) throws NullPointerException {
        Product product = productList.stream().filter(x -> x.productName.equals(productName)).findAny().orElse(null);
        if (null == product)
            throw new NullPointerException(String.format("no %s product in current list", productName));
        try {
            return product.getPrice(month);
        } catch (NullPointerException e) {
//            e.printStackTrace();
            throw new NullPointerException(String.format("no price for %s product at %s", productName, month));
        }
    }


    public void print() {
        System.out.println(String.format("Name      |%9s |%9s |%9s |%9s |%9s |%9s |%9s |%9s |%9s |%9s |%9s |%9s |", Month.values()));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        for (Product product : productList) {
            System.out.print(String.format("%8s  |", product.getProductName()));
            for (Month month : Month.values()) {
                String s;
                if (null == product.getPrice(month))
                    s = String.format("%8s  |", null);
                else
                    s = String.format("%8.2f  |", product.getPrice(month));
                System.out.print(s);

            }
            System.out.println();
        }
    }

}

class Product {
    @Getter
    @Setter
    String productName;
    private Map<Month, Double> productPrice;

    /**
     * Create a product
     *
     * @param productName product name
     */
    Product(String productName) {
        this.productName = productName;
        productPrice = new HashMap<>();
    }

    Product(String productName, Month month, double price) {
        this.productName = productName;
        productPrice = new HashMap<>();
        setPrice(month, price);
    }


    /**
     * Add a list of prices
     *
     * @param price list of product prices. Must be less than 12 elements long(as a number of month)
     * @throws IllegalArgumentException expected 12 prices for 12 months, if more than throw exception.
     */
    void addPrice(List<Double> price) throws IllegalArgumentException {
        if (price.size() > 12)
            throw new IllegalArgumentException("invalid number of items, expected 12 numbers for 12 Months, but was " + price.size());
        for (int i = 0; i < price.size(); i++) {
            productPrice.put(Month.of(1 + i), price.get(i));
        }
    }

    Double getPrice(Month month) {
        return productPrice.get(month);
    }

    void setPrice(Month month, Double price) {
        productPrice.put(month, price);
    }
}