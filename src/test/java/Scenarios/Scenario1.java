package Scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageObjects.loginPage;
import com.pageObjects.mystorePage;


public class Scenario1 {

	
	public static WebDriver driver;
	public loginPage lp= new loginPage(driver);
	public mystorePage msp= new mystorePage(driver);
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\ChromeDriver\\chromedriver.exe");  
		driver= new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}
	@Test 
	public void Scenario1_test()
	{
		lp.doLogin("jetblue@grr.la", "jetblue");
		String actTitle=lp.titleVerify();
		String expected="My account - My Store";
		Assert.assertEquals(actTitle, expected);
		msp.addToCart();
		Assert.assertTrue(msp.ProceedToCheckOut());
		
		// Verify Faded Short Sleeve T-shirts is dispalyed or not
		String expectedProdcut="Faded Short Sleeve T-shirts";
		String actProduct=msp.verifyProduct();
		Assert.assertEquals(actProduct, expectedProdcut);
		
		// Verify Orange, S is dispalyed or not
		String expectedSizeColor="Orange, S";
		String actSizeColor=msp.verifyColor();
		Assert.assertEquals(actSizeColor, expectedSizeColor);
		
		// Verify Quantity  is dispalyed or not
		String expectedQuantity="1";
		String actQuantity=msp.verifyQuantity();
		Assert.assertEquals(actQuantity, expectedQuantity);
		
		// Verify Total Price is dispalyed or not
		String expectedPrice="$16.51";
		String actPrice=msp.verifyTotalPrivce();
		Assert.assertEquals(actPrice, expectedPrice);
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}

