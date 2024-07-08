
import java.util.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

//para trabalhar com banco de dados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class CadProdutosFuncaoBotoes extends CadProdutos implements ActionListener {

    //objetos para conectar-se ao banco de dados
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private Date data = new Date();
    private SimpleDateFormat formataDataBanco = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat formataTodaTela = new SimpleDateFormat("dd-MM-yy");

    public CadProdutosFuncaoBotoes() {
        btnovo.addActionListener(this);
        btsalvar.addActionListener(this);
        btexcluir.addActionListener(this);
        btpesquisar.addActionListener(this);
        btalterar.addActionListener(this);
        btfechar.addActionListener(this);

        try {
            //conectar ao banco 
            //1º registro da classe (informar qual classe do conector adicionado fara a comunicação do java com o mySql)
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2º dizer qual banco de dados
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco5006", "root", "");
        } catch (Exception ex) {
            String m = "ocorreu o seguinte erro ao conectar-se ao banco de dados: " + ex;
            JOptionPane.showMessageDialog(null, m);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btexcluir) {
            if (lblid.getText().equals("Automatico")) {
                JOptionPane.showMessageDialog(null, "primeiro pesquise um produto para excluir");
            } else {
                String comando = "Delete from tblprodutos where id =?";
                try {
                    ps = con.prepareStatement(comando);
                    ps.setString(1, lblid.getText());

                    int r = ps.executeUpdate();//executa o comando e guarda no r quantas linhas conseguiu excluir
                    if (r != 0) {
                        txtproduto.setText("");
                        txtmarca.setText("");
                        txtprecocompra.setText("");
                        txtprecovenda.setText("");
                        txtqtd.setText("");
                        txtobs.setText("");
                        lblid.setText("");
                        JOptionPane.showMessageDialog(null, "produto excluido!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "erro:" + ex);
                }
            }
        }
        if (e.getSource() == btpesquisar) {
            String nomeproduto = JOptionPane.showInputDialog("Nome do produto: ");
            String comando = "Select * from tblprodutos where produto = ? ";

            try {
                ps = con.prepareStatement(comando);//prepara comando
                ps.setString(1, nomeproduto); //troca o 1º ? por nomeproduto
                ResultSet rs = ps.executeQuery();//executa comando, e guarda o que encontrou no ResultSet rs

                if (rs.next()) {//se encontrou dados
                    txtproduto.setText(rs.getString("produto"));
                    txtmarca.setText(rs.getString("marca"));
                    txtprecocompra.setText(rs.getString("precocompra").replace(".", ","));
                    txtprecovenda.setText(rs.getString("precovenda").replace(".", ","));
                    txtqtd.setText(rs.getString("qtd"));
                    txtobs.setText(rs.getString("obs"));
                    lblid.setText(rs.getString("id"));
                } else {//se nao encontrou dados
                    JOptionPane.showMessageDialog(null, "produto não encontrado");
                    txtproduto.setText("");
                    txtmarca.setText("");
                    txtprecocompra.setText("");
                    txtprecovenda.setText("");
                    txtqtd.setText("");
                    txtobs.setText("");
                    lblid.setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "erro ao pesquisar: " + ex);
            }

        }
        if (e.getSource() == btalterar) {
            if (lblid.getText().equals("Automatico")) {
                JOptionPane.showMessageDialog(null, "primeiro pesquise um produto para alterar");
            } else {
                String comando = "Update tblprodutos set produto = ?, marca=?,precocompra=?,precovenda=?,qtd=?,obs=? where id=?";

                try {
                    ps = con.prepareStatement(comando);

                    ps.setString(1, txtproduto.getText());
                    ps.setString(2, txtmarca.getText());
                    ps.setString(3, txtprecocompra.getText().replace(",", "."));
                    ps.setString(4, txtprecovenda.getText().replace(",", "."));
                    ps.setString(5, txtqtd.getText());
                    ps.setString(6, txtobs.getText());
                    ps.setString(7, lblid.getText());

                    int x = ps.executeUpdate();//executa e guarda no x quantas linhas da tabela ele alterou
                    if (x != 0) {
                        JOptionPane.showMessageDialog(null, "produto alterado");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "erro:" + ex);
                }

            }
        }
        //********************************************
        if (e.getSource() == btnovo) {
            lblid.setText("automatico");
            txtmarca.setText("");
            txtobs.setText("");
            txtprecocompra.setText("");
            txtprecovenda.setText("");
            txtproduto.setText("");
            txtqtd.setText("");
            txtproduto.requestFocus(); // coloca o foco
        }

        if (e.getSource() == btsalvar) {
            try {
                String comando = "Insert into tblprodutos (produto, marca, precocompra, precovenda, qtd, obs, datacadastro)";
                comando += "values(?,?,?,?,?,?,?)";

                ps = con.prepareStatement(comando);
                ps.setString(1, txtproduto.getText());
                ps.setString(2, txtmarca.getText());
                ps.setString(3, txtprecocompra.getText().replace(",", "."));
                ps.setString(4, txtprecovenda.getText().replace(",", "."));
                ps.setString(5, txtqtd.getText());
                ps.setString(6, txtobs.getText());
                ps.setString(7, formataDataBanco.format(data));

                ps.executeUpdate(); //executa o comando preparado acima

                JOptionPane.showMessageDialog(null, "produto cadastrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "erro: " + ex);
            }
        }

        if (e.getSource() == btfechar) {
            int r = 0;
            r = JOptionPane.showConfirmDialog(null, "sair?");
            if (r == 0) {
                System.exit(0);
            }
        }
    }

}
