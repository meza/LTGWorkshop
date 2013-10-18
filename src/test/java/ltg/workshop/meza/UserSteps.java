package ltg.workshop.meza;

import cucumber.api.java.en.Given;
import hu.meza.aao.Action;
import hu.meza.aao.Actor;
import hu.meza.aao.ActorManager;
import hu.meza.aao.DefaultScenarioContext;
import hu.meza.aao.ScenarioContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class UserSteps {

	private Configuration config;
	private ActorManager actorManager;
	private ScenarioContext context;

	public UserSteps(Configuration config, ActorManager actorManager, DefaultScenarioContext context) {
		this.config = config;
		this.actorManager = actorManager;
		this.context = context;
		this.actorManager.addContext(this.context);

	}

	@Given("^(.*) are on twitter$")
	public void areOnTwitter(List<String> actors) throws InterruptedException {

		List<Thread> threads = new ArrayList<Thread>();

		for (String actor : actors) {

			String username = config.getUsernameFor(actor);
			String password = config.getPasswordFor(actor);

			WebDriver driver = new FirefoxDriver();
			User twitterUser = new User(username, password, driver);

			actorManager.addActor(actor, twitterUser);

			LoginAction login = new LoginAction(username, password);

			// Opening browsers in separate threads to speed up execution
			final Thread thread = new Thread(new UserLoginThread(twitterUser, login));
			threads.add(thread);
			thread.start();
		}

		for (Thread thread : threads) {
			if (thread.isAlive()) {
				thread.join();
			}
		}

	}

	class UserLoginThread implements Runnable {

		private final Actor actor;
		private final Action action;

		UserLoginThread(Actor actor, Action action) {
			this.actor = actor;
			this.action = action;
		}

		@Override
		public void run() {
			actor.execute(action);
		}
	}

}
