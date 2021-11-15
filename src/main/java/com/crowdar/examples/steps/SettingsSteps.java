package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.SettingsService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button ,and it has nothing related to business logic, is correct to put here.
 */
public class SettingsSteps extends PageSteps {

    @When("the user access the Setting page")
    public void userAccessSettingsPage(){
        SettingsService.doAccessSettingsPage( );
        //System.out. println("........................<<<Access  Settings page >>>");

    }
    @And("the user switches to forced offline mode")
    public void UserSwitchesOfflineMode() {
         SettingsService.doSwitchOffLineMode();
        System.out. println("........................<<<Switch Offline Mode >>>");
    }
    @And("the user switches to online mode again")
    public void UserSwitchesOnlineMode() {
        SettingsService.doSwitchOnLineMode();
        System.out. println("........................<<<Switch Online Mode >>>");
    }

    @Then("the user improve if the offline mode is displayed properly")
    public void OfflineModeIsDisplayedProperly() {
        SettingsService.isVisibleOffLineBanner();
    }


    @When("the user go to Time tracker page")
    public void userGoToTimeTrackerPage(){
        SettingsService.doAccessTimeTrackerPage( );
      //  System.out. println("........................<<<Go to Time tracker >>>");

    }
}
