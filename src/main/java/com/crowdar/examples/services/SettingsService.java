package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;
import com.crowdar.examples.constants.SettingsConstants;
import org.testng.Assert;

/**
 * This class contains the business logic.
 * We can have querys, requests or steps to do certain things (how to log into the app).
 * If we need to only complete a field or click a button, we can put it in the steps.
 */
public class SettingsService {

    public static void doAccessSettingsPage() {
        MobileActionManager.click(SettingsConstants.HAMBURGER_MENU_LOCATOR);
        MobileActionManager.click(SettingsConstants.SETTINGS_LOCATOR);
       // System.out. println("........................<<<Click Settings>>>");
    }
    public static void doAccessTimeTrackerPage() {
        MobileActionManager.click(SettingsConstants.HAMBURGER_MENU_LOCATOR);
        MobileActionManager.waitVisibility(SettingsConstants.SETTING_TIME_ENTRIES_LOCATOR);
        MobileActionManager.click(SettingsConstants.SETTING_TIME_ENTRIES_LOCATOR);
      //  System.out. println("........................<<<Click Time entries menu >>>");
    }

    public static void doSwitchOffLineMode() {
        MobileActionManager.waitClickable(SettingsConstants.SWITCH_OFFLINE_MODE_LOCATOR);
        MobileActionManager.click(SettingsConstants.SWITCH_OFFLINE_MODE_LOCATOR);
    }
    public static void doSwitchOnLineMode() {
        MobileActionManager.waitClickable(SettingsConstants.SWITCH_OFFLINE_MODE_LOCATOR);
        MobileActionManager.click(SettingsConstants.SWITCH_OFFLINE_MODE_LOCATOR);
    }

    public static void isVisibleOffLineBanner() {
        MobileActionManager.waitVisibility(SettingsConstants.OFFLINE_BANNER);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.OFFLINE_BANNER), "No se muestra banner offline");
    }
}
