package com.fessor.functions;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.memorygame.R;
import com.fessor.activity.ShopActivity;
import com.fessor.constants.Constants;


public class ShopDialog extends Dialog implements android.view.View.OnClickListener{

	public Activity activity;
	private ImageView fessor, coinsImg;
	private Button yes, no;
	private TextView coins;
	private int pickedFessor;
	
	
	public ShopDialog(Activity a, int fessor) {
		super(a);
		this.pickedFessor = fessor;
		this.activity = a;
	}

	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.shop_dialog);
	    
	    declareVariables();
	    dressFessor();
	    
	    

	  }
	
	private void declareVariables(){
		
		fessor = (ImageView) findViewById(R.id.shopAlertFessor);
		coinsImg = (ImageView)findViewById(R.id.shopAlertCoinsImage);
		yes = (Button)findViewById(R.id.shopAlertYES);
		no = (Button)findViewById(R.id.shopAlertNO);
		coins = (TextView)findViewById(R.id.shopAlertCoins);
		
		yes.setOnClickListener(this);
		no.setOnClickListener(this);
	
	}
	
	private void dressFessor(){
		
		switch (pickedFessor) {
		
			case 0:
				fessor.setImageResource(R.drawable.costume_fessor);
				coins.setVisibility(View.INVISIBLE);
				coinsImg.setVisibility(View.INVISIBLE);
				yes.setEnabled(true);
				yes.setAlpha(1);
			break;

			case 1:
				fessor.setImageResource(R.drawable.costume_hero);
				if(Constants.getPlayer().getHero() == 0){
					
					if (Constants.presentOperation == Constants.plus){
						if (Constants.getPlayer().getPlusCoins()>19){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
						coins.setText("20");
					}else{
						if (Constants.getPlayer().getMinusCoins()>19){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
						coins.setText("20");
					}
					
				}else{
					coins.setVisibility(View.INVISIBLE);
					coinsImg.setVisibility(View.INVISIBLE);
				}
			break;
			
			case 2:
				fessor.setImageResource(R.drawable.costume_cowboy);
				if(Constants.getPlayer().getCowboy() == 0){
					coins.setText("40");
					
					// plus
					if (Constants.presentOperation == Constants.plus){
						if (Constants.getPlayer().getPlusCoins()>39){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
						coins.setText("40");
					}else{
						if (Constants.getPlayer().getMinusCoins()>39){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
					}
				
				
				
				
				
				
				
				
				}else{
					coins.setVisibility(View.INVISIBLE);
					coinsImg.setVisibility(View.INVISIBLE);
				}
			break;

			case 3:
				fessor.setImageResource(R.drawable.costume_indian);	
				if(Constants.getPlayer().getIndian() == 0){
					coins.setText("60");
					
					
					// plus
					if (Constants.presentOperation == Constants.plus){
						if (Constants.getPlayer().getPlusCoins()>59){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
						coins.setText("60");
					}else{
						if (Constants.getPlayer().getMinusCoins()>59){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
					}
				
				
				}else{
					coins.setVisibility(View.INVISIBLE);
					coinsImg.setVisibility(View.INVISIBLE);
				}
			break;
				
			case 4:
				fessor.setImageResource(R.drawable.costume_pirate);	
				if(Constants.getPlayer().getPirate() == 0){
					coins.setText("80");
					
					
					// plus
					if (Constants.presentOperation == Constants.plus){
						if (Constants.getPlayer().getPlusCoins()>79){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
						coins.setText("80");
					}else{
						if (Constants.getPlayer().getMinusCoins()>79){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
					}
				
				
				
				
				}else{
					coins.setVisibility(View.INVISIBLE);
					coinsImg.setVisibility(View.INVISIBLE);
				}
			break;

			case 5:
				fessor.setImageResource(R.drawable.costume_viking);		
				if(Constants.getPlayer().getViking() == 0){
					coins.setText("100");
					// plus
					if (Constants.presentOperation == Constants.plus){
						if (Constants.getPlayer().getPlusCoins()>99){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
						coins.setText("100");
					}else{
						if (Constants.getPlayer().getMinusCoins()>99){
							yes.setEnabled(true);
							yes.setAlpha(1);
						}else{yes.setAlpha((float) 0.5);}
					}
					
				}else{
					
					coins.setVisibility(View.INVISIBLE);
					coinsImg.setVisibility(View.INVISIBLE);
				}
			break;
		}
	}
	
	@Override
	public void onClick(View v) {
	
		
		switch (v.getId()) {
		
			case R.id.shopAlertYES:
				
				switch (pickedFessor) {
				
				case 0:
					Constants.setPresentFessorCostume(0);
					break;

				case 1:
					Constants.setPresentFessorCostume(1);
					Constants.getPlayer().setHero(1);
					
					if (Constants.presentOperation == Constants.plus){
						Constants.getPlayer().setPlusCoins(Constants.getPlayer().getPlusCoins()-20);  
					}else{
						Constants.getPlayer().setMinusCoins(Constants.getPlayer().getMinusCoins()-20);
					}
					
					break;
				
				case 2:
					Constants.setPresentFessorCostume(2);
					Constants.getPlayer().setCowboy(1);
					if (Constants.presentOperation == Constants.plus){
						Constants.getPlayer().setPlusCoins(Constants.getPlayer().getPlusCoins()-40);  
					}else{
						Constants.getPlayer().setMinusCoins(Constants.getPlayer().getMinusCoins()-40);
					}
					break;

				case 3:
					Constants.setPresentFessorCostume(3);
					Constants.getPlayer().setIndian(1);
					if (Constants.presentOperation == Constants.plus){
						Constants.getPlayer().setPlusCoins(Constants.getPlayer().getPlusCoins()-60);  
					}else{
						Constants.getPlayer().setMinusCoins(Constants.getPlayer().getMinusCoins()-60);
					}
					break;
					
				case 4:
					Constants.setPresentFessorCostume(4);
					Constants.getPlayer().setPirate(1);
					if (Constants.presentOperation == Constants.plus){
						Constants.getPlayer().setPlusCoins(Constants.getPlayer().getPlusCoins()-20);  
					}else{
						Constants.getPlayer().setMinusCoins(Constants.getPlayer().getMinusCoins()-80);
					}
					break;

				case 5:
					Constants.setPresentFessorCostume(5);
					Constants.getPlayer().setViking(1);
					if (Constants.presentOperation == Constants.plus){
						Constants.getPlayer().setPlusCoins(Constants.getPlayer().getPlusCoins()-100);  
					}else{
						Constants.getPlayer().setMinusCoins(Constants.getPlayer().getMinusCoins()-100);
					}
					break;
			}
				
				dismiss();
				ShopActivity.setLocks();
				ShopActivity.setCoins();
				break;

				
				
			case R.id.shopAlertNO:
				dismiss();
				break;
		}
	}
	
	
	
	
	
	
	
}
