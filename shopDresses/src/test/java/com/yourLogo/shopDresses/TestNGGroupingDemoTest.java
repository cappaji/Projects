package com.yourLogo.shopDresses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGGroupingDemoTest {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Executes once for the class before test");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Executes before each and every test");
	}
	
	@Test(groups = {"160cc", "Honda"} )
	public void dazzler() {
		System.out.println("This is Honda Dazzler");
	}
	
	@Test(groups = {"160cc", "TVS"} )
	public void apache() {
		System.out.println("This is TVS Apache");
	}
	
	@Test(groups = {"200cc", "Bajaj"} )
	public void pulsar200() {
		System.out.println("This is Bajaj Pulsar 200");
	}
	
	@Test(groups = {"200cc", "KTM"} )
	public void duke200() {
		System.out.println("This is KTM Duke 200");
	}
	
	@Test(groups = {"250cc", "KTM"} )
	public void duke250() {
		System.out.println("This is KTM Duke 250");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Executes after each and every test");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Executes once for the class after test");
	}

}
