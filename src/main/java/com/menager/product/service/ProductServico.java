package com.menager.product.service;

import com.menager.product.domain.Product;
import com.menager.product.repository.ProductRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ProductServico {

    private ProductRepositorio repositorio;

    public List<Product> productList() {
        return repositorio.findAll();
    }

    public void saveProduct(Product product) {
        repositorio.save(product);
    }

    public Product obterProductPorId(Integer id) {
        return repositorio.findById(id).get();
    }

    public void deleteById(Integer id) {
        repositorio.deleteById(id);
    }


}
