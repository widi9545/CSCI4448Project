package dnm;

public class Tile {
	private String name;
	private TileType tileType;
	public Tile nextTile;
	public Tile prevTile;

	public Tile(TileType _tileType, String _name) {
		this.setTileType(_tileType);
		this.setName(_name);
	}
	
	public void setTileType(TileType _tileType) {
		this.tileType = _tileType;
	}
	
	public TileType getTileType() {
		return this.tileType;
	}
	
	public void setName(String _name) {
		this.name = _name;
	}
	
	public String getName() {
		return this.name;
	}
}