package com.example.expuiautomator;

import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.os.RemoteException;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Context appContext;
    //must be public
    @Rule
    public ActivityScenarioRule<MainActivity> MyActivityRule= new ActivityScenarioRule<>(MainActivity.class);
    @Before
    public void setup ()
    {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
       assertEquals("com.example.expuiautomator", appContext.getPackageName());
    }
    @Test
    public void testuseAppContext() {
        // Context of the app under test.
        UiDevice device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        try {
            if (device.isScreenOn())
            {
                device.setOrientationLeft();
                device.openNotification();
                device.openQuickSettings();
                device.pressHome();
                UiObject allAppsButton = device
                        .findObject(new UiSelector().description("Apps")) ;
// Effectuer un clic sur le bouton pour charger le lanceur.
                try {
                    allAppsButton.click() ;
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}