package com.vmo.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.app_vmopage;
import com.vmo.test.Testbase;

public class app_Scenariotest extends Testbase{
	
	
	app_vmopage run;
	
	
	public app_Scenariotest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		 run = new app_vmopage();
	}
	
	
	
	@AfterMethod
	public void teardown() {
		Driver.quit();
	}
	
	@Test
	public void run() throws Exception {
		run.movetoview_Heatmapscreen();
		
	}
	

}
