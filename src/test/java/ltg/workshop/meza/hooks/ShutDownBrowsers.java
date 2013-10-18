package ltg.workshop.meza.hooks;

import cucumber.api.java.After;
import hu.meza.aao.Actor;
import hu.meza.aao.ActorManager;
import ltg.workshop.meza.User;

public class ShutDownBrowsers {

	private ActorManager actorManager;

	public ShutDownBrowsers(ActorManager actorManager) {
		this.actorManager = actorManager;
	}

	@After
	public void shutItAll() {
		for (Actor actor : actorManager) {
			((User) actor).killBrowser();
		}
	}

}
