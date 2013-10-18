package ltg.workshop.meza.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FollowAction implements UIAction {
	private final String username;
	private WebDriver driver;

	public FollowAction(String username) {
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
			WebElement followButton = driver.findElement(By.cssSelector(".not-following .js-follow-btn"));
			followButton.click();
		} catch (NoSuchElementException e) {
			return;
		}
	}

	@Override
	public <T> T copyOf() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
