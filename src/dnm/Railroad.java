package dnm;

public class Railroad extends Property {
	private int numOfOwnedRR;

	public Railroad(TileType _tileType, String _name) {
		super(_tileType, _name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int calculateRent(int tier) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setNumOfOwnedRR(int n) {
		this.numOfOwnedRR = n;
	}
	
	public int getNumOfOwnedRR() {
		return this.numOfOwnedRR;
	}
}
