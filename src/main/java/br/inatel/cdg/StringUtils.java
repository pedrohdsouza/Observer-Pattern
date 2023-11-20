package br.inatel.cdg;

import br.inatel.cdg.observer.impl.Observador;
import br.inatel.cdg.observer.impl.Observavel;

public class StringUtils 
{
    public static void main( String[] args )
    {
		Observavel stringUtils = new Observavel();

		Observador obs1 = new Observador(1);
		Observador obs2 = new Observador(2);
		Observador obs3 = new Observador(3);
		Observador obs4 = new Observador(4);
		Observador obs5 = new Observador(5);

		stringUtils.registraObservador(obs1);
		stringUtils.registraObservador(obs2);
		stringUtils.registraObservador(obs3);
		stringUtils.registraObservador(obs4);
		stringUtils.registraObservador(obs5);

		stringUtils.receiveSentence("O tempo é relativo, especialmente nas segundas-feiras.");
		stringUtils.receiveSentence("A vida é como um loop infinito, cheia de surpresas a cada iteração.");
		stringUtils.receiveSentence("Debugar é como procurar uma agulha no palheiro, mas às vezes a agulha é um erro de digitação.");
		stringUtils.receiveSentence("A verdade está lá fora... nos logs do servidor.");
		stringUtils.receiveSentence("O café é o combustível que mantém o código fluindo.");
		stringUtils.receiveSentence("A única rotina que eu sigo é a de Ctrl+c, Ctrl+v.");

		stringUtils.removeObservador(obs2);
		stringUtils.removeObservador(obs5);

		System.out.println("\n\nMandando notificação para todos os clientes: \n");
		stringUtils.notificaObservadores();
    }
}
