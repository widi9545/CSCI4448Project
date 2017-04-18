package dnm;

public class MoveCard extends Card {
	private String targetTileName;
	private TileType targetTileType;

	public MoveCard(String _description, int _amount,
			String _targetTileName, TileType _targetTileType) {
		super(_description, _amount);
		this.targetTileName = _targetTileName;
		this.targetTileType = _targetTileType;
	}

	@Override
	public Card execute(Player _player) {
		if (targetTileType == TileType.JAIL) {
			while (_player.getLocation().getTileType() != TileType.JAIL) {
				// A work-around to collecting GO money when sent 'directly' to jail.
				_player.incrementPlayerLocation();
			}
		} else if (targetTileName == null) {
			while (_player.getLocation().getTileType() != targetTileType) {
				_player.move(1);
			}
		} else {
			while (_player.getLocation().getName() != targetTileName) {
				_player.move(1);
			}
		}
		return this;
	}
}
