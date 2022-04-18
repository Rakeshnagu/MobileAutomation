package inkbox.wrapper;

import inkbox.modules.Geolocation;
import inkbox.modules.SearchProduct;
import inkbox.pages.*;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import inkbox.modules.HamburgerMenu;
import inkbox.modules.MenuPage;
import org.testng.annotations.Parameters;

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
	protected Bundles bundles;
	protected SearchProduct search;
	protected Geolocation geolocation;
	
	final static Logger logger = Logger.getLogger(BaseClass.class);
	
	@BeforeClass
	public void beforeClass() {
		
	}

	@Parameters({"geoLocation" })
	@BeforeMethod
	public void setup(String geoLocation)  {
		menuPage = new MenuPage();
		loginSignUpPage = new LoginSignUpPage();
		productDisplayPage = new ProductDisplayPage();
		shopProductPage = new ShopProductPage();
		tattooMaker= new TattooMaker();
		cartPage = new CartPage();
		hamburgerMenu = new HamburgerMenu();
		homePage =new HomePage();
		mysteryBundles = new MysteryBundles();
		bundles = new Bundles();
		search = new SearchProduct();
		geolocation = new Geolocation();

		DriverManager.startAppium();
		geolocation.SelectGeoLocation(geoLocation);
	}
	
	@AfterMethod
	public void teardown() {
		DriverManager.getWebdriver().close();
	}

}
