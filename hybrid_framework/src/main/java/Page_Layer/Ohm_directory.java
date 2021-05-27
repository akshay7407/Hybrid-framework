package Page_Layer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base_Layer.baseClass;
import Util_package.Action;
import Util_package.utilClass;

public class Ohm_directory extends baseClass {
	
	@FindBy(xpath="//b[contains(text(),'Directory')]")
	WebElement   Directory;
	
	@FindBy(xpath="//input[@id='searchDirectory_emp_name_empName']")
	WebElement empname ;
	
	@FindBy(xpath="//select[@id='searchDirectory_job_title']")
	WebElement jobtitle;
	
	@FindBy(xpath="//select[@id='searchDirectory_location']")
	WebElement    location ;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	WebElement serachbtn;
	
	public Ohm_directory () {
		
		PageFactory.initElements(driver, this);
	}

	public void Directorydata() {
		
		Directory.click();
		empname.sendKeys("Fiona Grace");

		utilClass.selectbyindex(jobtitle, 2);
		utilClass.selectbyindex(location, 5);
		
	}
	public String verifyTest () {
		String boxname=Directory.getText();
		return boxname;
	
	}
	public String employee() {
		String emplo=empname.getAttribute("value");
		return emplo;
	}
	public void clickon()
	{
		Action.clickOnElement(serachbtn);
	}
}
