import java.util.LinkedList;

import dto.CD;
import dto.Emprestimo;
import dto.Livro;
import dto.Usuario;

public class GerenciadorRegrasNegocio {

	private GerenciadorBaseDados gerenciadorBaseDados = new GerenciadorBaseDados();

	public void cadastraUsuario(String nome, int codigo) throws Exception {
		Usuario usuario = new Usuario(nome, codigo);
		gerenciadorBaseDados.insereUsuario(usuario);
	}

	public void cadastraLivro(String titulo, String autores, int codigo,
			int qtdExemplares) throws Exception {
		Livro livro = new Livro(autores, titulo, qtdExemplares, qtdExemplares,
				0, codigo);
		gerenciadorBaseDados.insereLivro(livro);
	}

	public void cadastraCD(String album, String artista, int codigo,
			int qtdExemplares) throws Exception {
		CD cd = new CD(album, artista, qtdExemplares, codigo);
		gerenciadorBaseDados.insereCD(cd);
	}

	public void devolveLivro(int codigoEmprestimo) {
		Emprestimo emprestimo = gerenciadorBaseDados
				.buscaEmprestimo(codigoEmprestimo);
		emprestimo.setFinalizado(true);
		gerenciadorBaseDados.alteraEmprestimo(emprestimo);
	}

	public LinkedList<Usuario> listaUsuarios() throws Exception {
		return gerenciadorBaseDados.listaUsuarios();
	}

	public LinkedList<Livro> listaLivros() throws Exception {
		return gerenciadorBaseDados.listaLivros();
	}

	public LinkedList<Emprestimo> listaEmprestimosEmAbertoDoUsuario(
			Usuario usuario) {
		return gerenciadorBaseDados.listaEmprestimosEmAbertoDoUsuario(usuario);
	}
}
