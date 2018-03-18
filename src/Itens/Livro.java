package Itens;
import java.util.LinkedList;

public class Livro extends Item{
    
    public enum Genero{Drama, FiccaoCientifica, Romance, Fantasia, Didatico, Terror, AutoAjuda, Policial, Misterio, Negocios} 
    
    private LinkedList<String> autor;
    private LinkedList<Genero> generos;
    private String editora;
    private int numEdicao;
    
    public Livro(String Titulo, int Ano, int QuantidadeDeExemplares, LinkedList<String> Autores, LinkedList<Genero> Generos, String Editora, int NumEdicao){
        super(Titulo, Ano, QuantidadeDeExemplares);
        SetAutor(Autores);
        SetGeneros(Generos);
        SetEditora(Editora);
        SetNumEdicao(NumEdicao);
    }
    
    public LinkedList<String> GetAutor (){
        return autor;
    }
    
    public final void SetAutor (LinkedList<String> x){
        autor = x;
    }    
    
    public LinkedList<Genero> GetGeneros (){
        return generos;
    }
    
    public final void SetGeneros (LinkedList<Genero> x){
        generos = x;
    }    
    
    public String GetEditora (){
        return editora;
    }
    
    public final void SetEditora (String x){
        editora = x;
    }       
    
    public int GetNumEdicao (){
        return numEdicao;
    }
    
    public final void SetNumEdicao (int x){
        numEdicao = x;
    }     
}