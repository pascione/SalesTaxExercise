package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundNo implements RoundIntf {

	public BigDecimal round(BigDecimal tobeRounded) {
		return tobeRounded.setScale(2, RoundingMode.UP);
	}

}
