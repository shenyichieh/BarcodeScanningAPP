package com.example.barcodescanningapp;


import com.example.barcodescanningapp.cosmetic.ProductMockData;
import com.google.zxing.integration.android.IntentIntegrator;

>>>>>>> 4ad99f12a2d7c6330148d1f83848844fbe5f36a9
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
<<<<<<< HEAD
import android.view.View.OnClickListener;
import android.widget.Button;
=======
import android.widget.TextView;

public class ProductInfoActivity extends Activity {


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
		// TextView lView = (TextView)findViewById(R.id.productName);
		// lView.setText(ProductMockData.getProduct1().getName());
	}

	public void onClick(View v) {
		// check for scan button
		if (v.getId() == R.id.alergies) {
			// instantiate ZXing integration class
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			// start scanning
			scanIntegrator.initiateScan();

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.product_info, menu);
		return true;
	}

}
