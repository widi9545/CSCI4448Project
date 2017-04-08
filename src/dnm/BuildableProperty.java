package dnm;

public class BuildableProperty extends Property {
	private boolean isMonopoly;
	private int buildingRank;
	private int buildCost;
	private Color color;
	
	public BuildableProperty(TileType _tileType, String _name, int _cost, int _buildCost,
			int _mortgageValue, Color _color, int _numInGroup, int _tier0, int _tier1, int _tier2,
			int _tier3, int _tier4, int _tier5) {
		super(_tileType, _name, _cost, _mortgageValue, _numInGroup);
		this.setBuildCost(_buildCost);
		this.setColor(_color);
		this.rentTiers = new int[6];
		super.setRentTier(0, _tier0);
		super.setRentTier(1, _tier1);
		super.setRentTier(2, _tier2);
		super.setRentTier(3, _tier3);
		super.setRentTier(4, _tier4);
		super.setRentTier(5, _tier5);
		this.setIsMonopoly(false);
		this.setBuildingRank(0);
	}

	@Override
	protected int calculateRent() {
		return this.getRentTier(buildingRank);
	}
	
	@Override
	protected int calculateValue() {
		return getCost() + buildingRank * buildCost;
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
	
	private void setBuildCost(int _buildCost) {
		this.buildCost = _buildCost;
	}
	
	public int getBuildCost() {
		return this.buildCost;
	}
	
	private void setColor(Color _color) {
		this.color = _color;
	}
	
	public Color getColor() {
		return this.color;
	}
}