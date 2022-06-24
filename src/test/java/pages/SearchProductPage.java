package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchProductPage {
    WebDriver driver;
    By searchBox = By.id("ispbxii_0");

    By SearchButton= By.xpath("//header/div[2]/div[4]/form[1]/input[2]");
    public SearchProductPage(WebDriver driver) {this.driver = driver;    }
    public void clickSearchButton(){driver.findElement(SearchButton).click();    }

    public void searchByProductName(String arg){driver.findElement(searchBox).sendKeys(arg);}

}
