package com.example.barcodescanningapp.cosmetic;

public class ProductMockData {
	static public ProductInfo getProduct1() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setId(1L);
		productInfo.setName("Maybelline Dream Fresh BB 8-in-1 Beauty Balm Skin Perfector, SPF 30");
		productInfo.setHazardRating(2);
		productInfo.setCancerRating(1);
		productInfo.setDevAndRepoRating(0);
		productInfo.setAlergyRating(2);
		productInfo.setRestrictionsRating(0);
		productInfo.setConcernsHigh("Contamination concerns, Irritation (skin, eyes, or lungs), Occupational hazards, Persistence and bioaccumulation");
		productInfo.setConcernsModerate("Biochemical or cellular level changes, Organ system toxicity (non-reproductive); Other LOW concerns: Enhanced skin absorption, Cancer, Data gaps, Ecotoxicology, Neurotoxicity");
		
		Ingredient ingredient1 = new Ingredient();
		ingredient1.setName("TITANIUM DIOXIDE (SUNSCREEN GRADE)(ACTIVE INGREDIENT)");
		ingredient1.setConcerns("Biochemical or cellular level changes, Cancer, Ecotoxicology, Allergies/immunotoxicity, Irritation (skin, eyes, or lungs), Organ system toxicity (non-reproductive), Occupational hazards");
		ingredient1.setScore("2");
		productInfo.addIngredient(ingredient1);
		
		return productInfo;
	}

}
