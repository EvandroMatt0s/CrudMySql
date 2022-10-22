package com.menager.product.controller;

import com.menager.product.domain.Product;
import com.menager.product.service.ProductServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class ProductController {

    private ProductServico services;
//localhost:8080/products
    @GetMapping(path = "/products")
    public List<Product> list() {
        return services.productList();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> obterProduct(@PathVariable Integer id){
        try {
            Product product = services.obterProductPorId(id);
         return new ResponseEntity<Product>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/products")
    public void saveProduct(@RequestBody Product product){
        services.saveProduct(product);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<?>updateProduct(@RequestBody Product product, @PathVariable Integer id){
        try {
            Product updateProduct = services.obterProductPorId(id);
            updateProduct.setName(product.getName());
            updateProduct.setPreco(product.getPreco());

            services.saveProduct(product);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable Integer id){
        services.deleteById(id);
    }

}
