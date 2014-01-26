package com.example.barcodescanningapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * This is demo code to accompany the Mobiletuts+ tutorial: - Using Barcode
 * Scanning in Android Apps
 * 
 * Sue Smith May 2013
 * 
 */
public class MainActivity extends Activity {

	// UI instance variables
	private TextView formatTxt, contentTxt;
	private ImageView homescreen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// instantiate UI items
		formatTxt = (TextView) findViewById(R.id.scan_format);
		contentTxt = (TextView) findViewById(R.id.scan_content);
		homescreen = (ImageView) findViewById(R.id.homescreen);

		homescreen.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent ev) {
				Log.d("onTouch", "Entered onTouch");
				final int action = ev.getAction();

				final int evX = (int) ev.getX();
				final int evY = (int) ev.getY();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					Log.d("onTouch", "Action Down");
					break;
				case MotionEvent.ACTION_UP:
					Log.d("onTouch", "Action Up");
					// On the UP, we do the click action.
					// The hidden image (image_areas) has three different
					// hotspots on
					// it.
					// The colors are red, blue, and yellow.
					// Use image_areas to determine which region the user
					// touched.
					// (2)
					Log.d("onTouch", "x=" + evX + ", y=" + evY);
					int touchColor = getHotspotColor(R.id.homescreen_mask, evX, evY);
					// Compare the touchColor to the expected values.
					// Switch to a different image, depending on what color was
					// touched.
					// Note that we use a Color Tool object to test whether the
					// observed color is close enough to the real color to
					// count as a match. We do this because colors on the screen
					// do
					// not match the map exactly because of scaling and
					// varying pixel density.
					int tolerance = 1000;
					// (3)
					Log.d("onTouch", "Color = " + touchColor + ", Expected Color = " + Color.RED);
					if (closeMatch(-1237980, touchColor, tolerance)) {
						Log.d("onTouch", "Changing intent to ProductInfo");
						startScan();
					} else if (closeMatch(-14503604, touchColor, tolerance)) {
						Log.d("onTouch", "Need to change Intent to login!!!!");
					}
					break;
				} // end switch

				Log.d("onTouch", "Done");
				return true;
			}
		});

		// listen for clicks
		Log.d("MainActivity", "Done with init");

	}
	
	public void switchToProductInfo() {
		Intent productInfoIntent = new Intent(this, ProductInfoActivity.class);
		startActivity(productInfoIntent);
	}
	
	public void switchToLogin() {
		Intent loginActivity = new Intent(this, LoginActivity.class);
		startActivity(loginActivity);
	}
	
	public void startScan() {
		//instantiate ZXing integration class
		//IntentIntegrator scanIntegrator = new IntentIntegrator(this);
		//start scanning
		//scanIntegrator.initiateScan();
		switchToProductInfo();
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		// retrieve result of scanning - instantiate ZXing object
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(
				requestCode, resultCode, intent);
		// check we have a valid result
		if (scanningResult != null) {
			// get content from Intent Result
			String scanContent = scanningResult.getContents();
			// get format name of data scanned
			String scanFormat = scanningResult.getFormatName();
			// output to UI
			formatTxt.setText("FORMAT: " + scanFormat);
			contentTxt.setText("CONTENT: " + scanContent);

			Intent productInfoIntent = new Intent(this,
					ProductInfoActivity.class);
			startActivity(productInfoIntent);
		} else {
			// invalid scan data or scan canceled
			Toast toast = Toast.makeText(getApplicationContext(),
					"No scan data received!", Toast.LENGTH_SHORT);
			toast.show();
		}
	}

	public int getHotspotColor(int hotspotId, int x, int y) {
		ImageView img = (ImageView) findViewById(hotspotId);
		img.setDrawingCacheEnabled(true);
		Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
		img.setDrawingCacheEnabled(false);
		return hotspots.getPixel(x, y);
	}

	public boolean closeMatch(int color1, int color2, int tolerance) {
		if ((int) Math.abs(color1 - color2) > tolerance)
			return false;
		return true;
	} // end match
}
