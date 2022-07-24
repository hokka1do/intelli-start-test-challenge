package repo;

import repo.model.Product;

import java.util.ArrayList;
import java.util.Objects;

public class ProductRepository {
    private final ArrayList<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product(1L, "Pen", 15));//(0)
        productList.add(new Product(2L, "Pencil", 25));//(1)
        productList.add(new Product(3L, "Notebook", 18));//(2)
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public Product findProductById(Long productId) {
        for (Product product : productList) {
            if (Objects.equals(product.getId(), productId)) {
                return product;
            }
        }
        System.out.println("Product not found");
        return null;
    }
}
