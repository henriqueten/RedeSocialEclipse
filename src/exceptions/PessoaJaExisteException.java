package exceptions;

public class PessoaJaExisteException extends Exception {
	public PessoaJaExisteException() {
		super("Pessoa J� Cadastrada");
	}
}
