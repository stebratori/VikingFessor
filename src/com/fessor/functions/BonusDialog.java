package com.fessor.functions;


import java.util.Random;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.memorygame.R;
import com.fessor.constants.Constants;

public class BonusDialog extends Dialog implements android.view.View.OnClickListener{

	public Activity activity;
	public TextView counter, dialogEquation, countdown;
	public Button answer1, answer2, answer3;
	
	
	private String equation;
	private String stringAnswer1, stringAnswer2,stringAnswer3;
	private int result;
	
	private Random random;
	
	private int equationValue,answerValue;
	
	
	public BonusDialog(Activity a) {
		super(a);
		this.activity = a;
	}

	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.bonus_dialog);
	    
	    declareVariables();
	    generateEquation();
	    final Handler handler = new Handler();
	    
	    countdown.setText("00:05");
	    handler.postDelayed(tickOne, 900);
	    handler.postDelayed(tickTwo, 1800);
		handler.postDelayed(tickThree, 2700);
		handler.postDelayed(tickFour, 3600);
		handler.postDelayed(tickFive, 4300);
	    


	  }
	
	private void declareVariables(){
		answer1 = (Button) findViewById(R.id.dialogAnswer1);
		answer2 = (Button) findViewById(R.id.dialogAnswer2);
		answer3 = (Button) findViewById(R.id.dialogAnswer3);
		
		answer1.setOnClickListener(this);
		answer2.setOnClickListener(this);
		answer3.setOnClickListener(this);
		
		countdown = (TextView) findViewById(R.id.countdown);
		
		random = new Random();
		result = random.nextInt(10-3)+3;
		
		dialogEquation = (TextView) findViewById(R.id.dialogEquation);
	}
	
	@Override
	public void onClick(View v) {
		disableCouds();
		switch(v.getId()){
		
		case (R.id.dialogAnswer1):
			if (answer(equation,answer1.getText().toString())==true){
			
			answer1.setBackgroundResource(R.drawable.lil_cloud_1_green);
			Constants.setBonus(Constants.getBonus()+3);
			}else{
				answer1.setBackgroundResource(R.drawable.lil_cloud_1_red);
				if (answer(equation,answer2.getText().toString())==true){
					answer2.setBackgroundResource(R.drawable.lil_cloud_1_green);
				}
				if (answer(equation,answer3.getText().toString())==true){
					answer3.setBackgroundResource(R.drawable.lil_cloud_1_green);
				}
			}
			break;
		
		case (R.id.dialogAnswer2):
			if (answer(equation,answer2.getText().toString())==true){
				Constants.setBonus(Constants.getBonus()+3);
				answer2.setBackgroundResource(R.drawable.lil_cloud_1_green);
				}else{
					answer2.setBackgroundResource(R.drawable.lil_cloud_1_red);
					if (answer(equation,answer1.getText().toString())==true){
						answer1.setBackgroundResource(R.drawable.lil_cloud_1_green);
					}
					if (answer(equation,answer3.getText().toString())==true){
						answer3.setBackgroundResource(R.drawable.lil_cloud_1_green);
					}
				}
				break;
			
			
		
		case (R.id.dialogAnswer3):
			if (answer(equation,answer3.getText().toString())==true){
				Constants.setBonus(Constants.getBonus()+3);
				answer3.setBackgroundResource(R.drawable.lil_cloud_1_green);
				}else{
					answer3.setBackgroundResource(R.drawable.lil_cloud_1_red);
					if (answer(equation,answer2.getText().toString())==true){
						answer2.setBackgroundResource(R.drawable.lil_cloud_1_green);
					}
					if (answer(equation,answer1.getText().toString())==true){
						answer1.setBackgroundResource(R.drawable.lil_cloud_1_green);
					}
				}
				break;
			
			
		
		
		}
		
		
		
	}
	
	private void generateEquation(){
		equation = EquationDecoder.equationMaker(result, Constants.plus);
		stringAnswer1 = NumberGenerator.generateRandom(result, 1, 10);
		stringAnswer2 = NumberGenerator.generateRandom(result, stringAnswer1, 1, 10);
		stringAnswer3 = ""+result;
		
		int position = random.nextInt(4-1)+1;
		if (position==1){
			answer1.setText(stringAnswer3);
			answer2.setText(stringAnswer2);
			answer3.setText(stringAnswer1);
		}if (position==2){
			answer1.setText(stringAnswer2);
			answer2.setText(stringAnswer3);
			answer3.setText(stringAnswer1);
		}if (position==3){
			answer1.setText(stringAnswer1);
			answer2.setText(stringAnswer2);
			answer3.setText(stringAnswer3);
		}
		
		dialogEquation.setText(""+equation);
	}

	public boolean answer(String equation, String answer){

		equationValue = EquationDecoder.equationDecoder(equation);
		answerValue = Integer.parseInt(answer);

		if (equationValue-answerValue==0){
			return true;
		}
		else {

			return false;
		}

	}
	
	private void disableCouds(){
		answer1.setEnabled(false);
		answer2.setEnabled(false);
		answer3.setEnabled(false);
	}

	Runnable tickOne = new Runnable() {
		
		@Override
		public void run() {
			countdown.setText("00:04");
			
		}
	};
	
	Runnable tickTwo = new Runnable() {
		
		@Override
		public void run() {
			countdown.setText("00:03");
			
		}
	};
	
	Runnable tickThree = new Runnable() {
		
		@Override
		public void run() {
			countdown.setText("00:02");
			
		}
	};
	
	Runnable tickFour = new Runnable() {
		
		@Override
		public void run() {
			countdown.setText("00:01");
			
		}
	};
	
	Runnable tickFive = new Runnable() {
		
		@Override
		public void run() {
			countdown.setText("00:00");
			
		}
	};



	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
