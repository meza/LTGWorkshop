package ltg.workshop.meza;

import ltg.workshop.meza.actions.UIAction;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAction implements UIAction {

	private WebDriver driver;
	private String username;
	private String password;

	public LoginAction(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	public void execute() {
		driver.get("http://www.twitter.com");
		try {
			WebElement usernameField = driver.findElement(By.id("signin-email"));
			WebElement passwordField = driver.findElement(By.id("signin-password"));
			WebElement button = driver.findElement(By.cssSelector("button.submit:nth-child(1)"));

			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			button.click();
			return;
		} catch (NoSuchElementException e) {
			return;
		}

	}

	@Override
	public <T> T copyOf() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void useDriver(WebDriver driver) {
		this.driver = driver;
	}
}
