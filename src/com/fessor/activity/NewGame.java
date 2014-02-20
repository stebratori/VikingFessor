package com.fessor.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.memorygame.R;
import com.fessor.constants.Constants;
import com.fessor.model.Player;
import com.fessor.model.SqlPrepare;

	

public class NewGame extends Activity implements OnClickListener{
	
	ImageView fessor, newPlayerAlertBck, deletePLayerAlertBck, deletePLayerExclamation,deletePlayerBin;
	ImageButton newPlayer;
	Button selectPlayer, deletePlayerAlert, deletePlayer, deletePlayerCancel, newPlayerCreate, newPlayerCancel, newPlayerAlert, nextPlayer, previousPlayer;
	TextView playerName, newPlayerName;
	private int playerIndex = -1;
	SqlPrepare db = new SqlPrepare(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game);
		
		declareVariables();
		populatePlayersArray();
		
	}

	private void declareVariables(){
	
		// ** IMAGES **
		fessor = (ImageView) findViewById(R.id.newGameImgFessor);
		newPlayerAlertBck = (ImageView) findViewById(R.id.newgameNewPlayerBck);
		deletePLayerAlertBck = (ImageView) findViewById(R.id.newGameImgDeletePlayerAlert);
		deletePLayerExclamation = (ImageView) findViewById(R.id.NewPlayerDeletePlayerAlertExclamation);
		deletePlayerBin = (ImageView) findViewById(R.id.NewPlayerDeletePlayerAlertBin);
		
		// ** BUTTONS**
		newPlayer = (ImageButton) findViewById(R.id.newPlayerBtnNewPlayer);
		selectPlayer = (Button)findViewById(R.id.newGameBtnPickPlayer);
		deletePlayerAlert = (Button)findViewById(R.id.newGameBtnDeleteAlertShow);
		deletePlayer = (Button)findViewById(R.id.newGameBtnDeletePlayerAlertDelete);
		deletePlayerCancel = (Button)findViewById(R.id.newGameBtnDeletePlayerAlertCancel);
		newPlayerCreate = (Button)findViewById(R.id.newGameBtnNewPlayerCreate);
		newPlayerCancel = (Button)findViewById(R.id.newGameBtnNewPlayerCancel);
		nextPlayer = (Button)findViewById(R.id.newGameBtnNext);
		previousPlayer = (Button)findViewById(R.id.newGameBtnPrevious);
		
		// ** BUTTONS onClickListeners **
		
		newPlayer.setOnClickListener(this);
		selectPlayer.setOnClickListener(this);
		deletePlayerAlert.setOnClickListener(this);
		deletePlayer.setOnClickListener(this);
		deletePlayerCancel.setOnClickListener(this);
		newPlayerCancel.setOnClickListener(this);
		newPlayerCreate.setOnClickListener(this);
		nextPlayer.setOnClickListener(this);
		previousPlayer.setOnClickListener(this);
		
		// ** TEXT **
		playerName= (TextView)findViewById(R.id.newGamePlayerName);
		newPlayerName = (TextView) findViewById(R.id.newPlayerName);
		
	}

	private void newPlayerAlert(){
		
		newPlayerAlertBck.setVisibility(View.VISIBLE);
		newPlayerName.setVisibility(View.VISIBLE);
		newPlayerCreate.setVisibility(View.VISIBLE);
		newPlayerCancel.setVisibility(View.VISIBLE);
		
		((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE))
        .showSoftInput(newPlayerName, InputMethodManager.SHOW_FORCED);
		
		newPlayerName.requestFocus();
		
	}
	
	private void newPlayerAlertClose(){
		
		newPlayerAlertBck.setVisibility(View.INVISIBLE);
		newPlayerName.setVisibility(View.INVISIBLE);
		newPlayerCreate.setVisibility(View.INVISIBLE);
		newPlayerCancel.setVisibility(View.INVISIBLE);
		
		
		
	}
	
	private void deletePlayerMethod(){
		if(playerIndex>-1){
			
			db.deletePlayer(db.getPlayer(playerIndex+1));
			Constants.players=db.getAllPlayers();
			if (Constants.players.size()>0){
				playerIndex--;
				Constants.setPlayer(Constants.players.get(playerIndex));
			}else{
				playerIndex = -1;
				Constants.setPlayer(null);
			}
			
			populatePlayersArray();
			
			
		}
	}
	
	private void deletePlayerAlert(){
		
		deletePlayer.setVisibility(View.VISIBLE);
		deletePLayerAlertBck.setVisibility(View.VISIBLE);
		deletePlayerCancel.setVisibility(View.VISIBLE);
		deletePLayerExclamation.setVisibility(View.VISIBLE);
		deletePlayerBin.setVisibility(View.VISIBLE);
		
		
		
	}
	
	private void deletePlayerAlertClose(){
		
		deletePlayer.setVisibility(View.INVISIBLE);
		deletePLayerAlertBck.setVisibility(View.INVISIBLE);
		deletePlayerCancel.setVisibility(View.INVISIBLE);
		deletePLayerExclamation.setVisibility(View.INVISIBLE);
		deletePlayerBin.setVisibility(View.INVISIBLE);
		
		
		
	}

	private void createNewPlayer(){
		if (newPlayerName.length()>0){
			
			Player player = new Player(0, newPlayerName.getText().toString(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
			
			db.addPlayer(player);
			
			//Constants.players = db.getAllPlayers();
			Constants.setPlayers(db.getAllPlayers());
			playerIndex=Constants.players.size()-1;
			Constants.setPlayer(db.getPlayer(playerIndex));
			
			
			Intent intent = new Intent(this, OperationPicker.class);
			startActivity(intent);
		}
	}

	private void populatePlayersArray(){
		if (Constants.getPlayers().size()>0){
			
			playerIndex=0;
			dressFessor();
			enableButtons();
			
		}
		else{
			
			disableButtons();
			fessor.setImageResource(R.drawable.costume_gray);
			playerName.setText(" ");
		}
	}
	
	private void dressFessor(){
		
		fessor.setImageResource(R.drawable.costume_fessor);
		playerName.setText("Professor "+Constants.getPlayer().getName());
		
		if (Constants.player.getHero() == 1){
			fessor.setImageResource(R.drawable.costume_hero);
			playerName.setText("Super "+Constants.getPlayer().getName());
		}
		if (Constants.player.getCowboy() == 1){
			fessor.setImageResource(R.drawable.costume_cowboy);
			playerName.setText("Sheriff "+Constants.getPlayer().getName());
		}
		if (Constants.player.getIndian() == 1){
			fessor.setImageResource(R.drawable.costume_indian);
			playerName.setText("Chief "+Constants.getPlayer().getName());
		}
		if (Constants.player.getPirate() == 1){
			fessor.setImageResource(R.drawable.costume_pirate);
			playerName.setText("Captain "+Constants.getPlayer().getName());
		}
		if (Constants.player.getViking() == 1){
			fessor.setImageResource(R.drawable.costume_viking);
			playerName.setText(Constants.getPlayer().getName()+" The Great");
		}
	}

	private void enableButtons(){
		selectPlayer.setEnabled(true);
		deletePlayer.setEnabled(true);
	}
	
	private void disableButtons(){
		selectPlayer.setEnabled(false);
		deletePlayer.setEnabled(false);
	}

	private void nextPlayer(){
		Log.v("next",""+playerIndex);
		if(Constants.getPlayers().size()>1){
			if (Constants.getPlayers().get(playerIndex+1)!=null){
				Constants.setPlayer(Constants.getPlayers().get(playerIndex+1));
				playerIndex++;
				Log.v("new index",""+playerIndex);
			}else{
				//Constants.setPlayer(Constants.getPlayers().get(0));
				Constants.player = Constants.players.get(0);
				playerIndex=0;
			}
			populatePlayersArray();
		}
			
	}
	
	private void prevPlayer(){
		if(Constants.getPlayers().size()>1){
			Log.v("prev",""+playerIndex);
			if (Constants.getPlayers().get(playerIndex-1)!=null){
				Constants.setPlayer(Constants.getPlayers().get(playerIndex-1)) ;
				playerIndex--;
			}else{
				Constants.setPlayer(Constants.getPlayers().get(playerIndex-1));
				playerIndex=Constants.getPlayers().size()-1;
			}
			populatePlayersArray();
		}
			
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
		case R.id.newPlayerBtnNewPlayer:
			newPlayerAlert();
			Log.v("Clicked","newPlayerBtnNewPlayer");
			break;

		case R.id.newGameBtnPickPlayer:
			Intent intent = new Intent(this,OperationPicker.class);
			startActivity(intent);
			break;
			
		case R.id.newGameBtnDeleteAlertShow:
			deletePlayerAlert();
			Log.v("Clicked","newGameBtnDeleteAlertShow");
			break;
			
		case R.id.newGameBtnDeletePlayerAlertDelete:
			
			deletePlayerAlertClose();
			deletePlayerMethod();
			Log.v("Clicked","newGameBtnDeletePlayerAlertDelete");
			break;
			
		case R.id.newGameBtnDeletePlayerAlertCancel:
			deletePlayerAlertClose();
			Log.v("Clicked","newGameBtnDeletePlayerAlertCancel");
			break;
			
		case R.id.newGameBtnNewPlayerCreate:
			createNewPlayer();
			Log.v("Clicked","newGameBtnNewPlayerCreate");
			break;
			
		case R.id.newGameBtnNewPlayerCancel:
			newPlayerAlertClose();
			Log.v("Clicked","newGameBtnNewPlayerCancel");
			break;
			
		case R.id.newGameBtnNext:
			nextPlayer();
			Log.v("Clicked","newGameBtnNext");
			break;
			
		case R.id.newGameBtnPrevious:
			prevPlayer();
			Log.v("Clicked","newGameBtnPrevious");
			break;
		}
		
	}










}
