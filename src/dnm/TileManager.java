package dnm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// May prove to be extraneous and can be consolidated
// into System.
public class TileManager {
	private Tile goTile;
	private Tile visitingTile;
	private String tileSet;
	private int tileCount;
	
	public TileManager(String _tileSet) {
		this.tileSet = _tileSet;
		accessMySQLDB();
	}
	
	public Tile getGoTile() {
		return this.goTile;
	}
	
	private void setVisitingTile(Tile _visiting) {
		this.visitingTile = _visiting;
	}
	
	public Tile getVisitingTile() {
		return this.visitingTile;
	}
	
	public int getTileCount() {
		return this.tileCount;
	}
	
	private void accessMySQLDB() {
		TileType currTileType;
		Tile prev;
		Tile tmp;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/monopolytiles", "root", "");
			Statement statement = conn.createStatement();
			String query = "Select * FROM " + tileSet;
			ResultSet rs = statement.executeQuery(query);
			rs.next();
			prev = goTile = new Tile(TileType.valueOf(rs.getString("TileType")), rs.getString("name"));
			tileCount = 1;
			while (rs.next()) {
				currTileType = TileType.valueOf(rs.getString("TileType"));
				switch (currTileType) {
				case PROPERTY:
					tmp = new BuildableProperty(currTileType, rs.getString("name"), rs.getInt("cost"),
							rs.getInt("buildcost"), rs.getInt("mortgage"), Color.valueOf(rs.getString("color")),
							rs.getInt("groupsize"), rs.getInt("tier0"), rs.getInt("tier1"), rs.getInt("tier2"),
							rs.getInt("tier3"), rs.getInt("tier4"), rs.getInt("tier5"));
					break;
				case RAILROAD:
					tmp = new Railroad(currTileType, rs.getString("name"), rs.getInt("cost"), rs.getInt("mortgage"),
							rs.getInt("groupsize"), rs.getInt("tier0"), rs.getInt("tier1"), rs.getInt("tier2"),
							rs.getInt("tier3"));
					break;
				case UTILITY:
					tmp = new Utility(currTileType, rs.getString("name"), rs.getInt("cost"), rs.getInt("mortgage"),
							rs.getInt("groupsize"), rs.getInt("tier0"), rs.getInt("tier1"));
					break;
				default:
					tmp = new Tile(currTileType, rs.getString("name"));
					if (currTileType == TileType.VISITING) this.setVisitingTile(tmp);
					break;
				}
				prev.nextTile = tmp;
				tmp.prevTile = prev;
				prev = tmp;
				tileCount++;
			}
			prev.nextTile = goTile;
			goTile.prevTile = prev;
			rs.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
