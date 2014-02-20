
package com.fessor.constants;

import java.util.LinkedList;
import java.util.List;

import com.fessor.model.Player;


public class Constants {
	
	public static int firstValue, secondValue, score;
	
	public static int playedGame = 0;

	public static int getPlayedGame() {
		return playedGame;
	}

	public static void setPlayedGame(int playedGame) {
		Constants.playedGame = playedGame;
	}

	public static final int plus = 1;
	public static final int minus = 2;
	public static final int add = 3;
	public static final int divide = 4;
	
	public static final int gold = 1;
	public static final int silver = 2;
	public static final int bronze = 3;
	
	public static final int iceland = 1;
	public static final int denmark = 2;
	public static final int norway = 3;
	public static final int faroe = 4;
	public static final int sweden = 5;
	public static final int finland = 6;
	
	public static boolean firstStart = true;
	
	public static int presentCountry;
	public static int presentOperation;
	
	public static int memoryGameBackground ;
	public static int boardGameBackground ;
	
	public static boolean firstTime = true;
	
	public static int coins;
	public static int coinsCloudGame;
	public static int coinsMemoryGame;
		
	public static int cloudGameMedal;
	public static int memoryGameMedal;
		
	public static int bonus = 0;
	
	public static int presentFessorCostume = 0;
	
	public static Player player;
	
	public static List<Player> players = new LinkedList<Player>();
	
	
	
	

	public static Player getPlayer() {
		return player;
	}

	public static void setPlayer(Player player) {
		Constants.player = player;
	}

	public static List<Player> getPlayers() {
		return players;
	}

	public static void setPlayers(List<Player> players) {
		Constants.players = players;
	}

	public static int getPresentFessorCostume() {
		return presentFessorCostume;
	}

	public static void setPresentFessorCostume(int presentFessorCostume) {
		Constants.presentFessorCostume = presentFessorCostume;
	}

	public static int getBonus() {
		return bonus;
	}

	public static void setBonus(int bonus) {
		Constants.bonus = bonus;
	}

	
	


	public static int getCloudGameMedal() {
		return cloudGameMedal;
	}

	public static void setCloudGameMedal(int cloudGameMedal) {
		Constants.cloudGameMedal = cloudGameMedal;
	}

	public static int getMemoryGameMedal() {
		return memoryGameMedal;
	}

	public static void setMemoryGameMedal(int memoryGameMedal) {
		Constants.memoryGameMedal = memoryGameMedal;
	}

	public static int getCoinsCloudGame() {
		return coinsCloudGame;
	}

	public static void setCoinsCloudGame(int coinsCloudGame) {
		Constants.coinsCloudGame = coinsCloudGame;
	}

	public static int getCoinsMemoryGame() {
		return coinsMemoryGame;
	}

	public static void setCoinsMemoryGame(int coinsMemoryGame) {
		Constants.coinsMemoryGame = coinsMemoryGame;
	}

	public static int getCoins() {
		return coins;
	}

	public static void setCoins(int coins) {
		Constants.coins = coins;
	}

	public static boolean isFirstTime() {
		return firstTime;
	}

	public static void setFirstTime(boolean firstTime) {
		Constants.firstTime = firstTime;
	}

	public static int getMemoryGameBackground() {
		return memoryGameBackground;
	}

	public static void setMemoryGameBackground(int memoryGameBackground) {
		Constants.memoryGameBackground = memoryGameBackground;
	}

	public static int getBoardGameBackground() {
		return boardGameBackground;
	}

	public static void setBoardGameBackground(int boardGameBackground) {
		Constants.boardGameBackground = boardGameBackground;
	}

	public static int getPresentCountry() {
		return presentCountry;
	}

	public static void setPresentCountry(int presentCountry) {
		Constants.presentCountry = presentCountry;
	}

	public static int getPresentOperation() {
		return presentOperation;
	}

	public static void setPresentOperation(int presentOperation) {
		Constants.presentOperation = presentOperation;
	}

	public static boolean isFirststart() {
		return firstStart;
	}
	
	public static void setFirstStart(boolean firstStart){
		Constants.firstStart = firstStart;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Constants.score = score;
	}

	public static int getFirstValue() {
		return firstValue;
	}

	public static void setFirstValue(int firstValue) {
		Constants.firstValue = firstValue;
	}

	public static int getSecondValue() {
		return secondValue;
	}

	public static void setSecondValue(int secondValue) {
		Constants.secondValue = secondValue;
	}

	
	

}
