package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class loginPage {
	
	public WebDriver driver;
	
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	 By username=By.id("email");
	 By password=By.id("passwd");
	 By signIn=By.id("SubmitLogin");
	
	
	public mystorePage doLogin(String uname,String pwd)
	{
		
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
		return new mystorePage(driver);
	}
	
	
	public String titleVerify()
	{
		return driver.getTitle();
	}
			

}
