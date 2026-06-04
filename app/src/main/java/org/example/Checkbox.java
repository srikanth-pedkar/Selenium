package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By;

public class Checkbox {
    
    private WebDriver driver;
    private static final String URL = "https://web-locators-static-site-qa.vercel.app/Checkbox";

    public void initDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void launchBrowser(){
        if(driver == null){
            throw new IllegalStateException("Driver not initialized. Call initDriver() first.");
        }
        driver.get(URL);
    }

    public void testCase(){
        WebElement course = driver.findElement(By.xpath("//div[@class='Checkbox_section1']"));

        List<WebElement> elements = course.findElements(By.xpath(".//div[@class='Checkbox_CheckboxWithText']"));
        for (WebElement row: elements) {
            WebElement checkboxInput = row.findElement(By.xpath(".//div[@class='Checkbox_checkbox']"));
            WebElement checkboxLabel = row.findElement(By.xpath(".//p[@class='Checkbox_CheckboxButtonText']"));
            String name = checkboxLabel.getText();
            boolean isEnabled = checkboxInput.isEnabled();

            if(isEnabled){
                System.out.println(name + "  :  [Enabled]");
            }else{
                System.out.println(name + "  :  [Disabled]");
            }
            if(name.equals("QA") || name.equals("DSA")){
                if(!checkboxInput.isSelected()){
                    checkboxInput.click();
                    System.out.println(name + " : Clicked");
                }else{
                    System.out.println(name + " : Already Selected");
                }
                
            }
            if(name.equals("FDT") || name.equals("DSA")){
                String typeAttribute = checkboxInput.getAttribute("type");
                System.out.println(name + " Name type Attribute is: "+typeAttribute);
            }
        }
    }
    
    public void closeBrowser(){
        driver.quit();
    }
}
