package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utils.ExClassReadData;



public class ProjectSpecMeth extends ExClassReadData
{
	
	public String file;
	
	private static final ThreadLocal <ChromeDriver> cdriver=new ThreadLocal < ChromeDriver>();
	public void setDriver()
	{
		cdriver.set(new ChromeDriver());
	}
	public ChromeDriver getDriver()
	{
		return cdriver.get();
	}
	@BeforeMethod
	public void preCondition()
	{
		setDriver();
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().get("http://139.144.4.104:3000/homepage");
	}
	@AfterMethod
	public void postCondition()
	{	System.out.println();
		getDriver().quit();
	}
	
	@DataProvider(name="ExcelDataPro")
	public String[][] readExcel() throws IOException
	{
		
		
 		return readMethod(file);
		
	}
	
	@BeforeSuite
	public void reportsGenera()
	{
		
		ExtentSparkReporter  ex=new ExtentSparkReporter ("./reports/firstreport.html");
		ExtentReports extendReport=new ExtentReports();
		extendReport.attachReporter(ex);
		ExtentTest test = extendReport.createTest("Test Case Name","Test Case description");
		test.assignCategory("Hello");
		test.assignAuthor("Michea1");
		
		
	}
	@AfterSuite
	public void reportadded()
	{
		
	}
	
}
