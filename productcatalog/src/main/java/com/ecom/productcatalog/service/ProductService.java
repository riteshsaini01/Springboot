package com.ecom.productcatalog.service;

import com.ecom.productcatalog.exception.ServiceException;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception ex) {
            throw new ServiceException("Failed to fetch products", ex);
        }
    }

    public List<Product> getProductByCategory(Long categoryId) {
        try {
            return productRepository.findByCategoryId(categoryId);
        } catch (Exception ex) {
            throw new ServiceException(
                    "Failed to fetch products for category id: " + categoryId,
                    ex
            );
        }
    }
}
