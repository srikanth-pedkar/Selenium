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
        System.out.println("----------Test Case 01--------------");
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

    public void testCase02(){
        System.out.println("----------Test Case 02--------------");
        WebElement osSection = driver.findElement(By.xpath("//div[@class='Checkbox_section2']"));

        List<WebElement> os = osSection.findElements(By.xpath(".//div[@class='Checkbox_CheckboxWithText']"));
        for(WebElement row: os){
            WebElement osInput = row.findElement(By.xpath(".//input[@type='checkbox']"));
            WebElement osLabel = row.findElement(By.xpath(".//p[@class='Checkbox_CheckboxButtonText']"));

            String name = osLabel.getText();
            //System.out.println("Name of the OS is: "+name);

            boolean defaultSelections = osInput.isSelected();
            System.out.println(name+ " is selected default: "+ defaultSelections);

        }

        for(WebElement rows: os){
            WebElement osystemInput = rows.findElement(By.xpath(".//input[@type='checkbox']"));
            WebElement osystemLabel = rows.findElement(By.xpath(".//p[@class='Checkbox_CheckboxButtonText']"));

            String name = osystemLabel.getText();
            //System.out.println("Name of the OS is: "+name);

            boolean defaultSelections = osystemInput.isSelected();
            if(defaultSelections){
                osystemInput.click();
                System.out.println("Default selection is unselected");
            }

            if(name.equals("Android") || name.equals("iOS")){
                osystemInput.click();
                System.out.println(name + " is selected");
            }
        }
    }
    
    public void testCase03(){
        System.out.println("----------Test Case 03--------------");
        WebElement section3 = driver.findElement(By.xpath("//div[@class='Checkbox_section3']"));
        List<WebElement> weekDays = section3.findElements(By.xpath(".//div[@class='Checkbox_CheckboxWithText']"));

        for(WebElement rows:weekDays){
            WebElement dayInput = rows.findElement(By.xpath(".//input[@type='checkbox']"));
            WebElement dayLable = rows.findElement(By.xpath(".//p[@class='Checkbox_CheckboxButtonText']"));

            String dayName = dayLable.getText();
            dayInput.click();
            System.out.println(dayName +" is selected");
        }
    }

    public void closeBrowser(){
        driver.quit();
    }
}
