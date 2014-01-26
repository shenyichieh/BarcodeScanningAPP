package com.example.barcodescanningapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class Allergic extends Activity {

	private ImageView allergyScreen;
	private ImageView allergyMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allergic);

		allergyScreen = (ImageView) findViewById(R.id.allergy_bottom);
		allergyScreen.setTag(Boolean.TRUE); // Used to toggle image

		allergyMenu = (ImageView) findViewById(R.id.allergy_menu);

		allergyScreen.setOnTouchListener(new OnTouchListener() {
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
					int touchColor = getHotspotColor(R.id.allergy_bottom_mask,
							evX, evY);
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
					Log.d("onTouch", "Color = " + touchColor
							+ ", Expected Color = " + Color.RED);
					if (closeMatch(-1237980, touchColor, tolerance)) {
						Log.d("onTouch", "Changing image to selected image");
						if ((Boolean) allergyScreen.getTag()) {
							allergyScreen.setTag(Boolean.FALSE);
							allergyScreen
									.setImageResource(R.drawable.selectallergies_selected_bottom);
						} else {
							allergyScreen.setTag(Boolean.TRUE);
							allergyScreen
									.setImageResource(R.drawable.selectallergies_bottom);
						}

					}
					break;
				} // end switch

				Log.d("onTouch", "Done");
				return true;
			}
		});

		allergyMenu.setOnTouchListener(new OnTouchListener() {
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
					Log.d("onTouch", "x=" + evX + ", y=" + evY);
					int touchColor = getHotspotColor(R.id.allergy_menu_mask,
							evX, evY);
					int tolerance = 1000;
					// (3)
					Log.d("onTouch", "Color = " + touchColor
							+ ", Expected Color = " + Color.RED);
					if (closeMatch(-1237980, touchColor, tolerance)) {
						Log.d("onTouch", "Changing image to selected image");
						finishAction();
					}
					break;
				} // end switch

				Log.d("onTouch", "Done");
				return true;
			}
		});
	}

	private void finishAction() {
		finish();
	}

	@Override
	public void finish() {
		// Prepare data intent
		Intent data = new Intent();
		if ((Boolean) allergyScreen.getTag()) {
			// Set to the new chem image
			Log.d("finishAction", "Using new image");
			data.putExtra("newImage", R.drawable.selectallergies_bottom);
		} else {
			// retain existing image
			Log.d("finishAction", "Using old image");
			data.putExtra("newImage", R.drawable.productchemicals);
		}
		// Activity finished ok, return the data
		setResult(RESULT_OK, data);
		super.finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_info, menu);
		return true;
	}

	public int getHotspotColor(int hotspotId, int x, int y) {
		ImageView img = (ImageView) findViewById(hotspotId);
		Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
		return bitmap.getPixel(x, y);
	}

	public boolean closeMatch(int color1, int color2, int tolerance) {
		if ((int) Math.abs(color1 - color2) > tolerance)
			return false;
		return true;
	} // end match

}
