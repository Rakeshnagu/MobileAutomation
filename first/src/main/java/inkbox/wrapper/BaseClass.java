package inkbox.wrapper;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import inkbox.modules.HamburgerMenu;
import inkbox.modules.MenuPage;
import inkbox.pages.CartPage;
import inkbox.pages.HomePage;
import inkbox.pages.LoginSignUpPage;
import inkbox.pages.ProductDisplayPage;
import inkbox.pages.ShopProductPage;
import inkbox.pages.TattooMaker;

public class BaseClass {

	protected MenuPage menuPage;
	protected LoginSignUpPage loginSignUpPage;
	protected ProductDisplayPage productDisplayPage;
	protected ShopProductPage shopProductPage;
	protected TattooMaker tattooMaker;
	protected CartPage cartPage;
	protected HamburgerMenu hamburgerMenu;
	protected HomePage homePage;
	
	final static Logger logger = Logger.getLogger(BaseClass.class);
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@BeforeMethod
	public void setup() {
		DriverManager.startAppium();
	}
	
	@AfterMethod
	public void teardown() {
		DriverManager.getWebdriver().close();
	}

}
