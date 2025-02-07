package pages.blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class BlogPage extends BasePage {

    public BlogPage (WebDriver driver) {super(driver);}

    private final By nameInput = By.xpath("//input[@id='author']");
    private final By emailInput= By.xpath("//input[@id='email']");
    private final By commentIInput = By.xpath("//textarea[@id='comment']");
    private final By submitButton = By.xpath("//button[@class='rqzvMi5z4kz']");
    private final By submitMessage = By.xpath("//div[@id='form-message']");
    private final By nextSliderButton = By.xpath("//button[@class='js-sites-next-sm slick-next slick-arrow']");
    private final By sliderBlock = By.xpath("(//div[@class='C8EJ4K0y-wPR'])[8]");
    private final By scrollToSlider = By.xpath("(//h2[@class='Mb9Bp63q'])[7]");

    public BlogPage topPostBlogButtonClick (int numButton) {
        By blogButton = By.xpath("(//a[@class='KmJM0eYwG'])[" + numButton + "]");
        driver.findElement(blogButton).click();
        return this;
    }

    public BlogPage topPostButtonClick (int numButton) {
        By topPostButton = By.xpath("(//a[@class='p5hdJwE'])[" + numButton + "]");
        driver.findElement(topPostButton).click();
        return this;
    }

    public BlogPage enterName (String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public BlogPage enterEmail (String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public BlogPage enterComment (String comment) {
        driver.findElement(commentIInput).sendKeys(comment);
        return this;
    }

    public BlogPage submitButtonClick () {
        driver.findElement(submitButton).click();
        return this;
    }

    public Boolean submitMessageVisibleCheck () {
        boolean isVisible = driver.findElements(submitMessage).size() > 0;
        if (!isVisible) {
            waitOneSeconds();
            submitButtonClick();
            waitTwoSeconds();
            isVisible = driver.findElements(submitMessage).size() > 0;
        }
        return isVisible;
    }

    public Boolean inputErrorVisibleCheck () {
        boolean errorsCheck = driver.findElements(By.xpath("//*[@class='Tm_2vEy error']")).size() == 3;
        if (!errorsCheck) {
            waitOneSeconds();
            submitButtonClick();
            waitTwoSeconds();
            errorsCheck = driver.findElements(submitMessage).size() == 3;
        }
        return errorsCheck;
    }

    public BlogPage nextSliderButtonClick () {
        driver.findElement(nextSliderButton).click();
        return this;
    }

    public Boolean sliderBlockVisibleCheck () {
        return elementVisibleCheck(sliderBlock);
    }

    public BlogPage scrollToSlider () {
        scrollToElement(scrollToSlider);
        return this;
    }

}
