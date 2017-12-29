package com.happy.grasshopper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.happy.excelReadWrite.ReadWriteExcel;

public class AddContact {
WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.navigate().to("https://go-v3b-testing.happygrasshopper.com");

		
	}
	@Test(dataProvider="getData")
	public void function(String firstName,String lastName,String mobNum,String mail,String audience,String txtNotes) throws InterruptedException {
		//String getTitle = driver.getTitle();
		Thread.sleep(3000);
		driver.findElement(By.id(ObjectRepository.userId)).sendKeys("hghcontacttest@gmail.com");
		driver.findElement(By.id(ObjectRepository.pwdId)).sendKeys("Grass123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		//for(int i=1;i<=7;i++) {
	    driver.findElement(By.linkText("View/Add Contacts")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Add Contact")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("ContactFirstName")).sendKeys(firstName);
	    driver.findElement(By.id("ContactLastName")).sendKeys(lastName);
	    driver.findElement(By.id("ContactPhone")).sendKeys(mobNum);
	    driver.findElement(By.id("ContactEmail")).sendKeys(mail);
	    Thread.sleep(2000);
	    Select dropdown = new Select(driver.findElement(By.id("ContactAudienceId")));
	    dropdown.selectByVisibleText(audience);
	    Thread.sleep(2000);
	    //tag
	  //  driver.findElement(By.xpath("//body[@class='class=\"hg forms-elements ontop-nav topnav-fixed\"']")).click();
		//Assert.assertEquals(getTitle, "Google");
	    driver.findElement(By.id("ContactNote")).sendKeys(txtNotes);
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
		}
//	}
	
	@DataProvider
	public Object[][] getData()
	{
		ReadWriteExcel readWrite= new ReadWriteExcel();
		Object[][] readObj = readWrite.readDataFromExcel();
		return readObj;
		
		
	}
	
	@AfterTest
	public void afterTest() {
		//close all window
		driver.quit();
	}
	
	

}
