package dnm;

public class Utility extends Property {
	private int numOfOwnedUtil;
	
	
	public Utility(TileType _tileType, String _name) {
		super(_tileType, _name);
	}

	@Override
	protected int calculateRent(int tier) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setNumOfOwnedUtil(int n) {
		this.numOfOwnedUtil = n;
	}
	
	public int getNumOfOwnedUtil() {
		return this.numOfOwnedUtil;
	}
}
