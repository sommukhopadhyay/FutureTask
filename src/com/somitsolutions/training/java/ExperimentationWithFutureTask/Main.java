package com.somitsolutions.training.java.ExperimentationWithFutureTask;

public class Main {
	public static void main(String[] args){
		Preloader preloader = new Preloader();
		
		preloader.start();
		
		ProductInfo pInfo = preloader.get();
		
		if (!preloader.cancel() == true){
			System.out.println("The task has been cancelled...");
		}
		else{
			System.out.println(pInfo.getProductName());
			System.out.print(pInfo.getProductPrice());	
		}
	}
}
