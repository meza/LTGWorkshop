package ltg.workshop.meza;

import hu.meza.aao.Action;
import hu.meza.aao.Actor;
import ltg.workshop.meza.actions.UIAction;
import org.openqa.selenium.WebDriver;

public class User extends Actor {

	private final WebDriver driver;
	private String username;
	private String password;

	public User(String username, String password, WebDriver driver) {
		this.username = username;
		this.password = password;
		this.driver = driver;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public void execute(Action action) {
		if (action instanceof UIAction) {
			((UIAction) action).useDriver(driver);
		}
		super.execute(action);
	}

	public void killBrowser() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
