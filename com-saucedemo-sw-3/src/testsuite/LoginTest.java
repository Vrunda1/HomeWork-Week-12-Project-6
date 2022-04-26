package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl=" https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void  userSholdLoginSuccessfullyWithValidCredentials(){
        // Enter  username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

       //Enter password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify the text “PRODUCTS”
       String expectedResult = "PRODUCTS";
       String actualResult = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
       Assert.assertEquals(expectedResult,actualResult);


    } @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter  username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");

        //Enter password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify that six products are displayed

        int expectedlist=6;
        int productName = Integer.parseInt(getTextFromElement(By.className("inventory_item")));
        System.out.println("Atual avilable products: "+productName);//6

        //Validate expected and actual message
        Assert.assertEquals("unable to display 6 products",expectedlist, productName);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }




}
