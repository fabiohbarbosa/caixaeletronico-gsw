package br.com.gsw.caixaeletronico;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabio on 03/09/15.
 */
public class Saque implements  CaixaEletronico{

    public Map<Nota, Integer> saque(Integer saque) {
        Map<Nota, Integer> map = new HashMap<Nota, Integer>();

        if (saque < 0) {
            throw new IllegalArgumentException();
        }
        int resto = saque % 10;
        if (resto > 0) {
            throw new IllegalArgumentException();
        }
        // verificação nota 100
        int qtdeNotas100 = saque / 100;
        map.put(Nota.CEM, qtdeNotas100);
        saque = saque - (qtdeNotas100 * 100);

        // verificação nota 50
        int qtdeNotas50 = saque / 50;
        map.put(Nota.CINQUENTA, qtdeNotas50);
        saque = saque - (qtdeNotas50 * 50);

        // verificação nota 20
        int qtdeNotas20 = saque / 20;
        map.put(Nota.VINTE, qtdeNotas20);
        saque = saque - (qtdeNotas20 * 20);

        // verificação nota 10
        int qtdeNotas10 = saque / 10;
        map.put(Nota.DEZ, qtdeNotas10);
        saque = saque - (qtdeNotas10 * 10);

        return map;
    }
}
