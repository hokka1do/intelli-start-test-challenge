package repo;

import repo.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseRepository {

    private final Map<Long, ArrayList<Product>> userPurchases = new HashMap<>();

    public ArrayList<Product> findProductsByUserId(Long userId) {
        if (userPurchases.containsKey(userId)) {
            System.out.println("User #" + userId + " purchased:");
            return userPurchases.get(userId);
        } else return null;
    }

    public List<Long> findUsersIdByProductId(Long productId) {
        List<Long> userIdList = new ArrayList<>();
        for (Map.Entry<Long, ArrayList<Product>> entry : userPurchases.entrySet()) {
            for (Product product : entry.getValue()) {
                if (product.getId().equals(productId)) {
                    userIdList.add(entry.getKey());
                }
            }
        }
        System.out.println("Product with id = " + productId + " was purchased by:");
        return userIdList;
    }

    public void addPurchasedProductByUserId(Long userId, Product product) {
        if (userPurchases.containsKey(userId)) {
            ArrayList<Product> userPurchasedProducts = userPurchases.get(userId);
            ArrayList<Product> existedUserPurchasedProducts = new ArrayList<>(userPurchasedProducts);
            existedUserPurchasedProducts.add(product);
            userPurchases.put(userId, existedUserPurchasedProducts);
        } else {
            ArrayList<Product> newUserPurchasedProducts = new ArrayList<>();
            newUserPurchasedProducts.add(product);
            userPurchases.put(userId, newUserPurchasedProducts);
        }
    }
}
