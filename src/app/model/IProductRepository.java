package app.model;

import java.io.IOException;
import java.util.List;

public interface IProductRepository {
    List<Product>  downloadAllProducts() throws Exception;
}
