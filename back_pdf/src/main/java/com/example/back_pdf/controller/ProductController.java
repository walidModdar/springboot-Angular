package com.example.back_pdf.controller;

import com.example.back_pdf.entity.Product;
import com.example.back_pdf.service.IServiceProduct;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin(origins="http://localhost:4200")


public class ProductController {
    private final IServiceProduct productService;



    @GetMapping("/all-products")
    public List<Product> getProducts() {
        return productService.PRODUCT_LIST();
    }

    @PostMapping("/add-product")
    public Product addProduct(@RequestBody Product p) {
        return productService.addProduct(p);
    }

    @PutMapping("/edit-product")
    public Product editProduct(@RequestBody Product p) {

        return productService.editProduct(p);
    }

    @GetMapping("/search")
    public List<Product> searchProductsByName(@RequestParam String title) {
      return  productService.findProductsByName(title);
    }


    @DeleteMapping("/delete-product/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/{idProduct}")
    public Product getProductById(@PathVariable("idProduct") Long id) {
        return productService.findById(id);
    }



}
