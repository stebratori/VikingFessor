package com.fessor.model;

public class Player {

	private int id;
	private String name;
	
	private int overallCoins;
	private int overallGold;
	private int overallSilver;
	private int overallBronze;
	
	private int plusCoins;
	private int plusGold;
	private int plusSilver;
	private int plusBronze;
	
	private int minusCoins;
	private int minusGold;
	private int minusSilver;
	private int minusBronze;
	
	private int icelandPlus;
	private int icelandMinus;
	
	private int faroePlus;
	private int faroeMinus;
	
	private int norwayPlus;
	private int norwayMinus;
	
	private int denmarkPlus;
	private int denmarkMinus;
	
	private int swedenPlus;
	private int swedenMinus;
	
	private int finlandPlus;
	private int finlandMinus;
	
	private int hero;
	private int cowboy;
	private int indian;
	private int pirate;
	private int viking;
	
	private int plusPlayed;
	private int minusPlayed;

	
	
	
	
	

	public Player(int id, String name, int overallCoins, int overallGold,
			int overallSilver, int overallBronze, int plusCoins, int plusGold,
			int plusSilver, int plusBronze, int minusCoins, int minusGold,
			int minusSilver, int minusBronze, int icelandPlus,
			int icelandMinus, int faroePlus, int faroeMinus, int norwayPlus,
			int norwayMinus, int denmarkPlus, int denmarkMinus, int swedenPlus,
			int swedenMinus, int finlandPlus, int finlandMinus, int hero,
			int cowboy, int indian, int pirate, int viking, int plusPlayed,
			int minusPlayed) {
		super();
		this.id = id;
		this.name = name;
		this.overallCoins = overallCoins;
		this.overallGold = overallGold;
		this.overallSilver = overallSilver;
		this.overallBronze = overallBronze;
		this.plusCoins = plusCoins;
		this.plusGold = plusGold;
		this.plusSilver = plusSilver;
		this.plusBronze = plusBronze;
		this.minusCoins = minusCoins;
		this.minusGold = minusGold;
		this.minusSilver = minusSilver;
		this.minusBronze = minusBronze;
		this.icelandPlus = icelandPlus;
		this.icelandMinus = icelandMinus;
		this.faroePlus = faroePlus;
		this.faroeMinus = faroeMinus;
		this.norwayPlus = norwayPlus;
		this.norwayMinus = norwayMinus;
		this.denmarkPlus = denmarkPlus;
		this.denmarkMinus = denmarkMinus;
		this.swedenPlus = swedenPlus;
		this.swedenMinus = swedenMinus;
		this.finlandPlus = finlandPlus;
		this.finlandMinus = finlandMinus;
		this.hero = hero;
		this.cowboy = cowboy;
		this.indian = indian;
		this.pirate = pirate;
		this.viking = viking;
		this.plusPlayed = plusPlayed;
		this.minusPlayed = minusPlayed;
	}







	@Override
	public String toString(){
		return "Player [id="+id+", name="+name+"]";
	}







	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public int getOverallCoins() {
		return overallCoins;
	}







	public void setOverallCoins(int overallCoins) {
		this.overallCoins = overallCoins;
	}







	public int getOverallGold() {
		return overallGold;
	}







	public void setOverallGold(int overallGold) {
		this.overallGold = overallGold;
	}







	public int getOverallSilver() {
		return overallSilver;
	}







	public void setOverallSilver(int overallSilver) {
		this.overallSilver = overallSilver;
	}







	public int getOverallBronze() {
		return overallBronze;
	}







	public void setOverallBronze(int overallBronze) {
		this.overallBronze = overallBronze;
	}







	public int getPlusCoins() {
		return plusCoins;
	}







	public void setPlusCoins(int plusCoins) {
		this.plusCoins = plusCoins;
	}







	public int getPlusGold() {
		return plusGold;
	}







	public void setPlusGold(int plusGold) {
		this.plusGold = plusGold;
	}







	public int getPlusSilver() {
		return plusSilver;
	}







	public void setPlusSilver(int plusSilver) {
		this.plusSilver = plusSilver;
	}







	public int getPlusBronze() {
		return plusBronze;
	}







	public void setPlusBronze(int plusBronze) {
		this.plusBronze = plusBronze;
	}







	public int getMinusCoins() {
		return minusCoins;
	}







	public void setMinusCoins(int minusCoins) {
		this.minusCoins = minusCoins;
	}







	public int getMinusGold() {
		return minusGold;
	}







	public void setMinusGold(int minusGold) {
		this.minusGold = minusGold;
	}







	public int getMinusSilver() {
		return minusSilver;
	}







	public void setMinusSilver(int minusSilver) {
		this.minusSilver = minusSilver;
	}







	public int getMinusBronze() {
		return minusBronze;
	}







	public void setMinusBronze(int minusBronze) {
		this.minusBronze = minusBronze;
	}







	public int getIcelandPlus() {
		return icelandPlus;
	}







	public void setIcelandPlus(int icelandPlus) {
		this.icelandPlus = icelandPlus;
	}







	public int getIcelandMinus() {
		return icelandMinus;
	}







	public void setIcelandMinus(int icelandMinus) {
		this.icelandMinus = icelandMinus;
	}







	public int getFaroePlus() {
		return faroePlus;
	}







	public void setFaroePlus(int faroePlus) {
		this.faroePlus = faroePlus;
	}







	public int getFaroeMinus() {
		return faroeMinus;
	}







	public void setFaroeMinus(int faroeMinus) {
		this.faroeMinus = faroeMinus;
	}







	public int getNorwayPlus() {
		return norwayPlus;
	}







	public void setNorwayPlus(int norwayPlus) {
		this.norwayPlus = norwayPlus;
	}







	public int getNorwayMinus() {
		return norwayMinus;
	}







	public void setNorwayMinus(int norwayMinus) {
		this.norwayMinus = norwayMinus;
	}







	public int getDenmarkPlus() {
		return denmarkPlus;
	}







	public void setDenmarkPlus(int denmarkPlus) {
		this.denmarkPlus = denmarkPlus;
	}







	public int getDenmarkMinus() {
		return denmarkMinus;
	}







	public void setDenmarkMinus(int denmarkMinus) {
		this.denmarkMinus = denmarkMinus;
	}







	public int getSwedenPlus() {
		return swedenPlus;
	}







	public void setSwedenPlus(int swedenPlus) {
		this.swedenPlus = swedenPlus;
	}







	public int getSwedenMinus() {
		return swedenMinus;
	}







	public void setSwedenMinus(int swedenMinus) {
		this.swedenMinus = swedenMinus;
	}







	public int getFinlandPlus() {
		return finlandPlus;
	}







	public void setFinlandPlus(int finlandPlus) {
		this.finlandPlus = finlandPlus;
	}







	public int getFinlandMinus() {
		return finlandMinus;
	}







	public void setFinlandMinus(int finlandMinus) {
		this.finlandMinus = finlandMinus;
	}







	public int getHero() {
		return hero;
	}







	public void setHero(int hero) {
		this.hero = hero;
	}







	public int getCowboy() {
		return cowboy;
	}







	public void setCowboy(int cowboy) {
		this.cowboy = cowboy;
	}







	public int getIndian() {
		return indian;
	}







	public void setIndian(int indian) {
		this.indian = indian;
	}







	public int getPirate() {
		return pirate;
	}







	public void setPirate(int pirate) {
		this.pirate = pirate;
	}







	public int getViking() {
		return viking;
	}







	public void setViking(int viking) {
		this.viking = viking;
	}







	public int getPlusPlayed() {
		return plusPlayed;
	}







	public void setPlusPlayed(int plusPlayed) {
		this.plusPlayed = plusPlayed;
	}







	public int getMinusPlayed() {
		return minusPlayed;
	}







	public void setMinusPlayed(int minusPlayed) {
		this.minusPlayed = minusPlayed;
	}

	
	
	
	
}
