package com.example.barcodescanningapp;

import com.example.barcodescanningapp.cosmetic.ProductMockData;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class ProductInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_info);

		TextView lView = (TextView)findViewById(R.id.productName);
		lView.setText(ProductMockData.getProduct1().getName());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_info, menu);
		return true;
	}

}
