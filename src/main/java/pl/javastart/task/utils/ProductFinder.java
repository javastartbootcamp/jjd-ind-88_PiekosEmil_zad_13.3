package pl.javastart.task.utils;

import pl.javastart.task.objects.Product;
import java.math.BigDecimal;
import java.util.List;

public class ProductFinder {

    public static void findTheMostExpensive(List<Product> euroProductList) {
        BigDecimal largest = BigDecimal.ZERO;
        int largestProductIndex = 0;
        for (int i = 0; i < euroProductList.size(); i++) {
            BigDecimal euroProductPrice = euroProductList.get(i).getPrice();
            if (euroProductPrice.doubleValue() > largest.doubleValue()) {
                largest = euroProductList.get(i).getPrice();
                largestProductIndex = i;
            }
        }
        System.out.printf("Najdroższy produkt to: %s %.2f %s", euroProductList.get(largestProductIndex).getName(),
                euroProductList.get(largestProductIndex).getPrice(), euroProductList.get(largestProductIndex).getCurrency());
        System.out.println();
    }

    public static void findTheCheapest(List<Product> euroProductList) {
        BigDecimal smallest = BigDecimal.valueOf(Integer.MAX_VALUE);
        int largestProductIndex = 0;
        for (int i = 0; i < euroProductList.size(); i++) {
            BigDecimal euroProductPrice = euroProductList.get(i).getPrice();
            if (euroProductPrice.doubleValue() < smallest.doubleValue()) {
                smallest = euroProductList.get(i).getPrice();
                largestProductIndex = i;
            }
        }
        System.out.printf("Najtańszy produkt to: %s %.2f %s", euroProductList.get(largestProductIndex).getName(),
                euroProductList.get(largestProductIndex).getPrice(), euroProductList.get(largestProductIndex).getCurrency());
        System.out.println();
    }
}
