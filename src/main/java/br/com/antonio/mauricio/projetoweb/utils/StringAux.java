package br.com.antonio.mauricio.projetoweb.utils;

public class StringAux {

	public static String replaceNull(String param) {
		if (param == null)
			return "";
		else
			return param;
	}

	public static Long replaceNullLong(Long value) {
		return value != null ? value : 0L;
	}

}
