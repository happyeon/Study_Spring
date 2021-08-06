package com.test03;

public class MyFood {
	
	private Food favoriteFood;
	private Food unFavoriteFood;
	
	public MyFood() {
	}
	
	public MyFood(Food favoriteFood, Food unFavoriteFood) {
		this.favoriteFood = favoriteFood;
		this.unFavoriteFood = unFavoriteFood;
	}
	
	public Food getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}
	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}
	
	@Override
	public String toString() {
		return "favorite : " + favoriteFood + "\nunfavorite : " + unFavoriteFood;
	}
	

}
