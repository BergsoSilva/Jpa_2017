package telasPessoa;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Interesse;



public class TabelaModeloInterese extends AbstractTableModel{
    
    private String colunas[] = {"Descrição"}; 
    private List<Interesse> interesses;

    public TabelaModeloInterese(List<Interesse> interesses) {
        this.interesses = interesses;
    }
    
    @Override
    public int getRowCount() {
        return interesses.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Interesse interesse = interesses.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return interesse.getDescricao();
            
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {            
        return colunas[column];       
    }
}
