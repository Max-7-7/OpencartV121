package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("***** Starting TC002_LoginTest *******");
		
		try
		{
		//homePage 
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(P.getProperty("email"));
		lp.setPassword(P.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();		
		
	    Assert.assertTrue(targetPage);   //Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	      logger.info("***** Finished TC002_LoginTest ******");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
