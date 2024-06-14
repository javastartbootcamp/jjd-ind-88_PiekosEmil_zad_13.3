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
        for (Product product : productList) {
            Currency equalsCurrency = findCurrencyFor(product, currencies);
            BigDecimal productPrice = product.getPrice();
            BigDecimal currenyValue = equalsCurrency.getValue();
            sum = sum.add(productPrice.divide(currenyValue, 16, RoundingMode.HALF_UP));
//                }
        }
//        }
        return sum;
    }

    public static BigDecimal averageEuroPrice(BigDecimal sumPrices, List<Product> productList) {
        BigDecimal listSize = new BigDecimal(productList.size());
        return sumPrices.divide(listSize, 16, RoundingMode.HALF_UP);
    }

    public static List<Product> createEuroProducts(List<Product> productList, List<Currency> currencies) throws ArithmeticException {
        List<Product> euroProductList = new ArrayList<>();
        for (Product value : productList) {
            Currency equalsCurrency = findCurrencyFor(value, currencies);
            BigDecimal productPrice = value.getPrice();
            BigDecimal currenyValue = equalsCurrency.getValue();
            BigDecimal euroPrice = productPrice.divide(currenyValue, 16, RoundingMode.HALF_UP);
            Product product = new Product(value.getName(), euroPrice, "EUR");
            euroProductList.add(product);
        }
        return euroProductList;
    }

    private static Currency findCurrencyFor(Product product, List<Currency> currencies) {
        for (Currency currency : currencies) {
            String currencyName = currency.getName();
            String productCurrency = product.getCurrency();
            if (productCurrency.equals(currencyName)) {
                return currency;
            }
        }
        return null;
    }
}
