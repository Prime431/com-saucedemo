package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class SauceDemo {
    static String baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Browser name : ");
        String browserName = scanner.nextLine();

        choosingBrowser(browserName);
        checkLoginFunctionality();
        scanner.close();
    }

    public static void choosingBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
    }

    public static void checkLoginFunctionality() {
        driver.get(baseUrl); // opening url
        System.out.println("Get the Title : " + driver.getTitle()); // getting the title
        System.out.println("Current URL : " + driver.getCurrentUrl()); // getting the current URL
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit time for holding the process
        System.out.println("Print the Page Source : " + driver.getPageSource());
        driver.findElement(By.id("user-name")).sendKeys("Visal@gmail.com"); // entering email id
        driver.findElement(By.id("password")).sendKeys("Password"); // entering password
        driver.findElement(By.id("login-button")).click(); // clicking on login button
        System.out.println("Print the Current URL : " + driver.getCurrentUrl()); // printing current url
        driver.navigate().to(baseUrl); // navigating to base url
        driver.navigate().refresh(); // refreshing the page
        System.out.println("Testing Pass");
        driver.close();// closing the browser
    }

}
