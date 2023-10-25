package hellocucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsItFriday {
    static String isItFriday(String today) {
        return "Friday".equals(today) ? "TGIF" : "Nope";
    }
}

public class StepDefinitions {
    private String today;
    private String actualAnswer;

    private final WebDriver driver = new ChromeDriver();

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_is_t_friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }
    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("today is Friday")
    public void today_is_the_Friday() {
        today = "Friday";
    }

    @Given("today is the Sunday")
    public void today_is_the_sunday() {
        today = "Sunday";
    }

    @Given("today is {string}")
    public void todayIs(String today) {
        this.today = today;
    }

    @Given("I am on the Google search page")
    public void iAmOnTheGoogleSearchPage() {
        driver.get("https://www.google.com");

    }

    @When("I search for {string}")
    public void iSearchFor(String arg0) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("cheese");
        element.submit();
    }

    @Then("the page title should start with {string}")
    public void thePageTitleShouldStartWith(String titleStartsWith) {
//        // Google's search is rendered dynamically with JavaScript
//        // Wait for the page to load timeout after ten seconds
//        new WebDriverWait(driver,).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                return d.getTitle().toLowerCase().startsWith(titleStartsWith);
//            }
//        });
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
