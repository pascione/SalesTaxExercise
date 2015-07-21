package com.example;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.example.Cart.Cart;
import com.example.Cart.CartIntf;
import com.example.Product.Item;
import com.example.Product.ProductOrigin;
import com.example.Product.ProductType;
import com.example.Tax.TaxCalculator;
import com.example.Tax.TaxExempted;
import com.example.Tax.TaxImported;
import com.example.Tax.TaxItem;

public class TestApp {

	private TaxCalculator taxCalculator;
	private CartIntf cart1, cart2, cart3;
	private BillIntf bill;
	private RoundIntf round5;

	private void setupTax() {
		round5 = new Round5();
		TaxItem basicGoods = new TaxItem("domestic goods", new BigDecimal("0.1"),
				new TaxExempted(ProductType.BOOK, ProductType.FOOD, ProductType.MEDICAL), round5);
		TaxItem importedGoods = new TaxItem("Imported Goods", new BigDecimal("0.05"), new TaxImported(), round5);

		taxCalculator = new TaxCalculator();
		taxCalculator.add(basicGoods);
		taxCalculator.add(importedGoods);
	}

	private void setupCartEx1() {
		Item i1 = new Item("book", ProductType.BOOK, ProductOrigin.DOMESTIC, "12.49");
		Item i2 = new Item("music CD", ProductType.OTHER, ProductOrigin.DOMESTIC, "14.99");
		Item i3 = new Item("chocolate bar", ProductType.FOOD, ProductOrigin.DOMESTIC, "0.85");
		cart1 = new Cart(this.taxCalculator);
		cart1.add(i1, 1);
		cart1.add(i2, 1);
		cart1.add(i3, 1);

	}

	private void setupCartEx2() {
		Item i1 = new Item("imported box chocolate", ProductType.FOOD, ProductOrigin.IMPORTED, "10.00");
		Item i2 = new Item("imported bottle perfume", ProductType.OTHER, ProductOrigin.IMPORTED, "47.50");
		cart2 = new Cart(this.taxCalculator);
		cart2.add(i1, 1);
		cart2.add(i2, 1);

	}

	private void setupCartEx3() {
		Item i1 = new Item("imported bottle perfume", ProductType.OTHER, ProductOrigin.IMPORTED, "27.99");
		Item i2 = new Item("bottle perfume", ProductType.OTHER, ProductOrigin.DOMESTIC, "18.99");
		Item i3 = new Item("packet headache pill", ProductType.MEDICAL, ProductOrigin.DOMESTIC, "9.75");
		Item i4 = new Item("imported chocolate bar", ProductType.FOOD, ProductOrigin.IMPORTED, "11.25");
		cart3 = new Cart(this.taxCalculator);
		cart3.add(i1, 1);
		cart3.add(i2, 1);
		cart3.add(i3, 1);
		cart3.add(i4, 1);

	}

	@Test
	public void testEx1() {
		this.setupTax();
		this.setupCartEx1();
		bill = new Bill(System.out);
		bill.addCart(cart1);
		bill.printBill();
		assertEquals(new BigDecimal("1.50"), bill.getTaxTotal());
		assertEquals(new BigDecimal("29.83"), bill.getTotal());
	}

	@Test
	public void testEx2() {
		this.setupTax();
		this.setupCartEx2();
		bill = new Bill(System.out);
		bill.addCart(cart2);
		bill.printBill();
		assertEquals(new BigDecimal("7.65"), bill.getTaxTotal());
		assertEquals(new BigDecimal("65.15"), bill.getTotal());
	}

	@Test
	public void testEx3() {
		this.setupTax();
		this.setupCartEx3();
		bill = new Bill(System.out);
		bill.addCart(cart3);
		bill.printBill();
		assertEquals(new BigDecimal("6.65"), bill.getTaxTotal());
		assertEquals(new BigDecimal("74.63"), bill.getTotal());
	}

}
