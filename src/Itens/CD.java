package Itens;
import java.util.LinkedList;

public class CD extends Item{
    public enum Genero{Pop, Rock, Indie, MPB, Eletrônica, Sertanejo, Alternativo}
    
    private LinkedList<Genero> genero;
    private LinkedList<String> Membros;
    
    public CD (String Titulo, int Ano, int Codigo, int QuantidadeDeExemplares){
        super(Titulo, Ano, Codigo, QuantidadeDeExemplares);
    }
    
}
