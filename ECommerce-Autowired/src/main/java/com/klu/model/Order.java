package com.klu.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {
	private int ordId;
	private String custName;
	private int qtty;
	@Autowired //this is used to use directly without by using this prod.prodId,prod.prodName...(caling the class Product pro in constructor of this class);
	private Product prod; //here we directly injected the constructor automatically
	
	//here we just injected the object
	public Order()
	{
		this.ordId=99;
		this.custName="Ak47";
		this.qtty=7;
	}
	public void disp()
	{
		System.out.println("The following r the ord det of cust=");
		System.out.println("ordId: "+ordId);
		System.out.println("custName: "+custName);
		System.out.println("quantity: "+qtty);
		System.out.println("prodId: "+prod.getProdId()); //accessing of members only by objects only
		System.out.println("prodName: "+prod.getProdName());
		System.out.println("prodPrice: "+prod.getProdprice());
		System.out.println("prodCategory: "+prod.getCatgory());
	}
	
}