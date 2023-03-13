package com.cloud.pages;

import com.cloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MenuOptions {
    public MenuOptions ()  {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//ul[@id='appmenu']//li//a")
    public List<WebElement> dashboardOptions;






    @FindBy ( xpath = "(//li[@data-id='files'])[1]")
    public WebElement files;
    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;
    @FindBy(xpath = "//li[@data-id='files']")
    public WebElement filesOption;


    @FindBy(xpath = "//li[@data-id='photos']")
    public WebElement photosOption;

    @FindBy(xpath = "//li[@data-id='activity']")
    public WebElement activityOption;

    @FindBy(xpath = "//a[@aria-label='Talk']")
    public WebElement talkOption;

    @FindBy(xpath = "//a[@aria-label='Mail']")
    public WebElement mailOption;
    @FindBy (xpath = "(//a[@aria-label='Activity'])[1]")
    public WebElement activityOption1;

    @FindBy(xpath = "//a[@aria-label='Contacts']")
    public WebElement contactsOption;

    @FindBy(xpath = "//a[@aria-label='Calendar']")
    public WebElement calendarOption;

    @FindBy(xpath = "//a[@aria-label='Notes']")
    public WebElement notesOption;

    @FindBy(xpath = "//a[@aria-label='Deck']")
    public WebElement deckOption;


    @FindBy(xpath = "//a[@aria-label='Tasks']")
    public WebElement tasksOption;


}


