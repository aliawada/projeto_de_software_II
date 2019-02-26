package lista.encadeada;

public interface Iterador<T> {
	T getDado();
	T proximo();
	T anterior();
}