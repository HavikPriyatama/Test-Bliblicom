package tests;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SignInTest extends BaseClass {

	
	
	@Test
	public void testOne() {
		System.out.println("Sample....");
		swipe();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("blibli.mobile.commerce:id/bt_get_started")));
		driver.findElement(By.id("blibli.mobile.commerce:id/bt_get_started")).click();;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("blibli.mobile.commerce:id/tv_continue_button")));
		driver.findElement(By.id("blibli.mobile.commerce:id/tv_continue_button")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("blibli.mobile.commerce:id/bt_login")));
		driver.findElement(By.id("blibli.mobile.commerce:id/bt_login")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("blibli.mobile.commerce:id/tv_registration")));
		MobileElement el = (MobileElement) driver.findElement(By.id("blibli.mobile.commerce:id/tv_registration"));
		Point p = el.getCenter();
		
		TouchAction act = new TouchAction(driver);
		act.tap(PointOption.point(p.x+100, p.y)).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("blibli.mobile.commerce:id/bt_other_options")));
		driver.findElement(By.id("blibli.mobile.commerce:id/bt_other_options")).click();
		
		MobileElement el1 = (MobileElement) driver.findElementById("blibli.mobile.commerce:id/et_user_name");
		el1.sendKeys("Havik Priyatama");
		MobileElement el2 = (MobileElement) driver.findElementById("blibli.mobile.commerce:id/et_user_email_id");
		el2.sendKeys("priyatama.havik@gmail.com");
		MobileElement el3 = (MobileElement) driver.findElementById("blibli.mobile.commerce:id/et_user_phone_number");
		el3.sendKeys("085375544300");
		MobileElement el4 = (MobileElement) driver.findElementById("blibli.mobile.commerce:id/et_user_password");
		el4.sendKeys("password123");
		MobileElement el5 = (MobileElement) driver.findElementById("blibli.mobile.commerce:id/rb_men");
		el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("blibli.mobile.commerce:id/cb_term_and_condition");
		el6.click();
	}
	
	
	public void swipe() {
		Dimension size = driver.manage().window().getSize();
		int anchor = size.getHeight()/2;
		int startx = (int) (size.width * 0.90);
		int starty = size.height;
		int endy = size.height / 2;
		int endx = (int) (size.width * 0.10);
		
		TouchAction myAction = new TouchAction(driver)
				.press(PointOption.point(startx, anchor))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endx, anchor))
				.release()
				.perform();
	}
}
