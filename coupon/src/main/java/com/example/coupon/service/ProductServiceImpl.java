package com.example.coupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.coupon.entity.Product;
import com.example.coupon.entity.ShoppingCart;
import com.example.coupon.repositary.ProductRepositary;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepositary productRepositary;

	@Override
	public void saveCouponDetails(Product product) {
		System.out.println(product);
		productRepositary.save(product);
		
	}
	
	public float getCartAmount(List<ShoppingCart> shoppingCartList) {

        float totalCartAmount = 0f;
        float singleCartAmount = 0f;
        int availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList) {

            int productId = cart.getProductId();
            Optional<Product> product = productRepositary.findById(productId);
            if (product.isPresent()) {
                Product product1 = product.get();
                if (product1.getAvailableQuantity() < cart.getQuantity()) {
                    singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
                    cart.setQuantity(product1.getAvailableQuantity());
                } else {
                    singleCartAmount = cart.getQuantity() * product1.getPrice();
                    availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                product1.setAvailableQuantity(availableQuantity);
                availableQuantity=0;
                cart.setProductName(product1.getName());
                cart.setAmount(singleCartAmount);
                productRepositary.save(product1);
            }
        }
        return totalCartAmount;
    }
}
