package com.example.back_pdf.repository;

import com.example.back_pdf.entity.Product;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@CrossOrigin("*")
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {


    public List<Product> findByTitle(@Param("mc") String title);






}
