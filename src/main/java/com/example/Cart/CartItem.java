package com.example.Cart;

import java.math.BigDecimal;

import com.example.Product.Item;
import com.example.Product.ProductOrigin;
import com.example.Product.ProductType;

public class CartItem {

	private Item item;
	private BigDecimal quantity;
	private BigDecimal tax;
	private BigDecimal totalprice;

	public CartItem(Item item, int quantity) {
		this.item = item;
		this.quantity = new BigDecimal(quantity);
		this.tax = new BigDecimal(0);
		this.totalprice = new BigDecimal(0);
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public String getDescription() {
		return this.item.getDescription();
	}

	public ProductType getType() {
		return this.item.getType();
	}

	public ProductOrigin getOrigin() {
		return this.item.getOrigin();
	}

	public BigDecimal getPrice() {
		return this.item.getPrice();
	}

}
