package com.example;

import java.math.BigDecimal;

import com.example.Cart.Cart;
import com.example.Cart.CartIntf;
import com.example.Product.Item;
import com.example.Product.ProductOrigin;
import com.example.Product.ProductType;
import com.example.Tax.TaxCalculator;
import com.example.Tax.TaxExempted;
import com.example.Tax.TaxImported;
import com.example.Tax.TaxItem;

/**
 * Hello world!
 *
 */
public class App {

	private TaxCalculator taxCalculator;
	private CartIntf cart1, cart2, cart3;
	private RoundIntf round5;

	public App() {
		this.setupTax();
	}

	public static void main(String[] args) {
		App app = new App();
		app.test1();
		app.test2();
		app.test3();
	}

	private void setupTax() {
		round5 = new Round5();
		TaxItem basicGoods = new TaxItem("domestic goods", new BigDecimal("0.1"),
				new TaxExempted(ProductType.BOOK, ProductType.FOOD, ProductType.MEDICAL), round5);
		TaxItem importedGoods = new TaxItem("Imported Goods", new BigDecimal("0.05"), new TaxImported(), round5);

		taxCalculator = new TaxCalculator();
		taxCalculator.add(basicGoods);
		taxCalculator.add(importedGoods);
	}

	private void test1() {
		Item i1 = new Item("book", ProductType.BOOK, ProductOrigin.DOMESTIC, "12.49");
		Item i2 = new Item("music CD", ProductType.OTHER, ProductOrigin.DOMESTIC, "14.99");
		Item i3 = new Item("chocolate bar", ProductType.FOOD, ProductOrigin.DOMESTIC, "0.85");
		cart1 = new Cart(this.taxCalculator);
		cart1.add(i1, 1);
		cart1.add(i2, 1);
		cart1.add(i3, 1);
		Bill bill = new Bill(System.out);
		bill.addCart(cart1);
		bill.printBill();

	}

	private void test2() {
		Item i1 = new Item("imported box chocolate", ProductType.FOOD, ProductOrigin.IMPORTED, "10.00");
		Item i2 = new Item("imported bottle perfume", ProductType.OTHER, ProductOrigin.IMPORTED, "47.50");
		cart2 = new Cart(this.taxCalculator);
		cart2.add(i1, 1);
		cart2.add(i2, 1);
		Bill bill = new Bill(System.out);
		bill.addCart(cart2);
		bill.printBill();
	}

	private void test3() {
		Item i1 = new Item("imported bottle perfume", ProductType.OTHER, ProductOrigin.IMPORTED, "27.99");
		Item i2 = new Item("bottle perfume", ProductType.OTHER, ProductOrigin.DOMESTIC, "18.99");
		Item i3 = new Item("packet headache pill", ProductType.MEDICAL, ProductOrigin.DOMESTIC, "9.75");
		Item i4 = new Item("imported chocolate bar", ProductType.FOOD, ProductOrigin.IMPORTED, "11.25");
		cart3 = new Cart(this.taxCalculator);
		cart3.add(i1, 1);
		cart3.add(i2, 1);
		cart3.add(i3, 1);
		cart3.add(i4, 1);
		Bill bill = new Bill(System.out);
		bill.addCart(cart3);
		bill.printBill();
	}
}
