package view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import exceptions.PessoaJaExisteException;
import exceptions.TextoNaoEncontrarException;
import exceptions.UsuarioJaAdicionadoException;
import exceptions.UsuarioNaoEncontrarException;
import fachada.Fachada;
import model.Pessoa;
import model.Texto;

public class Menu {
	static Fachada f = Fachada.getInstance();
	static Menu m = new Menu();
	Scanner sc = new Scanner(System.in);
	private static ObjectInputStream objInP;

	public static void main(String[] args) {

		if (new File("testepessoa").canRead() == true) {

			FileInputStream inP;
			try {
				inP = new FileInputStream("testepessoa");
				objInP = new ObjectInputStream(inP);

				@SuppressWarnings("unchecked")
				ArrayList<Pessoa> lista991 = (ArrayList<Pessoa>) objInP.readObject();
				f.receivelist(lista991);
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		if (new File("testetexto").canRead() == true) {

			FileInputStream inP;
			try {
				inP = new FileInputStream("testetexto");
				objInP = new ObjectInputStream(inP);

				@SuppressWarnings("unchecked")
				ArrayList<Texto> lista99 = ((ArrayList<Texto>) objInP.readObject());
				f.receivelistTEXTO(lista99);
			} catch (FileNotFoundException e1) {

				e1.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

		m.primeiroMenu();

	}

	public void primeiroMenu() {
		f.savelist();
		f.savelistTEXTO();
		System.out.println("=====================================================");
		System.out.println("1 - LOGAR"); // feito
		System.out.println("2 - CADASTRAR NO FAKEBOOK"); // feito
		System.out.println("3 - VER RELATORIOS");
		System.out.println("=====================================================");
		int sistema = 0;
		try {
			sistema = Integer.parseInt(sc.next());

		} catch (Exception e) {
			System.out.println("CARACTER INVALIDO");
		}

		switch (sistema) {
		case 1:
			System.out.println("INFORME SEU CPF");
			String cpf = sc.next();

			try {
				m.segundoMenuLogado(m.entrarUsuario(cpf));
			} catch (UsuarioNaoEncontrarException e) {
				System.out.println(e.getMessage());
				m.primeiroMenu();
			}

			break;
		case 2:
			m.cadastrarIndividuos();
			m.primeiroMenu();
			break;
		case 3:
			System.out.println("=====================================================");
			System.out.println("DIGITE 1 PARA: Menssagem com mais Curtidas");
			System.out.println("DIGITE 2 PARA: Pessoa Com mais Amigos");
			System.out.println("DIGITE 3 PARA: Pessoa com mais Texto");
			System.out.println("DIGITE 4 PARA: Pessoa com a maior Menssagem");
			System.out.println("DIGITE 5 PARA: Pessoa mais Velha");
			System.out.println("DIGITE 6 PARA:Pessoa com o maior Nome");
			System.out.println("DIGITE 7 PARA: Menssagem escrita pela Pessoa mais Velha");
			System.out.println("DIGITE 8 PARA: Pessoa com menos Amigos");
			System.out.println("DIGITE 9 PARA: Pessoa mais nova");
			System.out.println("DIGITE 10 PARA: Pessoa Com o menor Texto");
			System.out.println("DIGITE 11 PARA: QUANTIDADE DE USUARIOS");
			System.out.println("=====================================================");
			int relater = 0;
			try {
				relater = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Caractere Invalido");
				m.primeiroMenu();
			}

			m.relaterFunction(relater);
			m.primeiroMenu();

			break;

		default:
			System.out.println("OPS! Acho que vocÃª escolheu a opÃ§Ã£o errada :)");
			m.primeiroMenu();

			break;
		}
	}

	public void relaterFunction(int relater) {
		switch (relater) {
		case 1:
			try {
				f.getMaxCURTIDAS();
			} catch (TextoNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 2:
			try {
				f.getPersonWithMoreFriends();
			} catch (UsuarioNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 3:
			try {
				f.getPersonWithMoreTxT();
			} catch (UsuarioNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 4:
			try {
				f.getMaxTxTLENGTH();
			} catch (TextoNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 5:
			try {
				f.getOldestPerson();
			} catch (UsuarioNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 6:
			try {
				f.getPersonWithLOngestName();
			} catch (UsuarioNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 7:
			try {
				f.getTxtWtritedByOldestPerson();
			} catch (TextoNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 8:
			try {
				f.getPersonWithLessFriends();
			} catch (UsuarioNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 9:
			try {
				f.getYoungerPerson();
			} catch (UsuarioNaoEncontrarException e) {
				e.getMessage();
			}

			break;
		case 10:
			try {
				f.getLessTxTLENGTH();
			} catch (TextoNaoEncontrarException e) {
				e.getMessage();
			}
			break;
		case 11:
			System.out.println("O REDE TEM " + f.getListaPessoas().size() + " USUARIO");

			break;

		default:
			System.out.println("OPS! Acho que você escolheu a opção errada :)");
			m.primeiroMenu();
			break;
		}

	}

	public void segundoMenuLogado(Pessoa p) {
		f.savelist();
		f.savelistTEXTO();

		System.out.println("=====================================================");
		System.out.println("NOME DO USUÁRIO: " + p.getNome());
		System.out.println("1 - EXIBIR LISTA DE AMIGOS"); // feito
		System.out.println("2 - AMIGOS EM COMUM ENTRE DOIS AMIGOS"); // feito
		System.out.println("3 - PROCURAR AMIGOS");
		System.out.println("4 - AMIZADES PENDENTES");
		System.out.println("5 - TIMELINE");
		System.out.println("6 - DIGITE O QUE PENSA");
		System.out.println("7 - CURTIR UMA MENSSAGEM");
		System.out.println("0 - SAIR");
		System.out.println("=====================================================");
		int sistema = 0;
		try {
			sistema = sc.nextInt();
		} catch (Exception e) {
			System.out.println("CARACTER INVALIDO");
		}

		switch (sistema) {
		case 1:
			System.out.println("=====================================================");
			System.out.println("VOCÊ TEM " + p.getAmigos().size() + " AMIGOS");
			m.exibirAmigos(p);
			System.out.println("=====================================================");
			m.segundoMenuLogado(p);

			break;
		case 2:
			System.out.println("=====================================================");
			System.out.println("AMIGOS EM COMUM: ");
			try {
				m.amigoComumEntreDoisAmigos(p);
			} catch (UsuarioNaoEncontrarException e1) {

				System.out.println(e1.getMessage());
			}
			System.out.println("=====================================================");
			m.segundoMenuLogado(p);
			break;
		case 3:
			System.out.println("=====================================================");
			System.out.println(
					"DESEJA ADICIONAR ALGUEM? (DIGITE O CPF) OU DIGITE -VOLTAR- PARA VOLTAR AO MENU PRINCIPAL");
			String escolha1 = sc.next(); // verificar se existe
			System.out.println("=====================================================");
			if (escolha1.equalsIgnoreCase("voltar")) {
				m.segundoMenuLogado(p);
			}
			Pessoa p99 = null;
			try {
				p99 = f.searchPessoa(escolha1);
			} catch (UsuarioNaoEncontrarException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (Pessoa personable : p.getAmigosPendentes()) {
				if (p99.getCpf().equalsIgnoreCase(personable.getCpf())) {
					System.out.println("AMIZADE JA ESTÁ PENDENTE, VERIFIQUE EM AMIZADES PENDENTES");
					m.segundoMenuLogado(p);
					
				}
			}

			try {
				f.searchPessoa(escolha1).addPendenciaAmigos(p);
			} catch (UsuarioNaoEncontrarException e) {
				System.out.println(e.getMessage());
			} catch (UsuarioJaAdicionadoException e) {

				System.out.println(e.getMessage());
			}

			m.segundoMenuLogado(p);
			break;
		case 4:
			System.out.println("=====================================================");
			p.listaAmigosPendentes();
			if (p.getListaAmigosPendetesSize() == 0) {
				m.segundoMenuLogado(p);
			}
			System.out.println("ESCOLHA QUAL AMIGO DESEJA ADICIONAR(DIGITE O CPF DELE):");
			String escolha = sc.next(); // VERIFICAR SE EXISTE

			try {
				p.aceitarConvite("SIM", f.searchPessoa(escolha));
				f.searchPessoa(escolha).aceitarConvite("SIM", p);
			} catch (UsuarioNaoEncontrarException e) {
				System.out.println(e.getMessage());
				m.segundoMenuLogado(p);
			}
			try {
				p.removerPendenciaAmigos(f.searchPessoa(escolha));
			} catch (UsuarioNaoEncontrarException e) {
				System.out.println(e.getMessage());
				m.segundoMenuLogado(p);
			}

			System.out.println("AMIGO ADICIONADO COM SUCESSO!");
			System.out.println("=====================================================");
			m.segundoMenuLogado(p);
			break;
		case 5:
			System.out.println("=====================================================");
			System.out.println("TIMELINE: ");
			m.verTimeLine(p);
			System.out.println("=====================================================");
			m.segundoMenuLogado(p);

			break;
		case 6:
			System.out.println("=====================================================");
			m.digitarOquePensa(p);
			System.out.println("PENSAMENTO COMPARTILHADO COM SUCESSO!");
			System.out.println("=====================================================");
			m.segundoMenuLogado(p);
			break;
		case 7:
			System.out.println("=====================================================");
			int codigo = 0;
			System.out.println("DIGITE O CODIGO DO TEXTO");
			try {
				codigo = Integer.parseInt(sc.next());
			} catch (Exception e) {
				System.out.println("CODIGO INVALIDO");
				m.segundoMenuLogado(p);
			}
			Texto txt = null;
			try {
				txt = f.procurarTexti(codigo);
			} catch (TextoNaoEncontrarException e) {

				System.out.println(e.getMessage());
				m.segundoMenuLogado(p);
			}
			for (Pessoa pee : txt.getCurtidas()) {
				if (pee.getCpf().equalsIgnoreCase(p.getCpf())) {
					System.out.println("MENSSAGEM JA FOI CURTIDA");
					m.segundoMenuLogado(p);
				}
			}
			m.curtirMensagem(p, txt);
			System.out.println("=====================================================");
			m.segundoMenuLogado(p);
			break;

		case 0:
			m.primeiroMenu();

			break;

		default:
			System.out.println("OPS! Acho que vocÊ escolheu a opção errada :)");
			m.segundoMenuLogado(p);
			;

			break;
		}
	}

	public void curtirMensagem(Pessoa p, Texto txt) {

		txt.addListaCurtida(p);
		System.out.println("MENSSAGEM CURTIDA COM SUCESSO");
		f.savelistTEXTO();
		f.savelist();
	}

	public void verTimeLine(Pessoa p) {
		List<Pessoa> listaAmigos = p.getAmigos();
		List<Texto> listaTextoDoIndividuoLogado = p.getTextosParaTimeline();
		List<Texto> novaListaTextoAmigos = new ArrayList<Texto>();
		for (Pessoa pessoa : listaAmigos) {
			for (Texto texto : pessoa.getTextosParaTimeline()) {
				novaListaTextoAmigos.add(texto);
			}
		}
		for (Texto texto : listaTextoDoIndividuoLogado) {
			novaListaTextoAmigos.add(texto);
		}

		Collections.sort(novaListaTextoAmigos, new Comparator<Texto>() {

			@Override
			public int compare(Texto o1, Texto o2) {

				if (o1.getData() < o2.getData()) {
					return -1;
				}
				if (o1.equals(o2)) {
					return 0;
				} else {
					return 1;
				}
			}

		}

		);
		for (Texto texto : novaListaTextoAmigos) {
			for (Texto txt : f.getListaTexto()) {
				if (txt.getData() == texto.getData()) {
					System.out.println("-----------------------------------------------------");
					System.out.println("NOME: " + txt.getPessoa().getNome() + " Codigo: " + txt.getData()
							+ " Curtidas: " + txt.getCurtidas().size());
					System.out.println(texto.getTexto());
					System.out.println("-----------------------------------------------------");
				}
			}

		}

	}

	public void digitarOquePensa(Pessoa p) {
		System.out.println("DIGITE ABAIXO O QUE PENSA : ");
		sc.nextLine();
		String oquepensa = sc.nextLine();
		Texto oquepensatxt = new Texto(oquepensa, p);
		f.cadastrarTexto(oquepensatxt);
		p.adicionarTextosParaTimeLine(oquepensatxt);

	}

	public void cadastrarIndividuos() {
		System.out.println("DIGITE SEU NOME");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("DIGITE SUA IDADE");
		int age = 0;
		try {
			age = Integer.parseInt(sc.next());
		} catch (Exception e) {
			System.out.println("CARACTER INVALIDO");
			m.primeiroMenu();
		}

		System.out.println("DIGITE SEU CPF");
		String cpfPrimeiraVez = sc.next();
		Pessoa person = new Pessoa(nome, age, cpfPrimeiraVez);
		try {
			f.cadastrarPessoa(person);
		} catch (PessoaJaExisteException e) {

			System.out.println(e.getMessage());
		} catch (UsuarioNaoEncontrarException e) {

			System.out.println(e.getMessage());
		}
	}

	public void procurarFriends(Pessoa p) throws UsuarioNaoEncontrarException, UsuarioJaAdicionadoException {
		System.out.println("DIGITE O CPF DO SEU AMIGO");
		String cpf = sc.next();
		Pessoa a = f.searchPessoa(cpf);
		System.out.println("Deseja Adicionar");
		String resposta = sc.next();
		if (resposta.equalsIgnoreCase("sim")) {
			p.addPendenciaAmigos(a);

		} else {
			m.segundoMenuLogado(p);
		}

	}

	public void amigoComumEntreDoisAmigos(Pessoa p) throws UsuarioNaoEncontrarException {

		System.out.println("DIGITE O CPF DO SEU AMIGO OU DIGITE -VOLTAR- PARA VOLTAR AO MENU PRINCIPAL");
		String cpf2 = sc.next();
		if (cpf2.equalsIgnoreCase("voltar")) {
			m.segundoMenuLogado(p);
		}
		Pessoa b = f.searchPessoa(cpf2);
		Pessoa person1 = f.searchPessoa(p.getCpf()); // VERIFICAR SE EXISTE
		Pessoa person2 = f.searchPessoa(b.getCpf()); // VERIFICAR SE EXISTE

		Set<Pessoa> set1 = new HashSet<Pessoa>(person1.getAmigos());
		for (Pessoa pessoa : person2.getAmigos()) {
			if (set1.contains(pessoa)) {
				System.out.println(pessoa.getNome());
			}
		}

	}

	public void exibirAmigos(Pessoa p) {
		System.out.println("=====================================================");
		p.listaAmigos();
		System.out.println("=====================================================");
	}

	public void cadastrarPostagem(Pessoa p) {
		System.out.println("Digite o que Pensa");
		String think = sc.next();
		Texto txt = new Texto(think, p);
		f.cadastrarTexto(txt);
		System.out.println("=====================================================");
		System.out.println("MENSSAGEM CADASTRADA COM SUCESSO");
		System.out.println("=====================================================");
	}

	public Pessoa entrarUsuario(String cpf) throws UsuarioNaoEncontrarException {
		return f.searchPessoa(cpf);

	}

}
