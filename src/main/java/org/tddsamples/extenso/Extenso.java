package org.tddsamples.extenso;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Extenso {

	private static Map<BigDecimal, String> constants;
	static {
		constants = new HashMap<>();
		constants.put(BigDecimal.ZERO, "zero");
		constants.put(BigDecimal.ONE, "um");
		constants.put(new BigDecimal(2), "dois");
		constants.put(new BigDecimal(3), "tres");
		constants.put(BigDecimal.TEN, "dez");
		constants.put(new BigDecimal(11), "onze");
		constants.put(new BigDecimal(20), "vinte");
		constants.put(new BigDecimal(30), "trinta");
		constants.put(new BigDecimal(100), "cem");
		constants.put(new BigDecimal(200), "duzentos");
	}

	public static String parse(BigDecimal n) {
		return getStringFromTenth(n, 0).replace("e cem e", "cento e").replace(
				"dez e dois", "doze");
	}

	private static String getStringUnity(BigDecimal n, BigDecimal tenth) {
		BigDecimal unity = n.subtract(tenth);
		if (unity.compareTo(BigDecimal.ZERO) == 0) {
			return "";
		} else {
			String s = constants.get(unity);
			if (s == null) {
				s =  getStringFromTenth(unity, 0);
			}
			return " e " + s;
		}
	}

	private static String getStringFromTenth(BigDecimal n, int pow) {
		String s = getConstant(n, pow);
		if (s == null) {
			BigDecimal tenth = getTenth(n, pow + 1);
			s = getStringFromTenth(tenth, pow + 1) + getStringUnity(n, tenth);
		}
		return s;
	}

	private static String getConstant(BigDecimal n, int pow) {
		String s = constants.get(n);
		if (hundreds(n, pow)) {
			s = "cento";
		} else {
			BigDecimal factor = new BigDecimal(10).pow(pow);
			BigDecimal tenth = n.divideToIntegralValue(factor);

			if (thousands(pow, tenth)) {
				s = getStringFromTenth(tenth, 0) + " mil";
			}

			if (millions(pow, tenth)) {
				s = getStringFromTenth(tenth, 0) + " milhao";
			}
		}
		return s;
	}

	private static boolean millions(int pow, BigDecimal tenth) {
		return pow == 6 && tenth.compareTo(new BigDecimal(999)) <= 0;
	}

	private static boolean thousands(int pow, BigDecimal tenth) {
		return pow == 3 && tenth.compareTo(new BigDecimal(999)) <= 0;
	}

	private static boolean hundreds(BigDecimal n, int pow) {
		return pow > 0 && n.compareTo(new BigDecimal(100)) == 0;
	}

	private static BigDecimal getTenth(BigDecimal n, int pow) {
		BigDecimal factor = new BigDecimal(10).pow(pow);
		BigDecimal tenth = n.divideToIntegralValue(factor).multiply(factor);
		return tenth;
	}
}
