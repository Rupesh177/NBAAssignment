package glue;


import framework.ParentScenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class Base_Step_Definition extends ParentScenario {

    @Given("I have launched browser")
    public void Verify_Browser() {
        Before_Setup();
        Verify_Browser_Launched();
    }

    @Given("I am on NBA page")
    public void Navigate_To_NBA() throws IOException {
        configProp.load(in);
        String URL = configProp.getProperty("NBA_URL");
        Launch_URL(URL);
        obj_Home_Page.setCookie_accept();
    }

    @Then("I should be able to see NBA home page")
    public void Verify_App_Logo() {
        obj_Home_Page.Verify_NBA_Home_Page();
    }

    @When("user clicks on Load More option to check only 8 Elements are added")
    public void Load_More() {
        obj_Home_Page.loadMore();
    }

    @When("user clicks on Feedback button")
    public void SwitchToFeedback() {
        obj_Home_Page.SwitchToFeedback();
    }

    @When("Buy Ticket option should be available")
    public void VerifyBuyTicket() {
        obj_Home_Page.VerifyBuyTicket();
    }

    @When("I click on a random video")
    public void ClickRandomVideo() {
        obj_Home_Page.ClickOnRandomVideo();
    }

    @Then("video should be played in the same window")
    public void checkVideoIsPlayed() {
        obj_Home_Page.LoadVideo();
    }

    @Then("I click on {string} team")
    public void iClickOnTeam(String teamname) {
        obj_Home_Page.Verify_Search_Result(teamname);
    }

    @Then("user closes the browser")
    public void After_Scenario(){
        After_Setup();
    }

}
