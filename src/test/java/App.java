import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Task {
    static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void Login() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://uattaxpayer3.taxservice.am/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement userName = driver.findElement(By.name("username"));
        String searchName = "admin";
        userName.sendKeys(searchName);

        WebElement userPass = driver.findElement(By.name("password"));
        String searchPass = "adminadmin";
        userPass.sendKeys(searchPass);

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]/div/div[7]/input")));
        continueButton.click();
    }

    @Test

///////////////////


/////////
    public static void TC1() throws InterruptedException {
        WebElement textElement = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Հաշվետվություններ")));
        textElement.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement declaration = driver.findElement(By.partialLinkText("219."));
        js.executeScript("arguments[0].scrollIntoView(true);", declaration);
        Thread.sleep(500);
        declaration.click();

        Thread.sleep(8000);

        WebElement selectYear = driver.findElement(By.name("TAX_YEAR"));
        selectYear.click();
        WebElement year = driver.findElement(By.xpath("//*[@id=\"hatisForm\"]/div/table/tbody/tr[7]/td[2]/div/ul/ul/li[5]"));
        year.click();

        WebElement selectPeriod = driver.findElement(By.name("FILE_PERIOD"));
        selectPeriod.click();
        WebElement period = driver.findElement(By.xpath("//*[@id=\"hatisForm\"]/div/table/tbody/tr[7]/td[3]/div/ul/ul/li[1]"));
        period.click();


        WebElement expandButton = driver.findElement(By.name("ENV_TAX_CALC_LIST"));
        expandButton.click();
        WebElement expandWaterButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("ENV_6_TABLE_SHOWER")));
        expandWaterButton.click();


        WebElement firstItem = driver.findElement(By.name("ENV_6_WATER_TYPE"));
        firstItem.click();
        WebElement firstItem1 = driver.findElement(By.xpath("//*[@id=\"hatisForm\"]/div/div[14]/div[2]/div[4]/table[1]/tbody/tr/td[1]/div[1]/ul/ul/li[1]"));
        firstItem1.click();


        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ENV_6_WATER_TAX_RATE")));

        String inputValue = inputField.getAttribute("value");

        if (inputValue.equals("6890")) {
            System.out.println("The input value is correct: " + inputValue);
        } else {
            System.out.println("The input value is incorrect. Found: " + inputValue);
        }


        WebElement secondItem = wait.until(ExpectedConditions.elementToBeClickable(By.name("ENV_6_WATER_PLACE")));
        secondItem.click();
        WebElement secondItem2 = driver.findElement(By.xpath("//*[@id=\"hatisForm\"]/div/div[14]/div[2]/div[4]/table[1]/tbody/tr/td[2]/div/ul/ul/li[2]"));
        secondItem2.click();

        WebElement dropItem = driver.findElement(By.name("ENV_6_WATER_PLACE_REGION"));
        dropItem.click();
        WebElement dropItem2 = driver.findElement(By.xpath("//*[@id=\"hatisForm\"]/div/div[14]/div[2]/div[4]/table[1]/tbody/tr/td[3]/div/ul/ul/li[1]"));
        dropItem2.click();


        WebElement input6_2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("ENV_6_WATER_TAX_BASE")));
        input6_2.click();
        WebElement input6_3 = wait.until(ExpectedConditions.elementToBeClickable(By.name("ENV_6_WATER_TAX_BASE_COUNT")));
        input6_3.click();
        Random random = new Random();

        int randomNum1 = random.nextInt(11);
        input6_2.sendKeys(String.valueOf(randomNum1));
        int Number = Integer.parseInt(String.valueOf(randomNum1));
        int randomNum2 = random.nextInt(randomNum1);
        input6_3.sendKeys(String.valueOf(randomNum2));
        int Number2 = Integer.parseInt(String.valueOf(randomNum2));

        WebElement saveButton = driver.findElement(By.name("SAVE"));
        saveButton.click();


        WebElement input6_4 = driver.findElement(By.name("ENV_6_WATER_INLAW_COUNT"));
        String value = input6_4.getAttribute("value");
        int Number3 = Integer.parseInt(value);

        WebElement input6_5 = driver.findElement(By.name("ENV_6_WATER_OVER_LAW_COUNT"));
        String value1 = input6_5.getAttribute("value");
        int Number4 = Integer.parseInt(value1);

        WebElement input6_6 = driver.findElement(By.name("ENV_6_WATER_TAX_RATE"));
        String value2 = input6_6.getAttribute("value");
        int Number5 = Integer.parseInt(value2);

        WebElement input6_7 = driver.findElement(By.name("ENV_6_WATER_IN_COUNT_TAX"));
        String value3 = input6_7.getAttribute("value");
        int Number6 = Integer.parseInt(value3);

        WebElement input6_8 = driver.findElement(By.name("ENV_6_WATER_OVER_COUNT_TAX"));
        String value4 = input6_8.getAttribute("value");
        int Number7 = Integer.parseInt(value4);

        WebElement input6_9 = driver.findElement(By.name("ENV_6_WATER_NULLABLE_COUNT_TAX"));
        String value5 = input6_9.getAttribute("value");
        int Number8 = Integer.parseInt(value5);

        WebElement input6_10 = driver.findElement(By.name("ENV_6_WATER_TOTAL_TAX"));
        String value6 = input6_10.getAttribute("value");
        int Number9 = Integer.parseInt(value6);


        if (Number > Number2 && Number2 > 0) {
            Assert.assertEquals(Number3, Number2);
            System.out.println("Assertion passed:" + Number3 + " = " + Number2);

            int a = Number - Number2;
            Assert.assertEquals(Number4, a);
            System.out.println("Assertion passed:" + Number4 + " = " + (Number - Number2));

            int b = Number3 * Number5 * 2;
            b = Math.round(b);
            Assert.assertEquals(Number6, b);
            System.out.println("Assertion passed:" + Number6 + " = " + (Number3 * Number5 * 2));

            int c = Number4 * Number5 * 2 * 3;
            c = Math.round(c);  // Same as above
            Assert.assertEquals(Number7, c);
            System.out.println("Assertion passed:" + Number7 + " = " + (Number4 * Number5 * 2 * 3));

            Assert.assertEquals(Number8, 0);
            System.out.println("Assertion passed:" + Number8 + " = " + 0);

            int d = Number6 + Number7 + Number8;
            Assert.assertEquals(Number9, d);
            System.out.println("Assertion passed:" + Number9 + " = " + (Number6 + Number7 + Number8));
        } else {
            System.out.println("The value does not match any of the expected options.");
        }

    }
}




