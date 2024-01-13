package com.example.back_pdf.service;

import com.example.back_pdf.entity.Product;
import com.example.back_pdf.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class ProductServiceImpl implements IServiceProduct{
    private final ProductRepository productRepository;



    @Override
    public Product addProduct(Product p) {
        if (p.getTitle() == null || p.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Product title cannot be empty");
        }
        try {
            return productRepository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add product", e);
        }
    }

    @Override
    public Product editProduct(Product p)  throws RuntimeException {

        Long prd =p.getId_product();
        Product pr =productRepository.findById(prd).get();
        pr.setId_product(p.getId_product());
        pr.setTitle(p.getTitle());
        pr.setPrice(p.getPrice());
        pr.setQuantity(p.getQuantity());

       return  productRepository.save(p);

    }
    @Override
    public void deleteProduct(Long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);

        product.ifPresent(p -> {
            productRepository.delete(p);
        });

    }
   @Override
    public List<Product> findProductsByName(String title) {
        return productRepository.findByTitle(title);
    }



    @Override
    public List<Product> PRODUCT_LIST() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long idProduct) {
        return productRepository.findById(idProduct).get();
    }

}
