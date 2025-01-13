package testCases;


import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecMeth;
import pages.Login;

public class RunLogin extends ProjectSpecMeth{
	
	
		@Test(dataProvider="ExcelDataPro")
	public void runLogin(String userName,String Pass)
	{
		System.out.println("login method Started");
		Login lp=new Login ();
		lp.enterUsername(userName).enterPassowrd(Pass).clickLogin();
		WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains("homepage"));
		String currentUrl = getDriver().getCurrentUrl();
		Assert.assertEquals(currentUrl, "http://139.144.4.104:3000/homepage");
		System.out.println("Login method ended");
	}
		
		
		
@BeforeTest
public void setFile()
{
	
	file="Login";
	
}
}
