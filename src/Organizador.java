public class Organizador {
    
    private int maxEmprestimos;
    private BancoDeDados banco;
    private PromptInterface in;
    
    public Organizador(BancoDeDados Banco, PromptInterface In){
        SetMaxEmprestimos(3);
        SetBanco(Banco);
        SetIn(In);
    }
    
    //-----Funções Auxiliares-----//
    
    private boolean TestaEmprestimos(int usuario){
        return banco.usuarios.get(usuario).GetEmprestimosAtuais() >= maxEmprestimos;
    }
    
    //-----  -----  -----//
    
    //-----Funções Principais-----//
    
    public void EmprestaItem(){
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
        banco.usuarios.get(usuario).SetEmprestimosAtuais(1);
        banco.livros.get(livro).SetQuantidadeDeExemplares(-1);
    }
    
    public void DevolveItem(){
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
        banco.usuarios.get(usuario).SetEmprestimosAtuais(-1);
        banco.livros.get(livro).SetQuantidadeDeExemplares(1);
    }
    
    public void MostraEmprestimosDoUsuario(){
        int usuario = banco.Acha(1);
        boolean emprestimos = false;
        for (int i = 0; i < banco.GetMaxItens(); i++)
            if (matrizDeEmprestimos[usuario][i]){
                in.PrintaLivro(banco.livros.get(i));
                emprestimos = true;
            }
        if (!emprestimos)
            in.SemEmprestimos();
    }
    
    //-----  -----  -----//
    
    //-----Funções Secundárias-----//
    
    public int GetMaxEmprestimos (){
        return maxEmprestimos;
    }
    
    public final void SetMaxEmprestimos (int x){
        maxEmprestimos = x;
    }   
    public BancoDeDados GetBanco (){
        return banco;
    }
    
    public final void SetBanco (BancoDeDados x){
        banco = x;
    }   
    public PromptInterface GetIn (){
        return in;
    }
    
    public final void SetIn (PromptInterface x){
        this.in = x;
    }  
    
    //-----  -----  -----//    
}