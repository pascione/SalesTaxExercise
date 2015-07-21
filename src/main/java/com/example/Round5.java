package com.example;

import java.math.BigDecimal;

public class Round5 implements RoundIntf {
	private BigDecimal ROUND_FACTOR = new BigDecimal("0.05");

	public BigDecimal round(BigDecimal tobeRounded) {
		tobeRounded = tobeRounded.divide(ROUND_FACTOR);
		tobeRounded = new BigDecimal(Math.round(tobeRounded.doubleValue()));
		tobeRounded = tobeRounded.multiply(ROUND_FACTOR);
		return tobeRounded;
	}

}
