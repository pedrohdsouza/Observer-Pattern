package br.inatel.cdg.observer.impl;

import java.util.ArrayList;
import java.util.List;

import br.inatel.cdg.observer.interfaces.iObservavel;

public class Observavel implements iObservavel {

    private String sentence;
	private int countWords;
	private int countWordsWithChunksOfCharacterPairs;
	private int countWordsStartingWithCapitalLetters;
	private List<Observador> clients;

	public Observavel() {
		clients = new ArrayList<Observador>();
	}

    private String[] divideSentenceIntoWords(String sentence) {
		return sentence.split("\\s+");
    }

    @Override
	public void registraObservador(Observador obs) {
		clients.add(obs);
	}

	@Override
	public void removeObservador(Observador obs) {
		if(clients.contains(obs))
			clients.remove(obs);
	}

	@Override
	public void notificaObservadores() {
		for (Observador observador : clients) {
			observador.update(this);
		}
	} 

	private void novasMedidas() {
		System.out.println("\n\nFrase adicionada, notificando todos os clientes: \n");
		notificaObservadores();
	}

    public void receiveSentence(String sentence) {
        this.sentence = sentence;
		this.countWords();
		this.countWordsWithChunksOfCharacterPairs();
		this.countWordsStartingWithCapitalLetters();
		novasMedidas();
    }

	private void countWords() {
		this.countWords = divideSentenceIntoWords(this.sentence).length;
		return;
	}

	private void countWordsWithChunksOfCharacterPairs() {
		String[] words = this.sentence.split("\\s");
		int countEven = 0;

		for (String word: words) {
			if (word.length() % 2 == 0) {
				countEven++;
			}
		}
		this.countWordsWithChunksOfCharacterPairs = countEven;
		return;
	}

	private void countWordsStartingWithCapitalLetters() {
		String[] words = this.sentence.split("\\s");
		int countWordsStartingWithCapitalLetters = 0;

		String regEx = "^[A-Z].*";
 		for (String word: words){
		 	String wordTrim = word.trim();
			if (wordTrim.matches(regEx)) {
				System.out.println(word);
				countWordsStartingWithCapitalLetters++;
			}
		}
		this.countWordsStartingWithCapitalLetters = countWordsStartingWithCapitalLetters;
		return;
	}

	public String getSentence() {
		return this.sentence;
	}

	public int getCountWords() {
		return this.countWords;
	}

	public int getCountWordsWithChunksOfCharacterPairs() {
		return this.countWordsWithChunksOfCharacterPairs;
	}

	public int getCountWordsStartingWithCapitalLetters() {
		return this.countWordsStartingWithCapitalLetters;
	}
}
