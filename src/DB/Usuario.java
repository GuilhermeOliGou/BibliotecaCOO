package DB;

import java.util.LinkedList;
public class Usuario {
    
    private String nome;
    private static int codigo = 1;
    private int emprestimosAtuais = 0;
    private LinkedList<Emprestimo> emprestimos;
    
    public Usuario (String Nome){
        SetNome(Nome);
        SetCodigo();
    }
    
    public String GetNome (){
        return nome;
    }
    
    public final void SetNome (String x){
        nome = x;
    }       
    
    public int GetEmprestimosAtuais (){
        return emprestimosAtuais;
    }
    
    public final void SetEmprestimosAtuais (int x){
        emprestimosAtuais += x;
    }     
    
    public int GetCodigo (){
        return codigo;
    }
    
    public final void SetCodigo (){
        codigo = codigo++;
    }  
    
    public LinkedList<Emprestimo> GetEmprestimo (){
        return emprestimos;
    }
    
    public final void SetEmprestimo (LinkedList<Emprestimo> x){
        emprestimos = x;
    }
}