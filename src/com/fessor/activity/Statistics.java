package com.fessor.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

public class Statistics extends Activity {

	ImageView fessor, medal, bonus,statisticsBck;
	Button next;
	TextView coins, bonusCoins;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);
		
		declareVariables();
		setScore();
		
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (Constants.playedGame == 0){
					Constants.setPlayedGame(1);
					Intent intent = new Intent(Statistics.this, MemoryGame.class);
					startActivity(intent);
				}
				else{
					Constants.setPlayedGame(0);
					Intent intent = new Intent(Statistics.this, GameMap.class);
					startActivity(intent);
				}
				
				
			}
		});
	}


	private void declareVariables(){
		
		fessor = (ImageView) findViewById(R.id.gameBoardStatisticsFessor);
		medal = (ImageView) findViewById(R.id.gameBoardStatisticsMedal);
		bonus = (ImageView) findViewById(R.id.bonusImg);
		statisticsBck = (ImageView) findViewById(R.id.statisticsBck);
		
		next = (Button)findViewById(R.id.gameboardStatisticsBtnArrow);
		
		coins = (TextView)findViewById(R.id.gameBoardStatisticsCoins);
		bonusCoins = (TextView)findViewById(R.id.bonusCoins);
		
		if (Constants.playedGame == 0){
			
			bonus.setVisibility(View.INVISIBLE);
			bonusCoins.setVisibility(View.INVISIBLE);
			
			
			
		}else{
			
			bonus.setVisibility(View.VISIBLE);
			bonusCoins.setVisibility(View.VISIBLE);
			
			bonusCoins.setText(""+Constants.getBonus());
			
			
		}
	}
	


	private void setScore(){
		
		
		// Dress Fessor
		switch (Constants.presentFessorCostume)
		{
			case 0:
				fessor.setImageResource(R.drawable.costume_fessor);
				break;
				
			case 1:
				fessor.setImageResource(R.drawable.costume_hero);
				break;
				
			case 2:
				fessor.setImageResource(R.drawable.costume_cowboy);
				break;
				
			case 3:
				fessor.setImageResource(R.drawable.costume_indian);
				break;
				
			case 4:
				fessor.setImageResource(R.drawable.costume_pirate);
				break;
				
			case 5:
				fessor.setImageResource(R.drawable.costume_viking);
				break;
		}
		
		// Set Medal
		switch (Constants.cloudGameMedal) 
		{
			case Constants.gold:
				medal.setImageResource(R.drawable.gold_150);
			break;

			case Constants.silver:
				medal.setImageResource(R.drawable.silver_150);
			break;
			
			case Constants.bronze:
				medal.setImageResource(R.drawable.bronze_150);
			break;
		}
		
		// Set Background
		
		
		Log.v("country",""+Constants.presentCountry);
		switch (Constants.presentCountry) {
		
			case Constants.iceland:
				if (Constants.playedGame == 0){
					Log.v("country",""+Constants.playedGame);
					statisticsBck.setImageResource(R.drawable.iceland1);
				}
				else{
					statisticsBck.setImageResource(R.drawable.iceland2);
				}
			break;

			case Constants.faroe:
				if (Constants.playedGame == 0){
					statisticsBck.setImageResource(R.drawable.faroe1);
				}
				else{
					statisticsBck.setImageResource(R.drawable.faroe2);
				}
			break;
			
			case Constants.norway:
				if (Constants.playedGame == 0){
					statisticsBck.setImageResource(R.drawable.norway1);
				}
				else{
					statisticsBck.setImageResource(R.drawable.norway2);
				}
			break;
			
			case Constants.denmark:
				if (Constants.playedGame == 0){
					statisticsBck.setImageResource(R.drawable.denmark1);
				}
				else{
					statisticsBck.setImageResource(R.drawable.denmark2);
				}
			break;
			
			case Constants.sweden:
				if (Constants.playedGame == 0){
					statisticsBck.setImageResource(R.drawable.sweden1);
				}
				else{
					statisticsBck.setImageResource(R.drawable.sweden2);
				}
			break;
			
			case Constants.finland:
				if (Constants.playedGame == 0){
					statisticsBck.setImageResource(R.drawable.finland1);
				}
				else{
					statisticsBck.setImageResource(R.drawable.finland2);
				}
			break;
		}
		
		
		
		
		
	}


































}
