package ltg.workshop.meza;

public class DirectMessage {

	private String sender;
	private String message;

	public DirectMessage(String sender, String message) {
		this.sender = sender;
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public String getMessage() {
		return message;
	}
}
