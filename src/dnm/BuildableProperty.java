package dnm;

public class BuildableProperty extends Property {
	private boolean isMonopoly;
	private int buildingRank;
	private Color color;
	private int numInGroup;
	
	public BuildableProperty(TileType _tileType, String _name) {
		super(_tileType, _name);
		this.setBuildingRank(0);
		//this.setNumInGroup(n);;
		// Edit this after finding a database.
	}

	@Override
	protected int calculateRent(int tier) {
		//super.getRentTier(tier)
		return 0;
	}
	
	public void setIsMonopoly(boolean monopoly) {
		this.isMonopoly = monopoly;
	}
	
	public boolean getIsMonopoly() {
		return this.isMonopoly;
	}
	
	public void setBuildingRank(int rank) {
		this.buildingRank = rank;
	}
	
	public int getBuildingRank() {
		return this.buildingRank;
	}
	
	private void setColor(Color _color) {
		this.color = _color;
	}
	
	public Color getColor() {
		return this.color;
	}

	private void setNumInGroup(int n) {
		this.numInGroup = n;
	}
	
	public int getNumInGroup() {
		return this.numInGroup;
	}
}
