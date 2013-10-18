package ltg.workshop.meza;

import cucumber.api.java.en.Given;
import hu.meza.aao.ActorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class UserSteps {

	private Configuration config;
	private ActorManager actorManager;

	public UserSteps(Configuration config, ActorManager actorManager) {
		this.config = config;
		this.actorManager = actorManager;
	}

	@Given("^(.*) are on twitter$")
	public void areOnTwitter(List<String> actors) {

		for (String actor : actors) {

			String username = config.getUsernameFor(actor);
			String password = config.getPasswordFor(actor);

			WebDriver driver = new FirefoxDriver();
			User twitterUser = new User(username, password, driver);

			actorManager.addActor(actor, twitterUser);

			LoginAction login = new LoginAction(username, password);

			twitterUser.execute(login);

		}

	}

}
