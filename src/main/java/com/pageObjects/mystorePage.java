package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class mystorePage {

public WebDriver driver;
	
	
	public mystorePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public By tshirtslink=By.linkText("T-shirts");
	public By product=By.xpath("//h5/a[@title='Faded Short Sleeve T-shirts']");
	public By cart=By.xpath("//button[@name='Submit']/span[text()='Add to cart']");
	public By checkOut=By.xpath("//a[@title='Proceed to checkout']/span");
	public By successMessage=By.xpath("//h2/i/..");
	public By productName=By.xpath("//div/span[@class='product-name']");
	public By sizecolor=By.xpath("//div/span[@id='layer_cart_product_attributes']");
	public By quan=By.xpath("//div/span[@id='layer_cart_product_quantity']");
	public By totalPrice=By.xpath("//div/span[@id='layer_cart_product_price']");
	
	
	
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
