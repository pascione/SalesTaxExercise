package com.example.Cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.Product.Item;
import com.example.Tax.TaxCalculator;

public class Cart implements CartIntf {

	private List<CartItem> items;
	private TaxCalculator taxCalculator;

	public Cart(TaxCalculator taxCalculator) {
		this.items = new ArrayList<CartItem>();
		this.taxCalculator = taxCalculator;
	}

	public void add(Item i, int quantity) {
		CartItem ci = new CartItem(i, quantity);
		this.taxCalculator.calculateTax(ci);
		ci.setTotalprice(ci.getQuantity().multiply(ci.getTax().add(ci.getItem().getPrice())));
		this.items.add(ci);
	}

	public List<CartItem> getCart() {
		return this.items;
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (CartItem ci : items) {
			total = total.add(ci.getTotalprice());
		}
		return total;
	}

	public BigDecimal getTaxTotal() {
		BigDecimal totalTax = new BigDecimal(0);
		for (CartItem ci : items) {
			totalTax = totalTax.add(ci.getTax());
		}
		return totalTax;
	}

}
