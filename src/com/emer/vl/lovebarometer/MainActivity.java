package com.emer.vl.lovebarometer;

import javax.microedition.khronos.egl.EGL11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	// Use these as keys when you're saving state between reconfigurations
	//private static final String RESULTS_KEY = "Results";
	
	int counter = 0;
	String horo;
	TextView mResults;
	
	EGL11 egl;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mResults = (TextView)findViewById(R.id.Results);
		
		// Has previous state been saved?
		if (savedInstanceState != null) {
			// Restore value of counters from saved state
		    counter = savedInstanceState.getInt("Results");
		}
		
		Button launchActivitymPlus_button = (Button)findViewById(R.id.Plus_button);
		launchActivitymPlus_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter = counter + 1;
			     if (counter >5 ) {
			    		counter = 5;
			    	}
			     displayCounts();

				 switch (counter) {
				 case -5: horo = "MoinsCinq";
                 break;
				 case -4: horo = "MoinsQuatre";
                 break;
				 case -3: horo = "MoinsTrois";
                 break;
				 case -2: horo = "MoinsDeux";
                 break;
				 case -1: horo = "MoinsUn";
                 break;
				 case 0: horo = "Zero";
                 break;
				 case 1: horo = "Un";
                 break;
				 case 2: horo = "Deux";
                 break;
				 case 3: horo = "Trois";
                 break;
				 case 4: horo = "Quatre";
                 break;
				 case 5: horo = "Cinq";
                 break;
		         default: horo = "Cinq";
		         break;
		        }
			}
		});
		
		Button launchActivitymMoins_button = (Button)findViewById(R.id.Moins_button);
		launchActivitymMoins_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter = counter -1;
				 if (counter < -5 ) {
			    		counter = -5;
			    	} 
				 
				 displayCounts();
				 
				 switch (counter) {
				 case -5: horo = "MoinsCinq";
                 break;
				 case -4: horo = "MoinsQuatre";
                 break;
				 case -3: horo = "MoinsTrois";
                 break;
				 case -2: horo = "MoinsDeux";
                 break;
				 case -1: horo = "MoinsUn";
                 break;
				 case 0: horo = "Zero";
                 break;
				 case 1: horo = "Un";
                 break;
				 case 2: horo = "Deux";
                 break;
				 case 3: horo = "Trois";
                 break;
				 case 4: horo = "Quatre";
                 break;
				 case 5: horo = "Cinq";
                 break;
		         default: horo = "Cinq";
		         break;
		        }
				
			}
		});
		    	
		
		Button launchActivitymInterpret_button = (Button)findViewById(R.id.Interpret_button);
		launchActivitymInterpret_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//start horoscope
				Intent horoscop = new Intent(MainActivity.this, horoscope.class);
			    String answerIsTrue = horo;
				horoscop.putExtra(horoscope.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
				startActivity(horoscop);
				
			}
		}); 
		
	} //End of OnCreate(Bundle)

	//@Override
	//public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
	//	getMenuInflater().inflate(R.menu.main, menu);
	//	return true;
	//}
	
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// Save state information with a collection of key-value pairs
		savedInstanceState.putInt("OnCreate", counter);
	}
	
	// Updates the displayed counters
	// This method expects that the counters and TextView variables use the
	// names
	// specified above
	public void displayCounts() {
		mResults.setText("Your total is " + counter);

	}

}
