package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.TimeEntryService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * This class handles the steps in the features files and connects with the service in case of having business logic.
 * Otherwise, if it is a simple action, like clicking a button and it has nothing related to business logic, is correct to put here.
 */
public class TimeEntrySteps extends PageSteps {

    @Then("Time entries screen page is displayed")
    public void isHomePageVisible() {
        TimeEntryService.isViewLoaded();
    }

    @Then("the user click add entry")
    public void AddEntry() {
        TimeEntryService.doAddEntry();  }


    @When("the user set Start with (.*) : (.*)")
    public void theUserSetStartWithStartHourStartMinutes(String startHour,String startMinutes) {
        TimeEntryService.doSetStartHour(startHour,startMinutes);
    }
    @And("the user set End   with   (.*) : (.*)")
    public void theUserSetEndWithEndHourEndMinutes(String endHour,String endMinutes) {
        TimeEntryService.doSetEndHour(endHour,endMinutes);
    }

    @And("the user click save")
    public void theUserClickSave() {
        TimeEntryService.doSave();
    }
    @And("the user set project")
    public void theUserSetAProject(){
        TimeEntryService.setProject();
    }
    @And("the user set a (.*)")
    public void theUserSetDescription(String description){
        TimeEntryService.setDescription( description);
    }
    @When("the user improve if the time entry is saved (.*)")
    public void theUserImproveTimeEntrySaved(String description){
        TimeEntryService.Validate(description);

    }


}
