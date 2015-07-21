package com.example.Tax;

import com.example.Product.Item;

public interface TaxRule {
	boolean isEligible(Item item);

}
