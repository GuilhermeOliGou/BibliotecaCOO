package DB.Itens;

public class Item {
    protected String titulo;
    protected static int codigo = 1;
    protected int ano;
    protected int quantidadeDeExemplares = 0;
    
    public Item (){
        super();
    }
    
    public Item (String Titulo, int Ano, int QuantidadeDeExemplares){
        super();
        SetTitulo(Titulo);
        SetAno(Ano);
        SetCodigo();
        SetQuantidadeDeExemplares(QuantidadeDeExemplares);
    }
    
    public String GetTitulo (){
        return titulo;
    }
    
    public final void SetTitulo (String x){
        titulo = x;
    }
    
    public int GetCodigo (){
        return codigo;
    }
    
    public final void SetCodigo (){
        codigo = codigo++;
    }
    
    public int GetAno (){
        return ano;
    }
    
    public final void SetAno (int x){
        ano = x;
    }
        
    public int GetQuantidadeDeExemplares (){
        return quantidadeDeExemplares;
    }
    
    public final void SetQuantidadeDeExemplares (int x){
        quantidadeDeExemplares += x;
    }
}