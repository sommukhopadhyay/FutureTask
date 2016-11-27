package com.somitsolutions.training.java.ExperimentationWithFutureTask;

import java.util.List;

public class Main {
	public static void main(String[] args){
		List<ProductInfo> listOfProductInfo = null;
		System.out.println(Thread.currentThread().getName());
		
		Preloader preloader = new Preloader();
		
		//start getting the data in a background thread and
		//keep it for future use. while the background
		//thread is getting the data, we will continue
		//other task. later we can get this already fetched data
		//using future.get method. remember this get API is blocking
		preloader.start();
		
		/*//Do some other works... Here we are making the main thread sleep
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		int count = 0;
		while (!preloader.isDone()){
			System.out.println("Task is yet to be completed...");
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Preloader.executor.shutdown();
				System.exit(0);
			} //sleep for 1 millisecond before checking again
			
			if (count == 100){//make the count == a low number say 8
				//to see the cancellation effect
				preloader.cancel();
				System.out.println("The task has been cancelled...");
				Preloader.executor.shutdown();
				System.exit(0);
				}
			}
		
			if(!preloader.cancel() && preloader.isDone()){
				listOfProductInfo = preloader.get();
			}
		
		System.out.println(listOfProductInfo.get(0).getProductName());
		System.out.print(listOfProductInfo.get(0).getProductPrice());
		
		Preloader.executor.shutdown();
	}
}
