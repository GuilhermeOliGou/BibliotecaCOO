import java.util.LinkedList;

import dto.CD;
import dto.Emprestimo;
import dto.Item;
import dto.Livro;
import dto.Usuario;

public class GerenciadorBaseDados extends ConectorJDBC {

	private static final String PASSWORD = "";
	private static final String USER = "root";
	private static final String HOST = "localhost";
	private static final String DB_NAME = "coo2018";

	public GerenciadorBaseDados() {
		super(DB.MYSQL);
	}

	@Override
	protected String getUser() {
		return USER;
	}

	@Override
	protected String getPassword() {
		return PASSWORD;
	}

	@Override
	protected String getDbHost() {
		return HOST;
	}

	@Override
	protected String getDbName() {
		return DB_NAME;
	}

	private void insereItem(Item item) throws Exception {
		abreConexao();
		preparaComandoSQL("insert into Item (qtdTotalExemplares, qtdExemplaresDisponiveis, qtdExemplaresEmprestados, codigo) values (?, ?, ?, ?)");
		pstmt.setInt(1, item.getQtdTotalExemplares());
		pstmt.setInt(2, item.getQtdExemplaresDisponiveis());
		pstmt.setInt(3, item.getQtdExemplaresEmprestados());
		pstmt.setInt(4, item.getCodigo());
		pstmt.execute();
		fechaConexao();
	}

	public void insereUsuario(Usuario usuario) throws Exception {
		abreConexao();
		preparaComandoSQL("insert into Usuario (nome, codigo) values (?, ?)");
		pstmt.setString(1, usuario.getNome());
		pstmt.setInt(2, usuario.getCodigo());
		pstmt.execute();
		fechaConexao();
	}

	public void insereLivro(Livro livro) throws Exception {
		insereItem(livro);
		abreConexao();
		preparaComandoSQL("insert into Livro (autores, titulo, codigo) values (?, ?, ?)");
		pstmt.setString(1, livro.getAutores());
		pstmt.setString(2, livro.getTitulo());
		pstmt.setInt(3, livro.getCodigo());
		pstmt.execute();
		fechaConexao();
	}

	public void insereCD(CD cd) throws Exception {
		insereItem(cd);
		abreConexao();
		preparaComandoSQL("insert into CD (artista, album, codigo) values (?, ?, ?)");
		pstmt.setString(1, cd.getArtista());
		pstmt.setString(2, cd.getAlbum());
		pstmt.setInt(3, cd.getCodigo());
		pstmt.execute();
		fechaConexao();
	}

	public LinkedList<Usuario> listaUsuarios() throws Exception {
		LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
		abreConexao();
		preparaComandoSQL("select codigo, nome from Usuario");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			int codigo = rs.getInt(1);
			String nome = rs.getString(2);
			Usuario usuario = new Usuario(nome, codigo);
			usuarios.add(usuario);
		}

		fechaConexao();
		return usuarios;
	}

	private LinkedList<Item> listaItens() throws Exception {
		LinkedList<Item> itens = new LinkedList<Item>();
		abreConexao();
		preparaComandoSQL("select codigo, " + "qtdExemplaresDisponiveis, "
				+ "qtdExemplaresEmprestados, " + "qtdTotalExemplares "
				+ "from Item");
		rs = pstmt.executeQuery();

		while (rs.next()) {
			int codigo = rs.getInt(1);
			int qtdExemplaresDisponiveis = rs.getInt(2);
			int qtdExemplaresEmprestados = rs.getInt(3);
			int qtdTotalExemplares = rs.getInt(4);
			Item item = new Item(qtdTotalExemplares, qtdExemplaresDisponiveis,
					qtdExemplaresEmprestados, codigo);
			itens.add(item);
		}

		fechaConexao();
		return itens;
	}

	public LinkedList<Livro> listaLivros() throws Exception {
		LinkedList<Livro> livros = new LinkedList<Livro>();
		LinkedList<Item> itens = listaItens();
		abreConexao();
		preparaComandoSQL("select autores, titulo from Livro where codigo = ?");

		for (Item item : itens) {
			pstmt.setInt(1, item.getCodigo());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String autores = rs.getString(1);
				String titulo = rs.getString(2);
				Livro livro = new Livro(autores, titulo, item);
				livros.add(livro);
			}
		}
		
		fechaConexao();
		return livros;
	}

	public LinkedList<Emprestimo> listaEmprestimosEmAbertoDoUsuario(
			Usuario usuario) {
		throw new RuntimeException("método não implementado");
	}
	
	public void insereEmprestimo(Emprestimo emprestimo) {
		throw new RuntimeException("método não implementado");
	}

	public void alteraEmprestimo(Emprestimo emprestimoAlterado) {
		throw new RuntimeException("método não implementado");
	}

	public CD buscaCD(int codigo) {
		throw new RuntimeException("método não implementado");
	}

	public Livro buscaLivro(int codigo) {
		throw new RuntimeException("método não implementado");
	}

	public Usuario buscaUsuario(int codigoUsuario) throws Exception {
		throw new RuntimeException("método não implementado");
	}

	public Emprestimo buscaEmprestimo(int codigoEmprestimo) {
		throw new RuntimeException("método não implementado");
	}
}
