package com.example.back_pdf.service;

import com.example.back_pdf.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceProduct {

    Product addProduct(Product p);

    Product editProduct(Product p);

    void deleteProduct(Long idProduct);

    List<Product> PRODUCT_LIST();

    Product findById(Long idProduct);

    List<Product> findProductsByName(String title);


    }
