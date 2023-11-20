package br.inatel.cdg.observer.interfaces;

import br.inatel.cdg.observer.impl.Observador;

public interface iObservavel {
    public void registraObservador(Observador obs);
	public void removeObservador(Observador obs);
	public void notificaObservadores();
}
