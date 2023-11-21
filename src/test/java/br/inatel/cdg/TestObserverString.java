package br.inatel.cdg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import br.inatel.cdg.observer.impl.Observador;
import br.inatel.cdg.observer.impl.Observavel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestObserverString
{
    @Test
    public void testRetornaQuantidadeDePalavrasPares(){

        String wordsMock = "O aprendizado é a jornada que transforma cada desafio em uma oportunidade de crescimento.";

        Observavel observavel = new Observavel();

        observavel.setSentence(wordsMock);
        observavel.countWordsWithChunksOfCharacterPairs();
        int wordsChunks = observavel.getCountWordsWithChunksOfCharacterPairs();

        assertEquals(5, (int) wordsChunks);
    }

    @Test
    public void testRetornaQuantidadeDePalavrasComecadaComMaiusculas(){

        String wordsMock = "O Aprendizado é a Jornada que Transforma cada desafio em uma oportunidade de crescimento.";

        Observavel observavel = new Observavel();

        observavel.setSentence(wordsMock);
        observavel.countWordsStartingWithCapitalLetters();
        int wordsCapitalLetters = observavel.getCountWordsStartingWithCapitalLetters();

        assertEquals(4, (int) wordsCapitalLetters);
    }

    @Test
    public void testRetornaQuantidadeDePalavras(){

        String wordsMock = "O aprendizado é a jornada que transforma cada desafio em uma oportunidade de crescimento.";

        Observavel observavel = new Observavel();

        observavel.setSentence(wordsMock);
        observavel.countWords();
        int countWords = observavel.getCountWords();

        assertEquals(14, (int) countWords);
    }

    @Test
    public void testRegistraObservadorNoObservavel(){

        Observavel observavel = new Observavel();
        Observador observador1 = new Observador(1);
        Observador observador2 = new Observador(2);

        observavel.registraObservador(observador1);
        observavel.registraObservador(observador2);

        List<Observador> listClientes = observavel.getClients();

        assertTrue(listClientes.contains(observador1));
        assertTrue(listClientes.contains(observador2));
    }
}

