package com.example;

import java.math.BigDecimal;

import com.example.Cart.CartIntf;

public interface BillIntf {

	BigDecimal getTotal();

	BigDecimal getTaxTotal();

	void printBill();

	void addCart(CartIntf cart);

}
