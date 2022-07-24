package io;

import repo.model.Product;
import repo.model.User;

import java.util.List;

public class Printer {
    public void printUsersList(List<User> arrayUsersList) {
        for (User user : arrayUsersList) {
            System.out.println(user);
        }
    }

    public void printProductList(List<Product> productList) {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
