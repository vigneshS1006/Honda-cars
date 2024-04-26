package testClass;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObject.HondaPage;
import testBase.BaseClass;
import utilities.Median;

public class TC_001_HondaCars extends BaseClass{
	
	
	
	@Test
	public void checkPrice() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		HondaPage hp=new HondaPage(driver);
		hp.hoverShop();
		hp.clickPrice();
		hp.selectCar();
		
		hp.setState("tamil nadu");
		hp.setCity("coimbatore");
		
		hp.cvtClick();
		hp.zxClick();
		
		List<WebElement> color=hp.getColors();	
		
		System.out.println(color.size());
		
		List<Double> priceList=new ArrayList<>();
		List<String> colors=new ArrayList<>();
		//Map<Double,String> map=new LinkedHashMap<>();		
		for(int i=0;i<color.size();i++) {			
			WebElement colorNameEle=driver.findElement(By.xpath("(//*[@id='__next']/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div/input)["+(i+1)+"]"));
			String colorName=colorNameEle.getAttribute("value");
			colors.add(colorName);
			
			WebElement label=driver.findElement(By.xpath("//*[@id='__next']/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/div["+(i+1)+"]/label"));
			
			//js.executeScript("arguments[0].scrollIntoView();", label);
			js.executeScript("arguments[0].click();", label);
			
			WebElement colorPrice=driver.findElement(By.xpath("//*[@id='__next']/div[2]/div[2]/div[2]/div[2]/div/div/div/div[1]/div/div/button"));
			Thread.sleep(2000);
			String rupees=colorPrice.getText().replace("₹","").replace(" ","").replaceAll("[\\*]", "").trim();
			System.out.println(rupees);
			double d=Double.parseDouble(rupees);
			priceList.add(d);						
			//map.put(d, colorName);
		}
		
		double median=Median.findMedian(priceList);		
		System.out.println("Median: "+median);
		
		/*System.out.println("Map: "+map);		
		for(Map.Entry<Double, String> e:map.entrySet()) {
			
			if(e.getKey()==median) {
				System.out.println(e.getValue());
			}*/
		
		for(int i=0;i<priceList.size();i++) {
			
			if(priceList.get(i) == median) {				
					
					System.out.println(colors.get(i));
				
			}
		}
		
		}		
	}


