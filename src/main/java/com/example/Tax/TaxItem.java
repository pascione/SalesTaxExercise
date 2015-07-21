package com.example.Tax;

import java.math.BigDecimal;

import com.example.RoundIntf;
import com.example.Product.Item;

public class TaxItem {

	private TaxRule rule;
	private String description;
	private BigDecimal rate;
	private RoundIntf roundFun;

	public TaxItem(String description, BigDecimal rate, TaxRule rule, RoundIntf roundFun) {
		this.description = description;
		this.rate = rate;
		this.rule = rule;
		this.roundFun = roundFun;
	}

	public BigDecimal calculateTax(Item item) {
		return roundFun.round(item.getPrice().multiply(this.rate));
	}

	public boolean isEligible(Item item) {
		return rule.isEligible(item);
	}

	public TaxRule getRule() {
		return rule;
	}

	public void setRule(TaxRule rule) {
		this.rule = rule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public RoundIntf getRoundFunction() {
		return roundFun;
	}

	public void setRoundFunction(RoundIntf roundFun) {
		this.roundFun = roundFun;
	}

}
