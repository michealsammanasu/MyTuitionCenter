package pages;

import org.openqa.selenium.By;


import base.ProjectSpecMeth;



public class Login extends ProjectSpecMeth
{


	public Login enterUsername(String email)
	{
		getDriver().findElement(By.name("emailId")).sendKeys(email);
		return this;
		
	}
	public Login enterPassowrd(String pass)
	{
		getDriver().findElement(By.name("password")).sendKeys(pass);
		return this;
		
	}
	public  void clickLogin()
	{
		getDriver().findElement(By.className("Loginform_loginButton__WegUN")).click();
	
	}
}
