package fankick.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ReporterConfig.Property;

public class SeleniumUtilis implements FileConstants {

	private static WebDriver driver = null;
	
	public static void createInstance() 
	{
		if (PropertyUtils.getServerValue(BrowserName).equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVER);
			driver = new ChromeDriver();
		}
		if (PropertyUtils.getServerValue(BrowserName).equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver = new ChromeDriver();
		}
	}

	public static WebDriver getDriver() 
	{
		if (null == driver) 
		{
			createInstance();
		}
		return driver;
	}
	
	public static void quitDriver()
	{
		getDriver().quit();
		driver = null;
	}
	
	public static void loadUrl(String url)
	{
		maximize();
		getDriver().get(PropertyUtils.getServerValue(url));
	
	}
	public static void navigateUrl(String url)
	{
		getDriver().get(PropertyUtils.getObjectValue(url));
	}
	public static void maximize()
	{
	getDriver().manage().window().maximize();
	}
	
	/*
	 * public static void clickByXPath(String ele) { WebDriverWait wait = new
	 * WebDriverWait(getDriver(), 10);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele))).click(); }
	 */
	
	public static void clickByXpath(String ele) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(),10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyUtils.getObjectValue(ele)))).click();
	}
	
	public static void clickById(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(PropertyUtils.getObjectValue(ele)))).click();
	} 
	
	public static void clickByName(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name(PropertyUtils.getObjectValue(ele)))).click();
	}
	
	public static void clickByCssSelector(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertyUtils.getObjectValue(ele)))).click();
	}
	
	public static void clickByLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(PropertyUtils.getObjectValue(ele)))).click();
	}
	
	public static void clickByPartialLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(PropertyUtils.getObjectValue(ele)))).click();
	}
	
	public static void clickByClassName(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className(PropertyUtils.getObjectValue(ele)))).click();
	}
	
	public static WebElement getElement(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void sendKeysByXPath(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyUtils.getObjectValue(ele))));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void sendKeysById(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.id(PropertyUtils.getObjectValue(ele))));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void sendKeysByName(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.name(PropertyUtils.getObjectValue(ele))));
		until.clear();
		until.sendKeys(data);
	}
	
	public static void sendKeysByClassName(String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.className(PropertyUtils.getObjectValue(ele))));
		until.clear();
		until.sendKeys(data);
	}
	
	public static boolean isDisplayedByXPath(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try 
		{
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyUtils.getObjectValue(ele)))).isDisplayed();
		} catch (Exception e) 
		{}
		return flag;
	}
	
	
	public static boolean isDisplayedByName(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try 
		{
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.name(PropertyUtils.getObjectValue(ele)))).isDisplayed();
		} catch (Exception e) 
		{}
		return flag;
	}
	
	
	public static boolean isDisplayedByLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try 
		{
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(PropertyUtils.getObjectValue(ele)))).isDisplayed();
		} catch (Exception e) 
		{}
		return flag;
	}
	
	public static boolean isDisplayedById(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try 
		{
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.id(PropertyUtils.getObjectValue(ele)))).isDisplayed();
		} catch (Exception e) 
		{}
		return flag;
	}
	
	public static boolean isDisplayedByCssSelector(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try 
		{
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertyUtils.getObjectValue(ele)))).isDisplayed();
		} catch (Exception e) 
		{}
		return flag;
	}
	
	public static boolean isDisplayedByPartialLinkText(String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		boolean flag = false;
		try 
		{
			flag = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(PropertyUtils.getObjectValue(ele)))).isDisplayed();
		} catch (Exception e) 
		{}
		return flag;
	}
	
	public static void click(Type type, String ele)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		if (type.equals(Type.XPATH)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyUtils.getObjectValue(ele)))).click();
		}if (type.equals(Type.ID)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(PropertyUtils.getObjectValue(ele)))).click();
		}if (type.equals(Type.NAME)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(PropertyUtils.getObjectValue(ele)))).click();
		}if (type.equals(Type.LINKTEXT)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(PropertyUtils.getObjectValue(ele)))).click();
		}if (type.equals(Type.PARTIALLINKTEXT)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(PropertyUtils.getObjectValue(ele)))).click();
		}if (type.equals(Type.CSSSELECTOR)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertyUtils.getObjectValue(ele)))).click();
		}if (type.equals(Type.CLASSNAME)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.className(PropertyUtils.getObjectValue(ele)))).click();
		}
	}
	
	public static void sendKeys(Type type, String ele, String data)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		if (type.equals(Type.XPATH)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}if (type.equals(Type.ID)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.id(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}if (type.equals(Type.NAME)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.name(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}if (type.equals(Type.LINKTEXT)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}if (type.equals(Type.PARTIALLINKTEXT)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}if (type.equals(Type.CSSSELECTOR)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}if (type.equals(Type.CLASSNAME)) {
			WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.className(PropertyUtils.getObjectValue(ele))));
			until.clear();
			until.sendKeys(data);
		}
	}
	
	
	
}

