package data;

import java.util.ArrayList;

import exceptions.UsuarioNaoEncontrarException;
import model.Pessoa;

public interface IRepositorioPessoaArrayList {
	public Pessoa procurarPessoa(String cpf) throws UsuarioNaoEncontrarException;
	public void adicionarPessoa(Pessoa pessoa);
	public void removerPessoa(Pessoa pessoa);
	public boolean existePessoa(Pessoa p);
	public ArrayList<Pessoa> getListaPessoa();
	public void getPersonWithMoreFriends() throws UsuarioNaoEncontrarException;
	public void getPersonWithMoreTxT() throws UsuarioNaoEncontrarException;
	public void getOldestPerson() throws UsuarioNaoEncontrarException;
	public void getPersonWithLOngestName() throws UsuarioNaoEncontrarException;
	public void getPersonWithLessFriends() throws UsuarioNaoEncontrarException;
	public void getYoungerPerson() throws UsuarioNaoEncontrarException ;
	public void savelist();
	public void receivelist(ArrayList<Pessoa> listasalva);
}
