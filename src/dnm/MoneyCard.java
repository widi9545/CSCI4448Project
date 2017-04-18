package dnm;

public class MoneyCard extends Card {
	private boolean targetSelf;
	private Player[] playerList;

	public MoneyCard(String _description, int _amount,
			boolean _targetSelf, Player[] _playerList) {
		super(_description, _amount);
		setTargetSelf(_targetSelf);
		setPlayerList(_playerList);
	}

	private void setTargetSelf(boolean _targetSelf) {
		this.targetSelf = _targetSelf;
	}
	
	private void setPlayerList(Player[] _list) {
		this.playerList = _list;
	}
	
	@Override
	public Card execute(Player _player) {
		if (targetSelf) {
			_player.setCash(_player.getCash() + super.amount);
		} else {
			for (int i = 0; i < playerList.length; i++) {
				playerList[i].setCash(playerList[i].getCash() - super.amount);
				_player.setCash(_player.getCash() + super.amount);
			}
		}
		return this;
	}

}
