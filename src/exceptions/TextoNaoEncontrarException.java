package exceptions;

public class TextoNaoEncontrarException extends Exception {
	public TextoNaoEncontrarException() {
		super("Texto não encontrado");
	}
}
