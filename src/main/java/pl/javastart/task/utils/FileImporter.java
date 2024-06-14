package pl.javastart.task.utils;

import pl.javastart.task.objects.Currency;
import pl.javastart.task.objects.Product;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileImporter {
    public static List<Product> readProductsFromFile() throws IOException {
        Scanner sc = new Scanner(new File("src/main/resources/products.csv")).useDelimiter(";").useLocale(Locale.US);
        List<Product> productList = new ArrayList<>();
        while (sc.hasNext()) {
            String name = sc.next();
            BigDecimal price = BigDecimal.valueOf(sc.nextDouble());
            sc.skip(";");
            String curreny = sc.nextLine();
            Product product = new Product(name, price, curreny);
            productList.add(product);
        }
        return productList;
    }

    public static List<Currency> readCurrenciesFromFile() throws IOException {
        Scanner sc = new Scanner(new File("src/main/resources/currencies.csv")).useDelimiter(";").useLocale(Locale.US);
        List<Currency> currencies = new ArrayList<>();
        while (sc.hasNext()) {
            String name = sc.next();
            sc.skip(";");
            String valueString = sc.nextLine();
            BigDecimal value = new BigDecimal(valueString);
            Currency currency = new Currency(name, value);
            currencies.add(currency);
        }
        return currencies;
    }
}
