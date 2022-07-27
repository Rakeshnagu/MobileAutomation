package inkbox.pages;

import inkbox.modules.HamburgerMenu;
import inkbox.wrapper.DriverManager;
import inkbox.wrapper.Utilities;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Quiz extends HamburgerMenu {
    final static Logger logger = Logger.getLogger(Quiz.class);


    By startTheQuizButton = By.xpath("//*[@id='root']/main//span[contains(text(),'Start the Quiz')]");
    By Quiz_Frame = By.xpath("//iframe[@title='typeform-embed']");
    By whichDesignWouldYouWear = By.xpath("//span[text()='Which design(s) would you wear?']");
    By yourPerfectTattooIsFewClickAwayText = By.xpath("//span[text()='Your perfect tattoo is just a few clicks away!']");
    By enterButton = By.xpath("//*[@id='root']/main//strong[contains(text(),'Enter')]");

    By pictureChoice = By.xpath("//p[text()='Choose as many as you like']/../../../div[@data-qa='checkboxlist']/descendant::div[contains(@aria-describedby,'picture_choice')]");
    public void navigateToQuiz() {
        DriverManager.getWebdriver().get(Utilities.readPropertyFile("url") + "/g/quiz");
        Utilities.checkPageIsReady();
    }

    public void switchToQuizFrame() {
        WebElement element = DriverManager.getWebdriver().findElement(Quiz_Frame);
        DriverManager.getWebdriver().switchTo().frame(element);
    }

    public boolean checkStartTheQuizButtonExist() {
        return Utilities.elementExist(startTheQuizButton);
    }

    public void clickStartTheQuizButton() {

        Utilities.javascriptClick(startTheQuizButton);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getStartTheQuizButtonText() {
        return Utilities.getText(startTheQuizButton);
    }

    public boolean checkEnterButtonText() {
        return Utilities.elementExist(enterButton);
    }

    public boolean checkWhichDesignWouldYouWearExist() {
        return Utilities.elementExist(whichDesignWouldYouWear);
    }

    public boolean checkYourPerfectTattooIsFewClickAwayTextExist() {
        return Utilities.elementExist(yourPerfectTattooIsFewClickAwayText);
    }

    public void clickFirstPicture(){
        Utilities.click(pictureChoice);
    }

}