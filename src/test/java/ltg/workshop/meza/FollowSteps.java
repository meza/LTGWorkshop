package ltg.workshop.meza;

import cucumber.api.java.en.Given;
import hu.meza.aao.ActorManager;import ltg.workshop.meza.actions.FollowAction;

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
}
