package Itens;
import java.util.LinkedList;

public class CD extends Item{
    public enum Genero{Pop, Rock, Indie, MPB, Eletrônica, Sertanejo, Alternativo}
    
    private LinkedList<String> membros;
    private LinkedList<Genero> generos;
    
    public CD (String Titulo, int Ano, int Codigo, int QuantidadeDeExemplares){
        super(Titulo, Ano, QuantidadeDeExemplares);
    }
    
    public LinkedList<String> GetMembros (){
        return membros;
    }
    
    public void SetAutor (LinkedList<String> x){
        membros = x;
    }    
    
    public LinkedList<Genero> GetGeneros (){
        return generos;
    }
    
    public void SetGeneros (LinkedList<Genero> x){
        generos = x;
    }    
}
