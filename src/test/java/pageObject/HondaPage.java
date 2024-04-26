package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HondaPage extends BasePage{
	
	public HondaPage(WebDriver driver) {
		super(driver);
	}
	
	//locating elements
	
	@FindBy(xpath="//*[@id='__next']/div[11]/div/div/div[1]/button")
	WebElement cookies;
	
	@FindBy(xpath="//*[@id='main-nav']/li[3]/a")
	WebElement shop;
	
	@FindBy(xpath="//*[@id='main-nav']/li[3]/div/ul/li[2]/a")
	WebElement checkPrice;
	
	@FindBy(xpath="//span[normalize-space()='All-New Elevate']")
	WebElement elevate;
	
	@FindBy(xpath="//*[@id='state']/div/div[1]/div[2]/input")
	WebElement stateInput;
	
	@FindBy(xpath="//*[@id='city']/div/div[1]/div[2]/input")
	WebElement cityInput;
	
	@FindBy(id="trans-1")
	WebElement cvt;
	
	@FindBy(id="grade-2")
	WebElement zx;
	
	@FindBy(xpath="//*[@id='__next']/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div")
	List<WebElement> colors;
	
	@FindBy(xpath="//*[@id=\"__next\"]/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/button ")
	WebElement price;
	
	@FindBy(xpath="//*[@id='check-location']/div/div/div/div[3]/div[1]")
	WebElement location;
	
	//action methods
	
	WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act=new Actions(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public void hoverShop() throws InterruptedException {
		cookies.click();
		myWait.until(ExpectedConditions.visibilityOf(shop));
		act.moveToElement(shop).build().perform();
		Thread.sleep(3000);
	}
	
	public void clickPrice() {
		
		try {
		act.moveToElement(checkPrice).perform();
		myWait.until(ExpectedConditions.elementToBeClickable(checkPrice));
		js.executeScript("arguments[0].click();", checkPrice);
		}catch(Exception e) {}
	}
	
	public void selectCar() throws InterruptedException {
		//driver.navigate().refresh();
		Thread.sleep(3000);
		myWait.until(ExpectedConditions.visibilityOf(elevate));
		js.executeScript("arguments[0].scrollIntoView();", elevate);
		js.executeScript("arguments[0].click();", elevate);
	}
	

	
	public void setState(String state) throws InterruptedException {
		
		js.executeScript("arguments[0].scrollIntoView();", location);
		js.executeScript("arguments[0].scrollIntoView();", stateInput);
		stateInput.sendKeys(state);
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void setCity(String city) throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", cityInput);
		cityInput.sendKeys(city);
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	public void cvtClick() {
		js.executeScript("arguments[0].scrollIntoView();", cvt);
		js.executeScript("arguments[0].click();", cvt);
	}
	
	public void zxClick() {
		try {
		js.executeScript("arguments[0].scrollIntoView();", zx);
		js.executeScript("arguments[0].click();", zx);
		}catch(Exception e) {}
	}
	
	public List<WebElement> getColors(){
		return colors;
	}
	
	public String getPrice() {
		return price.getText();
	}
	

}
