package br.inatel.cdg.observer.impl;

import br.inatel.cdg.observer.interfaces.iObservador;

public class Observador implements iObservador {
	int id;

	public Observador(int id) {
		this.id = id;
	}

	@Override
	public void update(Observavel stringUtils) {
		System.out.println("Cliente: "+this.id);
		System.out.println("Frase: " + stringUtils.getSentence());
		System.out.println("Número de palavras na frase: " + stringUtils.getCountWords());
		System.out.println("Número de palavras com quantidade par de caracteres: " + stringUtils.getCountWordsWithChunksOfCharacterPairs());
		System.out.println("Número de palavras começadas com letra maiúscula: " + stringUtils.getCountWordsStartingWithCapitalLetters());
		System.out.println("\n");
	}
}
