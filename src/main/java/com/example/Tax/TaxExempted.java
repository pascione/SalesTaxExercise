package com.example.Tax;

import java.util.Arrays;
import java.util.List;

import com.example.Product.Item;
import com.example.Product.ProductType;

public class TaxExempted implements TaxRule {

	private List<ProductType> exemption;

	public TaxExempted(ProductType... productTypes) {
		this.exemption = Arrays.asList(productTypes);
	}

	public boolean isEligible(Item item) {
		return !exemption.contains(item.getType());
	}

}
