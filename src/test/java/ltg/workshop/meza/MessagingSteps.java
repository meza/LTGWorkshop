package ltg.workshop.meza;

import cucumber.api.java.en.When;
import hu.meza.aao.ActorManager;
import ltg.workshop.meza.actions.SendDirectMessageAction;

public class MessagingSteps {

	private ActorManager actorManager;

	public MessagingSteps(ActorManager actorManager) {
		this.actorManager = actorManager;
	}

	@When("^(.*) sends a DM to (.*)$")
	public void sendsDirectMessageTo(String actor1Label, String actor2Label) {
		User user1 = (User) actorManager.getActor(actor1Label);
		User user2 = (User) actorManager.getActor(actor2Label);

		final String randomMessage = getRandomMessage();
		DirectMessage message = new DirectMessage(user1.getUsername(), randomMessage);

		SendDirectMessageAction action = new SendDirectMessageAction(message, user2.getUsername());
		user1.execute(action);

	}

	private String getRandomMessage() {
		String prefix = "Random message";
		String time = String.valueOf(System.currentTimeMillis());

		String message = String.format("%s %s", prefix, time);
		return message;

	}
}
