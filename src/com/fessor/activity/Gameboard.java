package com.fessor.activity;


import java.util.Random;

import com.example.memorygame.R;
import com.fessor.constants.Constants;
import com.fessor.functions.EquationDecoder;
import com.fessor.functions.NumberGenerator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Gameboard extends Activity implements AnimationListener{

	private Animation move1a,move2a,move3a, move4a, fadeIn, blink;
	private ImageView fessor;
	private Button cloudAnswer1,cloudAnswer2,cloudAnswer3,cloudAnswer4, cloudQuestion;
	private TextView gameboardCoins;
	private String equation,answer2,answer3,answer4;
	private boolean correct = false;
	private Random random = new Random();
	private Handler handler = new Handler();
	private Intent memoryGame;
	private int count=1;
	private int medalCounter;
	private int points = 0;
	private int equationValue;
	int redCloud,greenCloud,operation;
	LinearLayout layout;
	ImageView medal;
	TranslateAnimation animation;
	int pace;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.gameboard);

	    
	    

	    declareVariables();
	    dressFessor();
	    generateClouds();
	    generateAnimations();
	    setBackground();
	    cloudsOnClickListeners();


	    handler.postDelayed(firstMove, 1000); 

	    
	    //// TEST
	    
	    //setPace();
	    
	    /// TEST
	    
	    
	    // Global Layout Listener which is called when all the views are drawwn and have their coordinates and dimensions.
	    // Otherwise, returning value of those values will be 0
	    
	    layout.getViewTreeObserver().addOnGlobalLayoutListener(
	    		new ViewTreeObserver.OnGlobalLayoutListener() {
					
					@Override
					public void onGlobalLayout() {
						setPace();
						
					}
				
	    		}	
	    );
	}

	private void declareVariables(){
		memoryGame = new Intent(Gameboard.this, Statistics.class);
	    operation = Constants.getPresentOperation();
	    answer2=null;
	    answer3=null;
	    redCloud = R.drawable.lil_cloud_1_red;
	    greenCloud = R.drawable.lil_cloud_1_green;
	    layout=(LinearLayout) findViewById(R.id.gameboardLayout);
	    gameboardCoins = (TextView) findViewById(R.id.gameboardCoins11);
	    gameboardCoins.setVisibility(View.INVISIBLE);
	    medal = (ImageView) findViewById(R.id.gameboardMedal);
	    medalCounter=0;
	    fessor = (ImageView) findViewById(R.id.gameboardFessorr);

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		
		if (animation==fadeIn){
			cloudQuestion.setVisibility(View.VISIBLE);
			cloudAnswer1.setVisibility(View.VISIBLE);
			cloudAnswer2.setVisibility(View.VISIBLE);
			cloudAnswer3.setVisibility(View.VISIBLE);
			cloudAnswer4.setVisibility(View.VISIBLE);


		}

		if (animation==move4a){
			finishGame();
		}



	}

	@Override
	public void onBackPressed() {
	Intent intent = new Intent(this, GameMap.class);
	startActivity(intent);
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		
	}

	@Override
	public void onAnimationStart(Animation animation) {
		

	}

	public void resetClouds(){
		cloudAnswer1.setBackgroundResource(R.drawable.lil_cloud_1);
		cloudAnswer2.setBackgroundResource(R.drawable.lil_cloud_1);
		cloudAnswer3.setBackgroundResource(R.drawable.lil_cloud_1);
		cloudAnswer4.setBackgroundResource(R.drawable.lil_cloud_1);


	}

	public void disableClouds(){
		cloudAnswer1.setEnabled(false);
		cloudAnswer2.setEnabled(false);
		cloudAnswer3.setEnabled(false);
		cloudAnswer4.setEnabled(false);
	}

	public void enableClouds(){
		cloudAnswer1.setEnabled(true);
		cloudAnswer2.setEnabled(true);
		cloudAnswer3.setEnabled(true);
		cloudAnswer4.setEnabled(true);
	}

	public boolean answer(String equation, String answer){

		equationValue = EquationDecoder.equationDecoder(equation);
		int answerValue = Integer.parseInt(answer);

		if (equationValue-answerValue==0){
			return true;
		}
		else {

			return false;
		}

	}

	public void generateEquation(){



		int result = random.nextInt(10-3)+3;

		answer2 = NumberGenerator.generateRandom(result, 3, 10);
		answer3 = NumberGenerator.generateRandom(result, answer2, 3, 10);
		answer4 = NumberGenerator.generateRandom(result, answer2, answer3, 3, 10);		

		String generated_equation = EquationDecoder.equationMaker(result, operation);


		int position = random.nextInt(5-1)+1;

		switch (position) {

		case 1:
			cloudAnswer1.setText(result+"");
			cloudAnswer2.setText(answer2);
			cloudAnswer3.setText(answer3);
			cloudAnswer4.setText(answer4);
			break;

		case 2:
			cloudAnswer2.setText(result+"");
			cloudAnswer1.setText(answer2);
			cloudAnswer3.setText(answer3);
			cloudAnswer4.setText(answer4);
			break;
		case 3:
			cloudAnswer3.setText(result+"");
			cloudAnswer2.setText(answer2);
			cloudAnswer1.setText(answer4);
			cloudAnswer4.setText(answer3);
			break;

		case 4:
			cloudAnswer4.setText(result+"");	
			cloudAnswer2.setText(answer2);
			cloudAnswer3.setText(answer3);
			cloudAnswer1.setText(answer4);
			break;

		}

		equation = generated_equation;
	}

	private void generateClouds(){
		cloudQuestion = (Button) findViewById(R.id.cloudQuestion);
	    cloudQuestion.setVisibility(View.INVISIBLE);
	    cloudAnswer1 = (Button) findViewById(R.id.cloudAnswer1);
	    cloudAnswer1.setVisibility(View.INVISIBLE);
	    cloudAnswer2 = (Button) findViewById(R.id.cloudAnswer2);
	    cloudAnswer2.setVisibility(View.INVISIBLE);
	    cloudAnswer3 = (Button) findViewById(R.id.cloudAnswer3);
	    cloudAnswer3.setVisibility(View.INVISIBLE);
	    cloudAnswer4 = (Button) findViewById(R.id.cloudAnswer4);
	    cloudAnswer4.setVisibility(View.INVISIBLE);



	    cloudQuestion = (Button) findViewById(R.id.cloudQuestion);
	    cloudQuestion.setVisibility(View.INVISIBLE);

	    cloudAnswer1 = (Button) findViewById(R.id.cloudAnswer1);
	    cloudAnswer1.setVisibility(View.INVISIBLE);

	    cloudAnswer2 = (Button) findViewById(R.id.cloudAnswer2);
	    cloudAnswer2.setVisibility(View.INVISIBLE);

	    cloudAnswer3 = (Button) findViewById(R.id.cloudAnswer3);
	    cloudAnswer3.setVisibility(View.INVISIBLE);

	    cloudAnswer4 = (Button) findViewById(R.id.cloudAnswer4);
	    cloudAnswer4.setVisibility(View.INVISIBLE);

	}

	private void generateAnimations(){

		move1a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move1);
	    move1a.setAnimationListener(this);

	    move2a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move2);
	    move2a.setAnimationListener(this);

	    move3a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move3);
	    move3a.setAnimationListener(this);

	    move4a = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move4);
	    move4a.setAnimationListener(this);

	    fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
	    fadeIn.setAnimationListener(this);

	    blink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

	    animation = new TranslateAnimation(Animation.ABSOLUTE, fessor.getX(), Animation.ABSOLUTE, fessor.getX()+60, Animation.ABSOLUTE, fessor.getY(), Animation.ABSOLUTE, fessor.getY());
	    
	}

	private void cloudsOnClickListeners(){

		cloudAnswer1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				disableClouds();
				String answered = cloudAnswer1.getText().toString();

				int cloud2 = Integer.parseInt(cloudAnswer2.getText().toString());
				int cloud3 = Integer.parseInt(cloudAnswer3.getText().toString());
				int cloud4 = Integer.parseInt(cloudAnswer4.getText().toString());



				boolean correctAnswer = answer(equation, answered);

				if (correctAnswer == true){

					cloudAnswer1.setBackgroundResource(greenCloud);
					cloudAnswer1.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
				}else{

					medalCounter++;
					if (cloud2-equationValue==0){
						cloudAnswer2.setBackgroundResource(greenCloud);
						cloudAnswer1.setBackgroundResource(redCloud);
					}
					if (cloud3-equationValue==0){
						cloudAnswer3.setBackgroundResource(greenCloud);
						cloudAnswer1.setBackgroundResource(redCloud);
					}
					if (cloud4-equationValue==0){
						cloudAnswer4.setBackgroundResource(greenCloud);
						cloudAnswer1.setBackgroundResource(redCloud);
					}

					handler.postDelayed(runnable, 2000);

				}
				setMedal();
			}
		});
	    cloudAnswer2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				disableClouds();
				String answered = cloudAnswer2.getText().toString();
				int cloud1 = Integer.parseInt(cloudAnswer1.getText().toString());
				int cloud3 = Integer.parseInt(cloudAnswer3.getText().toString());
				int cloud4 = Integer.parseInt(cloudAnswer4.getText().toString());

				boolean correctAnswer = answer(equation, answered);

				if (correctAnswer==true){

					cloudAnswer2.setBackgroundResource(greenCloud);
					cloudAnswer2.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
				}
				else{

					medalCounter++;
					if (cloud1-equationValue==0){
						cloudAnswer1.setBackgroundResource(greenCloud);
						cloudAnswer2.setBackgroundResource(redCloud);
					}
					if (cloud3-equationValue==0){
						cloudAnswer3.setBackgroundResource(greenCloud);
						cloudAnswer2.setBackgroundResource(redCloud);
					}
					if (cloud4-equationValue==0){
						cloudAnswer4.setBackgroundResource(greenCloud);
						cloudAnswer2.setBackgroundResource(redCloud);
					}
					handler.postDelayed(runnable, 2000);
				}
				setMedal();
			}
		});
	    cloudAnswer3.setOnClickListener(new View.OnClickListener() {

	    	@Override
	    	public void onClick(View v) {
	    		disableClouds();
	    		String answered = cloudAnswer3.getText().toString();
	    		int cloud2 = Integer.parseInt(cloudAnswer2.getText().toString());
				int cloud1 = Integer.parseInt(cloudAnswer1.getText().toString());
				int cloud4 = Integer.parseInt(cloudAnswer4.getText().toString());

				boolean correctAnswer = answer(equation, answered);

	    		if (correctAnswer==true){

					cloudAnswer3.setBackgroundResource(greenCloud);
					cloudAnswer3.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
	    		}
	    		else{

	    			medalCounter++;

	    			if (cloud2-equationValue==0){
						cloudAnswer2.setBackgroundResource(greenCloud);
						cloudAnswer3.setBackgroundResource(redCloud);
					}
					if (cloud1-equationValue==0){
						cloudAnswer1.setBackgroundResource(greenCloud);
						cloudAnswer3.setBackgroundResource(redCloud);
					}
					if (cloud4-equationValue==0){
						cloudAnswer4.setBackgroundResource(greenCloud);
						cloudAnswer3.setBackgroundResource(redCloud);
					}
					handler.postDelayed(runnable, 2000);
				}
	    		setMedal();
	    	}
	    });
	    cloudAnswer4.setOnClickListener(new View.OnClickListener() {

	    	@Override
	    	public void onClick(View v) {
	    		disableClouds();
	    		String answered = cloudAnswer4.getText().toString();
	    		int cloud2 = Integer.parseInt(cloudAnswer2.getText().toString());
				int cloud3 = Integer.parseInt(cloudAnswer3.getText().toString());
				int cloud1 = Integer.parseInt(cloudAnswer1.getText().toString());

				boolean correctAnswer = answer(equation, answered);

	    		if (correctAnswer==true){

					cloudAnswer4.setBackgroundResource(greenCloud);
					cloudAnswer4.setText(answered);
					correct = true;
					count++;
					points++;
					gameboardCoins.setText(""+points);
					moveFessor();
	    		}
	    		else{
	    			medalCounter++;
	    			if (cloud2-equationValue==0){
						cloudAnswer2.setBackgroundResource(greenCloud);
						cloudAnswer4.setBackgroundResource(redCloud);
					}
					if (cloud3-equationValue==0){
						cloudAnswer3.setBackgroundResource(greenCloud);
						cloudAnswer4.setBackgroundResource(redCloud);
					}
					if (cloud1-equationValue==0){
						cloudAnswer1.setBackgroundResource(greenCloud);
						cloudAnswer4.setBackgroundResource(redCloud);
					}
					handler.postDelayed(runnable, 2000);
				}
	    		setMedal();
	    	}
	    });

	    moveFessor();


	}

	public void moveFessor(){

		
		Runnable move = new Runnable() {

			@Override
			public void run() {
				if (correct){

					// reset clouds untill the last click
					if(points<7){
						correct=false;
						resetClouds();
						enableClouds();
						generateEquation();
						cloudQuestion.setText(equation);
					}
					switch (count) {

					

					case 2:
						
						animation = new TranslateAnimation(pace, pace*2, 0, 0);
						
						break;

					case 3:
						
						animation = new TranslateAnimation(pace*2, pace*3, 0, 0);
						
						break;

					case 4:
						animation = new TranslateAnimation(pace*3, pace*4, 0, 0);
						break;
						
					case 5:
						animation = new TranslateAnimation(pace*4, pace*5, 0, 0);
						break;
						
					case 6:
						animation = new TranslateAnimation(pace*5, pace*6, 0, 0);
						break;
						
					case 7:
						animation = new TranslateAnimation(pace*6, pace*7, 0, 0);
						break;
						
					case 8:
						animation = new TranslateAnimation(pace*7, pace*9, 0, 0);
						finishGame();
						break;
				}
					
					animation.setFillAfter(true);
					animation.setDuration(1000);
					fessor.startAnimation(animation);

			}

			}
		};


		handler.postDelayed(move, 1000);


	}

	private Runnable firstMove = new Runnable() {

		@Override
		public void run() {
			animation = new TranslateAnimation(0, pace, 0, 0);
			animation.setFillAfter(true);
			animation.setDuration(1000);
			
			fessor.startAnimation(animation);

			cloudQuestion.startAnimation(fadeIn);
			cloudAnswer1.startAnimation(fadeIn);
			cloudAnswer2.startAnimation(fadeIn);
			cloudAnswer3.startAnimation(fadeIn);
			cloudAnswer4.startAnimation(fadeIn);

			generateEquation();
			cloudQuestion.setText(equation);
			gameboardCoins.setVisibility(View.VISIBLE);
		}
	};
	

	public Runnable runnable = new Runnable() {

		@Override
		public void run() {
			resetClouds();
			generateEquation();
			cloudQuestion.setText(equation);
			enableClouds();
		}
	};

	
	public void setBackground(){
		switch (Constants.presentCountry) {

			case Constants.iceland:
				layout.setBackgroundResource(R.drawable.iceland1);
				break;

			case Constants.denmark:
				layout.setBackgroundResource(R.drawable.denmark1);
				break;

			case Constants.norway:
				layout.setBackgroundResource(R.drawable.norway1);
				break;

			case Constants.faroe:
				layout.setBackgroundResource(R.drawable.faroe1);
				break;

			case Constants.sweden:
				layout.setBackgroundResource(R.drawable.sweden1);
				break;

			case Constants.finland:
				layout.setBackgroundResource(R.drawable.finland1);
				break;
			}

	}

	public void setMedal(){


		if (medalCounter<2){
			medal.setImageResource(R.drawable.gold_110);
			Constants.setCloudGameMedal(Constants.gold);
		}

		if (medalCounter == 1 || medalCounter == 3){
			medal.setAnimation(blink);

		}

		if(medalCounter>1 && medalCounter <=3){
			medal.setImageResource(R.drawable.silver_110);
			Constants.setCloudGameMedal(Constants.silver);
		}


		if(medalCounter>4){
			medal.setImageResource(R.drawable.bronze_110);
			Constants.setCloudGameMedal(Constants.bronze);
		}
	}

	private void finishGame(){

		
		Constants.getPlayer().setOverallCoins(Constants.getPlayer().getOverallCoins()+points);

		switch (Constants.cloudGameMedal) {
			case Constants.gold:
			
			Constants.getPlayer().setOverallGold(Constants.getPlayer().getOverallGold()+1);
				break;

			case Constants.silver:
				Constants.getPlayer().setOverallSilver(Constants.getPlayer().getOverallSilver()+1);
				break;

			case Constants.bronze:
				Constants.getPlayer().setOverallBronze(Constants.getPlayer().getOverallBronze()+1);
				break;
		}
		
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				startActivity(memoryGame);
				
			}
		},  1400); 
		
		
	}

	private void dressFessor(){

		fessor.setImageResource(R.drawable.costume_fessor);
		
		
		if (Constants.getPlayer().getHero() == 1){
			fessor.setImageResource(R.drawable.costume_hero);
			
		}
		if (Constants.getPlayer().getCowboy() == 1){
			fessor.setImageResource(R.drawable.costume_cowboy);
			
		}
		if (Constants.getPlayer().getIndian() == 1){
			fessor.setImageResource(R.drawable.costume_indian);
			
		}
		if (Constants.getPlayer().getPirate() == 1){
			fessor.setImageResource(R.drawable.costume_pirate);
			
		}
		if (Constants.getPlayer().getViking() == 1){
			fessor.setImageResource(R.drawable.costume_viking);
			
		}
	}

	private void setPace(){
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		
		int width = size.x;
		int fessorLeft = fessor.getLeft();
		int fessorWidth = fessor.getWidth();
		
		pace = (width-fessorLeft+fessorWidth)/7;
		pace = pace - 60;
		
		
		
	}















}