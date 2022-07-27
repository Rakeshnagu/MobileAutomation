package inkbox.wrapper;

import inkbox.modules.*;
import inkbox.pages.*;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseClass {
    final static Logger logger = Logger.getLogger(BaseClass.class);

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
    protected WishList wishList;
    protected Footer footer;
    protected ProfilePage profilePage;
    protected Quiz quiz;
    protected Sort sort;

    @BeforeClass
    public void beforeClass() {

    }

    @Parameters({"geoLocation"})
    @BeforeMethod
    public void setup(String geoLocation, Method m) {
        menuPage = new MenuPage();
        loginSignUpPage = new LoginSignUpPage();
        productDisplayPage = new ProductDisplayPage();
        shopProductPage = new ShopProductPage();
        tattooMaker = new TattooMaker();
        cartPage = new CartPage();
        hamburgerMenu = new HamburgerMenu();
        homePage = new HomePage();
        mysteryBundles = new MysteryBundles();
        bundles = new Bundles();
        search = new SearchProduct();
        geolocation = new Geolocation();
        wishList = new WishList();
        footer = new Footer();
        profilePage = new ProfilePage();
        quiz = new Quiz();
        sort = new Sort();

        logger.info("*********************************************************************");
        logger.info("Running test case : " + m.getName().replace("_", " "));
        logger.info("*********************************************************************");

        DriverManager.startAppium();
     //   geolocation.SelectGeoLocation(geoLocation);
    }

    @AfterMethod
    public void teardown(Method m, ITestResult result) {
        DriverManager.getWebdriver().close();
        logger.info("*********************************************************************");
        logger.info("Completed test case : " + m.getName().replace("_", " ") + " " + (result.getStatus() == 1 ? "PASS" : "FAILED"));
        logger.info("*********************************************************************");
    }

}
