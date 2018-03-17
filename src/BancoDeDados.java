import Itens.Livro;
import java.util.LinkedList;

public class BancoDeDados {
    
    private int maxUsuarios = 30;
    private int maxItens = 90;
    public Usuario[] usuarios = new Usuario[maxUsuarios];
    public Livro[] livros = new Livro[maxItens];
    private int proximoIndiceLivreParaUsuario = 0;
    private int proximoIndiceLivreParaIten = 0;
    private PromptInterface in;
    
    public BancoDeDados (PromptInterface In){
        this.in = In;
    }
    
    //-----Funções de Auxílio-----//
    
    //+++++Testes+++++//
    
    private boolean UsuariosCheios (int x){
        return x == maxUsuarios;
    }
    
    private boolean ItensCheios (int x){
        return x == maxItens;
    }
    
    private boolean CodigoDeUsuarioExistente (int x){
        for(int i = 0; i < proximoIndiceLivreParaUsuario; i++){
            if (usuarios[i].GetCodigo() == x)
                return true;
        }
        return false;
    }
    
    private boolean CodigoDeLivroExistente (int x){
        for(int i = 0; i < proximoIndiceLivreParaIten; i++){
            if (livros[i].GetCodigo() == x)
                return true;
        }
        return false;
    }
    
    //+++++  +++++  +++++//
    
    //+++++Valores+++++//
    
    private int CadastraNumero (int operacao){
        switch (operacao){
            case 1:
                in.PedeCodigo();
                break;
            case 2:
                in.PedeCodigo();
                break;
            case 3:
                in.PedeQuantidade();
                break;
        }
        in.QuebraLinha();
        int numero;
        do{
            numero = in.retornaNumero();
            switch (operacao){
                case 1:
                    if (!CodigoDeUsuarioExistente(numero))
                        return numero;
                    else{
                        in.CodigoExistente();
                        break;
                    }
                case 2:
                    if (!CodigoDeLivroExistente(numero))
                        return numero;
                    else{
                        in.CodigoExistente();
                        break;
                    }
                case 3:
                    if (numero <= 0 || numero > 15){
                        in.QuantidadeDeLivrosInvalida();
                        break;
                    }else
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
        for (int i = 0; i < proximoIndiceLivreParaUsuario; i++)
            if (usuarios[i].GetCodigo() == codigo)
                return i;
        return -1;
    }
    
    private int PosicaoLivro (int codigo){
        for (int i = 0; i < proximoIndiceLivreParaIten; i++)
            if (livros[i].GetCodigo() == codigo)
                return i;
        return -1;
    }
    
    //+++++  +++++  +++++//
    
    //-----  -----  -----//
    
    //-----Funções Principais-----//
    
    public void CadastraUsuario(){
        if (UsuariosCheios(proximoIndiceLivreParaUsuario)) {
            in.UsuariosCheios();
            return;
        }
        String nome = CadastraPalavra(1);
        int codigo = CadastraNumero(1);
        usuarios[proximoIndiceLivreParaUsuario] = new Usuario (nome);
        proximoIndiceLivreParaUsuario++;
        in.CadastroDeUsuarioBemSucedido();
    }
    
    public void CadastraItem (){
        if (!ItensCheios(proximoIndiceLivreParaIten)) {
            in.LivrosCheios();
            return;
        }
        String titulo = CadastraPalavra(2);
        String autor = CadastraPalavra(3);
        int codigo = CadastraNumero(2);
        int quantidade = CadastraNumero(3);
        livros[proximoIndiceLivreParaLivro] = new Livro (titulo, autor, codigo, quantidade);
        proximoIndiceLivreParaIten++;
        in.CadastroDeLivroBemSucedido();
    }
    
    public void ListaUsuarios(){
        if (proximoIndiceLivreParaUsuario == 0){
            in.SemUsuarios();
            return;
        }
        for (int i = 0; i < proximoIndiceLivreParaUsuario; i++)
            in.PrintaUsuario(usuarios[i]);
    }
    
    public void ListaItens(){
        if (proximoIndiceLivreParaIten == 0){
            in.SemLivros();
            return;
        }
        for (int i = 0; i < proximoIndiceLivreParaIten; i++)
            in.PrintaLivro(livros[i]);
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
        return livros[posicao].GetQuantidadeDeExemplares() != 0;
    }
    
    public int GetMaxUsuarios (){
        return maxUsuarios;
    }  
    
    public int GetMaxItens (){
        return maxItens;
    }   
    
    //-----  -----  -----//
    
}