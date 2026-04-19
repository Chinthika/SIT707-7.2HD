package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {

	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void setDate(WebDriver driver, WebElement element, String dateValue) {
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].value = arguments[1];", element, dateValue);
	}

	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		// Find username element
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("chinthika");

		// Find password element
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("chinthika_pass");

		// Find dob element
		ele = driver.findElement(By.id("dob"));
		setDate(driver, ele, "1994-08-19");

		// Find Submit button, and click on button.
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "success");

		driver.close();
	}

	@Test
	public void testWrongPassword() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("chinthika");

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("wrong_pass");

		ele = driver.findElement(By.id("dob"));
		setDate(driver, ele, "1994-08-19");

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "fail");

		driver.close();
	}

	@Test
	public void testWrongUsername() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("wronguser");

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("chinthika_pass");

		ele = driver.findElement(By.id("dob"));
		setDate(driver, ele, "1994-08-19");

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "fail");

		driver.close();
	}

	@Test
	public void testWrongDOB() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("chinthika");

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("chinthika_pass");

		ele = driver.findElement(By.id("dob"));
		setDate(driver, ele, "2000-01-01");

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "fail");

		driver.close();
	}

	@Test
	public void testEmptyFields() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		WebElement ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "fail");

		driver.close();
	}

	@Test
	public void testAllWrong() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("wronguser");

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("wrongpass");

		ele = driver.findElement(By.id("dob"));
		setDate(driver, ele, "2000-01-01");

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "fail");

		driver.close();
	}

	@Test
	public void testExtremeValues() {
		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/chint/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.navigate().to(
				"file:///C:/Users/chint/OneDrive/Documents/Deakin%20Assignments/T3/SIT707%20-%20Software%20Quality%20and%20Testing/7.1P/7.1P-resources/pages/login.html");
		sleep(5);

		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("averyveryverylongusername1234567890");

		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("averyveryverylongpassword1234567890");

		ele = driver.findElement(By.id("dob"));
		setDate(driver, ele, "9999-12-31");

		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();

		sleep(5);

		String title = driver.getTitle();
		System.out.println("Title: " + title);

		Assert.assertEquals(title, "fail");

		driver.close();
	}
}
