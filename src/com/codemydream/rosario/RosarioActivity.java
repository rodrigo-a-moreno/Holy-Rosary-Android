package com.codemydream.rosario;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class RosarioActivity extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initial);
        
        Button btnNewRosary = (Button)findViewById(R.id.btnNewRosary);
        btnNewRosary.setOnClickListener(mNewRosaryClickListener);
        
        Button btnNext = (Button)findViewById(R.id.btnNext);
        btnNext.setOnClickListener(mNextClickListener);

        Button btnPrevious = (Button)findViewById(R.id.btnPrevious);
        btnPrevious.setOnClickListener(mPreviousClickListener);
        
        //Display display = getWindowManager().getDefaultDisplay(); 
        //int width = display.getWidth();
        //int height = display.getHeight();
        
        ScrollView ScrollViewBody = (ScrollView)findViewById(R.id.ScrollViewBody);
        ScrollViewBody.setPadding(10, 5, 10, 50);
    }
    
    /* Creates the menu items */
    final static int MENU_MAIN = 2;
    final static int MENU_NEW_ROSARY = 0;
    final static int MENU_QUIT = 1;
    int curStep = 0;
    int curMistery = 0;
        
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(0, MENU_MAIN, 0, R.string.Main);
    	menu.add(0, MENU_NEW_ROSARY, 0, R.string.NewRosary);
        menu.add(0, MENU_QUIT, 0, R.string.Quit);
        return true;
    }

    /* Handles item selections */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU_MAIN:
        	SetMainScreen();
            return true;
        case MENU_NEW_ROSARY:
        	SetNewRosarySequence();
            return true;
        case MENU_QUIT:
        	finish();
            return true;
        }
        return false;
    }
    
    public void steps(TextView txtTitle, TextView txtBody, int step) {
    	String strTemp, strIndex;
    	Log.i("steps", "Current step: " + String.valueOf(step));
    	switch(step) {
    	case 0:
    		txtTitle.setText(R.string.Step0Title);
            txtBody.setText(R.string.Step0Body);
    		break;
       	case 1:
       	case 8:
       	case 22:
       		// Our Father
    		txtTitle.setText(R.string.OurFatherTitle);
            txtBody.setText(R.string.OurFather);
    		break;
       	case 2:
    		txtTitle.setText(R.string.Step2Title);
            txtBody.setText(R.string.Step2Body);
    		break;
       	case 3:
       	case 4:
       	case 5:
       		// First three HailMary
       		strTemp = RosarioActivity.this.getString(R.string.Step3Body);
       		String strHailMary = RosarioActivity.this.getString(R.string.HailMary);
       		strTemp = strTemp.replace("<<HailMary>>", strHailMary);
       		strIndex = String.valueOf(step-2);
       		strTemp = strTemp.replace("<<Index>>", strIndex);
       		
    		txtTitle.setText(R.string.Step3Title);
            txtBody.setText(strTemp);
    		break;
       	case 6:
       	case 19:
       	case 34:
       		// Glory
       		txtTitle.setText(R.string.GloryTitle);
            txtBody.setText(R.string.Glory);
            break;
       	case 7:
       		// First Mystery 
       		strTemp = RosarioActivity.this.getString(R.string.misteryTitle);
       		strIndex = String.valueOf(step-6);
       		strTemp = strTemp.replace("<<Index>>", strIndex);
       		txtTitle.setText(strTemp);
            txtBody.setText(GetMistery(step-6));
    		break;
       	case 9:
       	case 10:
       	case 11:
       	case 12:
       	case 13:
       	case 14:
       	case 15:
       	case 16:
       	case 17:
       	case 18:
       		
       	case 23:
       	case 24:
       	case 25:
       	case 26:
       	case 27:
       	case 28:
       	case 29:
       	case 30:
       	case 31:
       	case 32:
       		strTemp = RosarioActivity.this.getString(R.string.TenHailMary);
       		strIndex = String.valueOf(step-8);
       		strTemp = strTemp.replace("<<Index>>", strIndex);
       		
    		txtTitle.setText(strTemp);
            txtBody.setText(R.string.HailMary);
    		break;
       	case 20:
       	case 33:
       		txtTitle.setText(R.string.JaculatoriaTitle);
            txtBody.setText(R.string.Jaculatoria);
            break;
       	case 21:
       		// Second Mystery 
       		strTemp = RosarioActivity.this.getString(R.string.misteryTitle);
       		strIndex = String.valueOf(step-19);
       		strTemp = strTemp.replace("<<Index>>", strIndex);
       		txtTitle.setText(strTemp);
            txtBody.setText(GetMistery(step-19));
    		break;
       	case 35:
       		// Second Mystery 
       		strTemp = RosarioActivity.this.getString(R.string.misteryTitle);
       		strIndex = String.valueOf(step-32);
       		strTemp = strTemp.replace("<<Index>>", strIndex);
       		txtTitle.setText(strTemp);
            txtBody.setText(GetMistery(step-32));
    		break;
    	}
    }
    
    private String GetMistery(int step) {
    	switch(curMistery) {
    	case 0:
    		switch(step) {
    		case 0:
    			return RosarioActivity.this.getString(R.string.Mistery1_1);
    		case 1:
    			return RosarioActivity.this.getString(R.string.Mistery1_2);
    		case 2:
    			return RosarioActivity.this.getString(R.string.Mistery1_3);
    		case 3:
    			return RosarioActivity.this.getString(R.string.Mistery1_4);
    		case 4:
    			return RosarioActivity.this.getString(R.string.Mistery1_5);
    		}
    	}
    	return "";
    }
    
    private void SetMainScreen() {
    	Button btnNewRosary = (Button)findViewById(R.id.btnNewRosary);
    	btnNewRosary.setVisibility(View.VISIBLE);
    	
    	RelativeLayout lytMainText = (RelativeLayout)findViewById(R.id.lytMainText);
    	lytMainText.setVisibility(View.GONE);
    }
    
    private void SetNewRosarySequence() {
    	final CharSequence[] items = {"Mistery1", "Mistery2", "Mistery3", "Mistery4"};
    	
    	items[0] = "Gozosos lun,sab";
    	items[1] = "Dolorosos mar,vie";
    	items[2] = "Luminosos jue";
    	items[3] = "Gloriosos mie/dom";

    	AlertDialog.Builder builder = new AlertDialog.Builder(RosarioActivity.this);
    	builder.setTitle(R.string.SelectMisteries);
    	builder.setItems(items, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
    	        
    	        Button btnNewRosary = (Button)findViewById(R.id.btnNewRosary);
    	        btnNewRosary.setVisibility(View.GONE);
    	        
    	        RelativeLayout lytMainText = (RelativeLayout)findViewById(R.id.lytMainText);
    	        lytMainText.setVisibility(View.VISIBLE);
    	        
    	        TextView txtTitle = (TextView)findViewById(R.id.txtTitle);
    	        TextView txtBody = (TextView)findViewById(R.id.txtBody);
    	        
    	        curMistery = item;
    	        curStep = 0;
    	        RosarioActivity.this.steps(txtTitle, txtBody, curStep);
    	    }
    	});
    	
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
    private OnClickListener mNextClickListener = new OnClickListener() {
        public void onClick(View v) {
        	//Toast.makeText(getApplicationContext(), R.string.Next, Toast.LENGTH_SHORT).show();
        	
        	TextView txtTitle = (TextView)findViewById(R.id.txtTitle);
	        TextView txtBody = (TextView)findViewById(R.id.txtBody);
	        
	        curStep++;
	        RosarioActivity.this.steps(txtTitle, txtBody, curStep);
        }
    };
    
    private OnClickListener mPreviousClickListener = new OnClickListener() {
        public void onClick(View v) {
        	//Toast.makeText(getApplicationContext(), R.string.Previous, Toast.LENGTH_SHORT).show();
        	
        	TextView txtTitle = (TextView)findViewById(R.id.txtTitle);
	        TextView txtBody = (TextView)findViewById(R.id.txtBody);
	        
	        curStep--;
	        RosarioActivity.this.steps(txtTitle, txtBody, curStep);
        }
    };
    
    private OnClickListener mNewRosaryClickListener = new OnClickListener() {
        public void onClick(View v) {
        	SetNewRosarySequence();
        }
    };
}