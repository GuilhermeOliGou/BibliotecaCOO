package Itens;

public class Item {
    protected String titulo;
    protected int codigo;
    protected int ano;
    protected int quantidadeDeExemplares;
    
    public Item (){
        super();
    }
    
    public Item (String Titulo, int Ano, int Codigo, int QuantidadeDeExemplares){
        super();
        SetTitulo(Titulo);
        SetAno(Ano);
        SetCodigo(Codigo);
        SetQuantidadeDeExemplares(QuantidadeDeExemplares);
    }
    
    public String GetTitulo (){
        return titulo;
    }
    
    public void SetTitulo (String x){
        titulo = x;
    }
    
    public int GetCodigo (){
        return codigo;
    }
    
    public void SetCodigo (int x){
        codigo = x;
    }
    
    public int GetAno (){
        return ano;
    }
    
    public void SetAno (int x){
        ano = x;
    }
        
    public int GetQuantidadeDeExemplares (){
        return quantidadeDeExemplares;
    }
    
    public void SetQuantidadeDeExemplares (int x){
        quantidadeDeExemplares += x;
    }
}