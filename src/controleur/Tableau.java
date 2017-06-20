package controleur;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
 
public class Tableau extends AbstractTableModel{
     
    private Object[][] Data;
    private String[] Title;
 
    public Tableau(Object[][] data, String[] title){
        super();
        this.Data = data;
        this.Title = title;
    }
    /**
    * Retourne le titre de la colonne � l'indice sp�cif�
    */
    public String getColumnName(int col) {
      return this.Title[col];
    }
 
    /**
     * Retourne le nombre de colonnes
     */
    public int getColumnCount() {
        return this.Title.length;
    }
     
    /**
     * Retourne le nombre de lignes
     */
    public int getRowCount() {
        return this.Data.length;
    }
     
    /**
     * Retourne la valeur � l'emplacement sp�cifi�
     */
    public Object getValueAt(int row, int col) {
        return this.Data[row][col];
    }
     
    /**
     * D�fini la valeur � l'emplacement sp�cifi�
     */
    public void setValueAt(Object value, int row, int col) {
        //On interdit la modification sur certaine colonne !
        if(!this.getColumnName(col).equals("Age") && !this.getColumnName(col).equals("Suppression"))
            this.Data[row][col] = value;
    }
             
    /**
    * Retourne la classe de la donn�e de la colonne
    * @param col
    */
    public Class getColumnClass(int col){
        //On retourne le type de la cellule � la colonne demand�e
        //On se moque de la ligne puisque les donn�es sur chaque ligne sont les m�mes
        //On choisit donc la premi�re ligne
        return this.Data[0][col].getClass();
    }
 
    /**
     * M�thode permettant de retirer une ligne du tableau
     * @param position
     */
    public void removeRow(int position){
         
        int indice = 0, indice2 = 0, nbRow = this.getRowCount()-1, nbCol = this.getColumnCount();
        Object temp[][] = new Object[nbRow][nbCol];
         
        for(Object[] value : this.Data){
            if(indice != position){
                temp[indice2++] = value;
            }
            indice++;
        }
        this.Data = temp;
        temp = null;
        //Cette m�thode permet d'avertir le tableau que les donn�es ont �t� modifi�es
        //Ce qui permet une mise � jours compl�te du tableau
        this.fireTableDataChanged();
    }
     
    /**
     * Permet d'ajouter une ligne dans le tableau
     * @param data
     */
    public void addRow(Object[] data){
        int indice = 0, nbRow = this.getRowCount(), nbCol = this.getColumnCount();
         
        Object temp[][] = this.Data;
        this.Data = new Object[nbRow+1][nbCol];
         
        for(Object[] value : temp)
            this.Data[indice++] = value;
         
             
        this.Data[indice] = data;
        temp = null;
        //Cette m�thode permet d'avertir le tableau que les donn�es ont �t� modifi�es
        //Ce qui permet une mise � jours compl�te du tableau
        this.fireTableDataChanged();
    }
     
     
    public void setData(Object[][] data) {
        Data = data;
    }
    public boolean isCellEditable(int row, int col){
        return true;
    }
    
}
