package ltg.workshop.meza.actions;

import ltg.workshop.meza.DirectMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendDirectMessageAction implements UIAction {
	private final DirectMessage message;
	private final String recipientUsername;
	private WebDriver driver;

	public SendDirectMessageAction(DirectMessage message, String recipientUsername) {
		this.message = message;
		this.recipientUsername = recipientUsername;
	}

	@Override
	public void useDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void execute() {
		driver.get("http://www.twitter.com/messages");

		By locator = By.cssSelector(".dm-new-button");

		Wait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.elementToBeClickable(locator));

		driver.findElement(locator).click();

		WebElement usernameField = driver.findElement(By.cssSelector(".dm-to-input"));
		WebElement messageBody = driver.findElement(By.id("tweet-box-dm-new-conversation"));

		usernameField.sendKeys(recipientUsername);
		messageBody.sendKeys(message.getMessage());

		WebElement button = driver.findElement(
			By.cssSelector("form.dm-tweetbox:nth-child(2) > div:nth-child(2) > button:nth-child(3)"));
		button.click();

	}

	@Override
	public <T> T copyOf() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
