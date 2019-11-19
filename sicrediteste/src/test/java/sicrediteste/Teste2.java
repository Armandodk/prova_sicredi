package sicrediteste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Teste2 {

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
	public void test() throws InterruptedException {
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
        campos.sendKeys("Av Assis Brasil, 3970"); //x
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
        WebElement btn = driver.findElement(By.id("save-and-go-back-button"));
        btn.click();
        Thread.sleep(300);
        if(btn.isDisplayed()) {btn.click();}
        xpathBtn = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[2]/a[3]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathBtn)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathBtn)));
        driver.findElement(By.xpath(xpathBtn)).click();
       
        driver.findElement(By.xpath("html/body/div[2]/div[2]/div[1]/div[2]/form/div[1]/div[2]/a[3]/input")).sendKeys("Teste Sicredi");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[3]")).click();
        String xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input";
        
        while(!driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[3]")).getText().contains("Teste Sicredi")) {
        	System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/tbody/tr[1]/td[3]")).getText());
        	Thread.sleep(1000);
        }

        WebElement check = driver.findElement(By.xpath(xpath));
        boolean displayed = driver.findElement(By.xpath(xpath)).isDisplayed();
        boolean enabled = driver.findElement(By.xpath(xpath)).isEnabled();
        while(displayed == false || enabled == false)
        { Thread.sleep(300);}
        driver.findElement(By.xpath(xpath)).click();
        //System.out.println(driver.findElement(By.xpath(xpath)).isSelected());       
       // System.out.println(check.getAttribute("type"));      
        //System.out.println(driver.findElement(By.xpath(xpath)).isSelected());
         xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[2]/div[1]/a"; //delete button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click(); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click(); //delete message 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/span[3]/p")));
        //System.out.println(driver.findElement(By.xpath("/html/body/div[3]/span[3]/p")).getText());
        String msg = driver.findElement(By.xpath("/html/body/div[3]/span[3]/p")).getText();  //   
         assertTrue(msg.contains("Your data has been successfully deleted from the database."));
	}
	
}
