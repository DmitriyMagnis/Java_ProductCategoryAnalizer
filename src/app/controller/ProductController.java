package app.controller;

import app.service.ProductService;
import app.view.ProductView;

public class ProductController {
    private final ProductService productService;
    private final ProductView view;

    public ProductController(ProductService productService, ProductView view) {
        this.productService = productService;
        this.view = view;
    }

    public void run() {
        try {
            if (this.productService.isEmpty()) {
                throw new RuntimeException("Products are Empty");
            }
            this.view.showProductsByCategories(this.productService.getProductsByCategories());
            this.view.showAveragePriceByCategory(this.productService.getAveragePriceByCategory());
            this.view.showMostExpensiveCategory(this.productService.getMostExpensiveCategoryByAvgPrice());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
