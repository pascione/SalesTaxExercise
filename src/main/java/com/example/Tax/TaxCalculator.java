package com.example.Tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.example.Cart.CartItem;

public class TaxCalculator {
	private List<TaxItem> taxes;

	public TaxCalculator() {
		this.taxes = new ArrayList<TaxItem>();
	}

	public void add(TaxItem t) {
		this.taxes.add(t);
	}

	public void calculateTax(CartItem ci) {
		BigDecimal tax = new BigDecimal(0);
		for (TaxItem ti : taxes) {
			if (ti.isEligible(ci.getItem())) {
				tax = tax.add(ti.calculateTax(ci.getItem()));
			}
		}
		ci.setTax(tax);
	}

}
