package com.bhawana.step.pageobjects.homepage;

import com.bhawana.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by mohanpant on 17/01/2017.
 */
public class HomepageObject {
    private  WebDriver aDriver;

   // @FindBy(how= How.CSS, using="h1[class='top ng-binding']")
    private WebElement header;

    private WebElement carousel;
    private WebElement whatonnowtitle;
    private WebElement homegrid;
    private WebElement bannerid;
    private WebElement bannerclose;

    public HomepageObject(WebDriver aDriver) {

        this.aDriver = aDriver;
        PageFactory.initElements(aDriver,this);
    }

    public void setUpCapabilitiesValue(String scenarioname) {
        Driver.setTestnameToSauce(scenarioname);

        //set the Browser with current options or plugin install
        Driver.set(Driver.BrowserName.SAUCELABS);
    }

    public String getSessionID() {
         return (((RemoteWebDriver) aDriver).getSessionId()).toString();
    }

    public void open() {
        Driver.open("http://go.sky.com/");
    }

    public WebElement getHeaderTitle() {
        header = aDriver.findElement(By.cssSelector("h1[class='top ng-binding']"));
        return header;
    }


    public WebElement getCarouselSlide() {
        carousel = aDriver.findElement(By.cssSelector("slick[class='slider " +
                "carousel ng-scope ng-isolate-scope slick-initialized slick-slider']"));
        return carousel;
    }

    public WebElement getHeroRow() {
        WebElement herorowtitle = aDriver.findElement(By.cssSelector("h1[class='ng-binding']"));
        return herorowtitle;
    }

    public WebElement getLargeImage() {
        WebElement largeimage = aDriver.findElement(By.xpath("//div[@class='row ng-scope slick-slide " +
                "slick-current slick-active']//img[@class='img-responsive']"));
        return largeimage;
    }

    public WebElement getSmallImage() {
        WebElement smallimage = aDriver.findElement(By.xpath("//div[@class='col-xs-3']" +
                "//div[@class='pageItemWrapper']/img[@class='img-responsive']"));
        return smallimage;
    }

    public WebElement getCatchUpTitle() {
        WebElement catchuptitle = aDriver.findElement(By.xpath("//slider[@class='ng-isolate-scope']" +
                "[@vertical-tracking='4']/preceding-sibling::h1[@class='ng-binding']"));
        return catchuptitle;
    }

    public WebElement getSkyCinemaTitle() {
        WebElement skycinematitile = aDriver.findElement(By.cssSelector("div[class='row heroRow onNow ng-scope']>" +
                "div[class='col-xs-12']>h1"));
        return skycinematitile;
    }

    public WebElement getWhatOnNowTitle() {
        whatonnowtitle = aDriver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='5']" +
                "/preceding-sibling::h1[@class='ng-binding']"));
        return whatonnowtitle;
    }

    public WebElement getKidsHightlights() {
        return aDriver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='8']" +
                "/preceding-sibling::h1[@class='ng-binding']"));
    }

    public WebElement getSkySportsTitle() {
        WebElement skysportstitle = aDriver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='9']" +
                "/preceding-sibling::h1[@class='ng-binding']"));
        return skysportstitle;
    }

    public int numberOfTopPicks() {
        int toppicks;
        homegrid = aDriver.findElement(By.cssSelector("div[class='ng-isolate-scope']"));
        toppicks = Integer.valueOf(homegrid.getAttribute("columns"))
                + Integer.valueOf(homegrid.getAttribute("vertical-tracking"));
        return toppicks;
    }

    public WebElement getTopPickTitle() {
        WebElement toppicktitle = aDriver.findElement(
                By.cssSelector("div[class='col-xs-6 topPicks ng-scope']>h1[class='top ng-binding']"));
        return toppicktitle;
    }

    public WebElement getCookyBannerID() {
        bannerid = aDriver.findElement(
                By.cssSelector("div[class='sticky banner ng-isolate-scope']"));
        return bannerid;
    }

    public void cookyBannerClose() {
        bannerclose = aDriver.findElement(
                By.cssSelector("div[class='closeBannerContainer']"));
        bannerclose.click();
    }
}
