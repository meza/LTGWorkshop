package ltg.workshop.meza;

import cucumber.api.java.en.Given;
import hu.meza.aao.ActorManager;
import ltg.workshop.meza.actions.FollowAction;
import ltg.workshop.meza.actions.UnFollowAction;

public class FollowSteps {

	private ActorManager actorManager;

	public FollowSteps(ActorManager actorManager) {
		this.actorManager = actorManager;
	}

	@Given("^(.*) is a follower of (.*)$")
	public void isFollowerOf(String actor1Label, String actor2Label) {

		User user1 = (User) actorManager.getActor(actor1Label);
		User user2 = (User) actorManager.getActor(actor2Label);

		FollowAction action = new FollowAction(user2.getUsername());

		user1.execute(action);

	}

	@Given("^(.*) is NOT following (.*)$")
	public void isNotFollowing(String actor1Label, String actor2Label) {
		User user1 = (User) actorManager.getActor(actor1Label);
		User user2 = (User) actorManager.getActor(actor2Label);

		UnFollowAction action = new UnFollowAction(user2.getUsername());

		user1.execute(action);
	}
}
