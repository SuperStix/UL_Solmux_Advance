package com.unilab.ul_solmux_advance;

import android.app.Activity;
import android.os.Bundle;

public class Exiter extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		finish();
		
		// Android will clean up the process automatically. But hey, if you
		// need to kill the process yourself, don't let me stop you.
		System.exit(0);
	}
 
}
