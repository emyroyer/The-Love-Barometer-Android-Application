package com.emer.vl.lovebarometer;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;


public class Link extends Activity {
	
	Button mClose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_link);
		
		// 1) How to replace link by text like "Click Here to visit Google" and
	    // the text is linked with the website url ?
	    TextView link = (TextView) findViewById(R.id.url);
	    String linkText = "Visit the <a href='https://play.google.com/store/apps/details?id=com.topnet999.android.filemanager&hl=en'>File Manager App</a> web page.";
	    link.setText(Html.fromHtml(linkText));
	    link.setMovementMethod(LinkMovementMethod.getInstance());
		
        mClose = (Button)findViewById(R.id.Close);
		mClose.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			//Je prends le screenshot et save l'image
			System.exit(0);
		}
		
		});
		
	}

	
	//Button to close the app
	//Et pub qui apparait

}
