package homepage;


import org.openqa.selenium.WebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import static org.junit.Assert.*;
public class HomepageSteps {
    WebDriver driver;
    private String url = "http://go.sky.com/";
    private WebElement header;
    private WebElement toppicktitle;
    private WebElement homegrid;
    private WebElement carousel;
    public WebElement bannerid;
    private WebElement  bannerclose;
    private FirefoxProfile firebugProfile;

    @Given("^I am on homepage$")
    public void iAmOnHomepage() throws Throwable {
        ProfilesIni profile = new ProfilesIni();
        firebugProfile = profile.getProfile("selenium");
        //System.setProperty("Webdriver.gecko.driver","C:\\Webdriver\\Marionatte\\geckodriver.exe");
        driver = new FirefoxDriver(firebugProfile);
        driver.get(url);
    }

    @Then("^Header title should be displayed as \"([^\"]*)\"$")
    public void headerTitleShouldBeDisplayedAs(String title) {
        header = driver.findElement(By.cssSelector("h1[class='top ng-binding']"));
        assertEquals("Title is not as expected",header.getText(),title);
    }

    @Then("^A carousel should be displayed on the top of the page$")
    public void aCarouselShouldBeDisplayedOnTheTopOfThePage() throws Throwable {
        carousel = driver.findElement(
                By.cssSelector("slick[class='slider carousel ng-scope ng-isolate-scope slick-initialized slick-slider']"));
        assertTrue("Carousel is not displayed",carousel.isDisplayed());
    }

    @Then("^Large image highlight should be displayed$")
    public void largeImageHighlightShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Small size highlight should be displayed$")
    public void smallSizeHighlightShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Catch Up Highlights should be displayed$")
    public void catchUpHightlightsShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Sky Cinema Highlights should be displayed$")
    public void skyCinemaHighlightsShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Christmas showcase should be displayed$")
    public void christmasShowcaseShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^What's On Now should be displayed$")
    public void whatSOnNowShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Kids Highlights showcase should be displayed$")
    public void kidsHighlightsShowcaseShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Sky Sports Highlights should be displayed$")
    public void skySportsHighlightsShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^four top picks images should be displayed$")
    public void fourTopPicksImagesShouldBeDisplayed() throws Throwable {
        int toppicks;
        homegrid = driver.findElement(By.cssSelector("div[class='ng-isolate-scope']"));
        toppicks = Integer.valueOf(homegrid.getAttribute("columns"))
                + Integer.valueOf(homegrid.getAttribute("vertical-tracking"));
        assertEquals("Value is not same",toppicks,4);
    }

    @Then("^Top picks title should be displayed as \"([^\"]*)\"$")
    public void topPicksTitleShouldBeDisplayedAs(String title) throws Throwable {
        toppicktitle = driver.findElement(
                By.cssSelector("div[class='col-xs-6 topPicks ng-scope']>h1[class='top ng-binding']"));
        assertEquals("Title is not as expected",toppicktitle.getText(),title);
    }

    @Then("^Cookies banner should be displayed on top of the page$")
    public void cookiesBannerShouldBeDisplayedOnTopOfThePage() throws Throwable {
        bannerid = driver.findElement(
                By.cssSelector("div[class='sticky banner ng-isolate-scope']"));
        assertTrue("Cookies banner is not display",bannerid.isDisplayed());
    }

    @When("^I select the close button$")
    public void iSelectTheCloseButton() throws Throwable {
        bannerclose = driver.findElement(
                By.cssSelector("div[class='closeBannerContainer']"));
        bannerclose.click();
    }

    @And("^Refresh the page$")
    public void refreshThePage() throws Throwable {
        driver.navigate().refresh();
    }

    @Then("^Cookies banner should be closed$")
    public void cookiesBannerShouldBeClosed() throws NoSuchElementException{
        try {
            bannerid = driver.findElement(
                    By.cssSelector("div[class='sticky banner ng-isolate-scope']"));
            bannerid.isDisplayed();
        }
        catch(NoSuchElementException e){
            System.out.println("Error message display:  " + e.getMessage());
        }
    }

    @After
    public void closeDriver() {
        driver.quit();
        driver = null;
        System.gc();
    }
}


