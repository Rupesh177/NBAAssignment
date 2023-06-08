package page_objects;


import framework.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TeamsList extends ParentPage {

    private WebDriver driver;

    By teamListDropdown = By.xpath("//span[text()='Teams'])");

    public TeamsList(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyTeamsPage(String teamname) {
        verify_Element_displayed(teamListDropdown);
        clickUsingJScript(teamListDropdown);
        verify_Element_displayed(teamListDropdown);
        Click(teamListDropdown);
        driver.findElement(By.xpath("//a[normalize-space()='" + teamname + "']")).click();
        switchToNewTab(1);
        Assert.assertTrue(driver.getTitle().contains("Celtics"));
        switchToDefault();

    }
}
