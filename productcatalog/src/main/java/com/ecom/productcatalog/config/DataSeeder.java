package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository,
                      CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {

        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Create Categories using Builder
        Category electronics = Category.builder()
                .name("Electronics")
                .build();

        Category clothing = Category.builder()
                .name("Clothing")
                .build();

        Category home = Category.builder()
                .name("Home and Kitchen")
                .build();

        categoryRepository.saveAll(List.of(electronics, clothing, home));

        // Create Products using Builder
        Product phone = Product.builder()
                .name("SmartPhone")
                .description("Latest model smartphone with latest features")
                .imageUrl("https://placehold.co/600x400")
                .price(7000.0)
                .category(electronics)
                .build();

        Product laptop = Product.builder()
                .name("Laptop")
                .description("High performance laptop for work and play with latest features")
                .imageUrl("https://placehold.co/600x400")
                .price(25000.0)
                .category(electronics)
                .build();

        Product jacket = Product.builder()
                .name("Winter Jacket")
                .description("Warm and cozy jacket for winter.")
                .imageUrl("https://placehold.co/600x400")
                .price(1000.0)
                .category(clothing)
                .build();

        Product blender = Product.builder()
                .name("Blender")
                .description("A high speed blender for smoothies and more")
                .imageUrl("https://placehold.co/600x400")
                .price(7000.0)
                .category(home)
                .build();

        productRepository.saveAll(List.of(phone, laptop, jacket, blender));
    }
}
