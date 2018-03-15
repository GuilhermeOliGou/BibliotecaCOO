package Itens;
import java.util.LinkedList;

public class Livro extends Item{
    
    public enum Genero{Drama, FiccaoCientifica, Romance, Fantasia, Didatico, Terror, AutoAjuda, Policial, Misterio, Negocios} 
    
    private LinkedList<String> autor;
    private LinkedList<Genero> genero;
    private String editora;
    private int numEdicao;
    
    public Livro(String Titulo, int Ano, int Codigo, int QuantidadeDeExemplares, LinkedList<String> Autores){
        super(Titulo, Ano, Codigo, QuantidadeDeExemplares);
        SetAutor(Autores);
    }
    
    public LinkedList<String> GetAutor (){
        return autor;
    }
    
    public void SetAutor (LinkedList<String> x){
        autor = x;
    }    
}