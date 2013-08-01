package org.tddsamples.extenso;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Extenso {

	private static Map<BigDecimal, String> constantes;
	static {
		constantes = new HashMap<>();
		constantes.put(BigDecimal.ZERO, "zero");
		constantes.put(BigDecimal.ONE, "um");
		constantes.put(new BigDecimal(2), "dois");
		constantes.put(BigDecimal.TEN, "dez");
		constantes.put(new BigDecimal(11), "onze");
		constantes.put(new BigDecimal(20), "vinte");
		constantes.put(new BigDecimal(30), "trinta");
		constantes.put(new BigDecimal(100), "cem");
		constantes.put(new BigDecimal(200), "duzentos");
		constantes.put(new BigDecimal(1000), "mil");
	}

	public static String parse(BigDecimal n) {
		String s = constantes.get(n);
		if (s == null) {
			s = getStringDecimo(n, 0);
		}
		return s.replace("e cem e", "cento e");
	}

	private static String getStringUnidade(BigDecimal n, BigDecimal decimo) {
		BigDecimal unidade = n.subtract(decimo);
		if (unidade.compareTo(BigDecimal.ZERO) == 0) {
			return "";
		} else {
			return " e " + constantes.get(unidade);
		}
	}

	private static String getStringDecimo(BigDecimal numero, int pow) {
		String s;
		if (numero.compareTo(new BigDecimal(100)) == 0) {
			s = "cento";
		} else {
			s = constantes.get(numero);
		}

		if (s == null) {
			BigDecimal decimo = getDecimo(numero, new BigDecimal(10).pow(pow + 1));
			s = getStringDecimo(decimo, pow + 1) + getStringUnidade(numero, decimo);
		}
		return s;
	}

	private static BigDecimal getDecimo(BigDecimal n, BigDecimal factor) {
		BigDecimal dezena = n.divideToIntegralValue(factor).multiply(factor);
		return dezena;
	}
}
