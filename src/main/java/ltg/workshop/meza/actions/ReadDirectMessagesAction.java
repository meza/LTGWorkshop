package ltg.workshop.meza.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDirectMessagesAction implements UIAction {
	private WebDriver driver;

	private Map<String, String> messagesReceived = new HashMap<String, String>();

	@Override
	public void useDriver(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void execute() {
		driver.get("http://twitter.com/messages");

		List<WebElement> messages = driver.findElements(By.cssSelector(".dm-thread-content"));

		for (WebElement message : messages) {
			String username = message.findElement(By.cssSelector(".username")).getText();
			String messageReceived = message.findElement(By.cssSelector(".js-tweet-text")).getText();
			messagesReceived.put(username, messageReceived);
		}

	}

	public Map<String, String> messages() {
		return messagesReceived;
	}

	@Override
	public ReadDirectMessagesAction copyOf() {
		return new ReadDirectMessagesAction();
	}
}
