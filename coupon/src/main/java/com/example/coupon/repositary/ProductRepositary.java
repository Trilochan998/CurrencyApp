package com.example.coupon.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.coupon.entity.Product;

@Repository
public interface ProductRepositary extends JpaRepository<Product, Long>{

}
