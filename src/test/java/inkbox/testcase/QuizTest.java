package inkbox.testcase;

import inkbox.wrapper.AllureListener;
import inkbox.wrapper.BaseClass;
import inkbox.wrapper.DriverManager;
import inkbox.wrapper.Utilities;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class QuizTest extends BaseClass {

    @Test(description = "Verify \"Start the Quiz \" button is visible or not")
    public void C5211_VerifyStartTheQuizButtonIsVisibleOrNot() {
        quiz.navigateToQuiz();
        quiz.switchToQuizFrame();
        Assert.assertTrue(quiz.checkStartTheQuizButtonExist(), "Start the Quiz button is not visible");
    }

    @Test(description = "Press Start Quiz")
    public void C5086_Press_StartQuiz() {
        quiz.navigateToQuiz();
        quiz.switchToQuizFrame();
        quiz.checkWhichDesignWouldYouWearExist();
        Assert.assertTrue(quiz.checkStartTheQuizButtonExist(), "Start the Quiz button is not visible");
        quiz.clickStartTheQuizButton();

        Assert.assertFalse(quiz.checkWhichDesignWouldYouWearExist(), "Start the Quiz button is visible");
    }

    @Test(description = "Validate QuizPage Availability")
    public void C5085_Validate_QuizPageAvailability() {
        quiz.navigateToQuiz();
        Assert.assertTrue(Utilities.getCurrentUrl().contains("g/quiz"), "Navigated to wrong page");
    }

    @Test(description = "Validate Text 'Your perfect tattoo is just a few clicks away !'")
    public void C5213_YourPerfectTattooIsFewClickAway() {
        quiz.navigateToQuiz();
        quiz.switchToQuizFrame();
        Assert.assertTrue(quiz.checkYourPerfectTattooIsFewClickAwayTextExist(), "'Your perfect tattoo is just a few clicks away !' is not visible");
    }

    @Test(description = "Verify the Text \" Start the Quiz \" and \" press enter \" button")
    public void C5215_VerifyTheText_StartTheQuizAndPressEnterButton(){
        quiz.navigateToQuiz();
        quiz.switchToQuizFrame();

        Assert.assertTrue(quiz.checkStartTheQuizButtonExist(),"Start the quiz button is not visible");
        Assert.assertFalse(quiz.checkEnterButtonText(), "Enter button is visible");
    }

    @Test(description = "Verify 'OK' button below the designs")
    public void C5221_VerifyOkButtonBelowTheDesigns() throws InterruptedException {
        quiz.navigateToQuiz();
        quiz.switchToQuizFrame();
        quiz.clickStartTheQuizButton();
        quiz.clickFirstPicture();
        Thread.sleep(10000);

    }
}