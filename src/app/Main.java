package app;

import app.controller.ProductController;
import app.model.ProductFileRepository;
import app.service.ProductService;
import app.view.ProductView;

public class Main {
    public static void main(String[] args) {
        ProductView view = new ProductView();
        ProductFileRepository productFileRepository = new ProductFileRepository();
        ProductService productService = new ProductService(productFileRepository);

        new ProductController(productService, view).run();
    }
}
