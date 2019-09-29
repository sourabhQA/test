package com.qa.pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.vmo.test.Testbase;

public class app_vmopage extends Testbase {
	
	
	

	@FindBy(xpath = "//div[@ng-show=\"hasHeatmapImgFailed\"]")
	WebElement overlayfirst;

	@FindBy(xpath = "//div[@class='screenshot-thumb__click-msg show-on-hover']")
	WebElement viewHeatmap;

	@FindBy(xpath = "//iframe[@id='heatmap-iframe']")
	WebElement HeatmapFrame;

	@FindBy(xpath = "//iframe[@id='element-list-iframe']")
	WebElement ElementlistFrame;

	@FindBy(xpath = "//div[@class=\"option-tab\" and @data-qa=\"zarujegatu\"]")
	WebElement Elementlistbtn;

	@FindBy(xpath = "//table[@id='element-list--content']//tr[1]//td")
	WebElement firstitem;

	@FindBy(xpath = "//h1[@elem_clicks]")
	WebElement check;
	
   @FindBy(xpath="//table/tr[3]/td[1]")
   WebElement elementclick;	
	
	
	@FindBy(xpath="//div[@class='_vwo_element_list_shim']")
	WebElement overlayz;
	
	@FindBy(xpath="//h1[@class='Fz(50px)--lg Fz($font-size-40)--sm Fz($font-size-32) Lts(1px)--md Mt(0) Mb(20px) Lh($line-height-headings)']")
	WebElement find;
	
	
	
	//Initialization of pagefactory
	public app_vmopage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Driver,10), this);
	}

	public void movetoview_Heatmapscreen() throws Exception {

    //Getting current open window
		String currentwindow = Driver.getWindowHandle();
		System.out.println("current" + currentwindow);
		
		Actions action = new Actions(Driver);
	//Moving the cursor on overlay and adding border to check the visibility
		action.moveToElement(overlayfirst).build().perform();
//		((JavascriptExecutor)Driver).executeScript("arguments[0].style.border='10px solid red'", overlayfirst);
	
		
		
	
	

		
	
		viewHeatmap.click();

		Set<String> allwindows = Driver.getWindowHandles();
		for (String openwindows : allwindows) {

			if (!currentwindow.equals(openwindows)) {
				Driver.switchTo().window(openwindows);
				System.out.println("switched window" + openwindows);
				System.out.println(Driver.getCurrentUrl());
				
				System.out.println(Driver.getCurrentUrl());
				//verify the current url with actual url
		        Assert.assertEquals("https://vwo.com/", Driver.getCurrentUrl()); 

			}

		

		}
		
       

   String colour = 	overlayz.getCssValue("display");
  
	
		System.out.println(colour);

		action.moveToElement(HeatmapFrame);
		Driver.switchTo().frame("heatmap-iframe");
		String temp = HeatmapFrame.getAttribute("id");
		System.out.println(temp);
		
		action.moveToElement(Elementlistbtn);
		if (!Elementlistbtn.isSelected()) {

			Elementlistbtn.click();

		}
		Driver.switchTo().parentFrame();
	
		action.moveToElement(ElementlistFrame);
		
		Driver.switchTo().frame(ElementlistFrame);

		
	
	
		
		elementclick.click();
		
		
	
		Driver.switchTo().defaultContent();
		((JavascriptExecutor)Driver).executeScript("arguments[0].style.display='none'", overlayz);
	  Assert.assertTrue(find.isDisplayed());
	  
	 
		


		
	
		
		

		
		
		

	}

}
