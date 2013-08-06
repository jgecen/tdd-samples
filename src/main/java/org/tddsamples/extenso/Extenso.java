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
		return fixes(s);
	}

	private static String fixes(String s) {
		return s.replace("cem e", "cento e").replace("um mil", "mil").replace(" e mil", " mil").trim();
	}

	private static String resolveCentenaDezenaUnidade(int n) {
		String s = "";
		int centena = (n / 100) * 100;
		if (centena != 0) {
			s = values.get(centena);
		}
		int dezena = n % 100;
		String dezenaStr = dezena == 0 ? "" : resolveDezenaUnidade(dezena).trim();
		return s + (dezena != 0 ? " e " : "") +  dezenaStr;
	}

	private static String resolveDezenaUnidade(int n) {
		String s = values.get(n);
		if (s != null) {
			return s;
		}
		int dezena = (n / 10) * 10;
		if (dezena != 0) {
			s = values.get(dezena);
		}
		int unidade = n % 10;
		String unidadeStr = unidade == 0 ? "" : values.get(unidade);
		return s + (unidade != 0 ? " e " : "") + unidadeStr;
	}
}
