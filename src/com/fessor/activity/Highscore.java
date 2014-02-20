package com.fessor.activity;

import com.example.memorygame.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class Highscore extends Activity{

	ImageView fessor, plusIceland, minusIceland, plusFaroe, minusFaroe, plusNorway, minusNorway,plusDenmark,minusDenmark,plusSweden,minusSweden,plusFinland,minusFinland;
	TextView overallCoins, overallGold,overallSilver,overallBronze,plusCoins,minusCoins,plusGold,minusGold,plusSilver,minusSilver,plusBronze,minusBronze,playerName;
	Button next,previous;
	ImageButton backToMainMenu;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscore);
		declareVariables();
		clickListener();
	}

	
	private void declareVariables(){
	
		
		// ** IMAGES **
		fessor = (ImageView) findViewById(R.id.highscoreImgFessor);
		
		plusIceland = (ImageView) findViewById(R.id.highscoreImgPlusIceland);
		minusIceland = (ImageView) findViewById(R.id.highscoreImgMinusIceland);
		
		plusFaroe = (ImageView) findViewById(R.id.highscoreImgPlusFaroe);
		minusFaroe = (ImageView) findViewById(R.id.highscoreImgMinusFaroe);
		
		plusNorway = (ImageView) findViewById(R.id.highscoreImgPlusNorway);
		minusNorway = (ImageView) findViewById(R.id.highscoreImgMinusNorway);
		
		plusDenmark = (ImageView) findViewById(R.id.highscoreImgPlusDenmark);
		minusDenmark = (ImageView) findViewById(R.id.highscoreImgMinusDenmark);
		
		plusSweden = (ImageView) findViewById(R.id.highscoreImgPlusSweden);
		minusSweden = (ImageView) findViewById(R.id.ImageView14);
		
		plusFinland = (ImageView) findViewById(R.id.highscoreImgPlusFinland);
		minusFinland = (ImageView) findViewById(R.id.ImageView15);
		
		
		// ** TEXT **
		overallCoins = (TextView) findViewById(R.id.highscoreOverallCoins);
		overallGold = (TextView) findViewById(R.id.highscoreOverallGold);
		overallSilver = (TextView) findViewById(R.id.highscoreOverallSilver);
		overallBronze = (TextView) findViewById(R.id.highscoreOverallBronze);
		
		plusCoins = (TextView) findViewById(R.id.highscorePlusCoins);
		plusGold = (TextView) findViewById(R.id.highscorePlusGold);
		plusSilver = (TextView) findViewById(R.id.highscorePlusSilver);
		plusBronze = (TextView) findViewById(R.id.highscorePlusBronze);
		
		minusCoins = (TextView) findViewById(R.id.highscoreMinusCoins);
		minusGold = (TextView) findViewById(R.id.highscoreMinusGold);
		minusSilver = (TextView) findViewById(R.id.highscoreMinusSilver);
		minusBronze = (TextView) findViewById(R.id.highscoreMinusBronze);
		
		playerName = (TextView) findViewById(R.id.highscorePlayerName);
		
		
		// ** BUTTONS **
		previous = (Button) findViewById(R.id.highscoreBtnPrev);
		next = (Button) findViewById(R.id.highscoreBtnNext);
		backToMainMenu = (ImageButton) findViewById(R.id.highscoreBackToMenu);
		
	}

	private void clickListener(){
		
		backToMainMenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(Highscore.this, MainActivity.class);
				startActivity(intent);
				
			}
		});
	}




	
	























}
