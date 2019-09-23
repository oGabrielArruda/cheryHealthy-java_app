package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bd.daos.*;
import bd.dbos.*;
import cripto.*;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTextField txtDDD;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		txtCod = new JTextField();
		txtCod.setBounds(186, 31, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(186, 74, 242, 20);
		contentPane.add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(186, 113, 242, 20);
		contentPane.add(txtCpf);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(186, 152, 242, 20);
		contentPane.add(txtEmail);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(227, 194, 201, 20);
		contentPane.add(txtTel);
		
		txtDDD = new JTextField();
		txtDDD.setBounds(184, 194, 33, 20);
		contentPane.add(txtDDD);
		txtDDD.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD");
		lblDdd.setBounds(186, 213, 46, 14);
		contentPane.add(lblDdd);
		
		JLabel lblEx = new JLabel("Ex: 34527689");
		lblEx.setBounds(227, 213, 78, 14);
		contentPane.add(lblEx);
		
		JLabel lblEx_1 = new JLabel("Ex: 023.567.123-92");
		lblEx_1.setBounds(186, 133, 119, 14);
		contentPane.add(lblEx_1);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(186, 238, 110, 20);
		contentPane.add(txtPass);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Criptografia.Cripto(txtPass.getText());
					String telefone = "(" + txtDDD.getText() + ")" + txtTel.getText();
					Nutricionista 
				}
				catch(Exception ex) {
					
				}
				
			}
		});
		btnCadastrar.setBounds(186, 286, 89, 23);
		contentPane.add(btnCadastrar);
	}
}
