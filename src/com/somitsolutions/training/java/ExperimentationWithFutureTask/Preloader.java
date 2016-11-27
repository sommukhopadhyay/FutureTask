package com.somitsolutions.training.java.ExperimentationWithFutureTask;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class Preloader {
	
		static ExecutorService executor  = Executors.newFixedThreadPool(1);
		List<ProductInfo> productInfo = new ArrayList<ProductInfo>();
		//The difference between Callable & Runnable 
		//is that Callable can return a value (of type futuretask)
		private FutureTask<List<ProductInfo>> future = null;
		
		/*new FutureTask<List<ProductInfo>>(new LoadProductInfo());*/
				
		
		public List<ProductInfo> get(){
			//List<ProductInfo> retValue = null;
			try {
				//get is blocking
				productInfo =  future.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return productInfo;
		}
		
		public boolean cancel(){
			return future.cancel(true);
		}
		
		public boolean isDone(){
			return future.isDone();
		}
		
		//private final Thread thread = new Thread(future);
		
		public void start() {
			System.out.println("The task is being submitted now...");
			//submit will return immediately. So we can do the other work
			//in the main thread. Later we can check if the task is
			//finished or not using isDone method.
			future = (FutureTask<List<ProductInfo>>) (executor.submit(new LoadProductInfo())); 
			}
		
		//long running task
		private List<ProductInfo> loadProductInfo(){
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//As if this data we have got from 
			//the database
			for (int i = 0; i<100000; i++){
				ProductInfo productI = new ProductInfo(Integer.toString(i), i);
				productInfo.add(productI);
			}
			return productInfo;
		}
		//The difference between Callable & Runnable 
		//is that Callable can return a value (of type futuretask)	
		class LoadProductInfo implements Callable<List<ProductInfo>>{
	
			@Override
			public List<ProductInfo> call() throws Exception {
				// TODO Auto-generated method stub
				return loadProductInfo();
			}
			
		}
}

