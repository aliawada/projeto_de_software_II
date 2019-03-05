package lista.encadeada;

public class ListaEncadeada<TIPO> {
	public class IteradorConcreto implements Iterador<TIPO> {
		private No noAtual;
		
		IteradorConcreto(No noAtual) {
			this.noAtual = noAtual;
		}
		
		@Override
		public TIPO getDado() {
			if(noAtual == null)
				return null;
			return noAtual.dado;
		}

		@Override
		public TIPO proximo() {
			if(noAtual == null)
				return null;
			TIPO obj = noAtual.dado;
			noAtual = noAtual.proximo;
			return obj;
		}

		@Override
		public TIPO anterior() {
			if(noAtual == null)
				return null;
			TIPO obj = noAtual.dado;
			noAtual = noAtual.anterior;
			return obj;
		}

	}

	private class No {
		public No proximo;
		public No anterior;
		
		public TIPO dado;
	}
	
	
	private No inicio;
	private No fim;

	private int tamanho = 0;
	
	public Iterador<TIPO> getInicio() {
		Iterador<TIPO> i = new IteradorConcreto(inicio);
		return i;
	}
	
	public Iterador<TIPO> getFim() {
		return new IteradorConcreto(fim);
	}


	public int getTamanho() {
		return tamanho;
	}
	
	public boolean isVazia() {
		if(tamanho == 0)
			return true;
		return false;
	}

	public void inserirInicio(TIPO obj) {
		No novo = new No();
		novo.dado = obj;
		novo.proximo = inicio;
		novo.anterior = null;
		
		if(inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			inicio.anterior = novo;
			inicio = novo;
		}

		tamanho++;
	}

	public void inserirFim(TIPO obj) {
		No novo = new No();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = fim;

		if (fim != null)
			fim.proximo = novo;

		fim = novo;
		if (inicio == null)
			inicio = novo;

		tamanho++;
	}

	public void inserir(TIPO obj, int pos) {		
		if(pos < 1 || pos > tamanho + 1)
			return;
		
		if(pos == 1) { // novo inicio
			inserirInicio(obj);
			return;
		}
		
		if(pos == tamanho + 1) { // novo fim
			inserirFim(obj);
			return;
		}
		
		No novo = new No();
		novo.dado = obj;
		novo.proximo = null;
		novo.anterior = null;

		// inserir no meio da lista
		No aux = inicio;
		int cont = 1;
		
		while(cont < pos ) {
			aux = aux.proximo;
			cont++;
		}
		
		novo.anterior = aux.anterior;
		novo.proximo = aux;
		aux.anterior.proximo = novo;
		aux.anterior = novo;
		
		tamanho++;
	}

	public TIPO removerInicio() {
		if (inicio == null)
			return null;

		TIPO dado = inicio.dado;

		if (inicio == fim) { // if(tamanho == 1)
			inicio = null;
			fim = null;
		} else {
			inicio.proximo.anterior = null;
			inicio = inicio.proximo;
		}

		tamanho--;

		return dado;
	}

	public TIPO removerFim() {
		if (fim == null) 
			return null;

		TIPO dado = fim.dado;

		if (inicio == fim) { //if(tamanho == 0)
			inicio = null;
			fim = null;
		} else {
			fim.anterior.proximo = null;
			fim = fim.anterior;
		}
		tamanho--;

		return dado;
	}

	public TIPO remover(int pos) {
		if(pos < 1 || pos > tamanho)
			return null;
		
		if(pos == 1) { // remover inicio
			return removerInicio();
		}
		
		if(pos == tamanho) { // remover o fim
			return removerFim();
		}
		
		No aux = inicio;
		int cont = 1;
		
		// remover no do meio da lista
		while(cont < pos ) {
			aux = aux.proximo;
			cont++;
		}
		
		TIPO dado = aux.dado;
		
		aux.anterior.proximo = aux.proximo;
		aux.proximo.anterior = aux.anterior;
		
		tamanho--;
		return dado;
	}

	public TIPO pesquisar(int pos) {
		No aux = inicio;
		int cont = 1;

		if (tamanho == 0)
			return null;

		if (pos > tamanho)
			return null;

		while (cont < pos) {
			aux = aux.proximo;
			cont++;
		}

		return aux.dado;
	}
}