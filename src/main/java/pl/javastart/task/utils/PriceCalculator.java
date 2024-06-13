package pl.javastart.task.utils;

import pl.javastart.task.objects.Currency;
import pl.javastart.task.objects.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
    public static BigDecimal sumAllEuroPrices(List<Product> productList, List<Currency> currencies) throws ArithmeticException {
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < productList.size(); i++) {
            String productCurrency = productList.get(i).getCurrency();
            for (int j = 0; j < currencies.size(); j++) {
                String currencyName = currencies.get(j).getName();
                if (productCurrency.equals(currencyName)) {
                    BigDecimal productPrice = productList.get(i).getPrice();
                    BigDecimal currenyValue = currencies.get(j).getValue();
                    sum = sum.add(productPrice.divide(currenyValue, 16, RoundingMode.HALF_UP));
                    break;
                }
            }
        }
        return sum;
    }

    public static BigDecimal averageEuroPrice(BigDecimal sumPrices, List<Product> productList) {
        BigDecimal listSize = new BigDecimal(productList.size());
        return sumPrices.divide(listSize, 16, RoundingMode.HALF_UP);
    }

    public static List<Product> createEuroProducts(List<Product> productList, List<Currency> currencies) throws ArithmeticException {
        List<Product> euroProductList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            String productCurrency = productList.get(i).getCurrency();
            for (int j = 0; j < currencies.size(); j++) {
                String currencyName = currencies.get(j).getName();
                if (productCurrency.equals(currencyName)) {
                    BigDecimal productPrice = productList.get(i).getPrice();
                    BigDecimal currenyValue = currencies.get(j).getValue();
                    BigDecimal euroPrice = productPrice.divide(currenyValue, 16, RoundingMode.HALF_UP);
                    Product product = new Product(productList.get(i).getName(), euroPrice, "EUR");
                    euroProductList.add(product);
                    break;
                }
            }
        }
        return euroProductList;
    }
}
