package com.example;

import java.io.PrintStream;
import java.math.BigDecimal;

import com.example.Cart.CartIntf;
import com.example.Cart.CartItem;

public class Bill implements BillIntf {

	private CartIntf cart;
	private PrintStream out;
	private RoundIntf roundFunction;

	public Bill(PrintStream out) {
		this.out = out;
		this.roundFunction = new RoundNo();
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (CartItem ci : this.cart.getCart()) {
			total = total.add(ci.getTotalprice());
		}
		return total;
	}

	public BigDecimal getTaxTotal() {
		BigDecimal totalTax = new BigDecimal(0);
		for (CartItem ci : this.cart.getCart()) {
			totalTax = totalTax.add(ci.getTax());
		}
		return totalTax;
	}

	public void printBill() {
		for (CartItem ci : this.cart.getCart()) {
			out.println(ci.getQuantity() + " " + ci.getDescription() + ":" + roundFunction.round(ci.getTotalprice()));
		}
		out.println("Sales Taxes: " + (cart.getTaxTotal()));
		out.println("Total: " + roundFunction.round((cart.getTotal())));
		out.println();
	}

	public void addCart(CartIntf cart) {
		this.cart = cart;

	}
}
