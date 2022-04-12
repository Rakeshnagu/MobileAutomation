package inkbox.wrapper;

import inkbox.pages.*;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import inkbox.modules.HamburgerMenu;
import inkbox.modules.MenuPage;

public class BaseClass {

	protected MenuPage menuPage;
	protected LoginSignUpPage loginSignUpPage;
	protected ProductDisplayPage productDisplayPage;
	protected ShopProductPage shopProductPage;
	protected TattooMaker tattooMaker;
	protected CartPage cartPage;
	protected HamburgerMenu hamburgerMenu;
	protected HomePage homePage;
	protected MysteryBundles mysteryBundles;
	
	final static Logger logger = Logger.getLogger(BaseClass.class);
	
	@BeforeClass
	public void beforeClass() {
		
	}
	
	@BeforeMethod
	public void setup() {
		menuPage = new MenuPage();
		loginSignUpPage = new LoginSignUpPage();
		productDisplayPage = new ProductDisplayPage();
		shopProductPage = new ShopProductPage();
		tattooMaker= new TattooMaker();
		cartPage = new CartPage();
		hamburgerMenu = new HamburgerMenu();
		homePage =new HomePage();
		mysteryBundles = new MysteryBundles();

		DriverManager.startAppium();
	}
	
	@AfterMethod
	public void teardown() {
		DriverManager.getWebdriver().close();
	}

}
