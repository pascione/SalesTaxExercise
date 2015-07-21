package com.example.Product;

import java.math.BigDecimal;

public class Item {

	private String description;
	private ProductType type;
	private ProductOrigin origin;
	private BigDecimal price;

	public Item(String description, ProductType p_type, ProductOrigin p_origin, String price) {
		this.description = description;
		this.type = p_type;
		this.origin = p_origin;
		this.price = new BigDecimal(price);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public ProductOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(ProductOrigin origin) {
		this.origin = origin;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
