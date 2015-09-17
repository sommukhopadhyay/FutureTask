package com.somitsolutions.training.java.ExperimentationWithFutureTask;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class Preloader {
	
		private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>(){
				public ProductInfo call() {
					return loadProductInfo();
					}
				}){
		};
		
		public ProductInfo get(){
			ProductInfo retValue = null;
			try {
				retValue =  future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return retValue;
		}
		
		public boolean cancel(){
			return future.cancel(true);
		}
		
		private final Thread thread = new Thread(future);
		
		public void start() { thread.start(); }
		
		private ProductInfo loadProductInfo(){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ProductInfo("ABC", 100);
		}
}

