package com.menager.product.repository;

import com.menager.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface ProductRepositorio extends JpaRepository<Product,Integer> {

}
