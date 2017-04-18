package testdnm;

import dnm.*;

public class testTileManager {
	public static void main(String[] args) {
		TileManager tm = new TileManager("originalset");
		int setSize = tm.getTileCount();
		Tile currTile = tm.getGoTile();
		for (int i = 0; i < setSize; i++) {
			System.out.print(currTile.getName() + "\t\t" + currTile.getTileType());
			if (currTile instanceof Property) {
				System.out.println("\t" + ((Property) currTile).getCost() + "\t" + ((Property) currTile).getMortgageValue()
				+ "\t" + ((Property) currTile).getRentTier(0) + "\t" + ((Property) currTile).getRentTier(1)
				+ "\t" + ((Property) currTile).getRentTier(2));
			} else {
				System.out.println();
			}
			currTile = currTile.nextTile;
		}
	}
}
