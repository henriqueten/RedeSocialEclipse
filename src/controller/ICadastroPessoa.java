package controller;

import java.util.ArrayList;

import exceptions.PessoaJaExisteException;
import exceptions.UsuarioNaoEncontrarException;
import model.Pessoa;

public interface ICadastroPessoa {
	public Pessoa searchPessoa(String cpf) throws UsuarioNaoEncontrarException;
	public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaExisteException, UsuarioNaoEncontrarException;
	public void descadastrarPessoa(Pessoa pessoa) throws UsuarioNaoEncontrarException;
	public void getPersonWithMoreFriends() throws UsuarioNaoEncontrarException;
	public void getPersonWithMoreTxT() throws UsuarioNaoEncontrarException;
	public void getOldestPerson() throws UsuarioNaoEncontrarException;
	public void getPersonWithLOngestName() throws UsuarioNaoEncontrarException;
	public void getPersonWithLessFriends() throws UsuarioNaoEncontrarException;
	public void getYoungerPerson() throws UsuarioNaoEncontrarException ;
	public void existePessoaCadastro(Pessoa p);
	public ArrayList<Pessoa> getListaPessoas();
	public void savelist();
	public void receivelist(ArrayList<Pessoa> listasalva);

}
