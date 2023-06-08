package page_objects;


import framework.ParentPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class NBA_Home_Page extends ParentPage {

    private WebDriver driver;
    private JavascriptExecutor js;

    @FindBy(xpath = "//img[@alt='NBA Logo']")
    WebElement logo_NBA;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement cookie_accept;

    @FindBy(xpath = "//div[@class='p-2 absolute right-3 hover:cursor-pointer']")
    WebElement popup;

    @FindBy(xpath = "//button[contains(.,'Load more')]")
    WebElement load_more;

    @FindBy(xpath = "//img[@src='https://d6tizftlrpuof.cloudfront.net/themes/production/golden-state-warriors-button-5b6a732a53224abf123d8fe3cb36ee61.png']")
    WebElement feedback;

    @FindBy(xpath = "//h4[normalize-space()='Buy Tickets']")
    WebElement buyTicket;

    @FindBy(xpath = "//a[normalize-space()='×']")
    WebElement feedback_close;

    @FindBy(xpath = "//iframe[contains(@title,'Feedback')]")
    WebElement feedback_Frame;

    @FindBy(xpath = "//iframe[contains(@title,'Feedback Form Frame')]")
    WebElement feedback_Form_Frame;

    @FindBy(xpath = "//img[@alt=\"The Best of Klay Thompson's 2022‑23 Season\"]")
    WebElement random_video;

    By loadMoreCount = By.xpath("//div[contains(@class,'xsm:mx-5')]//div[contains(@class,'flex justify-between')]//div[contains(@class,'Article_card')]");

    By videoLocator = By.cssSelector("video[preload=\"auto\"]");


    private TeamsList obj_Teams_List;

    public NBA_Home_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        obj_Teams_List = new TeamsList(driver);
        PageFactory.initElements(driver, this);
    }

    public void Verify_NBA_Home_Page() {
        verify_Element_displayed(logo_NBA);
        Assert.assertEquals(true, driver.getTitle().contains("Golden State Warriors"));

    }

    public void setCookie_accept() {
        verify_Element_displayed(cookie_accept);
        verify_Element_displayed(popup);
        Click(cookie_accept);
        Click(popup);
    }

    public void ClickOnRandomVideo() {
        verify_Element_displayed(random_video);
        clickUsingJScript(random_video);
    }

    public void LoadVideo() {
        verify_Element_displayed(videoLocator);
        boolean isPaused = videoLoadedorNot();
        Assert.assertTrue(isPaused);
        pressUsingActions(Keys.ESCAPE);

    }

    public boolean videoLoadedorNot() {
        js = (JavascriptExecutor) driver;
        return (boolean) js.executeScript("return document.querySelector('video[preload=\"auto\"]').paused");

    }

    public void SwitchToFeedback() {
        switchToiFrame(feedback_Frame);
        Click(feedback);
        switchToDefault();
    }

    public void VerifyBuyTicket() {
        switchToiFrame(feedback_Form_Frame);
        verify_Element_displayed(buyTicket);
        Click(feedback_close);
        switchToDefault();
    }


    public void loadMore() {
        int count = driver.findElements(loadMoreCount).size();
        scrollToBottom();
        verify_Element_displayed(load_more);
        Click(load_more);

        int count_load_more = driver.findElements(loadMoreCount).size();
        int difference = count_load_more - count;

        Assert.assertEquals(difference, 8);

    }

    public void Verify_Search_Result(String teamname) {
        scrollToUp();
        obj_Teams_List.verifyTeamsPage(teamname);
    }

}
