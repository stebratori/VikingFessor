package com.fessor.activity;

import com.example.memorygame.R;
import com.fessor.constants.Constants;
import com.fessor.model.SqlPrepare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button newGame, highscore, trophyRoom;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		
		declareVariables();
		readDB();
		
		
		
		
		newGame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(MainActivity.this, NewGame.class);
				startActivity(intent);
				
			}
		});
		highscore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent = new Intent(MainActivity.this, Highscore.class);
				startActivity(intent);
				
			}
		});
	
	}

	private void declareVariables(){
		
		newGame = (Button) findViewById(R.id.newGameBtnDeleteAlertShow);
		highscore = (Button) findViewById(R.id.newGameBtnPickPlayer);
		
	}
	
	private void readDB(){
		SqlPrepare db = new SqlPrepare(this);
		Constants.players = db.getAllPlayers();
		if (Constants.players.size()>0){
			Constants.player = Constants.players.get(0);
		}
	}
	
	public void onBackPressed() {
		finish();
	}







	
	
	

}
