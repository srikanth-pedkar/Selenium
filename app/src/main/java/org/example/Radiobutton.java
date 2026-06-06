package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.List;

public class Radiobutton {
    private WebDriver driver;
    private static final String URL = "https://web-locators-static-site-qa.vercel.app/Radio";

    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void openURL(){
        if(driver == null){
            throw new IllegalStateException("Driver not found. Please initiate Driver first");
        }
        driver.get(URL);
    }

    public void testCase01(){
        WebElement section1 = driver.findElement(By.xpath("//div[@class='RadioScreen_section1']"));

        List<WebElement> gender = section1.findElements(By.xpath(".//div[@class='RadioScreen_RadioWithText']"));
        for(WebElement element:gender){
            WebElement elementInput = element.findElement(By.xpath(".//input[@type='radio']"));
            WebElement elementName = element.findElement(By.xpath(".//p[@class='RadioScreen_RadioButtonText']"));

            String name = elementName.getText();
            if(name.equals("Female")){
                boolean defaultSelected = elementInput.isSelected();
                String typeValue = elementInput.getAttribute("type");
                String attributeValue = elementInput.getAttribute("value");
                System.out.println(name + " : Default is selected : " + defaultSelected);
                System.out.println(name + " Value of Type attribute is: "+ typeValue);
                System.out.println(name + " Value Attibute value is: "+ attributeValue);
            }
        }
    }

    public void testCase02(){
        WebElement section2 = driver.findElement(By.xpath("//div[@class='RadioScreen_section2']"));

        List<WebElement> javaRating = section2.findElements(By.xpath(".//div[@class='RadioScreen_RadioWithText']"));
        for(WebElement element:javaRating){
            WebElement elementInput = element.findElement(By.xpath(".//input[@type='radio']"));
            WebElement elementName = element.findElement(By.xpath(".//p[@class='RadioScreen_RadioButtonText']"));

            String name = elementName.getText();
            if(name.equals("Very Good")){
                elementInput.click();
                System.out.println(name + " : is selected ");
            }
        }
    }

    public void testCase03(){
        WebElement section3 = driver.findElement(By.xpath("//div[@class='RadioScreen_section3']"));

        List<WebElement> proofCard = section3.findElements(By.xpath(".//div[@class='RadioScreen_RadioWithText']"));
        for(WebElement element:proofCard){
            WebElement elementInput = element.findElement(By.xpath(".//input[@type='radio']"));
            WebElement elementName = element.findElement(By.xpath(".//p[@class='RadioScreen_RadioButtonText']"));

            String name = elementName.getText();
            if(name.equals("No")){
                boolean NoOption = elementInput.isEnabled();
                System.out.println("Option No is enabled: "+NoOption);
            }
            if(name.equals("Yes")){
                boolean yesOption = elementInput.isEnabled();
                System.out.println("Option Yes is enabled: "+yesOption);
                elementInput.click();
                System.out.println("Option Yes is selected");
            }
        }
    }

    public void closeBrowser(){
        driver.quit();
    }
}
