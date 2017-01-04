package homepage;


import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import static org.hamcrest.CoreMatchers.is;
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
    private WebElement herorowtitle;
    private WebElement largeimage;
    private WebElement smallimage;
    private WebElement catchuptitle;
    private WebElement skycinematitile;
    private WebElement kidshighlight;
    private WebElement skysportstitle;
    private WebElement whatonnowtitle;
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
        herorowtitle = driver.findElement(By.cssSelector("h1[class='ng-binding']"));
        assertThat("Title is not as expected",herorowtitle.getText(),is("Sky Box Sets Highlights"));

        largeimage = driver.findElement(By.xpath("//div[@class='row ng-scope slick-slide slick-current slick-active']//" +
                "img[@class='img-responsive']"));
        assertTrue("Image doesnot display", largeimage.isDisplayed());
    }
    @And("^Small size highlight should be displayed$")
    public void smallSizeHighlightShouldBeDisplayed() throws Throwable {
       smallimage = driver.findElement(By.xpath("//div[@class='col-xs-3']" +
               "//div[@class='pageItemWrapper']/img[@class='img-responsive']"));
       assertTrue("Image doesnot display", smallimage.isDisplayed());


    }

    @Then("^Catch Up Highlights should be displayed$")
    public void catchUpHightlightsShouldBeDisplayed() throws Throwable {
       catchuptitle = driver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='4']" +
               "/preceding-sibling::h1[@class='ng-binding']"));
        assertThat("Title is not as expected",catchuptitle.getText(),is("Catch Up Highlights"));

    }

    @Then("^Sky Cinema Highlights should be displayed$")
    public void skyCinemaHighlightsShouldBeDisplayed() throws Throwable {
        skycinematitile = driver.findElement(By.cssSelector("div[class='row heroRow onNow ng-scope']>" +
                "div[class='col-xs-12']>h1"));
        assertThat("Title is not as expected",skycinematitile.getText(),is("What's On Now"));
    }

    @Then("^What's On Now should be displayed$")
    public void whatSOnNowShouldBeDisplayed() throws Throwable {
        whatonnowtitle = driver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='5']" +
                "/preceding-sibling::h1[@class='ng-binding']"));
        assertThat("Title is not as expected",whatonnowtitle.getText(),is("Sky Cinema Highlights"));
    }

    @Then("^Kids Highlights showcase should be displayed$")
    public void kidsHighlightsShowcaseShouldBeDisplayed() throws Throwable {
        kidshighlight = driver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='8']" +
                "/preceding-sibling::h1[@class='ng-binding']"));
        assertThat("Title is not as expected",kidshighlight.getText(),is("Kids Highlights"));
    }

    @Then("^Sky Sports Highlights should be displayed$")
    public void skySportsHighlightsShouldBeDisplayed() throws Throwable {
        skysportstitle = driver.findElement(By.xpath("//slider[@class='ng-isolate-scope'][@vertical-tracking='9']" +
                "/preceding-sibling::h1[@class='ng-binding']"));
        assertThat("Title is not as expected",skysportstitle.getText(),is("Kids Highlights"));
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


