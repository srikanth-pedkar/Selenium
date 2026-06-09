package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.support.ui.Select;



public class Dropdown {
    private WebDriver driver;
    private static final String URL = "https://web-locators-static-site-qa.vercel.app/Dropdown";

    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openBrowser(){
        if(driver == null){
            throw new IllegalStateException("Driver not found. Initialize it first");
        }
        driver.get(URL);
    }

    public void testCase01(){
        System.out.println("Which country do you want to travel");

        WebElement dropdown = driver.findElement(By.xpath("(//select[@class='dropdown'])[1]"));
        Select dropdownOptions = new Select(dropdown);
        dropdownOptions.selectByVisibleText("Australia");
        WebElement selectedOption = dropdownOptions.getFirstSelectedOption();
        System.out.println("Selected options is: "+ selectedOption.getText());

    }

    public void testCase02() {
        System.out.println("What would you prefer to watch among the listed movies?");

        WebElement moviesDropdown = driver.findElement(By.xpath("(//select[@class='dropdown'])[2]"));
        moviesDropdown.click();
        Select moviesOptions = new Select(moviesDropdown);
        
        for(int i=0; i<=moviesOptions.getOptions().size(); i++){
            if(i==moviesOptions.getOptions().size()-1){
               moviesOptions.selectByIndex(i);
               System.out.println("The selected option is: "+moviesOptions.getFirstSelectedOption().getText());
            }
        }
    }

    public void testCase03(){
        System.out.println("What would you prefer to eat among the listed fruits?");

        WebElement fruitsDropdown = driver.findElement(By.xpath("(//select[@class='dropdown'])[3]"));
        Select fruitsOptions = new Select(fruitsDropdown);
        boolean isMultiple = fruitsOptions.isMultiple();
        System.out.println("Is the dropdown is multi select? :"+isMultiple);
        String selectedOption = fruitsOptions.getFirstSelectedOption().getText();
        System.out.println("Default selected option is: "+selectedOption);
        List<WebElement> options = fruitsOptions.getOptions();
        for(WebElement element:options){
            String name = element.getText();
            System.out.println("Options are: "+name);
        }
    }

    public void closeBrowser(){
        driver.quit();
    }
}
