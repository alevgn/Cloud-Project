package com.cloud.step_definitions;

import com.cloud.pages.LoginPage;
import com.cloud.pages.MenuOptions;
import com.cloud.utilities.ConfigurationReader;
import com.cloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B28G31_91_StepDefs_Alp {

    MenuOptions menuOptions = new MenuOptions();
    LoginPage loginPage = new LoginPage();

    @Given("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));


    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedList) {

        List<String> ExpectedList = new ArrayList<>(Arrays.asList("Files, Photos, Activity, Talk, Mail, Contacts, Calendar, Notes, Deck, Tasks, "));
       // System.out.println(ExpectedList);

        List<String> ActualList = new ArrayList<>();
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//ul[@id='appmenu']//li//a"));
        for (WebElement each : list) {
            ActualList.add(each.getAccessibleName());
        }

        Assert.assertTrue(ActualList.toString().contains(ExpectedList.toString()));

    }



    }













