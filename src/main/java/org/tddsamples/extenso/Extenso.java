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
		values.put(9, "nove");
		values.put(10, "dez");
		values.put(11, "onze");
		values.put(15, "quinze");
		values.put(20, "vinte");
		values.put(30, "trinta");
		values.put(60, "sessenta");
		values.put(100, "cem");
		values.put(200, "duzentos");
		values.put(500, "quinhentos");
		values.put(1000, "mil");
	}

	public static String parse(int n) {
		String s = values.get(n);
		if (n > 100 && n < 1000) {
			s = new Centena(n).getAsString();
		}
		if (n > 1000) {
			int x = (n / 1000);
			s = parse(x) + " mil " + new Centena(n % 1000).getAsString().trim();
		}
		if (s == null) {
			s = new Dezena(n).getAsString();
		}
		return fixes(s);
	}

	private static String fixes(String s) {
		return s.replace("cem e", "cento e").replace("um mil", "mil").replace(" e mil", " mil").trim();
	}

	static class Centena {
		int centena;
		int dezena;
		public Centena(int n) {
			int factor = (int) Math.pow(10, 2);
			this.centena = (n / factor) * factor;
			this.dezena = n % factor;
		}
		private String getCentenaAsString() {
			return this.centena != 0 ? values.get(centena) : "";
		}
		private String getDezenaAsString() {
			return this.dezena == 0 ? "" : new Dezena(this.dezena).getAsString();
		}
		String getAsString() {
			return getCentenaAsString() + (this.dezena != 0 ? " e " : "") +  getDezenaAsString();	
		}
	}

	static class Dezena {
		int dezena;
		int unidade;
		int n;
		public Dezena(int n) {
			int factor = (int) Math.pow(10, 1);
			this.dezena = (n / factor) * factor;
			this.unidade = n % factor;
			this.n = n;
		}
		private String getDezenaAsString() {
			return dezena != 0 ? values.get(dezena) : "";
		}
		private String getUnidadeAsString() {
			return unidade == 0 ? "" : values.get(unidade);
		}
		String getAsString() {
			String s = values.get(n);
			if (s != null) {
				return s;
			}
			return getDezenaAsString() + (unidade != 0 ? " e " : "") + getUnidadeAsString();	
		}
	}
}
