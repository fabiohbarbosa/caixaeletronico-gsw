package br.com.gsw.caixaeletronico;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class CaixaEletronicoTest {
    private Saque saque = new Saque();

    @Test
    public void aoSacar100ReaisVoltarUmaNotaDeCem() {
        final Map<Nota, Integer> valorSaque = saque.saque(100);
        Assert.assertTrue(1 == valorSaque.get(Nota.CEM));
    }

    @Test
    public void aoSacar30RetornaUmaDe20eUmaDE10(){
        final Map<Nota,Integer> valorRetorno = saque.saque(30);
        Assert.assertTrue(1 == valorRetorno.get(Nota.VINTE));
        Assert.assertTrue(1 == valorRetorno.get(Nota.DEZ));
    }

    @Test
    public void aoSacar180RetornaUmaDe100UmaDe50UmaDe20UmaDe10(){
        final Map<Nota,Integer> valorRetorno = saque.saque(180);
        Assert.assertTrue(1 == valorRetorno.get(Nota.CEM));
        Assert.assertTrue(1 == valorRetorno.get(Nota.CINQUENTA));
        Assert.assertTrue(1 == valorRetorno.get(Nota.VINTE));
        Assert.assertTrue(1 == valorRetorno.get(Nota.DEZ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void erroAoSacar7Reais(){
        saque.saque(7);

    }

    @Test(expected = IllegalArgumentException.class)
    public void erroSaqueNegativo(){
        saque.saque(-90);

    }
}
