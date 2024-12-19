package app.view;

import app.model.Product;

import java.util.List;
import java.util.Map;

public class ProductView {
    public void showProductsByCategories(Map<String, List<Product>> productsByCategory) {
        System.out.println("Products by category: ");

        productsByCategory.forEach((productCategory, productList) -> {
            System.out.println(productCategory + ": " + productList.stream().map(Product::getName).toList());
        });
    }
    public void showAveragePriceByCategory(Map<String, Double> averagePriceByCategory) {
        System.out.println("Average price by category: ");

        averagePriceByCategory.forEach((productCategory, averagePrice) -> {
            System.out.println(productCategory + ": " + averagePrice);
        });
    }
    public void showMostExpensiveCategory(String category) {
        System.out.println("Most expensive category by average price: " + category);
    }
}
