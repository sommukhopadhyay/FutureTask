package com.somitsolutions.training.java.ExperimentationWithFutureTask;

public class Main {
	public static void main(String[] args){
		Preloader preloader = new Preloader();
		
		preloader.start();
		while (!preloader.isDone()){
			System.out.println("Task is not completed yet...."); 
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //sleep for 1 millisecond before checking again
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ProductInfo pInfo = preloader.get();
		
		//This commented block shows how we can cancel a Future task
		/*if (!preloader.cancel() == true){
			System.out.println("The task has been cancelled...");
		}
		else{
			System.out.println(pInfo.getProductName());
			System.out.print(pInfo.getProductPrice());	
		}*/
		
		System.out.println(pInfo.getProductName());
		System.out.print(pInfo.getProductPrice());	
	}
}
