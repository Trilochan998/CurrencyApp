package com.example.coupon.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.coupon.dto.OrderDTO;
import com.example.coupon.dto.ResponseOrderDTO;
import com.example.coupon.entity.Product;
import com.example.coupon.service.ProductService;

@RestController
@RequestMapping("/coupon")
public class SellerController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "My name is Trilochan";
	}
	
	@PostMapping("/saveCouponDetails")
	public String saveCouponDetails(@RequestBody Product product) {
		return "Data has Successfully Posted";
	}
	
	 @PostMapping("/placeOrder")
	    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
	        System.out.println("Request Payload " + orderDTO.toString());
	        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
	        float amount = productService.getCartAmount(orderDTO.getCartItems());

	        Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
	        Integer customerIdFromDb = customerService.isCustomerPresent(customer);
	        if (customerIdFromDb != null) {
	            customer.setId(customerIdFromDb);
	            System.out.println("Customer already present in db with id : " + customerIdFromDb);
	        }else{
	            customer = customerService.saveCustomer(customer);
	            System.out.println("Customer saved.. with id : " + customer.getId());
	        }
	        Order order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
	        order = productService.saveOrder(order);
	        System.out.println("Order processed successfully..");

	        responseOrderDTO.setAmount(amount);
	        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
	        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
	        responseOrderDTO.setOrderId(order.getId());
	        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

	        System.out.println("test push..");

	        return ResponseEntity.ok(responseOrderDTO);
	    }


}
