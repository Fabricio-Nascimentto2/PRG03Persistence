/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.ifba.curso.view;

import br.com.ifba.curso.controller.CursoController;
import br.com.ifba.curso.controller.CursoIController;
import br.com.ifba.curso.entity.Curso;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Insets;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fabricio
 */
public class CursoListar extends javax.swing.JFrame {
    private List<Curso> listaCursos;
    
    // No topo da sua tela (JFrame)
    private final CursoIController cursoController = new CursoController();

    /**
     * Creates new form CursoListar
     */
    public CursoListar() {
        initComponents();
        
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
        @Override
        public void focusGained(java.awt.event.FocusEvent evt) {
            if (jTextField1.getText().equals("Pesquisar....")) {
                jTextField1.setText("");
                jTextField1.setForeground(new java.awt.Color(0, 0, 0)); // Cor preta ao digitar
            }
        }
        
        @Override
        public void focusLost(java.awt.event.FocusEvent evt){
            if (jTextField1.getText().isEmpty()) {
                jTextField1.setText("Pesquisar....");
                jTextField1.setForeground(new java.awt.Color(153, 153, 153)); // Cor cinza padrão
            }
        }
        });
        
        configurarIconesTabela();
        atualizarTabela();
        // Dentro do construtor de CursoListar ou onde configurou a tblCursos
        tblCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int linha = tblCursos.getSelectedRow();
                int coluna = tblCursos.columnAtPoint(evt.getPoint());

                // Evita erro caso clique fora de uma linha válida
                if (linha == -1) return;

                // --- LÓGICA DA COLUNA 4: REMOVER ---
                if (coluna == 4) {
                    int confirma = javax.swing.JOptionPane.showConfirmDialog(null, 
                        "Tem certeza que deseja remover este curso?", "Atenção", javax.swing.JOptionPane.YES_NO_OPTION);

                    if (confirma == javax.swing.JOptionPane.YES_OPTION) {
                        try {
                            Curso selecionado = listaCursos.get(linha); 
                            // O DAO resolve tudo agora:
                            cursoController.delete(selecionado);

                            javax.swing.JOptionPane.showMessageDialog(null, "Curso removido!");
                            atualizarTabela(); 
                        } catch (HeadlessException e) {
                            javax.swing.JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
                        }
                    }
                }else if(coluna == 5){
                    try{
                        Curso cursoSelecionado = listaCursos.get(linha);
                        
                        // Abre a tela de edição passando o curso
                        CursoEditar telaEditar = new CursoEditar(cursoSelecionado);
                        telaEditar.setLocationRelativeTo(null);
                        telaEditar.setVisible(true);

                        // Quando fechar a edição, atualiza a tabela principal
                        telaEditar.addWindowListener(new java.awt.event.WindowAdapter(){
                            @Override
                            public void windowClosed(java.awt.event.WindowEvent e){
                                atualizarTabela();
                            }
                        });
                    }catch(Exception e){
                        javax.swing.JOptionPane.showMessageDialog(null, "Erro ao abrir edição: " + e.getMessage());
                    }
                }
            }
        });

    }
    
    public void pesquisarCursos(String termo){
        try{
            // ESSA LINHA É A CHAVE: Ela atualiza a lista global com o resultado da busca
            this.listaCursos = cursoController.findByName(termo);

            DefaultTableModel model = (DefaultTableModel) tblCursos.getModel();
            model.setRowCount(0);

            for (Curso c : this.listaCursos){
                model.addRow(new Object[]{
                    c.getNome(), c.getCodigo(), c.getVagas(), c.getModalidade(), "", ""
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na pesquisa: " + e.getMessage());
        }
    }

    class RoundedBorder implements Border {
        private int radius;
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }
        @Override
        public boolean isBorderOpaque() {
            return true;
        }
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width-1, height-1, radius, radius);
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

        pnlCorpo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        lblTurma = new javax.swing.JLabel();
        lblModalidade = new javax.swing.JLabel();
        lblRemover = new javax.swing.JLabel();
        lblEditar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        pnlPesquisa = new javax.swing.JPanel();
        lblLupa = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        pnlCadastraCurso = new javax.swing.JPanel();
        btncadastraCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlCorpo.setBackground(new java.awt.Color(0, 102, 102));
        pnlCorpo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("NOME CURSO");

        lblCurso.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(255, 255, 255));
        lblCurso.setText("CODIGO CURSO");

        lblTurma.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblTurma.setForeground(new java.awt.Color(255, 255, 255));
        lblTurma.setText("  VAGAS");

        lblModalidade.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblModalidade.setForeground(new java.awt.Color(255, 255, 255));
        lblModalidade.setText("MODALIDADE");

        lblRemover.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblRemover.setForeground(new java.awt.Color(255, 255, 255));
        lblRemover.setText("         REMOVER");

        lblEditar.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        lblEditar.setForeground(new java.awt.Color(255, 255, 255));
        lblEditar.setText("          EDITAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(lblRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblModalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlCorpo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1140, 50));

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ));
        tblCursos.setToolTipText("");
        tblCursos.setRowHeight(40);
        jScrollPane1.setViewportView(tblCursos);

        pnlCorpo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 1140, 500));

        pnlPesquisa.setBackground(new java.awt.Color(255, 255, 255));

        lblLupa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa.png"))); // NOI18N
        pnlPesquisa.add(lblLupa);

        jTextField1.setColumns(15);
        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setText("Pesquisar....");
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        pnlPesquisa.add(jTextField1);

        pnlCorpo.add(pnlPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 370, 50));

        pnlCadastraCurso.setBackground(new java.awt.Color(0, 153, 153));
        pnlCadastraCurso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));

        btncadastraCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adicionar-usuario (1).png"))); // NOI18N
        btncadastraCurso.setBorderPainted(false);
        btncadastraCurso.setContentAreaFilled(false);
        btncadastraCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastraCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadastraCursoLayout = new javax.swing.GroupLayout(pnlCadastraCurso);
        pnlCadastraCurso.setLayout(pnlCadastraCursoLayout);
        pnlCadastraCursoLayout.setHorizontalGroup(
            pnlCadastraCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastraCursoLayout.createSequentialGroup()
                .addComponent(btncadastraCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlCadastraCursoLayout.setVerticalGroup(
            pnlCadastraCursoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadastraCursoLayout.createSequentialGroup()
                .addComponent(btncadastraCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlCorpo.add(pnlCadastraCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 170, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCorpo, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btncadastraCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastraCursoActionPerformed
        CadastraCurso tela = new CadastraCurso();
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

        tela.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                atualizarTabela(); 
            }
        });
        
    }//GEN-LAST:event_btncadastraCursoActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String termo = jTextField1.getText().trim();
        if(termo.length() > 0){
            pesquisarCursos(termo);
        }else{
            atualizarTabela();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CursoListar().setVisible(true);
            }
        });
    }
    
    private void configurarIconesTabela() {
    try {
        // Carrega as imagens da pasta resources/images
        ImageIcon imgRemover = new ImageIcon(getClass().getResource("/images/remover.png"));
        ImageIcon imgEditar = new ImageIcon(getClass().getResource("/images/editar.png"));

        //  renderizador para desenhar os ícones nas células
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // Garante que não apareça texto, apenas o ícone
                label.setText(""); 
                label.setHorizontalAlignment(JLabel.CENTER);

                // Coluna 4 é REMOVER, Coluna 5 é EDITAR (ajuste se a sua ordem for diferente)
                switch (column) {
                    case 4 -> label.setIcon(imgRemover);
                    case 5 -> label.setIcon(imgEditar);
                    default -> label.setIcon(null); // Outras colunas não têm ícone
                }

                return label;
            }
        };

        // Aplica o renderizador nas colunas de ação
        tblCursos.getColumnModel().getColumn(4).setCellRenderer(renderer);
        tblCursos.getColumnModel().getColumn(5).setCellRenderer(renderer);

    } catch (Exception e) {
        System.err.println("Erro ao carregar ícones: " + e.getMessage());
    }
}
    public void atualizarTabela(){
        try {
        // ESSA LINHA É CRUCIAL:
        this.listaCursos = cursoController.findAll(); 

        DefaultTableModel model = (DefaultTableModel) tblCursos.getModel();
        model.setRowCount(0);

        for (Curso c : this.listaCursos) {
            model.addRow(new Object[]{
                c.getNome(), c.getCodigo(), c.getVagas(), c.getModalidade(), "", ""
            });
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
    }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastraCurso;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEditar;
    private javax.swing.JLabel lblLupa;
    private javax.swing.JLabel lblModalidade;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRemover;
    private javax.swing.JLabel lblTurma;
    private javax.swing.JPanel pnlCadastraCurso;
    private javax.swing.JPanel pnlCorpo;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JTable tblCursos;
    // End of variables declaration//GEN-END:variables
}
