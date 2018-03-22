import java.util.Scanner;

import dto.CD;
import dto.Emprestimo;
import dto.Item;
import dto.Livro;
import dto.Usuario;

public class GerenciadorInterfacePrompt {

	private Scanner in = new Scanner(System.in);
	private GerenciadorRegrasNegocio gerenciadorRegrasNegocio = new GerenciadorRegrasNegocio();

	public static void main(String[] args) throws Exception {
		GerenciadorInterfacePrompt gerenciadorInterfacePrompt = new GerenciadorInterfacePrompt();
		gerenciadorInterfacePrompt.inicia();
	}

	public void inicia() throws Exception {
		while (true) {
			mostraMenu();

			// lê o comando digitado
			int comando = Integer.parseInt(in.nextLine());

			// ---- trata cada comando em um método separado -----
			switch (comando) {
			case 1:
				cadastraUsuario();
				break;

			case 2:
				cadastraItem();
				break;

			case 3:
				realizaEmprestimo();
				break;

			case 4:
				realizaDevolucao();
				break;

			case 5:
				listaUsuarios();
				break;

			case 6:
				listaLivros();
				break;

			case 7:
				listaLivrosEmprestadosPorCadaUsuario();
				break;

			case 8:
				encerra();
				break;
			// -------------------------------------------------

			default:
				mostraMensagem("Opção Inválida!");
				break;
			}
		}
	}

	private void cadastraItem() throws Exception {
		mostraMensagem("Deseja cadastrar um livro (1) ou um CD (2)?");
		int opcao = leInt("Opção");
		int codigo = leInt("Código");
		int qtdExemplares = leInt("Quantidade de Exemplares");

		switch (opcao) {
		case 1:
			cadastraLivro(codigo, qtdExemplares);
			break;

		case 2:
			cadastraCD(codigo, qtdExemplares);
			break;

		default:
			mostraMensagem("Opção Inválida");
			break;
		}
	}

	private void cadastraLivro(int codigo, int qtdExemplares) throws Exception {
		String titulo = leString("Título");
		String autores = leString("Autores");
		gerenciadorRegrasNegocio.cadastraLivro(titulo, autores, codigo,
				qtdExemplares);
		mostraMensagem("Livro cadastrado com sucesso!");
	}

	private void cadastraCD(int codigo, int qtdExemplares) throws Exception {
		String artista = leString("Artista");
		String album = leString("Album");
		gerenciadorRegrasNegocio.cadastraCD(album, artista, codigo,
				qtdExemplares);
		mostraMensagem("CD cadastrado com sucesso!");
	}

	private void cadastraUsuario() throws Exception {
		String nome = leString("Nome");
		int codigo = leInt("Código");
		gerenciadorRegrasNegocio.cadastraUsuario(nome, codigo);
		mostraMensagem("Usuário cadastrado com sucesso!");
	}

	private void encerra() {
		mostraMensagem("Obrigado por utilizar nosso sistema :)");
		mostraMensagem("Tchau!");
		in.close();
		System.exit(0);
	}

	private void mostraMensagem(String mensagem) {
		System.out.println(mensagem);
	}

	private void mostraMenu() {
		mostraMensagem("----------------------------------------------------------------------");
		mostraMensagem("	Digite uma das opções abaixo:");
		mostraMensagem("		1 - Para cadastrar um novo usuário");
		mostraMensagem("		2 - Para cadastrar um novo item");
		mostraMensagem("		3 - Para realizar um empréstimo");
		mostraMensagem("		4 - Para realizar uma devolução");
		mostraMensagem("		5 - Para listar os usuários cadastrados");
		mostraMensagem("		6 - Para listar os livros cadastrados");
		mostraMensagem("		7 - Para listar os itens emprestados por um usuário");
		mostraMensagem("		8 - Para encerrar");
		mostraMensagem("----------------------------------------------------------------------");
	}
	private void mostraItem(Item item) {
		mostraMensagem("Código Livro: " + item.getCodigo());
		mostraMensagem("Total de Exemplares: " + item.getQtdTotalExemplares());
		mostraMensagem("Exemplares Disponíveis: "
				+ item.getQtdExemplaresDisponiveis());
		mostraMensagem("Exemplares Emprestados: "
				+ item.getQtdExemplaresEmprestados());
	}

	private void mostraLivro(Livro livro) {
		mostraItem(livro);
		mostraMensagem("Título: " + livro.getTitulo());
		mostraMensagem("Autor(es): " + livro.getAutores());
	}

	private void mostraCD(CD cd) {
		mostraItem(cd);
		mostraMensagem("Álbum: " + cd.getAlbum());
		mostraMensagem("Artista(s): " + cd.getArtista());
	}

	private void mostraUsuario(Usuario usuario) {
		mostraMensagem("Nome: " + usuario.getNome());
		mostraMensagem("Código: " + usuario.getCodigo());
	}

	private int leInt(String nomeCampo) {
		mostraMensagem(nomeCampo + ": ");
		int numDigitado = Integer.parseInt(in.nextLine());
		return numDigitado;
	}

	private String leString(String nomeCampo) {
		mostraMensagem(nomeCampo + ": ");
		String txtDigitado = in.nextLine();
		return txtDigitado;
	}
	
	/* ***************************************************************************************
	 * 
	 *  ***************************** MÉTODOS A SEREM CORRIGIDOS *****************************
	 * 
	 * ***************************************************************************************/
	
	private void realizaDevolucao() {
		int codigoEmprestimo = leInt("Código do Empréstimo");
		gerenciadorRegrasNegocio.devolveLivro(codigoEmprestimo);
		mostraMensagem("Devolução realizada com sucesso!");
	}

	private void realizaEmprestimo() {
		int codigoUsuario = leInt("Código do Usuário");
		int codigoLivro = leInt("Código do Livro");
		// gerenciadorRegrasNegocio.emprestaItem(codigoUsuario, codigoLivro);
		mostraMensagem("Empréstimo realizado com sucesso!");
	}
	
	private void listaUsuarios() throws Exception {
		for (Usuario usuario : gerenciadorRegrasNegocio.listaUsuarios()) {
			mostraUsuario(usuario);
			mostraMensagem("");
		}
	}

	private void listaLivros() throws Exception {
		for (Livro livro : gerenciadorRegrasNegocio.listaLivros()) {
			mostraLivro(livro);
			mostraMensagem("");
		}
	}

	private void listaLivrosEmprestadosPorCadaUsuario() throws Exception {
		for (Usuario usuario : gerenciadorRegrasNegocio.listaUsuarios()) {
			mostraMensagem("-----------------------------------------");
			mostraUsuario(usuario);
			mostraMensagem("");
			listaLivrosEmprestados(usuario);
			mostraMensagem("-----------------------------------------");
		}
	}

	private void listaLivrosEmprestados(Usuario usuario) {
		for (Emprestimo emprestimo : gerenciadorRegrasNegocio
				.listaEmprestimosEmAbertoDoUsuario(usuario)) {
			mostraEmprestimo(emprestimo);
			mostraMensagem("");
		}
	}
	private void mostraEmprestimo(Emprestimo emprestimo) {
	}
}
