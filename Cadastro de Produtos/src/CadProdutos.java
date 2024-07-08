
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

public class CadProdutos extends JFrame {

    private JLabel lblcodigo = new JLabel("código:");
    private JLabel lblproduto = new JLabel("produto:");
    private JLabel lblmarca = new JLabel("marca:");
    private JLabel lblprecocompra = new JLabel("pr. compra:");
    private JLabel lblprecovenda = new JLabel("pr. venda:");
    private JLabel lblqtd = new JLabel("Qtd:");
    private JLabel lblobs = new JLabel("Obs:");

    protected JLabel lblid = new JLabel("Automatico");

    protected JTextField txtproduto = new JTextField();
    protected JTextField txtmarca = new JTextField();
    protected JTextField txtprecocompra = new JTextField();
    protected JTextField txtprecovenda = new JTextField();
    protected JTextField txtqtd = new JTextField();
    protected JTextArea txtobs = new JTextArea();

    private JScrollPane painelcomrolagem = new JScrollPane();

    protected JButton btnovo = new JButton("Novo", new ImageIcon("./imgs/add_ico.png"));
    protected JButton btexcluir = new JButton("Excluir", new ImageIcon("./imgs/delete_ico.png"));
    protected JButton btpesquisar = new JButton("Pesquisar", new ImageIcon("./imgs/find_ico.png"));
    protected JButton btalterar = new JButton("Alterar", new ImageIcon("./imgs/edit_ico.png"));
    protected JButton btfechar = new JButton("Fechar", new ImageIcon("./imgs/close_ico.png"));
    protected JButton btsalvar = new JButton("Salvar", new ImageIcon("./imgs/save_ico.png"));

    public CadProdutos() {
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setTitle("Cadastro de Produtos");
        setSize(400, 350);

        lblcodigo.setBounds(10, 10, 100, 22);
        lblproduto.setBounds(10, 40, 100, 22);
        lblmarca.setBounds(10, 70, 100, 22);
        lblprecocompra.setBounds(10, 100, 100, 22);
        lblprecovenda.setBounds(10, 130, 100, 22);
        lblqtd.setBounds(10, 160, 100, 22);
        lblobs.setBounds(10, 190, 100, 22);

        lblid.setBounds(100, 10, 100, 22);
        lblid.setForeground(Color.blue);

        txtproduto.setBounds(100, 40, 150, 22);
        txtmarca.setBounds(100, 70, 150, 22);
        txtprecocompra.setBounds(100, 100, 60, 22);
        txtprecovenda.setBounds(100, 130, 60, 22);
        txtqtd.setBounds(100, 160, 60, 22);

        painelcomrolagem.setBounds(10, 210, 300, 44);
        painelcomrolagem.setViewportView(txtobs);

        btnovo.setBounds(270, 10, 100, 22);
        btexcluir.setBounds(270, 40, 100, 22);
        btpesquisar.setBounds(270, 70, 100, 22);
        btalterar.setBounds(270, 100, 100, 22);
        btsalvar.setBounds(270, 130, 100, 22);
        btfechar.setBounds(270, 160, 100, 22);

        add(lblcodigo);
        add(lblproduto);
        add(lblmarca);
        add(lblprecocompra);
        add(lblprecovenda);
        add(lblqtd);
        add(lblobs);

        add(txtproduto);
        add(txtmarca);
        add(txtprecocompra);
        add(txtprecovenda);
        add(txtqtd);

        add(lblid);
        add(painelcomrolagem);

        add(btnovo);
        add(btsalvar);
        add(btpesquisar);
        add(btalterar);
        add(btsalvar);
        add(btfechar);
        add(btexcluir);

        setVisible(true);

        

    }

}
