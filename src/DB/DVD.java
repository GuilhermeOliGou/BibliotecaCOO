package DB;
import java.util.LinkedList;

public class DVD extends Item {
    
    public enum Genero{Drama, FiccaoCientifica, Romance, Fantasia, Documentario, Terror, AutoAjuda, Policial, Misterio}
        
    private LinkedList<Genero> generos;
    
    public DVD (String Titulo, int Ano, int Codigo, int QuantidadeDeExemplares){
        super(Titulo, Ano, QuantidadeDeExemplares);
    }   
    
    public LinkedList<Genero> GetGeneros (){
        return generos;
    }
    
    public void SetGeneros (LinkedList<Genero> x){
        generos = x;
    }

}
