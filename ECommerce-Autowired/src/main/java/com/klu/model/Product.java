package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private int prodId;
	private String prodName;
	private double prodPrice;
	private String category;
 	public Product()
 	{
 		this.prodId=10;
 		this.prodName="Laptop";
 		this.prodPrice=999999.99;
 		this.category="Ecletronic";
 	}//op
 	public int getProdId()
 	{
 		return prodId;
 	}
 	public String getProdName()
 	{
 		return prodName;
 	}
 	public double getProdprice()
 	{
 		return prodPrice;
 	}
 	public String getCatgory()
 	{
 		return category;
 	}
}