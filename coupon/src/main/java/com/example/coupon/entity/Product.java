package com.example.coupon.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "coupon_code")
	private String couponCode;
	
	@Column(name = "exp_date")
	private String expDate;
	
	@Column(name = "offer_details")
	private String offerDetails;
	
	@Column(name = "paid_status")
	private String paidStatus;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getOfferDetails() {
		return offerDetails;
	}

	public void setOfferDetails(String offerDetails) {
		this.offerDetails = offerDetails;
	}

	public String getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(String paidStatus) {
		this.paidStatus = paidStatus;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", title=" + title + ", description=" + description + ", couponCode="
				+ couponCode + ", expDate=" + expDate + ", offerDetails=" + offerDetails + ", paidStatus=" + paidStatus
				+ "]";
	}
	

}
