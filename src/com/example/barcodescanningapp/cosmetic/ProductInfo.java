package com.example.barcodescanningapp.cosmetic;

import java.util.ArrayList;
import java.util.List;

public class ProductInfo {
	private long id;
	private String name;
	private int hazardRating;
	private int cancerRating;
	private int devAndRepoRating;
	private int alergyRating;
	private int RestrictionsRating;
	private String concernsHigh;
	private String concernsModerate;
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHazardRating() {
		return hazardRating;
	}
	public void setHazardRating(int hazardRating) {
		this.hazardRating = hazardRating;
	}
	public int getCancerRating() {
		return cancerRating;
	}
	public void setCancerRating(int cancerRating) {
		this.cancerRating = cancerRating;
	}
	public int getDevAndRepoRating() {
		return devAndRepoRating;
	}
	public void setDevAndRepoRating(int devAndRepoRating) {
		this.devAndRepoRating = devAndRepoRating;
	}
	public int getAlergyRating() {
		return alergyRating;
	}
	public void setAlergyRating(int alergyRating) {
		this.alergyRating = alergyRating;
	}
	public int getRestrictionsRating() {
		return RestrictionsRating;
	}
	public void setRestrictionsRating(int restrictionsRating) {
		RestrictionsRating = restrictionsRating;
	}
	public String getConcernsHigh() {
		return concernsHigh;
	}
	public void setConcernsHigh(String concernsHigh) {
		this.concernsHigh = concernsHigh;
	}
	public String getConcernsModerate() {
		return concernsModerate;
	}
	public void setConcernsModerate(String concernsModerate) {
		this.concernsModerate = concernsModerate;
	}
	
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
}
