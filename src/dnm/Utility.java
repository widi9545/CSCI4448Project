package dnm;

public class Utility extends Property {
	private int numOfOwnedUtil;
	
	public Utility(TileType _tileType, String _name, int _cost,
			int _mortgageValue, int _numInGroup, int _tier0,
			int _tier1) {
		super(_tileType, _name, _cost, _mortgageValue, _numInGroup);
		this.rentTiers = new int[3];
		super.setRentTier(0, 0);
		super.setRentTier(1, _tier0);
		super.setRentTier(2, _tier1);
		this.setNumOfOwnedUtil(0);
	}

	@Override
	protected int calculateRent() {
		return super.getRentTier(numOfOwnedUtil);
	}
	
	@Override
	protected int calculateValue() {
		return getCost();
	}

	public void setNumOfOwnedUtil(int n) {
		this.numOfOwnedUtil = n;
	}
	
	public int getNumOfOwnedUtil() {
		return this.numOfOwnedUtil;
	}
}
