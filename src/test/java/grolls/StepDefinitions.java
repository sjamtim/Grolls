package grolls;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

   // https://www.grolls.se/helags-t-shirt--svart1100099.html

    WebDriver driver;
    WebDriverWait waiter;

    @Given("I have navigated to the website")
    public void iHaveNavigatedToTheWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.grolls.se/helags-t-shirt--svart1100099.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-mask")));
    }

    @And("I select size small")
    public void i_select_size_small() throws InterruptedException {
        Select dropdownSize = new Select(driver.findElement(By.cssSelector("select[id=attribute400][name='super_attribute[400]']")));
        dropdownSize.selectByValue("1419");
        Thread.sleep(1000);

    }
    @Given("I want {int} t-shirts")
    public void i_want_t_shirts(int amount) throws InterruptedException {
        WebElement amountBox = driver.findElement(By.cssSelector("input[type=number"));
        amountBox.clear();
        amountBox.sendKeys(Integer.toString(amount));
        Thread.sleep(1000);


    }
    @When("I press {string}")
    public void i_press(String string) throws InterruptedException {
        WebElement addButton = driver.findElement(By.cssSelector("button[title='Lägg i varukorgen']"));
        //WebElement addButton = driver.findElement(By.xpath("/html/body/div[4]/main/div[2]/div/div[1]/div[2]/div[5]/form/div[2]/div/div/div[2]/button"));
        System.out.println(addButton.getText());
        addButton.click();
        Thread.sleep(1000);

    }
    @Then("the result should be {int} t-shirts size small in the cart")
    public void the_result_should_be_t_shirts_size_small_in_the_cart(int amount) {
        WebElement cartQuantity = driver.findElement(By.cssSelector("span[class='counter qty']"));
        cartQuantity.getAttribute("outerText");
        //System.out.println("Quantity " + cartQuantity.getAttribute(("outerText")));
        assertEquals(amount, Integer.parseInt(cartQuantity.getAttribute("outerText")));
        driver.quit();

    }


}
