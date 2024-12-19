package app.service;

import app.model.Product;
import app.model.ProductFileRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final ProductFileRepository productRepository;

    public ProductService(ProductFileRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Map<String, List<Product>> getProductsByCategories() throws Exception {
        return this.productRepository
                    .downloadAllProducts()
                    .stream()
                    .collect(Collectors.groupingBy(Product::getCategory));
    }
    public Map<String, Double> getAveragePriceByCategory() throws Exception {
        return this.productRepository
                .downloadAllProducts()
                .stream()
                .collect(Collectors
                        .groupingBy((Product::getCategory),
                                Collectors.averagingDouble(Product::getPrice)));
    }
    public String getMostExpensiveCategoryByAvgPrice() throws Exception {
        return getAveragePriceByCategory()
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No category");
    }
    public boolean isEmpty() throws Exception {
        return this.productRepository
                   .downloadAllProducts()
                   .isEmpty();
    }
}
