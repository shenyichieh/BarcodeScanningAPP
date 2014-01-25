package com.example.barcodescanningapp.cosmetic;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductInfoTranslator {

	// TODO: This will not come into play yet. Stale code for now.
	static final public ProductInfo jsonToProductInfo(String json) throws JSONException {
		JSONObject jsonObj = new JSONObject(json);
		return jsonToProductInfo(jsonObj);
	}
	static final public ProductInfo jsonToProductInfo(JSONObject json) {
		ProductInfo productInfo = new ProductInfo();
		return productInfo;
	}
}
