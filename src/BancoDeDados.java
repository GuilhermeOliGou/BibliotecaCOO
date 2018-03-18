import Itens.CD;
import Itens.DVD;
import Itens.Livro;
import java.util.LinkedList;

public class BancoDeDados {
    
    private int maxUsuarios;
    private int maxLivros;
    private int maxCDs;
    private int maxDVDs;
    private int quantidadeDeUsuarios = 0;
    private int quantidadeDeLivros = 0;
    private int quantidadeDeCDs = 0;
    private int quantidadeDeDVDs = 0;
    private LinkedList<Usuario> usuarios;
    private LinkedList<Livro> livros;
    private LinkedList<CD> CDs;
    private LinkedList<DVD> DVDs;
    private LinkedList<Emprestimo> emprestimos;
    private PromptInterface in;
    
    public BancoDeDados (PromptInterface In){
        SetIn(In);
        SetMaxUsuarios(60);
        SetMaxLivros(200);
        SetMaxCDs(100);
        SetMaxDVDs(100);
    }
    
    //-----Funções de Auxílio-----//
    
    //+++++Testes+++++//
    
    private boolean UsuariosCheios (int x){
        return x == maxUsuarios;
    }
    
    private boolean ItensCheios (int operacao){
        switch(operacao){
            case 1:
                return quantidadeDeLivros >= maxLivros;
            case 2:
                return quantidadeDeCDs >= maxCDs;
            case 3:
                return quantidadeDeDVDs >= maxDVDs;
            default:
                return false;
        }        
    }
    
    /*private boolean CodigoDeUsuarioExistente (int x){
        for(int i = 0; i < quantidadeDeUsuarios; i++){
            if (usuarios.get(i).GetCodigo() == x)
                return true;
        }
        return false;
    }
    
    private boolean CodigoDeLivroExistente (int x){
        for(int i = 0; i < proximoIndiceLivreParaIten; i++){
            if (livros.get(i).GetCodigo() == x)
                return true;
        }
        return false;
    }*/
    
    //+++++  +++++  +++++//
    
    //+++++Valores+++++//
    
    private int CadastraNumero (int operacao){
        switch (operacao){
            case 1:
                in.MostraOpçõesDeEmprestimo();
                break;
            case 2:
                in.PedeQuantidade();
                break;
            case 3:
                in.PedeAno();
                break;
        }
        in.QuebraLinha();
        int numero;
        do{
            numero = in.retornaNumero();
            switch (operacao){
                case 1:
                    return numero;
                case 2:
                    if (numero <= 0 || numero > 15){
                        in.QuantidadeDeLivrosInvalida();
                        break;
                    }else
                        return numero;
                case 3:
                    return numero;
            }
        }while (true);
    }
    
    private String CadastraPalavra (int operacao){
        switch(operacao){
            case 1:
                in.PedeNome();
                break;  
            case 2:
                in.PedeTitulo();
                break;  
            case 3:
                in.PedeAutor();
                break;  
        }
        in.QuebraLinha();
        return in.retornaString();
    }
    
    private int PosicaoUsuario (int codigo){
        for (int i = 0; i < quantidadeDeUsuarios; i++)
            if (usuarios.get(i).GetCodigo() == codigo)
                return i;
        return -1;
    }
    
    private int PosicaoLivro (int codigo){
        for (int i = 0; i < proximoIndiceLivreParaIten; i++)
            if (livros.get(i).GetCodigo() == codigo)
                return i;
        return -1;
    }
    
    private LinkedList<String> CadastraGrupoDePalavras (int operacao){
        LinkedList<String> grupoDePalavras;
        do {
            switch(operacao){
                case 1:
                    
            }
        }while(true);
        return grupoDePalavras;
    }
    
    //+++++  +++++  +++++//
    
    //-----  -----  -----//
    
    //-----Funções Principais-----//
    
    public void CadastraUsuario(){
        if (UsuariosCheios(quantidadeDeUsuarios)) {
            in.UsuariosCheios();
            return;
        }
        String nome = CadastraPalavra(1);
        Usuario usuario = new Usuario (nome);
        usuarios.addLast(usuario);
        quantidadeDeUsuarios++;
        in.CadastroDeUsuarioBemSucedido();
    }
    
    public void CadastraItem (){
        int operacao = CadastraNumero(1);
        if (!ItensCheios(operacao)) {
            in.ItensCheios(operacao);
            return;
        }
        String titulo = CadastraPalavra(2);
        int ano = CadastraNumero(3);
        int quantidade = CadastraNumero(2);
        switch (operacao){
            case 1:
                LinkedList<String> autores = CadastraGrupoDePalavras(operacao);
                quantidadeDeLivros += quantidade;
                break;
            case 2:
                quantidadeDeCDs += quantidade;
                break;
            case 3:
                quantidadeDeDVDs += quantidade;
                break;
        }
        in.CadastroDeItemBemSucedido();
    }
    
    public void ListaUsuarios(){
        if (quantidadeDeUsuarios == 0){
            in.SemUsuarios();
            return;
        }
        for (int i = 0; i < quantidadeDeUsuarios; i++)
            in.PrintaUsuario(usuarios.get(i));
    }
    
    public void ListaItens(){
        if (proximoIndiceLivreParaIten == 0){
            in.SemLivros();
            return;
        }
        for (int i = 0; i < proximoIndiceLivreParaIten; i++)
            in.PrintaLivro(livros.get(i));
    }
    
    //-----  -----  -----//
    
    //-----Funções Secundárias-----//
    
    public int Acha(int operacao){
        if (operacao == 1)
            in.PedeCodigo2();
        else
            in.PedeCodigo3();
        int codigo = in.retornaNumero();
        switch (operacao){
            case 1:
                return PosicaoUsuario(codigo);
            case 2:
                return PosicaoLivro(codigo);
            default:
                return -1;
        }
    }
    
    public boolean ExemplaresDisponiveis (int posicao){
        return livros.get(posicao).GetQuantidadeDeExemplares() != 0;
    }
    
    public int GetMaxUsuarios (){
        return maxUsuarios;
    }  
    
    public final void SetMaxUsuarios (int x){
        maxUsuarios = x;
    }
    
    public int GetMaxLivros (){
        return maxLivros;
    }  
    
    public final void SetMaxLivros (int x){
        maxLivros = x;
    }
    
    public int GetMaxCDs (){
        return maxCDs;
    }  
    
    public final void SetMaxCDs (int x){
        maxCDs = x;
    }
    
    public int GetMaxDVDs (){
        return maxDVDs;
    }  
    
    public final void SetMaxDVDs (int x){
        maxDVDs = x;
    }
    
    public PromptInterface GetIn (){
        return in;
    }
    
    public final void SetIn (PromptInterface x){
        this.in = x;
    }  
    
    //-----  -----  -----//
    
}