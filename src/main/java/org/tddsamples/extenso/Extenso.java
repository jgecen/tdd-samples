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
		constants.put(BigDecimal.TEN, "dez");
		constants.put(new BigDecimal(11), "onze");
		constants.put(new BigDecimal(20), "vinte");
		constants.put(new BigDecimal(30), "trinta");
		constants.put(new BigDecimal(100), "cem");
		constants.put(new BigDecimal(200), "duzentos");
		constants.put(new BigDecimal(1000), "mil");
	}

	public static String parse(BigDecimal n) {
		return getStringFromTenth(n, 0).replace("e cem e", "cento e");
	}

	private static String getStringUnity(BigDecimal n, BigDecimal tenth) {
		BigDecimal unity = n.subtract(tenth);
		if (unity.compareTo(BigDecimal.ZERO) == 0) {
			return "";
		} else {
			return " e " + constants.get(unity);
		}
	}

	private static String getStringFromTenth(BigDecimal n, int pow) {
		String s = constants.get(n);
		if (pow > 0 && n.compareTo(new BigDecimal(100)) == 0) {
			s = "cento";
		}

		if (s == null) {
			BigDecimal tenth = getTenth(n, pow + 1);
			s = getStringFromTenth(tenth, pow + 1) + getStringUnity(n, tenth);
		}
		return s;
	}

	private static BigDecimal getTenth(BigDecimal n, int pow) {
		BigDecimal factor = new BigDecimal(10).pow(pow);
		BigDecimal dezena = n.divideToIntegralValue(factor).multiply(factor);
		return dezena;
	}
}
