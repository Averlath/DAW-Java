package org.mvpigs.Romans;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numero {
    private String numeroRomano = null;
    private int numeroDecimal = 0;

    public NumeroRomano() {
    }

    public void setNumeroRomano(String numeroRomano) {
        this.numeroRomano = numeroRomano;
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }

    public void setNumeroDecimal(int numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public int getNumeroDecimal() {
        return this.numeroDecimal;
    }

    public void setRegexDiccionario(RegexNumerosRomanos regex) {
		this.regexDiccionario = regex;
	}

	public RegexNumerosRomanos getRegexDiccionario() {
		return this.regexDiccionario;
	}

    public short toDecimal() {
		for(String regex : getRegexDiccionario().getValues()) {
			Matcher matcher = createMatcher(regex);
			groupSumatoryToDecimal(matcher);
		}		
		return getNumeroDecimal();
}