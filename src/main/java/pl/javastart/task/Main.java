package pl.javastart.task;

import pl.javastart.task.objects.Currency;
import pl.javastart.task.objects.Product;
import pl.javastart.task.utils.FileImporter;
import pl.javastart.task.utils.PriceCalculator;
import pl.javastart.task.utils.ProductFinder;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            List<Product> productList = FileImporter.readProductsFromFile();
            List<Currency> currencies = FileImporter.readCurrenciesFromFile();

            BigDecimal sumOfAllProductInEuro = PriceCalculator.sumAllEuroPrices(productList, currencies);
            System.out.printf("Suma cen wszystkich produktów w euro %.2f %s", sumOfAllProductInEuro, "EUR");
            System.out.println();

            BigDecimal averageEuroPrice = PriceCalculator.averageEuroPrice(sumOfAllProductInEuro, productList);
            System.out.printf("Średnia cena produktów z listy: %.2f %s", averageEuroPrice, "EUR");
            System.out.println();

            List<Product> euroProductList = PriceCalculator.createEuroProducts(productList, currencies);
            ProductFinder.findTheMostExpensive(euroProductList);
            ProductFinder.findTheCheapest(euroProductList);
        } catch (IOException e) {
            System.err.println("Nie znaleziono pliku");
        }
    }
}
