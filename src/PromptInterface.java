import DB.Usuario;
import DB.Livro;
import java.util.Scanner;
import java.util.InputMismatchException;

public class PromptInterface {
    
    private final Scanner sc = new Scanner(System.in);
    public int retornaNumero(){
        do{
            int x; 
            try {
                System.out.println("batata");
                x = sc.nextInt();
                return x;
            }catch (InputMismatchException e){
                System.out.println("ERRO: Digite apenas números!!");
            }
        }while (true);
    }
    
    public String retornaString (){
        return sc.nextLine();
    }
    
    //-----Postagens na Tela-----//
    
    //+++++Principal+++++//
    
    public void MostraMenu (){
        System.out.println("Digite uma das opções abaixo:");
        System.out.println("1 - Para cadastrar um novo usuário");
        System.out.println("2 - Para cadastrar um novo livro");
        System.out.println("3 - Para realizar um empréstimo");
        System.out.println("4 - Para realizar uma devolução");
        System.out.println("5 - Para listar os usuários cadastrados");
        System.out.println("6 - Para listar os livros cadastrados");
        System.out.println("7 - Para listar os livros emprestados por um usuário");
        System.out.println("8 - Para encerrar");
    }
    
    public void Sair (){
        System.out.println("Obrigado por utilizar nosso sistema :)");
        System.out.println("Até mais!");
        sc.close();
    }
    
    public void MostraOpçõesDeEmprestimo (){
        System.out.println("Escolha o tipo de item:");
        System.out.println("1 - Livro");
        System.out.println("2 - CD");
        System.out.println("3 - DVD");
        System.out.println("4 - Catálogo Geral");
    }
    
    //+++++  +++++  +++++//
    
    //+++++Avisos+++++//
    
    public void TipoDeItemInexistente (){
        System.out.println("Operação inválida!! Tipo de Item inexistente!!");
    }
    
    public void OperacaoInvalida (){
        System.out.println("Operação inválida!! Digite números de 1 a 8!!");
    }
    
    public void UsuariosCheios (){
        System.out.println("Não cabe mais nenhum Usuário!");
    }
    
    public void ItensCheios (int item){
        switch(item){
            case 1:
                System.out.println("Não cabe mais nenhum Livro!");
            case 2:
                System.out.println("Não cabe mais nenhum CD!");
            case 3:
                System.out.println("Não cabe mais nenhum DVD!");
            default:
                TipoDeItemInexistente();
        }        
    }
    
    public void CodigoExistente(){
        System.out.println("Código já existente! Digite outro código!!");
    }
    
    public void QuantidadeDeLivrosInvalida(){
        System.out.println("Quantidade de livros invélida!! Digite números entre 1 e 15");
    }
    
    public void SemUsuarios(){
        System.out.println("Não há Usuários cadastrados!");
    }
    
    public void SemLivros(){
        System.out.println("Não há Livros cadastrados!!");
    }
    
    public void UsuarioInexistente(){
        System.out.println("Esse Usuario não existe!");
    }
    
    public void LivroInexistente(){
        System.out.println("Esse Livro não existe!");
    }
    
    public void MaximoDeEmprestimos(){
        System.out.println("Usuario já extrapolou a cota de empréstimos!!");
    }
    
    public void SemExemplares(){
        System.out.println("Não há exemplares dsponíveis desse livro no momento!!");
    }
    
    public void UsuarioJaPegou(){
        System.out.println("O Usuario já está com um exemplar desse livro e não pode pegar outro!!");
    }
    
    public void UsuarioJaDevolveu(){
        System.out.println("O Usuario já devolveu a cópia emprestada do livro!!");
    }
    
    public void SemEmprestimos(){
        System.out.println("Usuario já extrapolou a cota de empréstimos!!");
    }
    
    //+++++  +++++  +++++//
    
    //+++++Pedidos+++++//
    
    public void PedeNome (){
        System.out.print("Nome: ");
    }
    
    public void PedeTitulo (){
        System.out.print("Título: ");
    }
    
    public void PedeAutor (){
        System.out.print("Autor: ");
    }
    
    public void PedeQuantidade (){
        System.out.print("Quantidade de Exemplares: ");
    }
    
    public void PedeCodigo (){
        System.out.print("Código: ");
    }
    
    public void PedeCodigo2 (){
        System.out.println("Código Usuário: ");
    }
    
    public void PedeCodigo3 (){
        System.out.println("Código Livro: ");
    }
    
    public void QuebraLinha (){
        System.out.println();
    }
    
    public void PedeAno (){
        System.out.println("Digite o ano de criação do Item:");
    }
    
    //+++++  +++++  +++++//
    
    //+++++Printar+++++//
    
    public void PrintaUsuario(Usuario u){
        PedeNome();
        System.out.println(u.GetNome());
        QuebraLinha();
        PedeCodigo();
        System.out.println(u.GetCodigo());
        QuebraLinha();
    }
    
    public void PrintaLivro(Livro l){
        PedeTitulo();
        System.out.println(l.GetTitulo());
        QuebraLinha();
        PedeAutor();
        System.out.println(l.GetAutor());
        QuebraLinha();
        PedeCodigo();
        System.out.println(l.GetCodigo());
        QuebraLinha();
    }
    
    //+++++  +++++  +++++//
    
    //+++++Agradecimentos+++++//
    
    public void CadastroDeUsuarioBemSucedido (){
        System.out.println("Usuário cadstrado com sucesso!");
    }
    
    public void CadastroDeItemBemSucedido (){
        System.out.println("Item cadstrado com sucesso!");
    }
    
    //+++++  +++++  +++++//
    
    //-----  -----  -----//
    
}