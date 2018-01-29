package controller;

import java.util.ArrayList;

import exceptions.TextoNaoEncontrarException;
import exceptions.UsuarioNaoEncontrarException;
import model.Texto;

public interface ICadastroTexto {
	public void cadastrarTexto(Texto texto);
	public void descadastrarTexto(Texto texto);
	public Texto procurarTexti(int data) throws TextoNaoEncontrarException;
	public void getMaxCURTIDAS() throws TextoNaoEncontrarException;
	public void getMaxTxTLENGTH() throws TextoNaoEncontrarException;
	public void getTxtWtritedByOldestPerson() throws TextoNaoEncontrarException;
	public void getLessTxTLENGTH() throws TextoNaoEncontrarException;
	public void receivelistTEXTO(ArrayList<Texto> listasalva);
	public void savelistTEXTO();
	public ArrayList<Texto> getListaTexto();


}
