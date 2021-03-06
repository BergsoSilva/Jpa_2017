package telasPessoa;

import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import modelo.Pessoa;
import controle.PessoaControle;

public class TelaPessoaExcluir extends javax.swing.JFrame {

    /**
     * Creates new form TelaPessoaExcluir
     */
    Pessoa pessoa;
    
    public TelaPessoaExcluir() {
        initComponents();
    }
    
    public TelaPessoaExcluir(Pessoa pessoa) {
        this();
        this.pessoa = pessoa;
                
        rotuloPergunta.setText("Deseja Realmente EXCLUIR"
                + " a Pessoa " + pessoa.getNome() + " ??");
    }
    
    private void deletar()  {
        PessoaControle controle = new PessoaControle();
        try {
            controle.excluir(pessoa);
        } catch (ConstraintViolationException cex) {
            for (ConstraintViolation c : cex.getConstraintViolations()) {
                JOptionPane.showMessageDialog(null, c.getMessage());
            }
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
        jSeparator1 = new javax.swing.JSeparator();
        botaoSim = new javax.swing.JButton();
        BotaoNao = new javax.swing.JButton();
        rotuloPergunta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Excluir Pessoa");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 10));

        botaoSim.setText("Sim");
        botaoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSimActionPerformed(evt);
            }
        });
        jPanel1.add(botaoSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        BotaoNao.setText("Não");
        BotaoNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNaoActionPerformed(evt);
            }
        });
        jPanel1.add(BotaoNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        rotuloPergunta.setText("Pergunta:");
        jPanel1.add(rotuloPergunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 360, 150));

        setSize(new java.awt.Dimension(377, 189));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSimActionPerformed
        deletar();
        JOptionPane.showMessageDialog(null, "Operação Realizada com Sucesso !!!");
        dispose();
    }//GEN-LAST:event_botaoSimActionPerformed

    private void BotaoNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNaoActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoNaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPessoaExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPessoaExcluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPessoaExcluir().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoNao;
    private javax.swing.JButton botaoSim;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel rotuloPergunta;
    // End of variables declaration//GEN-END:variables
}
