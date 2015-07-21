package com.example.Tax;

import com.example.Product.Item;
import com.example.Product.ProductOrigin;

public class TaxImported implements TaxRule {

	public TaxImported() {
	}

	public boolean isEligible(Item item) {
		return ProductOrigin.IMPORTED.equals(item.getOrigin());
	}

}
