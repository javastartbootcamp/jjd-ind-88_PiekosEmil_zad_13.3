package pl.javastart.task.utils;

import pl.javastart.task.objects.Product;
import java.math.BigDecimal;
import java.util.List;

public class ProductFinder {

    public static void findTheMostExpensive(List<Product> euroProductList) {
        BigDecimal largest = BigDecimal.ZERO;
        Product mostExpensiveProduct = null;
        for (Product product : euroProductList) {
            BigDecimal euroProductPrice = product.getPrice();
            if (euroProductPrice.compareTo(largest) > 0) {
                largest = product.getPrice();
                mostExpensiveProduct = product;
            }
        }
        System.out.printf("Najdroższy produkt to: %s %.2f %s", mostExpensiveProduct.getName(),
                mostExpensiveProduct.getPrice(), mostExpensiveProduct.getCurrency());
        System.out.println();
    }

    public static void findTheCheapest(List<Product> euroProductList) {
        BigDecimal smallest = BigDecimal.valueOf(Integer.MAX_VALUE);
        Product cheapestProduct = null;
        for (Product product : euroProductList) {
            BigDecimal euroProductPrice = product.getPrice();
            if (euroProductPrice.compareTo(smallest) < 0) {
                smallest = product.getPrice();
                cheapestProduct = product;
            }
        }
        System.out.printf("Najtańszy produkt to: %s %.2f %s", cheapestProduct.getName(),
                cheapestProduct.getPrice(), cheapestProduct.getCurrency());
        System.out.println();
    }
}
