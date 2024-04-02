package com.example.get_post_put_delete2.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private static List<Product> products=new ArrayList<>();

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product("1", "benson", 23));
        products.add(new Product("2", "margo", 25));
        products.add(new Product("3", "amy", 30));
        products.add(new Product("4", "jack", 28));
        products.add(new Product("5", "jason", 21));
    }

    public Product getProduct(String id) {
        return products.stream()
                .filter(product -> id.equals(product.getId()))
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String id, Product updatedProduct) {
        products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .ifPresent(product -> {
                    product.setName(updatedProduct.getName());
                    product.setAge(updatedProduct.getAge());
                });
    }


    public void deleteProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }

}
