/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telasPessoa;

import controle.PessoaControle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Interesse;
import modelo.Pessoa;

public class TelaInteresses extends javax.swing.JFrame {

    private Pessoa pessoaLista = new Pessoa();
    private Pessoa pessoas;
    private Interesse inte;

    private String opcao = "Cadastar";

    public static List<Interesse> interesse = new ArrayList<>();

    public TelaInteresses() {
        initComponents();
        
        preparaNomes();
        preencherCombo();

    }

    public TelaInteresses(Pessoa pessoas) {
        initComponents();
        this.pessoas = pessoas;
        preencherCombo();
        setarValores(this.pessoas);
        preparaNomes();

    }

    //prepara os nomes pro título da tela e o nome do botão
    private void preparaNomes() {
//        setTitle(opcao + " Pessoa");
//        botaoCadastrar.setText(opcao);
        
    }

    public void preencherCombo() {
        
        comboIInteresse.removeAllItems();
        comboIInteresse.addItem("");

       
        PessoaControle p = new PessoaControle();
       
        for (Interesse in : p.listaIteresse()) {
            comboIInteresse.addItem(in);
        }
      

    }

    private void setarValores(Pessoa pessoa) {
        
        interesse=(List<Interesse>) pessoa.getInteresses();
        preencherTabelaInteresse();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        comboIInteresse = new javax.swing.JComboBox<>();
        btnIncluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbIteresse = new javax.swing.JTable();
        btnIncluir1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu de opções:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(51, 51, 51)));
        jPanel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboIInteresse.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboIInteresse.setModel(new javax.swing.DefaultComboBoxModel<>(new Object[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboIInteresse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboIInteresseMouseClicked(evt);
            }
        });
        jPanel1.add(comboIInteresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, 30));

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        tbIteresse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Descrição"
            }
        ));
        tbIteresse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbIteresseMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbIteresse);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 350, 120));

        btnIncluir1.setText("Excluir");
        btnIncluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnIncluir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jButton1.setText("Salvar Interesse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboIInteresseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboIInteresseMouseClicked

       
    }//GEN-LAST:event_comboIInteresseMouseClicked

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        if (interesse.contains((Interesse) comboIInteresse.getSelectedItem())){
            JOptionPane.showMessageDialog(this,"Interesse existe");
        }else{
             this.interesse.add((Interesse) comboIInteresse.getSelectedItem());
             preencherTabelaInteresse();
        }
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnIncluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluir1ActionPerformed
       realizarAcao();
    }//GEN-LAST:event_btnIncluir1ActionPerformed

    private void tbIteresseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbIteresseMouseClicked
        selecionarInteresse(evt);
    }//GEN-LAST:event_tbIteresseMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    

    public static void main(String[] args) {
        new TelaInteresses().setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnIncluir1;
    private javax.swing.JComboBox<Object> comboIInteresse;
    private javax.swing.ButtonGroup grupoSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbIteresse;
    // End of variables declaration//GEN-END:variables

   
    
    private void selecionarInteresse(MouseEvent evt){
        int linha = tbIteresse.rowAtPoint(evt.getPoint());
        
        if(linha >= 0){
            tbIteresse.setRowSelectionInterval(linha, linha);
            linha = tbIteresse.getSelectedRow();
            
            this.inte = interesse.get(linha);            
        }
    }
    
    private void realizarAcao(){
       interesse.remove(this.inte);
       preencherTabelaInteresse();
    }
    private void preencherTabelaInteresse(){
        tbIteresse.setModel(new TabelaModeloInterese(interesse));
    }

    private void cadastrar() {
       ///
    }
}
