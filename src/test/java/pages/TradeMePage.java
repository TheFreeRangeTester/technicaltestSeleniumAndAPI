package pages;

public class TradeMePage extends BasePage {

    private String makeDropdown = "(//select[@name='selectedMake'])";
    private String searchButton = "//button[@type='submit']";
    private String resultsLabel = "//h3[@class='tm-search-header-result-count__heading ng-star-inserted']";

    public TradeMePage(){
        super(driver);
    }

    public void navigateToTradeMeMotor(){
        navigateTo("https://www.trademe.co.nz/a/motors");
    }

    public void selectMakeFromDropdown(String make){
        selectFromDropdownByText(makeDropdown,make);
    }

    public void clickSearch(){
        clickElement(searchButton);
    }

    public int makeDropdownSize(){
       return dropdownSize(makeDropdown);
    }

    public String resultsAmount(){
        return textFromElement(resultsLabel);
    }

    
    
}
