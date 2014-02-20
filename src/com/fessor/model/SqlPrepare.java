package com.fessor.model;

import java.util.LinkedList;
import java.util.List;

import com.fessor.constants.Constants;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SqlPrepare extends SQLiteOpenHelper{

	
	
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PlayersDataBase.db";
    
    //////////////////////////////////////////////////////
    	
    private static final String TABLE = "players_table";
    
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    
    private static final String KEY_OVERALL_COINS = "overall_coins";
    private static final String KEY_OVERALL_GOLD = "overall_gold";
    private static final String KEY_OVERALL_SILVER="overall_silver";
    private static final String KEY_OVERALL_BRONZE="overall_bronze";
    
    private static final String KEY_PLUS_COINS="plus_coins";
    private static final String KEY_PLUS_GOLD="plus_gold";
    private static final String KEY_PLUS_SILVER="plus_silver";
    private static final String KEY_PLUS_BRONZE="plus_bronze";
    
    private static final String KEY_MINUS_COINS="minus_coins";
    private static final String KEY_MINUS_GOLD="minus_gold";
    private static final String KEY_MINUS_SILVER="minus_silver";
    private static final String KEY_MINUS_BRONZE="minus_bronze";
    
    private static final String KEY_ICELAND_PLUS="iceland_plus";
    private static final String KEY_ICELAND_MINUS="iceland_minus";
    
    private static final String KEY_FAROE_PLUS="faroe_plus";
    private static final String KEY_FAROE_MINUS="faroe_minus";
    
    private static final String KEY_DENMARK_PLUS="denmark_plus";
    private static final String KEY_DENMARK_MINUS="denmark_minus";
    
    private static final String KEY_SWEDEN_PLUS="sweden_plus";
    private static final String KEY_SWEDEN_MINUS="sweden_minus";
    
    private static final String KEY_NORWAY_PLUS="norway_plus";
    private static final String KEY_NORWAY_MINUS="norway_minus";
    
    private static final String KEY_FINLAND_PLUS="finland_plus";
    private static final String KEY_FINLAND_MINUS="finland_minus";
    
    private static final String KEY_HERO="hero";
    private static final String KEY_COWBOY="cowboy";
    private static final String KEY_INDIAN="indian";
    private static final String KEY_PIRATE = "pirate";
    private static final String KEY_VIKING="viking";
    
    private static final String KEY_PLUS_PLAYED = "plus_played";
    private static final String KEY_MINUS_PLAYED ="minus_played";
    
    
    private static final String[] COLUMNS = {KEY_ID,KEY_NAME,KEY_OVERALL_COINS,KEY_OVERALL_GOLD,
    	KEY_OVERALL_GOLD,KEY_OVERALL_SILVER,KEY_OVERALL_BRONZE,KEY_PLUS_COINS,KEY_PLUS_GOLD,KEY_PLUS_SILVER,KEY_PLUS_BRONZE,
    	KEY_MINUS_COINS,KEY_MINUS_GOLD,KEY_MINUS_SILVER,KEY_MINUS_BRONZE,KEY_ICELAND_PLUS,KEY_ICELAND_MINUS,KEY_FAROE_PLUS,KEY_FAROE_MINUS
    	,KEY_DENMARK_PLUS,KEY_DENMARK_MINUS,KEY_SWEDEN_PLUS,KEY_SWEDEN_MINUS,KEY_NORWAY_PLUS,KEY_NORWAY_MINUS,KEY_FINLAND_PLUS,KEY_FINLAND_MINUS,
    	KEY_HERO,KEY_COWBOY,KEY_INDIAN,KEY_INDIAN,KEY_PIRATE,KEY_VIKING,KEY_VIKING,KEY_PLUS_PLAYED,KEY_MINUS_PLAYED};

	public SqlPrepare(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Here we create player table
		Log.v("addPlayer"," Here we create table");
		String CREATE_PLAYER_TABLE = 	"CREATE TABLE players_table ( " +
        								"id INTEGER PRIMARY KEY AUTOINCREMENT, " + 
        								"name TEXT, " + 
        								"overall_coins INTEGER, " + 
        								"overall_gold INTEGER, " + 
        								"overall_silver INTEGER, " + 
        								"overall_bronze INTEGER, " + 
        								"plus_coins INTEGER, " + 
        								"plus_gold INTEGER, " + 
        								"plus_silver INTEGER, " + 
        								"plus_bronze INTEGER, " + 
        								"minus_coins INTEGER, " + 
        								"minus_gold INTEGER, " + 
        								"minus_silver INTEGER, " + 
        								"minus_bronze INTEGER, " +
        								"iceland_plus INTEGER, " +
        								"iceland_minus INTEGER, " +
        								"faroe_plus INTEGER, " +
        								"faroe_minus INTEGER, " +
        								"norway_plus INTEGER, " +
        								"norway_minus INTEGER, " +
        								"denmark_plus INTEGER, " +
        								"denmark_minus INTEGER, " +
        								"sweden_plus INTEGER, " +
        								"sweden_minus INTEGER, " +
        								"finland_plus INTEGER, " +
        								"finland_minus INTEGER, " +
        								"hero INTEGER, " +
        								"cowboy INTEGER, " +
        								"indian INTEGER, " +
        								"pirate INTEGER, " +
        								"viking INTEGER, " +
        								"plus_played INTEGER, " +
        								"minus_played INTEGER )";
		
		db.execSQL(CREATE_PLAYER_TABLE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		// Here we drop older player table, if existed.
		db.execSQL("DROP TABLE IF EXISTS player");
		
		// Here we create new and fresh player table
		this.onCreate(db);
	}
	
	
	// Here be dragons.
	
	public void addPlayer(Player player){
		
		Log.v("addPlayer"," Here we start adding player object to players table");
		
		// Here we're getting a refference to a writtable db
		SQLiteDatabase db = this.getWritableDatabase();
		int size = Constants.players.size();
		// HEre we're creating ContentValues to ad key "column"/value
		ContentValues values = new ContentValues();
		values.put(KEY_ID, size);
		values.put(KEY_NAME, player.getName());
		
		values.put(KEY_OVERALL_COINS,player.getOverallCoins());
		values.put(KEY_OVERALL_GOLD, player.getOverallGold());
		values.put(KEY_OVERALL_SILVER, player.getOverallSilver());
		values.put(KEY_OVERALL_BRONZE, player.getOverallBronze());
		
		values.put(KEY_PLUS_COINS,player.getPlusCoins());
		values.put(KEY_PLUS_GOLD, player.getPlusGold());
		values.put(KEY_PLUS_SILVER, player.getPlusSilver());
		values.put(KEY_PLUS_BRONZE, player.getPlusBronze());
		
		values.put(KEY_MINUS_COINS,player.getMinusCoins());
		values.put(KEY_MINUS_GOLD, player.getMinusGold());
		values.put(KEY_MINUS_SILVER, player.getMinusSilver());
		values.put(KEY_MINUS_BRONZE, player.getMinusBronze());
		
		values.put(KEY_ICELAND_PLUS, player.getIcelandPlus());
		values.put(KEY_ICELAND_MINUS, player.getIcelandMinus());
		
		values.put(KEY_FAROE_PLUS, player.getFaroePlus());
		values.put(KEY_FAROE_MINUS, player.getFaroeMinus());
		
		values.put(KEY_NORWAY_PLUS, player.getNorwayPlus());
		values.put(KEY_NORWAY_MINUS, player.getNorwayMinus());
		
		values.put(KEY_DENMARK_PLUS, player.getDenmarkPlus());
		values.put(KEY_DENMARK_MINUS, player.getDenmarkMinus());
		
		values.put(KEY_SWEDEN_PLUS, player.getSwedenPlus());
		values.put(KEY_SWEDEN_MINUS, player.getSwedenMinus());
		
		values.put(KEY_FINLAND_PLUS, player.getFinlandPlus());
		values.put(KEY_FINLAND_MINUS, player.getFinlandMinus());
		
		values.put(KEY_HERO, player.getHero());
		values.put(KEY_COWBOY, player.getCowboy());
		values.put(KEY_INDIAN, player.getIndian());
		values.put(KEY_PIRATE, player.getPirate());
		values.put(KEY_VIKING, player.getViking());
		
		values.put(KEY_PLUS_PLAYED, player.getPlusPlayed());
		values.put(KEY_MINUS_PLAYED, player.getMinusPlayed());
		
		// Here we insert values to our database
		db.insert(TABLE, null, values);
		
		db.close();
	}
	
	public Player getPlayer(int id){
		
		// Here we're getting a refference to a writtable db
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.query(TABLE, COLUMNS," id = ?", new String[]{String.valueOf(id)},null,null,null,null);
		
		if (cursor!=null)
			cursor.moveToFirst();
		
		Player player = new Player(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), 
				Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), 
				Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)), 
				Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)), Integer.parseInt(cursor.getString(15)), 
				Integer.parseInt(cursor.getString(16)), Integer.parseInt(cursor.getString(17)), Integer.parseInt(cursor.getString(18)), Integer.parseInt(cursor.getString(19)), 
				Integer.parseInt(cursor.getString(20)), Integer.parseInt(cursor.getString(21)), Integer.parseInt(cursor.getString(22)), Integer.parseInt(cursor.getString(23)), 
				Integer.parseInt(cursor.getString(24)), Integer.parseInt(cursor.getString(25)), Integer.parseInt(cursor.getString(26)), Integer.parseInt(cursor.getString(27)), 
				Integer.parseInt(cursor.getString(28)), Integer.parseInt(cursor.getString(29)), Integer.parseInt(cursor.getString(30)), Integer.parseInt(cursor.getString(31)), 
				Integer.parseInt(cursor.getString(32)));
		
		return player;
	}
	
	public List<Player> getAllPlayers(){
		
		List<Player> players = new LinkedList<Player>();
		
		String query = "SELECT * FROM "+TABLE;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		if (cursor.moveToFirst()){
			do{
				Player player = new Player(Integer.parseInt(cursor.getString(0)), cursor.getString(1), Integer.parseInt(cursor.getString(2)), Integer.parseInt(cursor.getString(3)), 
						Integer.parseInt(cursor.getString(4)), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), 
						Integer.parseInt(cursor.getString(8)), Integer.parseInt(cursor.getString(9)), Integer.parseInt(cursor.getString(10)), Integer.parseInt(cursor.getString(11)), 
						Integer.parseInt(cursor.getString(12)), Integer.parseInt(cursor.getString(13)), Integer.parseInt(cursor.getString(14)), Integer.parseInt(cursor.getString(15)), 
						Integer.parseInt(cursor.getString(16)), Integer.parseInt(cursor.getString(17)), Integer.parseInt(cursor.getString(18)), Integer.parseInt(cursor.getString(19)), 
						Integer.parseInt(cursor.getString(20)), Integer.parseInt(cursor.getString(21)), Integer.parseInt(cursor.getString(22)), Integer.parseInt(cursor.getString(23)), 
						Integer.parseInt(cursor.getString(24)), Integer.parseInt(cursor.getString(25)), Integer.parseInt(cursor.getString(26)), Integer.parseInt(cursor.getString(27)), 
						Integer.parseInt(cursor.getString(28)), Integer.parseInt(cursor.getString(29)), Integer.parseInt(cursor.getString(30)), Integer.parseInt(cursor.getString(31)), 
						Integer.parseInt(cursor.getString(32)));
				players.add(player);
			}
			while(cursor.moveToNext());
		}
		
		return players;
	}
	
	public int updatePlayer(Player player){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(KEY_ID, player.getId());
		values.put(KEY_NAME, player.getName());
		
		values.put(KEY_OVERALL_COINS,player.getOverallCoins());
		values.put(KEY_OVERALL_GOLD, player.getOverallGold());
		values.put(KEY_OVERALL_SILVER, player.getOverallSilver());
		values.put(KEY_OVERALL_BRONZE, player.getOverallBronze());
		
		values.put(KEY_PLUS_COINS,player.getPlusCoins());
		values.put(KEY_PLUS_GOLD, player.getPlusGold());
		values.put(KEY_PLUS_SILVER, player.getPlusSilver());
		values.put(KEY_PLUS_BRONZE, player.getPlusBronze());
		
		values.put(KEY_MINUS_COINS,player.getMinusCoins());
		values.put(KEY_MINUS_GOLD, player.getMinusGold());
		values.put(KEY_MINUS_SILVER, player.getMinusSilver());
		values.put(KEY_MINUS_BRONZE, player.getMinusBronze());
		
		values.put(KEY_ICELAND_PLUS, player.getIcelandPlus());
		values.put(KEY_ICELAND_MINUS, player.getIcelandMinus());
		
		values.put(KEY_FAROE_PLUS, player.getFaroePlus());
		values.put(KEY_FAROE_MINUS, player.getFaroeMinus());
		
		values.put(KEY_NORWAY_PLUS, player.getNorwayPlus());
		values.put(KEY_NORWAY_MINUS, player.getNorwayMinus());
		
		values.put(KEY_DENMARK_PLUS, player.getDenmarkPlus());
		values.put(KEY_DENMARK_MINUS, player.getDenmarkMinus());
		
		values.put(KEY_SWEDEN_PLUS, player.getSwedenPlus());
		values.put(KEY_SWEDEN_MINUS, player.getSwedenMinus());
		
		values.put(KEY_FINLAND_PLUS, player.getFinlandPlus());
		values.put(KEY_FINLAND_MINUS, player.getFinlandMinus());
		
		values.put(KEY_HERO, player.getHero());
		values.put(KEY_COWBOY, player.getCowboy());
		values.put(KEY_INDIAN, player.getIndian());
		values.put(KEY_PIRATE, player.getPirate());
		values.put(KEY_VIKING, player.getViking());
		
		values.put(KEY_PLUS_PLAYED, player.getPlusPlayed());
		values.put(KEY_MINUS_PLAYED, player.getMinusPlayed());
		
		int i = db.update(TABLE, values, KEY_ID+" =?", new String[]{String.valueOf(player.getId()) });
		
		db.close();
		
		return i;
	}
	
	public void deletePlayer(Player player){
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		db.delete(TABLE, KEY_ID+" = ?", new String[]{String.valueOf(player.getId()) });
		
		db.close();
	}
	
	
	
	
	
	
	

}
