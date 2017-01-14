package com.bhawana.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.System;

import java.util.concurrent.TimeUnit;

/**
 * Created by mohanpant on 08/01/2017.
 */
public class Driver extends Thread {
    public static WebDriver adriver = null;
    public static final String USERNAME = "bhawana123";
    public static final String ACCESS_KEY = "43666b44-9eac-46ef-a48f-c6ebd213d973";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    public enum BrowserName {FIREFOX, GOOGLECHROME, IE, SAFARI, HTMLUNIT, SAUCELABS}
    public static BrowserName usethisbrowser = BrowserName.FIREFOX;
    public static BrowserName currentbrowser;

    private static String currentDir;
    private static String saucetestname;

    public static void set(BrowserName abrowser) {usethisbrowser = abrowser;}

    public static void setScenarioName(String scenarioname) {
        saucetestname = scenarioname;}

    public static WebDriver get()  {
        currentDir = System.getProperty("user.dir");
        if(adriver == null){
            switch (usethisbrowser){
                case FIREFOX:
                    String geckoDriverLocation = currentDir + "/tools/geckodriver/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
                    ProfilesIni profile = new ProfilesIni();
                    FirefoxProfile firebugProfile = profile.getProfile("selenium");
                    adriver = new FirefoxDriver(firebugProfile);
                    currentbrowser = BrowserName.FIREFOX;
                    break;

                case GOOGLECHROME:
                    String chromeDriverLocation = currentDir + "/tools/chromedriver/chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    adriver = new ChromeDriver();
                    currentbrowser = BrowserName.FIREFOX;
                    break;

                case HTMLUNIT:
                    adriver = new HtmlUnitDriver();
                    adriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    currentbrowser = BrowserName.HTMLUNIT;
                    break;


                case SAFARI:
                    adriver = new SafariDriver();
                    currentbrowser = BrowserName.SAFARI;
                    break;

                case SAUCELABS:
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("platform", System.getProperty("platform"));
                    caps.setCapability("browserName",System.getProperty("browserName"));
                    caps.setCapability("version",System.getProperty("version"));
                    caps.setCapability("name",saucetestname);
                    System.out.println(saucetestname);
                    try {
                        adriver = new RemoteWebDriver(new URL(URL), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }

            //we want to shutdown the browser when the test finish
            Runtime.getRuntime().addShutdownHook(new Thread() {
                                                     public void run() {
                                                         adriver.quit();
                                                     }
                                                 }

            );
        }else {
            try {
                if(adriver.getWindowHandle() != null){
                    //driver is still alive
                }
            }catch (Exception e){throw new RuntimeException();}
            adriver.quit();
            adriver = null;
            return get();
        }
        return adriver;
    }

    public static WebDriver get(String aURL){
        return null;
    }

    public static void open(String aURL) {
        adriver.get(aURL);
    }


    public static void quit() throws Exception {
        if(adriver!=null){
            try{
                adriver.quit();
                adriver = null;
            }catch (Exception e){

            }
        }
    }
}

