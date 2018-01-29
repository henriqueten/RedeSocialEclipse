package exceptions;

public class PessoaJaExisteException extends Exception {
	public PessoaJaExisteException() {
		super("Pessoa Já Cadastrada");
	}
}
