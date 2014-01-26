package com.example.barcodescanningapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ProductInfoActivity extends Activity implements OnClickListener {

	private Button alergyButton;
	private ImageView productChemicals;
	private boolean changeImage = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("onCreate", "starting up product info!");
		setContentView(R.layout.activity_product_info);

		alergyButton = (Button) findViewById(R.id.alergies);
		productChemicals = (ImageView) findViewById(R.id.product_chemicals);

		alergyButton.setOnClickListener(this);

		// TextView lView = (TextView)findViewById(R.id.productName);
		// lView.setText(ProductMockData.getProduct1().getName());
	}

	public void onClick(View v) {
		// check for scan button
		if (v.getId() == R.id.alergies) {
			Intent allergies = new Intent(this, Allergic.class);
			startActivity(allergies);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_info, menu);
		return true;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d("activityResult", "Checking result of last activity");
		if (resultCode == RESULT_OK) {
			super.onActivityResult(requestCode, resultCode, data);
			int newImage = data.getIntExtra("newImage",	R.drawable.productchemicals);
			Log.d("activityResult", "Activity result was: " + newImage);
			productChemicals.setImageResource(newImage);
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Log.d("onStart", "Entering onStart");
		if (changeImage)
			productChemicals.setImageResource(R.drawable.selectallergies_bottom);
		else
			productChemicals.setImageResource(R.drawable.productchemicals);
	}
}
