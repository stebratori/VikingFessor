package com.fessor.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.memorygame.R;
import com.fessor.constants.Constants;
import com.fessor.functions.ShopDialog;

public final class ShopActivity extends Activity  implements OnClickListener {

	private ImageButton fessor;
	private static ImageButton hero;
	private static ImageButton cowboy, indian, pirate, viking;
	private Button back;
	private static TextView shopCoins;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.shop);
	    
	    generateVariables();
	    setLocks();
	    setCoins();
	}

	private void generateVariables(){
		fessor = (ImageButton) findViewById(R.id.shopFessor);
		fessor.setOnClickListener(this);
		hero = (ImageButton) findViewById(R.id.shopHero);
		hero.setOnClickListener(this);
		cowboy = (ImageButton) findViewById(R.id.shopCowboy);
		cowboy.setOnClickListener(this);
		indian = (ImageButton) findViewById(R.id.shopIndian);
		indian.setOnClickListener(this);
		pirate = (ImageButton) findViewById(R.id.shopPirate);
		pirate.setOnClickListener(this);
		viking = (ImageButton) findViewById(R.id.shopViking);
		viking.setOnClickListener(this);
		
		back = (Button) findViewById(R.id.mrzimandroid);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent (ShopActivity.this, GameMap.class);
				startActivity(i);
				
			}
		});
		
		shopCoins = (TextView) findViewById(R.id.shopCoins);
		
		
	}

	@Override
	public void onClick(View v) {
		
		ShopDialog dialog = null;
			
			switch (v.getId()) {
			
			case R.id.shopFessor:
				dialog = new ShopDialog(this, 0);
				
				break;

			case R.id.shopHero:
				dialog = new ShopDialog(this, 1);
				break;
		
		
			case R.id.shopCowboy:
				dialog = new ShopDialog(this, 2);
				break;
		
	
			case R.id.shopIndian:
				dialog = new ShopDialog(this, 3);
				break;
				
			case R.id.shopPirate:
				dialog = new ShopDialog(this, 4);
				break;
		
	
			case R.id.shopViking:
				dialog = new ShopDialog(this, 5);
				break;
				
			
		
		}
			
			dialog.show();
		
		
		
	}
	
	public  static void setLocks(){
		
		if(Constants.getPlayer().getHero() == 1){
			hero.setImageResource(android.R.color.transparent);
		}
		if(Constants.getPlayer().getCowboy() == 1){
			cowboy.setImageResource(android.R.color.transparent);
		}
		if(Constants.getPlayer().getIndian() == 1){
			indian.setImageResource(android.R.color.transparent);
		}
		if(Constants.getPlayer().getPirate() == 1){
			pirate.setImageResource(android.R.color.transparent);
		}
		if(Constants.getPlayer().getViking() == 1){
			viking.setImageResource(android.R.color.transparent);
		}
		
	}
	
	public static void setCoins(){
		shopCoins.setText(""+Constants.getPlayer().getOverallCoins());
	}
	
	

	













}
