package Test_Layer;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;
import Page_Layer.Ohm_directory;

public class Ohm_directoryTest extends baseClass {
	Ohm_directory obj ;
	@BeforeMethod
	
	public void basic() {
		baseClass.initalization();
		LoginPage obj1 = new LoginPage();
		obj1.loginFunctionality("Admin", "admin123");
	}
	@Test
	
	public void directory() {
	  obj=new Ohm_directory();
		obj.Directorydata();
	}
	@Test(enabled=false)
	
	public void verification ()
	{
		String a=obj.verifyTest();
		String b= "Directory";
		Assert.assertEquals(a, b);
	}
	@Test
	 public void empname() {
		
		String c=obj.employee();
		String d="Fiona Grace";
		Assert.assertEquals(c, d);
	}
	
	
	
	
	@AfterClass
	
	public void teardown() {
		obj.clickon();
	}

}
