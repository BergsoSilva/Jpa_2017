package telasPessoa;

import controle.EstadoDAO;
import controle.PessoaControle;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import modelo.Cidade;
import modelo.Estado;
import modelo.Interesse;
import modelo.Pessoa;
import util.JPAUtil;

public class TelaPessoaAlterar extends javax.swing.JFrame {

    /**
     * Creates new form TelaPessoaCadastrar
     */
    Pessoa pessoa;
    Pessoa p=new Pessoa();
    
    public TelaPessoaAlterar() {
        initComponents();
        carregarComboEstado();
       
    }
    public TelaPessoaAlterar(Pessoa pessoa){
        initComponents();
        this.pessoa=pessoa;
        carregarComboEstado();
         mostrarObjeto();
        
    }
    
    private void preencherObjeto()  {
        
        p.setId(pessoa.getId());
       
        p.setNome(campoNome.getText());
        p.setEndereco(campoEndereco.getText());
        p.setTelefone(campoTelefone.getText());
        p.setCidade((Cidade) comboCidade.getSelectedItem());
        
        
    }
    private void mostrarObjeto(){
        campoNome.setText(pessoa.getNome());
        campoEndereco.setText(pessoa.getEndereco());
        campoTelefone.setText(pessoa.getTelefone());
        comboEstado.setSelectedItem(pessoa.getCidade().getEstado());
        comboEstado.setSelectedIndex((int) pessoa.getCidade().getId());
       
        
        
    }
    
    private void carregarComboEstado()    {
        try {
            EntityManager em = JPAUtil.getJPAUtil();
            EstadoDAO dao = new EstadoDAO(em);
            List<Estado> estados = dao.listar();
            em.getTransaction().begin();
            comboEstado.removeAllItems();
            comboEstado.addItem(" ");
            for (Estado estado : estados) {
                comboEstado.addItem(estado);
            }
            em.getTransaction().commit();
            em.clear();
            em.close();
        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation c : ex.getConstraintViolations()) {
                JOptionPane.showMessageDialog(null, c.getMessage());
            }
        }
    }
    
    private void carregarComboCidade()    {
        try {
            EntityManager em = JPAUtil.getJPAUtil();
            EstadoDAO dao = new EstadoDAO(em);
            List<Cidade> cidades = dao.getTodasCidadesEstado((Estado) comboEstado.getSelectedItem());
            em.getTransaction().begin();
            comboCidade.removeAllItems();
            for (Cidade cidade : cidades) {
                comboCidade.addItem(cidade);
            }
            em.getTransaction().commit();
            em.clear();
            em.close();
        } catch (ConstraintViolationException ex) {
            for (ConstraintViolation c : ex.getConstraintViolations()) {
                JOptionPane.showMessageDialog(null, c.getMessage());
            }
        }
    }
    
    private void limpar()   {
        campoNome.setText(null);
        campoEndereco.setText(null);
        campoTelefone.setText(null);
        comboCidade.setSelectedItem(null);
    }
    
    private void salvar()   {
       
        try {
            EntityManager em = JPAUtil.getJPAUtil();
             preencherObjeto();
            
            PessoaControle controle = new PessoaControle();
           // p = new Pessoa();
            em.getTransaction().begin();
            Pessoa paux =  em.find(Pessoa.class, pessoa.getId());
            em.getTransaction().commit();
            em.close();
            
             if(paux.equals(pessoa)){
                    JOptionPane.showMessageDialog(null, "Alteração não realizada !!!");
                    
             }else{
                     
                     controle.alterar(p);
                   JOptionPane.showMessageDialog(null, "Operação Realizada com Sucesso !!!"); 
            }
           
            
            
            
            
            //
        } catch (ConstraintViolationException cex) {
            for (ConstraintViolation c : cex.getConstraintViolations()) {
                JOptionPane.showMessageDialog(null, c.getMessage());
            }
            campoNome.setFocusable(true);
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        rotuloNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campoTelefone = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        campoEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboCidade = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Cadastrar Pessoa");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rotuloNome.setText("Nome:");
        jPanel1.add(rotuloNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));
        jPanel1.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 300, -1));

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, -1, -1));

        jLabel1.setText("Endereço:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        try {
            campoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        campoTelefone.setText("(  )      -     ");
        campoTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelefoneActionPerformed(evt);
            }
        });
        jPanel1.add(campoTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 300, -1));

        jLabel2.setText("Telefone:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel1.add(campoEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 300, -1));

        jLabel3.setText("Cidade:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        comboCidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCidadeMouseClicked(evt);
            }
        });
        jPanel1.add(comboCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 300, -1));

        jLabel4.setText("Estado:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jPanel1.add(comboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 300, -1));

        jButton1.setText("Iteresses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 410));

        setSize(new java.awt.Dimension(346, 465));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        dispose();
        System.out.println(pessoa.getCidade().getEstado().getNome());
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        salvar();
        limpar();
        campoNome.setFocusable(true);
        dispose();
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void campoTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelefoneActionPerformed

    }//GEN-LAST:event_campoTelefoneActionPerformed

    private void comboCidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCidadeMouseClicked
        carregarComboCidade();
    }//GEN-LAST:event_comboCidadeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        TelaInteresses inte = new TelaInteresses(this.pessoa);
        inte.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {   
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaAlterar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPessoaAlterar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoNome;
    private javax.swing.JFormattedTextField campoTelefone;
    private javax.swing.JComboBox comboCidade;
    private javax.swing.JComboBox comboEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel rotuloNome;
    // End of variables declaration//GEN-END:variables
}
