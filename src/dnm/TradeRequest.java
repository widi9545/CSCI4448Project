package dnm;

public class TradeRequest {
	private boolean completed;
	private Player recipient;
	private Player sender;
	private int recipientCash;
	private int senderCash;
	private Property[] recipientProperties;
	private Property[] senderProperties;
	private int recipientPropertyCount;
	private int senderPropertyCount;
	
	public TradeRequest(Player _sender, Player _recipient) {
		this.setSender(_sender);
		this.setRecipient(_recipient);
		this.recipientCash = this.senderCash = 
				this.recipientPropertyCount = 
				this.senderPropertyCount = 0;
		this.recipientProperties = new Property[30];
		this.senderProperties = new Property[30];
		this.completed = false;
	}
	
	private void setRecipient(Player _recipient) {
		this.recipient = _recipient;
	}
	
	public Player getRecipient() {
		return this.recipient;
	}
	
	private void setSender(Player _sender) {
		this.sender = _sender;
	}
	
	public Player getSender() {
		return this.sender;
	}
	
	public void setRecipientCash(int _cash) {
		if (_cash < 0) {
			this.recipientCash = 0;
		} else {
			this.recipientCash = _cash;
		}
	}
	
	public int getRecipientCash() {
		return this.recipientCash;
	}
	
	public void setSenderCash(int _cash) {
		if (_cash < 0) {
			this.senderCash = 0;
		} else {
			this.senderCash = _cash;
		}
	}
	
	public int getSenderCash() {
		return this.senderCash;
	}
	
	public Property[] getRecipientProperties() {
		return this.recipientProperties;
	}
	
	public Property[] getSenderProperties() {
		return this.senderProperties;
	}
	
	public void addRecipientProperty(Property _property) {
		this.recipientProperties[recipientPropertyCount] = _property;
		this.recipientPropertyCount++;
	}
	
	public boolean removeRecipientProperty(Property _property) {
		for (int i = 0; i < this.recipientPropertyCount; i++) {
			if (this.recipientProperties[i] == _property) {
				this.recipientProperties[i] = null;
				pack(i, this.recipientProperties);
				return true;
			}
		}
		return false;
	}
	
	public void addSenderProperty(Property _property) {
		this.senderProperties[senderPropertyCount] = _property;
		this.senderPropertyCount++;
	}
	
	public boolean removeSenderProperty(Property _property) {
		for (int i = 0; i < this.senderPropertyCount; i++) {
			if (this.senderProperties[i] == _property) {
				this.senderProperties[i] = null;
				pack(i, this.senderProperties);
				return true;
			}
		}
		return false;
	}
	
	private void pack(int removedItemIndex, Property[] properties) {
		int last = removedItemIndex;
		while (properties[last+1] != null) {
			last += 1;
		}
		properties[removedItemIndex] = properties[last];
		properties[last] = null;
	}
	
	public boolean getCompleted() {
		return this.completed;
	}
	
	private boolean verifyRecipient(Player _recipient) {
		if (_recipient.getCash() < recipientCash) return false;
		for (int i = 0; i < recipientPropertyCount; i++) {
			if (recipientProperties[i].getOwner() != _recipient) return false;
		}
		return true;
	}
	
	private boolean verifySender(Player _sender) {
		if (_sender.getCash() < senderCash) return false;
		for (int i = 0; i < senderPropertyCount; i++) {
			if (senderProperties[i].getOwner() != _sender) return false;
		}
		return true;
	}
	
	public boolean attemptTrade() {
		if (verifyRecipient(recipient) && verifySender(sender)) {
			for (int m = 0; m < senderPropertyCount; m++) {
				senderProperties[m].setOwner(recipient);
				recipient.addProperty(senderProperties[m]);
				sender.removeProperty(senderProperties[m]);
			}
			for (int n = 0; n < recipientPropertyCount; n++) {
				recipientProperties[n].setOwner(sender);
				sender.addProperty(recipientProperties[n]);
				recipient.removeProperty(recipientProperties[n]);
			}
			recipient.setCash(recipient.getCash() + this.senderCash - this.recipientCash);
			sender.setCash(sender.getCash() + this.recipientCash - this.senderCash);
			this.completed = true;
			return true;
		} else return false;
	}
}
