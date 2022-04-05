package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Banana {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Banana() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Banana [price=" + price + "]";
	}
	
	@PostConstruct
	public void start() {
		System.out.println("Start Method");
	}
	
	@PreDestroy
	public void end() {
		System.out.println("End Method");
	}

}
