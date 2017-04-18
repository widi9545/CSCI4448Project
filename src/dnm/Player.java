package dnm;

public class Player {
	private final int MAX_PROPERTIES = 30;
	private String name;
	private int cash;
	private Tile location;
	private Property[] properties;
	private int propertyCount;
	private boolean isJailed;
	private int turnsJailed;
	private boolean isBankrupt;
	
	public Player(String _name) {
		this.setName(_name);
		for (int i = 0; i < MAX_PROPERTIES; i++) {
			this.properties[i] = null;
		}
		this.propertyCount = 0;
	}
	
	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCash(int _cash) {
		this.cash = _cash;
	}
	
	public int getCash() {
		return this.cash;
	}

	// Generally only used to enact CC or Chance cards and 'Go to Jail'.
	public void setLocation(Tile _tile) {
		this.location = _tile;
	}
	
	public Tile getLocation() {
		return this.location;
	}
	
	// Used for normal movement of player through dice roll.
	public void move(int diceRoll) {
		for (int i = 0; i < diceRoll; i++) {
			incrementPlayerLocation();
			if (location.getTileType() == TileType.GO) {
				setCash(this.cash + 200);
			}
		}
	}
	
	public void incrementPlayerLocation() {
		this.location = this.location.nextTile;
	}
	
	public Property[] getPropertyList() {
		return this.properties;
	}
	
	public int getPropertyCount() {
		return this.propertyCount;
	}
	
	public void addProperty(Property _property) {
		this.properties[this.propertyCount] = _property;
		this.propertyCount++;
	}
	
	public boolean removeProperty(Property _property) {
		for (int i = 0; i < this.propertyCount; i++) {
			if (this.properties[i] == _property) {
				this.properties[i] = null;
				pack(i);
				this.propertyCount--;
				return true;
			}
		}
		return false;
	}
	
	// Not sure if this should be here;
	// Packs properties array for easy lookups.
	private void pack(int removedItemIndex) {
		int last = removedItemIndex;
		while (this.properties[last+1] != null) {
			last += 1;
		}
		this.properties[removedItemIndex] = this.properties[last];
		this.properties[last] = null;
	}
	
	public void jail() {
		this.isJailed = true;
	}
	
	public void unjail() {
		this.isJailed = false;
		this.turnsJailed = 0;
	}
	
	public boolean getJailed() {
		return this.isJailed;
	}
	
	public void incTurnsJailed() {
		this.turnsJailed++;
	}
	
	public int getTurnsJailed() {
		return this.turnsJailed;
	}
	
	// Intentionally irreversible.
	public void setBankrupt() {
		this.isBankrupt = true;
	}
	
	public boolean getBankrupt() {
		return this.isBankrupt;
	}
	
	// Generally only used for '20% of worth or $200' tax tile.
	public int calculateWorth() {
		int worth = cash;
		for (int i = 0; i < propertyCount; i++) {
			worth += properties[i].calculateValue();
		}
		return worth;
	}
}
