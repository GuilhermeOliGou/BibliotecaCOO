public class Livro extends Item{
    
    public enum GeneroLivro{Drama, FiccaoCientifica, Romance, Fantasia, Didatico, Terror, AutoAjuda, Policial, Misterio, Negocios} 
    
    private GeneroLivro genero;
    
    public Livro(String Titulo, String Autor, int Ano, int Codigo, int QuantidadeDeExemplares){
        super(Titulo, Autor, Ano, Codigo, QuantidadeDeExemplares);
    }
    
}