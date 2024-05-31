package com.org.happyfox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



//POM - Cucumber with Junit or TestNG
//Project
  //test/java
     //com.pages
     //com.pagemanager
     //com.runner
     //com.stepdefinition
     //com.reports
     //com.base
  //test/resources
     //Features


//We should maintain all the locators in pages with page factory concept.
//Avoid code duplication, improve the readability and reusability.
//It's good practice to keep the main method seperate from utility and page classes.
//Main method is doing too much, break this down into smaller methods and classes.
//We should add comments to explain the purpose of key blocks of code.
//Use logger which can help for debugging purpose and maintaining the code.






public class Testcase101 {

    public static void main(String[] args) throws InterruptedException, AWTException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();  //If we use the WebDriverManager dependency, we don’t need to specify the jar file and setProperty method.
        driver.get("https://interview.supporthive.com/staff/"); //We should read the URL from the config.properties file.
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.id("id_username")).sendKeys("Agent");//We should read the credentials from the config.properties file.
        driver.findElement(By.id("id_password")).sendKeys("Agent@123");//We should create utility methods for sendKeys methods.
        driver.findElement(By.id("btn-submit")).click();//We should create utility methods for click methods.
        WebElement tickets = driver.findElement(By.id("ember29"));
        Actions action = new Actions(driver);
        action.moveToElement(tickets).build().perform();//Create utility method for action class methods
        WebElement statuses = driver.findElement(By.linkText("Statuses"));
        statuses.click();
        driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click();//Prefer the fastest locators, such as ID and CSS selector. If it’s not available, then go for xpath.
        driver.findElement(By.tagName("input")).sendKeys("Issue Created");
        WebElement statusColourSelect =
                  driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));//Create utility method for click an element
                  statusColourSelect.click();

                  WebElement statusColourEnter =
                  driver.findElement(By.xpath("//input[@class='sp-input']"));
                  statusColourEnter.clear(); statusColourEnter.sendKeys("#47963f");//statusColourEnter.clear().sendKeys("#47963f")

                  Robot r = new Robot();
                  r.keyPress(KeyEvent.VK_ESCAPE); //Once we pressed any keys, we should release robot.keyRelease(KeyEvent.VK_ESCAPE);
    
        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));//give proper ref variable name
        firstElement.click();

       
        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));//give proper ref variable name
        secondElement.click();
        

        
        driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
        WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));//Prefer the fastest locators, such as ID and CSS selector. If it’s not available, then go for xpath.
          addCreate.click();

          Thread.sleep(3000); //We should not use static waits. It will reduce automation performance. Use explicit waits - WebDriverWait

          WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
          action.moveToElement(moveTo).build().perform();
          moveTo.click();
         
          Thread.sleep(9000);//Use explicit waits - WebDriverWait
          
          WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
            action.moveToElement(issue).build().perform();
            
            
          WebElement make = driver.findElement(By.linkText("Make Default"));
          make.click();
          driver.findElement(By.linkText("Priorities")).click();//We should maintain all the locators in the page class.
          driver.findElement(By.xpath("//header/button[1]")).click();//We should create utility methods in one class.
          driver.findElement(By.tagName("input")).sendKeys("Assistance required");//We should create utility methods in one class.
          driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
          WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
          button.click();
    }      //We missed closing the main method.
Thread.sleep(9000);//Use explicit waits - WebDriverWait
}          //We missed closing the class.

//We should add comments to explain the purpose of key blocks of code, making it easier for others to understand.

//We should use two different test cases instead of keeping them outside of the block.

WebElement tickets2 = driver.findElement(By.id("ember29")); //We should give proper variable names; we should not use numbers.
action.moveToElement(tickets2).build().perform();
WebElement priorities2 = driver.findElement(By.linkText("Priorities"));//We should give proper variable names; we should not use numbers.
priorities2.click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Once we declare we should not duplicate, implicitly waits should always be at the top.
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click();//Don't use full xpath or absolute path
driver.findElement(By.linkText("Delete")).click();
WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
delete.click();

Thread.sleep(9000);//Use explicit waits - WebDriverWait
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click();//Prefer the fastest locators, such as ID and CSS selector. If it’s not available, then go for xpath.
driver.findElement(By.linkText("Logout")).click();

//Once the execution is over, quit the browser --> driver.quit();




// Incomplete class fix, Pages should be seperated properly

public class PagesforAutomationAssignment {


    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.happyfox.com");//We should read the URL from the config.properties file.

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        driver.quit();
    }
}//We should close the class 

//We should create separate classes for each page.

    static class BasePage {
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

//We should create separate classes for each page.
    static class LoginPage extends BasePage {
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

// Use (page factory) @FindBy annotation. It will increase the readability, when implementing the Page Object Model design pattern.
//Also it encapsulates the web element locators within page classes.

            driver.findElement(By.id("username")).sendKeys(username);//Create utility methods for good practice
            driver.findElement(By.id("password")).sendKeys(password);//Create utility methods for good practice
            driver.findElement(By.id("loginButton")).click();//Create utility methods for good practice
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();//Create utility methods for good practice
        }
    }

//How many pages available create that many classes.

    static class HomePage extends BasePage {
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }

    }// Close the class once all the methods are added.




    public class TablePage extends BasePage {

// Use (Page factory) @FindBy annotation. It will increase the readability, when implementing the Page Object Model design pattern.
    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr");

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator);

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }




    }

}// Remove unnecessary paranthesis

