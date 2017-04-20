/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTabela;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Pessoa;

/**
 *
 * @author ALEX
 */
public class PessoaModeloTabela extends AbstractTableModel  {

    private List<Pessoa> pessoas;

    public PessoaModeloTabela(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int col) {
        Pessoa pessoa = pessoas.get(linha);
        switch (col)    {
            case 0: return pessoa.getNome();
            case 1: return pessoa.getEndereco();
            case 2: return pessoa.getTelefone();
            case 3: return pessoa.getCidade();
            case 4: return pessoa.getCidade().getEstado();
        }
        return null;
    }
    
    @Override
    public String getColumnName(int col)    {
        switch (col)    {
            case 0: return "Nome";
            case 1: return "Endereço";
            case 2: return "Telefone";
            case 3: return "Cidade";
            case 4: return "Estado";
        }
        return null;
    }
    
    public boolean IsCellEditable (int linha, int col)  {
        return false;
    }
    
}
