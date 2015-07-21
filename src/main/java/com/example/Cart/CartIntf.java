package com.example.Cart;

import java.math.BigDecimal;
import java.util.List;

import com.example.Product.Item;

public interface CartIntf {

	void add(Item it, int quantity);

	List<CartItem> getCart();

	BigDecimal getTotal();

	BigDecimal getTaxTotal();

}
