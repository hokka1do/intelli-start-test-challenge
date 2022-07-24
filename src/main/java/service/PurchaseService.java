package service;

import repo.ProductRepository;
import repo.PurchaseRepository;
import repo.UsersRepository;
import repo.model.Product;
import repo.model.User;

public class PurchaseService {
    private final UsersRepository usersRepository;
    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(UsersRepository usersRepository, ProductRepository productRepository,
                           PurchaseRepository purchaseRepository) {
        this.usersRepository = usersRepository;
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public void purchase(Long userId, Long productId) {
        User user = usersRepository.findUserById(userId);
        Product product = productRepository.findProductById(productId);
        long amountOfUserMoneyBeforePurchase = user.getAmountOfMoney();
        long productPrice = product.getPrice();
        long amountOfUserMoneyAfterPurchase = amountOfUserMoneyBeforePurchase - productPrice;
        if (amountOfUserMoneyAfterPurchase < 0) {
            throw new RuntimeException(userId + " not enough money to purchase this product.");
        } else {
            System.out.println("User #" + userId + " successfully purchased " + product.getName() + ".");
            user.setAmountOfMoney(amountOfUserMoneyAfterPurchase);
            purchaseRepository.addPurchasedProductByUserId(userId, product);
        }
        System.out.println("User #" + userId + " has " + amountOfUserMoneyBeforePurchase + " dollars.");
    }
}