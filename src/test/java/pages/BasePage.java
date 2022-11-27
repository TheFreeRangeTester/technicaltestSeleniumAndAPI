package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected static WebDriver driver;
    private static Actions action;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();;
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
        //return driver.findElement(By.xpath(locator));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void submitElement(String locator){
        Find(locator).submit();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
       return dropdownOptions.size();
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select (Find(locator));

        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){

        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{
        driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }
    
    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){

        return Find(locator).isSelected();
    }

    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void selectNthElementFromList(String locator, int index){
        List<WebElement> list = driver.findElements(By.className(locator));
        list.get(index).click();
    }

    public void dragAndDrop(String locator, String locator2){
        WebElement element = Find(locator);
        WebElement element2 = Find(locator2);
        action.dragAndDrop(element, element2).build().perform();
    }

    public void selectCriteriaFromList(String locator, String criteria){
        List<WebElement> list = driver.findElements(By.className(locator));
        for(WebElement element : list){
            if(element.getText().equals(criteria)){
                element.click();
                break;
            }
        }
    }
    
}