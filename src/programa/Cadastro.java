package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bd.daos.*;
import bd.dbos.*;
import cripto.*;
import javax.swing.JOptionPane;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtCod;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtEmail;
	private JFormattedTextField txtTel;
	private JFormattedTextField txtDDD;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCod = new JLabel("C\u00F3digo(1-5000)");
		lblCod.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCod.setBounds(43, 33, 155, 14);
		contentPane.add(lblCod);
		
		JLabel lblAa = new JLabel("Nome");
		lblAa.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAa.setBounds(43, 75, 110, 14);
		contentPane.add(lblAa);
		
		JLabel lblCpf = new JLabel("Cpf");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 18));
		lblCpf.setBounds(43, 114, 110, 14);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(43, 153, 110, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefon = new JLabel("Telefone");
		lblTelefon.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTelefon.setBounds(43, 195, 110, 14);
		contentPane.add(lblTelefon);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSenha.setBounds(43, 239, 110, 14);
		contentPane.add(lblSenha);
		
		txtCod = new JFormattedTextField();
		txtCod.setBounds(186, 31, 86, 20);
		txtCod.setColumns(10);
		try 
		{
			MaskFormatter mask = new MaskFormatter("####");
			mask.install(txtCod);
		}
		catch(Exception e) 
		{}
		contentPane.add(txtCod);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(186, 74, 242, 20);
		contentPane.add(txtNome);

		txtCpf = new JFormattedTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(186, 113, 242, 20);	
		try 
		{
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(txtCpf);
		}
		catch(Exception e) {}
		contentPane.add(txtCpf);
		
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(186, 152, 242, 20);
		contentPane.add(txtEmail);
		
		txtTel = new JFormattedTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(227, 194, 201, 20);
		try 
		{
			MaskFormatter mask = new MaskFormatter("####-####");
			mask.install(txtTel);
		}
		catch(Exception e) 
		{}
		contentPane.add(txtTel);
		
		txtDDD = new JFormattedTextField();
		txtDDD.setBounds(184, 194, 33, 20);
		txtDDD.setColumns(2);
		try 
		{
			MaskFormatter mask = new MaskFormatter("##");
			mask.install(txtDDD);
		}
		catch(Exception e) 
		{}
		contentPane.add(txtDDD);
		
		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(186, 213, 69, 14);
		contentPane.add(lblDdd);
		
		JLabel lblEx = new JLabel("Ex: 3452-7689");
		lblEx.setBounds(227, 213, 201, 14);
		contentPane.add(lblEx);
		
		JLabel lblEx_1 = new JLabel("Ex: 023.567.123-92");
		lblEx_1.setBounds(186, 133, 119, 14);
		contentPane.add(lblEx_1);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(186, 238, 110, 20);
		contentPane.add(txtPass);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		/**
		 * Click do bot�o cadastrar.
		 * Tenta-se realizar o cadastro com os valores inseridos
		 * Em caso de excess�o no m�todo cadastrar, que valida e cadastra o usu�rio, � exibida a mensagem de erro
		 */
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					cadastrar();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(186, 286, 119, 23);
		contentPane.add(btnCadastrar);
	}
	
	/**
	 * Cadastra o usu�rio.
	 * Valida as informa��es digitadas, e em caso de algum erro � lan�ada a exce��o
	 * Caso n�o ocorram erros na digita��o e na instancia��o do Nutricionista, cadastra-se o novo Nutricionista
	 * @throws Exception se alguma informa��o n�o estiver condizente com os atributos do cadastro
	 */
	private void cadastrar() throws Exception{
		if((txtCod.getText().trim().equals("")) || (txtNome.getText().trim().equals("")) ||
				(txtCpf.getText().trim().equals("")) || (txtEmail.getText().trim().equals("")) || 
				(txtDDD.getText().trim().equals("")) || (txtTel.getText().trim().equals("")) ||
				(txtPass.getPassword().length == 0))
					throw new Exception("Preencha todos os campos");	
				
				String senhaCripto = Criptografia.Cripto(new String(txtPass.getPassword()));
						
				String telefone = "(" + txtDDD.getText() + ")" + txtTel.getText();
				Nutricionista nutri = new Nutricionista(Integer.parseInt(txtCod.getText().trim()),
																				txtNome.getText(),
																				txtCpf.getText(),
																				txtEmail.getText().trim(),
																				telefone,
																				senhaCripto);
				Nutricionistas.incluir(nutri);
				JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
				Cadastro.this.dispose();
	}
}
