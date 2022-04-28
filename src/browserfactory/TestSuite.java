package browserfactory;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String BaseUrl = "https://www.amazon.co.uk/";

    //1. Open the URL https://www.amazon.co.uk/
    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }

    @Test
    public void amazon() throws InterruptedException {
        //2. Type "Dell Laptop" in the search box and press enter or click on search  Button.
        clickOnElement(By.name("accept"));
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));

        //3. Click on the checkbox brand dell on the left side.
        clickOnElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]"));

        // 4. Verify that the  30(May be different) products are displayed on the page.
        String ActMsg = getTextFromElement(By.xpath("//span[contains(text(),'1-24 of over 1,000 results for')]"));
        System.out.println(ActMsg);
        messageValidation("1-24 of over 1,000 results for", ActMsg);
        
        // 5. Print all product names in the console.
        List<WebElement> printName = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement e : printName) {
            System.out.println(e.getText());
           }
    }
   // 6. Close the Browser.
    @After
    public void closeBrowser() {
        //closeBrowser();
    }
}