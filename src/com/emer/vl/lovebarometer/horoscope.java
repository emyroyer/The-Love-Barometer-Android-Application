package com.emer.vl.lovebarometer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.*;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class horoscope extends Activity {


	public static final String EXTRA_ANSWER_IS_TRUE = 
			"com.emer.vl.lovebarometer.answer_is_true";
	
	String mAnswerIsTrue; 
	TextView mRep;
	String MoinsCinq, MoinsQuatre, MoinsTrois, MoinsDeux, MoinsUn, Zero, Un, Deux,
	               Trois, Quatre, Cinq;

    Button mScreen_button;
	ImageView mRepHeart;
	AdView adView;
	private static final String AD_UNIT_ID = "ca-app-pub-7153081403932123/3746922699";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.horoscope);
		
		//Ads
	    // Create the adView.
	    AdView adView = new AdView(this);
	    adView.setAdUnitId(AD_UNIT_ID);
	    adView.setAdSize(AdSize.SMART_BANNER);
	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout".
		LinearLayout layout = (LinearLayout)findViewById(R.id.adLayout);

	    // Add the adView to it.
	       layout.addView(adView);

	    // Initiate a generic request.
           AdRequest adRequest = new AdRequest.Builder().build();
	    
	    // Load the adView with the ad request.
	       adView.loadAd(adRequest);

	    //Continue App
		
		mAnswerIsTrue = getIntent().getStringExtra(EXTRA_ANSWER_IS_TRUE);
		MoinsCinq = "MoinsCinq";
		MoinsQuatre = "MoinsQuatre";
		MoinsTrois = "MoinsTrois";
		MoinsDeux = "MoinsDeux";
		MoinsUn = "MoinsUn";
		Zero = "Zero";
		Un = "Un";
		Deux = "Deux";
		Trois = "Trois";
		Quatre = "Quatre";
		Cinq = "Cinq";
		
		System.out.println(mAnswerIsTrue);
		
		mRep = (TextView)findViewById(R.id.Rep);
		mRepHeart = (ImageView)findViewById(R.id.RepHeart);
		if (mAnswerIsTrue.equals(MoinsCinq)) {
		mRep.setText(R.string.Rep5m);
		mRepHeart.setImageResource(R.drawable.heart5m);
	    }
		else if (mAnswerIsTrue.equals(MoinsQuatre)) {
		mRep.setText(R.string.Rep4m);
		mRepHeart.setImageResource(R.drawable.heart4m);
	    }
		else if (mAnswerIsTrue.equals(MoinsTrois)) {
		mRep.setText(R.string.Rep3m);
		mRepHeart.setImageResource(R.drawable.heart3m);
	    }
		else if (mAnswerIsTrue.equals(MoinsDeux)) {
		mRep.setText(R.string.Rep2m);
		mRepHeart.setImageResource(R.drawable.heart2m);
	    }
		else if (mAnswerIsTrue.equals(MoinsUn)) {
		mRep.setText(R.string.Rep1m);
		mRepHeart.setImageResource(R.drawable.heart1m);
	    }
		else if (mAnswerIsTrue.equals(Zero)) {
		mRep.setText(R.string.Rep0);
		mRepHeart.setImageResource(R.drawable.heart0);
	    }
		else if (mAnswerIsTrue.equals(Un)) {
		mRep.setText(R.string.Rep1);
		mRepHeart.setImageResource(R.drawable.heart1);
	    }
		else if (mAnswerIsTrue.equals(Deux)) {
		mRep.setText(R.string.Rep2);
		mRepHeart.setImageResource(R.drawable.heart2);
	    }
		else if (mAnswerIsTrue.equals(Trois)) {
		mRep.setText(R.string.Rep3);
		mRepHeart.setImageResource(R.drawable.heart3);
	    }
		else if (mAnswerIsTrue.equals(Quatre)) {
		mRep.setText(R.string.Rep4);
		mRepHeart.setImageResource(R.drawable.heart4);
	    }
		else if (mAnswerIsTrue.equals(Cinq)) {
		mRep.setText(R.string.Rep5);
		mRepHeart.setImageResource(R.drawable.heart5);
	    }
		else {
    		mRep.setText(R.string.Rep5);
    		mRepHeart.setImageResource(R.drawable.heart5);
    	}


		//Take the screenshot
        mScreen_button = (Button)findViewById(R.id.Screen_button);
		mScreen_button.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			//Je prends le screenshot et save l'image
		       Bitmap bitmap = takeScreenshot();
		       saveBitmap(bitmap);
		       System.out.print("Screen taken!");
		}
		
		});
	
	}

	
	public Bitmap takeScreenshot() {
		   View rootView = findViewById(android.R.id.content).getRootView();
		   rootView.setDrawingCacheEnabled(true);
		   return rootView.getDrawingCache();
		}

	
	public void saveBitmap(Bitmap bitmap) {
	    File imagePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/screenshot.png");
	    FileOutputStream fos = null;
	    String filePath = imagePath.getAbsolutePath();
        System.out.println("file path is"+filePath);
	    try {
	        fos = new FileOutputStream(imagePath);
	        //File file = new File(imagePath, "DemoPicture.jpg");
	        bitmap.compress(CompressFormat.JPEG, 100, fos);
	        fos.flush();
	        fos.close();
	    } catch (FileNotFoundException e) {
	        Log.e("GREC", e.getMessage(), e);
	    } catch (IOException e) {
	        Log.e("GREC", e.getMessage(), e);
	    }

	
	//Start Link activity
	TimerTask task = new TimerTask() {
		@Override
	public void run() {
	Intent linka = new Intent(horoscope.this, Link.class);
	startActivity(linka);
	finish();
	}
	};
    Timer t = new Timer();
    t.schedule(task, 2000);
}
}
		


