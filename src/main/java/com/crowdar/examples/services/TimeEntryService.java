package com.crowdar.examples.services;

import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.TimeEntryConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class TimeEntryService {

    public static boolean IsVisibleElemetScreenEntries(){
        return  MobileActionManager.isVisible(TimeEntryConstants.SCREEN_ENTRIES_LOCATOR)   ;
    }

    public static void isViewLoaded() {

        MobileActionManager.waitVisibility(TimeEntryConstants.SCREEN_ENTRIES_LOCATOR);
        Assert.assertTrue(IsVisibleElemetScreenEntries(), TimeEntryConstants.VIEW_NOT_DISPLAYED_MESSAGE);
    }

    public static void doAddEntry(){
         MobileActionManager.click(TimeEntryConstants.ADD_SAVE_FLOATING_BUTTON);
    }

    public static void doSetStartHour(String startHour,String startMinutes) {
        MobileActionManager.waitVisibility(TimeEntryConstants.START_END_HEADER);
        MobileActionManager.click(TimeEntryConstants.START_END_HEADER);
        System.out.println("........................<<<Set Start Hour>>>");


        MobileActionManager.setInput(TimeEntryConstants.SCROLL_HOUR,startHour,true,false,startHour);
        MobileActionManager.setInput(TimeEntryConstants.SCROLL_HOUR,startHour);

        MobileActionManager.click(TimeEntryConstants.BUTTON_UP_MINUTES);
        MobileActionManager.click(TimeEntryConstants.BUTTON_UP_MINUTES);

        //MobileActionManager.clickOptionSpinner(TimeEntryConstants.SCROLL_HOUR_Xpath,startHour);

        System.out. println("........................<<<Fin  start >>>");

    }
    public static void doSetEndHour(String endHour,String endMinutes){
        MobileActionManager.waitVisibility(TimeEntryConstants.TAB_END_LOCATOR);
        MobileActionManager.click(TimeEntryConstants.TAB_END_LOCATOR);
        System.out. println("........................<<<Set End Hour>>>");


        MobileActionManager.setInput(TimeEntryConstants.SCROLL_HOUR,endHour,true,false,endHour);
        MobileActionManager.setInput(TimeEntryConstants.SCROLL_HOUR,endHour);

        MobileActionManager.click(TimeEntryConstants.BUTTON_UP_MINUTES);
        MobileActionManager.click(TimeEntryConstants.BUTTON_UP_MINUTES);

        System.out. println("........................<<<Fin End >>>");

    }
    public static void doSave(){

        MobileActionManager.click(TimeEntryConstants.ADD_SAVE_FLOATING_BUTTON);
        System.out. println("........................<<<Save Time Entry >>>");
    }

    public static void setProject(){
        MobileActionManager.waitVisibility(TimeEntryConstants.SELECT_PROJECT_LOCATOR);
        MobileActionManager.click(TimeEntryConstants.SELECT_PROJECT_LOCATOR);


        MobileActionManager.waitVisibility(TimeEntryConstants.PROJECT_MOBILE_LOCATOR);
        MobileActionManager.click(TimeEntryConstants.PROJECT_MOBILE_LOCATOR);

        System.out. println("........................<<<Set project>>>");
    }
    public static void setDescription(String description){

        MobileActionManager.waitVisibility(TimeEntryConstants.DESCRIPTION_WORKING_ON_LOCATOR);
        MobileActionManager.click(TimeEntryConstants.DESCRIPTION_WORKING_ON_LOCATOR);
        MobileActionManager.setInput(TimeEntryConstants.DESCRIPTION_WORKING_ON_LOCATOR,description);
        System.out. println("........................<<<Set description >>>");
    }

    public static void Validate(String description){
       boolean saved =false;
        MobileActionManager.waitVisibility(TimeEntryConstants.LIST_TIME_ENTRY_SAVED_LOCATOR);
          List <WebElement> descriptions = ActionManager.getElements(TimeEntryConstants.LIST_TIME_ENTRY_SAVED_LOCATOR);
        for (WebElement e:descriptions ) {
            String description_saved= e.getAttribute("name");
            System.out.println("........................<<<Time saved >>>" +description_saved) ;

            if (description_saved.equals( description)) {
                saved = true;
                   }

        }

        Assert.assertTrue(saved,"Not found time entry saved");


        }

}
