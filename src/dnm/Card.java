package dnm;

public abstract class Card {
	private String description;
	protected int amount;
	
	protected Card(String _description, int _amount) {
		setDescription(_description);
		setAmount(_amount);
	}
	
	private void setDescription(String _description) {
		this.description = _description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	private void setAmount(int _amount) {
		this.amount = _amount;
	}
	
	public abstract Card execute(Player _player);
}
