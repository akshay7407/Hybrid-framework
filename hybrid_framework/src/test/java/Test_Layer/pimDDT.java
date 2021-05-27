package Test_Layer;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base_Layer.baseClass;
import Page_Layer.LoginPage;
import Page_Layer.pimPage;
import Util_package.ExcelReader;

public class pimDDT extends baseClass {
	
	ExcelReader obj1;
	LoginPage obj;
	pimPage obj2;
	@BeforeMethod
	
	public void startup() {
		baseClass.initalization();
	    obj=new LoginPage();
		
	}
	
	@Test(dataProvider="pimdata")
	
	public void pimlogin(String name,String id,String empstatus,String include) {
		
		obj.loginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		obj2=new pimPage();
		obj2.testtdata(name, id, empstatus, include);
	    	
	}
	@AfterMethod
	
	public void teardwon() {
		driver.close();
	}

	@DataProvider(name="pimdata")
	
	public Object dataaa(){
		
		
		try {
			obj1 = new ExcelReader("C:\\Users\\lenovo\\Desktop\\java files\\cucumber\\PIMdatadriven.xlsx");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		int rows=obj1.lastRowCount(1);
		
		Object [][]data=new Object[rows][4];
		for (int i=1;i<rows;i++)
		{
			data[i][0]=obj1.getData(i, 0, 1);
			data[i][1]=obj1.getData(i, 1, 1);
			data[i][2]=	obj1.getData(i, 2, 1);
			data[i][3]=	obj1.getData(i, 3, 1);
		}
		return data;
		
		
		
	}
	
	
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
