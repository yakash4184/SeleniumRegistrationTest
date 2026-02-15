import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterTest {

    public static void main(String[] args) throws InterruptedException {

        // 1️⃣ Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 2️⃣ Open Registration Form (MAC PATH)
        driver.get("file:///Users/akashyadav/frugal-registration/index.html"); //This is File path
        //Click on Run button


        System.out.println("Page URL  : " + driver.getCurrentUrl());
        System.out.println("Page Title: " + driver.getTitle());

        // =====================================================
        // ❌ NEGATIVE TEST CASE (Last Name missing)
        // =====================================================

        driver.findElement(By.id("firstName")).sendKeys("Akash");
        // lastName intentionally skipped
        driver.findElement(By.id("email")).sendKeys("akash@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Password@123");
        driver.findElement(By.id("terms")).click();

        driver.findElement(By.id("submitBtn")).click();
        Thread.sleep(2000); //Program stop this interview for Better Page Load 2000 milli second  = 2 sec
        System.out.println("Negative Test Executed - Last Name validation checked");


        //When Any Element Not Found we Wait till Explict wait lock() After debuge. Grache only you fill all form without script
        //Crash
        // =====================================================
        // 🔁 RESET PAGE
        // =====================================================
        driver.navigate().refresh(); //naviagate control page
        Thread.sleep(1000); // wait a mintue // Explict is better option (wait to condition complete)

        // =====================================================
        // ✅ POSITIVE TEST CASE (All valid data)
        // =====================================================

        driver.findElement(By.id("firstName")).sendKeys("Akash");
        driver.findElement(By.id("lastName")).sendKeys("Yadav");
        driver.findElement(By.id("email")).sendKeys("akash@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("password")).sendKeys("Password@123");
        driver.findElement(By.id("confirmPassword")).sendKeys("Password@123");
        driver.findElement(By.id("terms")).click();

        driver.findElement(By.id("submitBtn")).click();
        Thread.sleep(2000);

        // =====================================================
        // ✅ VERIFY SUCCESS MESSAGE
        // =====================================================
        WebElement successMsg = driver.findElement(By.id("successMsg")); //WebElement Object bnaya aur search in html
        System.out.println("Success Message Displayed: " + successMsg.getText());  // call agar

        // =====================================================
        // ❌ Close Browser
        // =====================================================
        driver.quit(); // close
    }
}
