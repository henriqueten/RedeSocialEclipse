package exceptions;

public class UsuarioJaAdicionadoException extends Exception {
	public UsuarioJaAdicionadoException() {
		super("Usuario ja foi adicionado");
	}
}
