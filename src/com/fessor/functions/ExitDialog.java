package com.fessor.functions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.example.memorygame.R;
import com.fessor.activity.OperationPicker;

public class ExitDialog extends Dialog implements android.view.View.OnClickListener{

	public Activity activity;
	ImageButton exit;
	ImageButton cancel;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.exit_dialog);
	    
	    declareVariables();
	   

	    

	  }
	
	public ExitDialog(Activity a) {
		super(a);
		this.activity = a;
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.exitDialogTrue:
			intent = new Intent (activity, OperationPicker.class);
			activity.startActivity(intent);
			break;

		case R.id.exitDialogFalse:
			dismiss();
			break;
		}
		
	}
	
	private void declareVariables(){
		exit = (ImageButton) findViewById(R.id.exitDialogTrue);
		cancel = (ImageButton) findViewById(R.id.exitDialogFalse);
		
		exit.setOnClickListener(this);
		cancel.setOnClickListener(this);
		
		
	}

}
