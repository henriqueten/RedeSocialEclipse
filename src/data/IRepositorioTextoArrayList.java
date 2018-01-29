package data;

import java.util.ArrayList;

import exceptions.TextoNaoEncontrarException;
import model.Texto;

public interface IRepositorioTextoArrayList {
	public void adicionarTexto(Texto texto);
	public void removerTexto(Texto texto);
	public Texto procurarTexto(int data) throws TextoNaoEncontrarException;
	public void getMaxCURTIDAS() throws TextoNaoEncontrarException;
	public void getMaxTxTLENGTH() throws TextoNaoEncontrarException;
	public void getTxtWtritedByOldestPerson() throws TextoNaoEncontrarException;
	public void getLessTxTLENGTH() throws TextoNaoEncontrarException;
	public void receistlistTEXTO(ArrayList<Texto> listasalva);
	public void savelistTEXTO();
	public ArrayList<Texto> getListaTexto();
}
