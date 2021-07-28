package com.zerobank.stepdefinitions;

import com.zerobank.Pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import com.zerobank.utilities.browserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class loginStepDefs {

    LoginPage loginPage=new LoginPage();
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("signin_button")).click();

    }
    @Then("the user enters credentials and logs in")
    public void the_user_enters_credentials_and_logs_in() {
        loginPage.username.sendKeys("username");
        loginPage.password.sendKeys("Password");
        loginPage.signInButton.click();

        browserUtils.sleep(2);
        loginPage.backToSafety.click();


        String actualUser=Driver.getDriver().findElement(By.xpath("//i[@class='icon-user']")).getText();

    }
}
