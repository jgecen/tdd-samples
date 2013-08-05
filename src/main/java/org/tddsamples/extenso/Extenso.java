package org.tddsamples.extenso;

import java.util.HashMap;
import java.util.Map;

public class Extenso {

	private static Map<Integer, String> values = new HashMap<>();
	static {
		values.put(0, "zero");
		values.put(1, "um");
		values.put(2, "dois");
		values.put(3, "tres");
		values.put(10, "dez");
		values.put(11, "onze");
		values.put(15, "quinze");
		values.put(20, "vinte");
		values.put(30, "trinta");
		values.put(100, "cem");
		values.put(200, "duzentos");
		values.put(500, "quinhentos");
		values.put(1000, "mil");
	}

	public static String parse(int n) {
		String s = values.get(n);
		if (n > 100 && n < 1000) {
			s = resolveCentenaDezenaUnidade(n);
		}
		if (n > 1000) {
			int x = (n / 1000);
			s = parse(x) + " mil " + resolveCentenaDezenaUnidade(n % 1000).trim();
		}
		if (s == null) {
			s = resolveDezenaUnidade(n);
		}
		return s.replace("cem e", "cento e").replace("um mil", "mil").replace(" e mil", " mil").trim();
	}

	private static String resolveCentenaDezenaUnidade(int n) {
		String s = "";
		int x = (n / 100) * 100;
		int dezena = n % 100;
		if (x != 0) {
			s = values.get(x);
		}
		String dezenaStr = resolveDezenaUnidade(dezena).trim();
		s = s + (x != 0 || dezena != 0 ? " e " : "") + (dezena == 0 ? "" :  dezenaStr);
		return s;
	}

	private static String resolveDezenaUnidade(int n) {
		String s = values.get(n);
		if (s != null) {
			return s;
		}
		int x = (n / 10) * 10;
		int unidade = n % 10;
		if (x != 0) {
			s = values.get(x);
		}
		s = s + (unidade != 0 ? " e " : "") + (unidade == 0 ? "" : values.get(unidade));
		return s;
	}
}
