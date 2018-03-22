package DB;

import DB.Usuario;
import DB.Item;

public class Emprestimo {
    
    private Item item;
    private Usuario usuario;
    private int dataDeEmprestimo;
    private int dataDeDevolucao;
    private int numDeRenovacoes;

    public Emprestimo(Item item, Usuario usuario, int dataDeEmprestimo, int dataDeDevolucao) {
        SetItem(item);
        SetUsuario(usuario);
        SetDataDeEmprestimo(dataDeEmprestimo);
        SetDataDeDevolucao(dataDeDevolucao);
        SetNumDeRenovacoes(0);
    }
    
    public Item GetItem() {
        return item;
    }

    public final void SetItem(Item x) {
        this.item = x;
    }

    public Usuario GetUsuario() {
        return usuario;
    }

    public final void SetUsuario(Usuario x) {
        this.usuario = x;
    }

    public int GetDataDeEmprestimo() {
        return dataDeEmprestimo;
    }

    public final void SetDataDeEmprestimo(int x) {
        this.dataDeEmprestimo = x;
    }

    public int GetDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void SetDataDeDevolucao(int x) {
        this.dataDeDevolucao = x;
    }
         
    public int GetNumDeRenovacoes() {
        return numDeRenovacoes;
    }

    public void SetNumDeRenovacoes(int x) {
        this.numDeRenovacoes += x;
    }
}
