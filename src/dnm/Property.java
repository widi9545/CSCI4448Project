package dnm;

public abstract class Property extends Tile {
	private Player owner;
	private int cost;
	private int mortgageValue;
	private boolean isMortgaged;
	private int numInGroup;
	protected int[] rentTiers;
	
	Property(TileType _tileType, String _name, int _cost,
			int _mortgageValue, int _numInGroup) {
		super(_tileType, _name);
		this.setCost(_cost);
		this.setMortgageValue(_mortgageValue);
		this.setNumInGroup(_numInGroup);
		this.isMortgaged = false;
		this.owner = null;
	}

	public void setOwner(Player player) {
		this.owner = player;
	}
	
	public Player getOwner() {
		return this.owner;
	}
	
	private void setCost(int _cost) {
		this.cost = _cost;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	private void setMortgageValue(int _mortgageValue) {
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
	
	protected void setRentTier(int tier, int rent) {
		this.rentTiers[tier] = rent;
	}
	
	public int getRentTier(int tier) {
		return this.rentTiers[tier];
	}
	
	private void setNumInGroup(int _numInGroup) {
		this.numInGroup = _numInGroup;
	}
	
	public int getNumInGroup() {
		return this.numInGroup;
	}

	protected abstract int calculateRent();
	
	protected abstract int calculateValue();
}
