package com.ibm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.entity.Product;

import java.util.List;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductByProdId(Integer prodId);

    List<Product> findProductByProdName(String prodName);
    
    List<Product> findProductByCategory(String category);
    
    List<Product> findProductByPrice(long price);
    
    List<Product> findProductByDiscount(int discount);
}
