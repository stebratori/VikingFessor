package com.fessor.activity;

import com.example.memorygame.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TrophyRoom extends Activity implements OnClickListener{

	TextView coins, gold, silver, bronze, name;
	Button left, right;
	ImageView fessor;
	
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.trophy_room);
	    
	    declareVariables();
	}

	private void declareVariables(){
		coins = (TextView) findViewById(R.id.trophyRoomCoins);
		gold = (TextView) findViewById(R.id.trophyRoomGold);
		silver = (TextView) findViewById(R.id.trophyRoomSilver);
		bronze = (TextView) findViewById(R.id.trophyRoomBronze);
		name = (TextView) findViewById(R.id.trophyRoomName);
		
		left = (Button) findViewById(R.id.trophyRoomLeft);
		right = (Button) findViewById(R.id.trophyRoomRight);
		
		fessor = (ImageView) findViewById(R.id.trophyRoomFessor);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.trophyRoomLeft:
			
			break;

		case R.id.trophyRoomRight:
			
			break;
		}
		
	}
}
