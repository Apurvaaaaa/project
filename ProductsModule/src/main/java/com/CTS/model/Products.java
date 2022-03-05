package com.CTS.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Model Class of Product Microservice
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Products {

	@Id
	private int id;
	private String name;
	private double price;
////	/public Products() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Products(int id, String name, double price, String description, String imageName, float rating,
//			int userRated) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.description = description;
//		this.imageName = imageName;
//		this.rating = rating;
//		this.userRated = userRated;
//	}
	private String description;
	@Column(name = "image_name")
	private String imageName;
//	@Range(min = 1,max = 5,message = "Rating should be between 1 to 5")
	private float rating;
	private int userRated;
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public String getImageName() {
//		return imageName;
//	}
//	public void setImageName(String imageName) {
//		this.imageName = imageName;
//	}
//	public float getRating() {
//		return rating;
//	}
//	public void setRating(float rating) {
//		this.rating = rating;
//	}
//	public int getUserRated() {
//		return userRated;
//	}
//	public void setUserRated(int userRated) {
//		this.userRated = userRated;
//	}

}
