package dnm;

public class Railroad extends Property {
	private int numOfOwnedRR;

	public Railroad(TileType _tileType, String _name, int _cost,
			int _mortgageValue, int _numInGroup, int _tier0,
			int _tier1, int _tier2, int _tier3) {
		super(_tileType, _name, _cost, _mortgageValue, _numInGroup);
		this.rentTiers = new int[5];
		super.setRentTier(0, 0);
		super.setRentTier(1, _tier0);
		super.setRentTier(2, _tier1);
		super.setRentTier(3, _tier2);
		super.setRentTier(4, _tier3);
		this.setNumOfOwnedRR(0);
	}

	@Override
	protected int calculateRent() {
		return super.getRentTier(numOfOwnedRR);
	}

	@Override
	protected int calculateValue() {
		return getCost();
	}
	
	public void setNumOfOwnedRR(int n) {
		this.numOfOwnedRR = n;
	}
	
	public int getNumOfOwnedRR() {
		return this.numOfOwnedRR;
	}
}
