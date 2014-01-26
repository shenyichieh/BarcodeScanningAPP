package com.example.barcodescanningapp;

<<<<<<< HEAD

import com.example.barcodescanningapp.cosmetic.ProductMockData;
import com.google.zxing.integration.android.IntentIntegrator;

>>>>>>> 4ad99f12a2d7c6330148d1f83848844fbe5f36a9
=======
>>>>>>> 00fdb14cadc69e52da26bbfced2ac1947fda7b48
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
<<<<<<< HEAD
=======
import android.widget.TextView;

public class ProductInfoActivity extends Activity {

=======
import android.widget.ImageView;
>>>>>>> 00fdb14cadc69e52da26bbfced2ac1947fda7b48

public class ProductInfoActivity extends Activity implements OnClickListener {

	private Button alergyButton;
	private ImageView productChemicals;
	private boolean changeImage = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("onCreate", "starting up product info!");
		setContentView(R.layout.activity_product_info);

<<<<<<< HEAD

	public void onClick(View v) {
		// check for scan button
		System.out.println("SSSSS");
		if (v.getId() == R.id.alergies) {
			
			Intent productInfoIntent = new Intent(this, Allergic.class);
		    startActivity(productInfoIntent);
=======
		alergyButton = (Button) findViewById(R.id.alergies);
		productChemicals = (ImageView) findViewById(R.id.product_chemicals);

		alergyButton.setOnClickListener(this);

>>>>>>> 00fdb14cadc69e52da26bbfced2ac1947fda7b48
		// TextView lView = (TextView)findViewById(R.id.productName);
		// lView.setText(ProductMockData.getProduct1().getName());
	}

	public void onClick(View v) {
		// check for scan button
		if (v.getId() == R.id.alergies) {
<<<<<<< HEAD
			// instantiate ZXing integration class
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			// start scanning
			scanIntegrator.initiateScan();

=======
			Intent allergies = new Intent(this, Allergic.class);
			startActivity(allergies);
>>>>>>> 00fdb14cadc69e52da26bbfced2ac1947fda7b48
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
