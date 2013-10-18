package ltg.workshop.meza.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnFollowAction implements UIAction {
	private final String username;
	private WebDriver driver;

	public UnFollowAction(String username) {
		this.username = username;
	}

	@Override
	public void useDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void execute() {
		final String url = String.format("http://www.twitter.com/%s", username);
		driver.get(url);
		try {
			WebElement followButton = driver.findElement(By.cssSelector(".following .js-follow-btn"));
			followButton.click();
		} catch (NoSuchElementException e) {
			return;
		}

	}

	@Override
	public UnFollowAction copyOf() {
		return new UnFollowAction(username);
	}
}
