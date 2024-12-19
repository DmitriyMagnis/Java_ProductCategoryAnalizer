package app.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductFileRepository implements IProductRepository {
    private final String BASE_PATH = "db";
    private final String FILE_NAME = "products";

    public List<Product> downloadAllProducts() throws IOException {
        List<Product> products = new ArrayList<>();

        Files.readAllLines(Paths.get(BASE_PATH, FILE_NAME + ".txt")).forEach(str -> {
            String[] data = str.trim().split("\\s+");
            Product product = new Product(data[0], data[1], Double.parseDouble(data[2]));
            products.add(product);
        });

        return products;
    }
}
