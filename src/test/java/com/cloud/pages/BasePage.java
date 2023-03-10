package com.cloud.pages;


import com.cloud.utilities.BrowserUtils;
import com.cloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "(//a[@aria-label='Files'])[1]")
    public WebElement filesOption;


    @FindBy(xpath = "(//a[@aria-label='Photos'])[1]")
    public WebElement photosOption;

    @FindBy(xpath = "(//a[@aria-label='Activity'])[1]")
    public WebElement activityOption;

    @FindBy(xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkOption;

    @FindBy(xpath = "(//a[@aria-label='Mail'])[1]")
    public WebElement mailOption;

    @FindBy(xpath = "(//a[@aria-label='Contacts'])[1]")
    public WebElement contactsOption;

    @FindBy(xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement calendarOption;

    @FindBy(xpath = "(//a[@aria-label='Notes'])[1]")
    public WebElement notesOption;

    @FindBy(xpath = "(//a[@aria-label='Deck'])[1]")
    public WebElement deckOption;


    @FindBy(xpath = "(//a[@aria-label='Tasks'])[1]")
    public WebElement tasksOption;

    @FindBy(xpath = "//span[@aria-label='Magnify icon']")
    public WebElement searchMagnifier;

    @FindBy(xpath = "//div[@aria-label='Notifications']")
    public WebElement notifications;

    @FindBy(xpath = "//div[@aria-label='Contacts menu']")
    public WebElement contacts;

    @FindBy(xpath = "//div[@aria-label='Settings']")
    public WebElement settings;

    @FindBy(xpath = "//div[@class='logo logo-icon']")
    public WebElement logoIcon;

    //This locates the action icon button for the file created purposely for this test
    @FindBy(xpath ="//tr[@data-file='SM_Delete_Test.txt']//a[@data-action='menu']")
    public WebElement actionIconSM_Delete_TEst_file;

    //Locates the Delete File from the dropdown menu
    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteFileButtonFromDropDownMenu;

    //Locator for Deleted files button from submodule on bottom left corner
    @FindBy(xpath = "//a[@class='nav-icon-trashbin svg']")
    public WebElement deletedFilesButtonFromSubModule;

    //Locator for specific file made for this test with name SM_Delete_Test
    //This will locate the file ones is under Deleted files
    @FindBy(xpath = "//tr[@data-path='SM_Delete_Test.txt']")
    public WebElement deletedFileWebE_UnderDeletedFiles;

    //Locator for the restore button
    @FindBy(xpath = "//tr[@data-path='SM_Delete_Test.txt']//a[@data-action='Restore']")
    public WebElement restoreButtonFromDeletedFilesModuleS;




    /**
     * This method will navigate user to the specific module in Ceallo application.
     * For example: if tab is equals to Photos
     * Then method will navigate user to this page: https://qa.ceallo.com/index.php/apps/photos/
     *
     * @param tab
     *
     */
    public static void navigateToTab(String tab) {
        String tabLocator = "(//a[@aria-label='" + tab + "'])[1]";

        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
            new Actions(Driver.getDriver()).moveToElement(tabElement).pause(200).click().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Adam's Methods: Use if you need. Please do not delete for now.

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
            new Actions(Driver.getDriver()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
            Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.getDriver().findElement(By.xpath(moduleLocator)), 5);
        }
    }

}
