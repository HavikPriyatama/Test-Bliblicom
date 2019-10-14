package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");//android or IOS
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9"); //android version
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Jave"); //device name
		caps.setCapability(MobileCapabilityType.UDID, "42a699a8"); //from adb devices
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);//time out session
//		caps.setCapability("appPackage", "com.instagram.android");
//		caps.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
		caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\Inspiro\\appium-test\\AppiumDemoProject\\src\\test\\resources\\apps\\Blibli.com.apk");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, caps);
		wait  = new WebDriverWait(driver, 10);
	}
	
	@AfterTest
	public void tearDown() {
		
	}
}
