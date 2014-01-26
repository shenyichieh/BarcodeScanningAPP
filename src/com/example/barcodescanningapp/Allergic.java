package com.example.barcodescanningapp;

import com.example.barcodescanningapp.cosmetic.ProductMockData;
import com.google.zxing.integration.android.IntentIntegrator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Allergic extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allergic);

		// TextView lView = (TextView)findViewById(R.id.productName);
		// lView.setText(ProductMockData.getProduct1().getName());
	}

	public void onClick(View v) {
		// check for scan button

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_info, menu);
		return true;
	}

}
