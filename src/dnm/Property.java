package dnm;

public abstract class Property extends Tile {
	private Player owner;
	private int cost;
	private int mortgageValue;
	private boolean isMortgaged;
	private int[] rentTiers;
	
	Property(TileType _tileType, String _name) {
		super(_tileType, _name);
		this.isMortgaged = false;
		this.owner = null;
		// TODO Load property information from database
	}

	public void setOwner(Player player) {
		this.owner = player;
	}
	
	public Player getOwner() {
		return this.owner;
	}
	
	public void setCost(int _cost) {
		this.cost = _cost;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public void setMortgageValue(int _mortgageValue) {
		this.mortgageValue = _mortgageValue;
	}
	
	public int getMortgageValue() {
		return this.mortgageValue;
	}
	
	public void setMortgaged(Boolean _mortgaged) {
		this.isMortgaged = _mortgaged;
	}
	
	public boolean getMortgaged() {
		return this.isMortgaged;
	}
	
	public void setRentTier(int tier, int rent) {
		this.rentTiers[tier] = rent;
	}
	
	public int getRentTier(int tier) {
		return this.rentTiers[tier];
	}
	
	protected abstract int calculateRent(int tier);
}
