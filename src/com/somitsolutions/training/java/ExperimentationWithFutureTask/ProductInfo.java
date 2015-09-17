package com.somitsolutions.training.java.ExperimentationWithFutureTask;

public class ProductInfo {
	
	private String productName;
	private float productPrice;
	
	public ProductInfo(String productName, float productPrice){
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
