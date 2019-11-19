package sicrediteste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Teste1 {
	static WebDriver driver;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	
	@Test
	public void test1() throws InterruptedException {

		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("switch-version-select")));
		driver.findElement(By.id("switch-version-select")).sendKeys("Bootstrap V4 Theme");
	Thread.sleep(700);
        //add bttn
		String xpathBtn = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[1]/a";
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathBtn)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBtn)));
        driver.findElement(By.xpath(xpathBtn)).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("field-customerName")));
        WebElement campos = driver.findElement(By.id("field-customerName")); //name
        campos.sendKeys("Teste Sicredi");
        campos = driver.findElement(By.id("field-contactLastName")); //last name 
        campos.sendKeys("Teste");
        campos = driver.findElement(By.id("field-contactFirstName")); //first name
        campos.sendKeys("Armando");
        campos = driver.findElement(By.id("field-phone")); //phone
        campos.sendKeys("51 9999-9999");
        campos = driver.findElement(By.id("field-addressLine1")); //address1
        campos.sendKeys("Av Assis Brasil, 3970"); 
        campos = driver.findElement(By.id("field-addressLine2")); //address2
        campos.sendKeys("Torre D"); 
        campos = driver.findElement(By.id("field-city")); //city
        campos.sendKeys("Porto Alegre"); 
        campos = driver.findElement(By.id("field-state")); //state
        campos.sendKeys("RS"); 
        campos = driver.findElement(By.id("field-postalCode")); //pc
        campos.sendKeys("91000-000"); 
        campos = driver.findElement(By.id("field-country")); //country
        campos.sendKeys("Brasil");        
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/a/div/b")).click(); //drop
        campos = driver.findElement(By.id("field_salesRepEmployeeNumber_chosen"));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/div/ul/li[8]")).click(); // fixter
        campos = driver.findElement(By.id("field-creditLimit")); //credit
        campos.sendKeys("200");
        
        WebElement btn = driver.findElement(By.id("form-button-save"));
        btn.click();
        btn.click();
        //success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));
        String msg = driver.findElement(By.id("report-success")).getText();
       // assertEquals("Your data has been successfully stored into the database.", msg);
        assertTrue(msg.contains("Your data has been successfully stored into the database."));
       
	}

}
