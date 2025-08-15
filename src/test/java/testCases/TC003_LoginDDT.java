package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  -  logout
  Data is valid -- login failed  - test failed

  Data is invalid - login success - test failed - logout
  Data is invalid -- login failed - test pass
*/

public class TC003_LoginDDT extends BaseClass {

   @Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class,groups="DataDriven") // getting data provider from class
   public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException
   {
	   logger.info("****** Starting TC_003_LoginDDT ******");
	   
	   try
	   {
		//homePage 
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
        boolean targetPage=macc.isMyAccountPageExists();	
    

     /*Data is valid  - login success - test pass  -  logout
                      -- login failed  - test failed

       Data is invalid -  login success - test failed - logout
                       -- login failed - test pass
       */
        
       if(exp.equalsIgnoreCase("Valid"))
       {
    	   if(targetPage==true)
    	   {  
    		   macc.clickLogout();
    		   Assert.assertTrue(true);
    		 
    	   }
    	   else
    	   {
    		   Assert.assertTrue(false);
    	   }
       
        }
        
        if(exp.equalsIgnoreCase("Invalid"))
        {
          if(targetPage==true)
        	   {  
        		   macc.clickLogout();
        		   Assert.assertTrue(false);
        		 
          	   }
        	   else
        	   {
        		   Assert.assertTrue(true);
        	   }
        
        }
	  
	    } catch(Exception e)
        {
        	Assert.fail();                  
        }
	    Thread.sleep(3000);
        logger.info("****** Finished TC_003_LoginDDT ********");
     
   }

}
