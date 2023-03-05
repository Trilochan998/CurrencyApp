package com.example.coupon.service;

import java.util.List;

import com.example.coupon.entity.Product;
import com.example.coupon.entity.ShoppingCart;

public interface ProductService {
	
	public void saveCouponDetails(Product product);
	public float getCartAmount(List<ShoppingCart> shoppingCartList);

}
