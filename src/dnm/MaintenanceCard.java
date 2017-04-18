package dnm;

public class MaintenanceCard extends Card {

	public MaintenanceCard(String _description, int _amount) {
		super(_description, _amount);
	}

	@Override
	public Card execute(Player _player) {
		Property[] list = _player.getPropertyList();
		int price = 0;
		for (int i = 0; i < _player.getPropertyCount(); i++) {
			if (list[i] instanceof BuildableProperty) {
				BuildableProperty buildable = (BuildableProperty) list[i];
				int rank = buildable.getBuildingRank();
				if (rank < 5) {
					price += super.amount * rank;
				} else {
					price += super.amount + 75;
				}
			}
		}
		_player.setCash(_player.getCash() - price);
		return this;
	}
}
