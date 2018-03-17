public class Organizador {
    
    private int maxEmprestimos = 3;
    private boolean[][] matrizDeEmprestimos;
    private BancoDeDados banco;
    private PromptInterface in;
    
    public Organizador(BancoDeDados Banco, PromptInterface In){
        this.banco = Banco;
        matrizDeEmprestimos = new boolean[banco.GetMaxUsuarios()][banco.GetMaxItens()];
        this.in = In;
    }
    
    //-----Funções Auxiliares-----//
    
    private boolean TestaEmprestimos(int usuario){
        return banco.usuarios[usuario].GetEmprestimos() >= maxEmprestimos;
    }
    
    //-----  -----  -----//
    
    //-----Funções Principais-----//
    
    public void EmprestaLivro(){
        int usuario = banco.Acha(1);
        if (usuario == -1){
            in.UsuarioInexistente();
            return;
        }
        int livro = banco.Acha(2);
        if (livro == -1){
            in.LivroInexistente();
            return;
        }
        if (TestaEmprestimos(usuario)){
            in.MaximoDeEmprestimos();
            return;
        }
        if (!banco.ExemplaresDisponiveis(livro)){
            in.SemExemplares();
            return;
        }        
        if (!matrizDeEmprestimos[usuario][livro]){
            in.UsuarioJaPegou();
            return;
        }
        matrizDeEmprestimos[usuario][livro] = true;
        banco.usuarios[usuario].SetEmpresetimos(1);
        banco.livros[livro].SetQuantidadeDeExemplares(-1);
    }
    
    public void DevolveLivro(){
        int usuario = banco.Acha(1);
        if (usuario == -1){
            in.UsuarioInexistente();
            return;
        }
        int livro = banco.Acha(2);
        if (livro == -1){
            in.LivroInexistente();
            return;
        }
        if (matrizDeEmprestimos[usuario][livro]){
            in.UsuarioJaDevolveu();
            return;
        }
        matrizDeEmprestimos[usuario][livro] = false;
        banco.usuarios[usuario].SetEmpresetimos(-1);
        banco.livros[livro].SetQuantidadeDeExemplares(1);
    }
    
    public void MostraEmprestimosDoUsuario(){
        int usuario = banco.Acha(1);
        boolean emprestimos = false;
        for (int i = 0; i < banco.GetMaxItens(); i++)
            if (matrizDeEmprestimos[usuario][i]){
                in.PrintaLivro(banco.livros[i]);
                emprestimos = true;
            }
        if (!emprestimos)
            in.SemEmprestimos();
    }
    
    //-----  -----  -----//
    
}