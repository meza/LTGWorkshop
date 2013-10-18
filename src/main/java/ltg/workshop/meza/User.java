package ltg.workshop.meza;

import hu.meza.aao.Actor;
import org.openqa.selenium.WebDriver;

public class User extends Actor {

	private String username;
	private String password;
	private final WebDriver driver;

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
}
