public class Usuario {
    
    private String nome;
    private static int codigo = 1;
    private int emprestimos = 0;
    
    Usuario (String Nome){
        SetNome(Nome);
    }
    
    public String GetNome (){
        return nome;
    }
    
    public final void SetNome (String x){
        nome = x;
    }       
    
    public int GetEmprestimos (){
        return emprestimos;
    }
    
    public final void SetEmpresetimos (int x){
        emprestimos += x;
    }     
    
    public int GetCodigo (){
        return codigo;
    }
    
    public final void SetCodigo (){
        codigo = codigo++;
    }     
}