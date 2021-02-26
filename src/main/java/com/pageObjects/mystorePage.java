package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mystorePage {

public WebDriver driver;
	
	
	public mystorePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	 By tshirtslink=By.linkText("T-shirts");
	 By product=By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']");
	 By cart=By.xpath("//button[@name='Submit']/span[text()='Add to cart']");
	 By checkOut=By.xpath("//a[@title='Proceed to checkout']/span");
	 By successMessage=By.xpath("//h2/i/..");
	 By productName=By.xpath("//div/span[@class='product-name']");
	 By sizecolor=By.xpath("//div/span[@id='layer_cart_product_attributes']");
	 By quan=By.xpath("//div/span[@id='layer_cart_product_quantity']");
	 By totalPrice=By.xpath("//div/span[@id='layer_cart_product_price']");
	
	
	
	public void addToCart()
	{
		driver.findElement(tshirtslink).click();
		driver.findElement(product).click();
		driver.findElement(cart).click();
		
	}
	public boolean ProceedToCheckOut()
	{
		return driver.findElement(successMessage).isDisplayed();
		
	}
	public String verifyProduct()
	{
		String prdt=driver.findElement(productName).getText();
		return prdt;
	}
	public String verifyColor()
	{
	String color=driver.findElement(sizecolor).getText();
	return color;
	}
	public String verifyQuantity()
	{
		String quantity=driver.findElement(quan).getText();
		return quantity;
		}
	public String verifyTotalPrivce()
	{
		String price=driver.findElement(totalPrice).getText();
		return price;
	}
	
			
	
	
	
}
