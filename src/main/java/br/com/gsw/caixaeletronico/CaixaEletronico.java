package br.com.gsw.caixaeletronico;

import java.util.Map;

public interface CaixaEletronico {
	public Map<Nota, Integer> saque(Integer saque);
}
