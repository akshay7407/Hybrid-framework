package Base_Layer;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Util_package.WebEventListener;




public class baseClass   {


	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener listner;
	public static EventFiringWebDriver EventDriver;
	


	public baseClass()  {
		try {
			prop=new Properties();
			FileInputStream  fis=new FileInputStream("C:\\Users\\lenovo\\Desktop\\java files\\hybrid_framework\\src\\main\\java\\Config\\Config.Properties");
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void initalization() {



		String browsername=prop.getProperty("browser");


		if(browsername.equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\java files\\hybrid_framework\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browsername.equals("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\lenovo\\Desktop\\java files\\hybrid_framework\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
		else if (browsername.equals("opera")) {
			System.setProperty("webdriver.opera.driver",
					"C:\\Users\\lenovo\\Desktop\\java files\\hybrid_framework\\operadriver.exe");
			driver = new OperaDriver();

		}

		 listner =new WebEventListener();
		
		 EventDriver=new EventFiringWebDriver(driver);
		//we have registred Custom class in util package..--- Web Event Listener
		
		EventDriver.register(listner);
		driver=EventDriver;
		 
		 
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
