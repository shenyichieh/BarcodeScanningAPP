package com.example.barcodescanningapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ProductInfoActivity extends Activity implements OnClickListener {
	private Button allerBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_info);
		allerBtn = (Button)findViewById(R.id.alergies);
		allerBtn.setOnClickListener(this);
		// TextView lView = (TextView)findViewById(R.id.productName);
		// lView.setText(ProductMockData.getProduct1().getName());
	}

	public void onClick(View v) {
		// check for scan button
		System.out.println("SSSSS");
		if (v.getId() == R.id.alergies) {
			
			Intent productInfoIntent = new Intent(this, Allergic.class);
		    startActivity(productInfoIntent);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_info, menu);
		return true;
	}

}
