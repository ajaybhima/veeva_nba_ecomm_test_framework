package stepDefinitions;

import com.veeva.nba.pages.HomePage;
import com.veeva.nba.utils.FileReadWriteUtils;
import com.veeva.nba.utils.SeleniumTestUtils;
import com.veeva.nba.utils.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SearchStepDefinitions extends TestBase {

    HomePage homePage;

    @Given("^User launches Nba application in browser$")
    public void UserlaunchesNbaapplicationinbrowser(){
        String applicationURL = FileReadWriteUtils.readDataFromPropertiesFile("./test.properties","Test_URL");
        System.out.println("Application URL = "+applicationURL);
        SeleniumTestUtils.launchApplication(driver,applicationURL);
    }

    @When("User navigates to Mens page from Menu options")
    public void userNavigatesToMensPageFromMenuOptions() {
        homePage = new HomePage(driver);
        homePage.closePreSalePopupClose();
        homePage.clickOnMensSubMenu();
    }
}
