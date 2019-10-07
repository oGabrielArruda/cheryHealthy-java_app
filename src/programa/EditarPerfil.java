package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.daos.*;
import bd.dbos.*;
import cripto.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarPerfil extends JFrame {

	private JPanel contentPane;
	private JTextField txtCod;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtDDD;
	private JTextField txtTel;
	private JPasswordField txtSenha;
	private int codNutricionista;
	private Nutricionista nutri;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPerfil frame = new EditarPerfil();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditarPerfil() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarPerfil = new JLabel("Editar Perfil");
		lblEditarPerfil.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblEditarPerfil.setBounds(154, 80, 364, 91);
		contentPane.add(lblEditarPerfil);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCdigo.setBounds(35, 169, 116, 30);
		contentPane.add(lblCdigo);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNome.setBounds(266, 169, 116, 30);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCpf.setBounds(35, 224, 116, 30);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setBounds(266, 224, 116, 30);
		contentPane.add(lblEmail);
		
		JLabel lblDdd = new JLabel("Telefone");
		lblDdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDdd.setBounds(84, 302, 116, 30);
		contentPane.add(lblDdd);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSenha.setBounds(266, 302, 116, 30);
		contentPane.add(lblSenha);
		
		JLabel label = new JLabel("DDD");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		label.setBounds(35, 302, 116, 30);
		contentPane.add(label);
		
		txtCod = new JTextField();
		txtCod.setEditable(false);
		txtCod.setBounds(35, 193, 86, 20);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(266, 193, 214, 20);
		contentPane.add(txtNome);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(35, 248, 165, 20);
		contentPane.add(txtCpf);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(266, 248, 214, 20);
		contentPane.add(txtEmail);
		
		txtDDD = new JTextField();
		txtDDD.setColumns(10);
		txtDDD.setBounds(35, 328, 39, 20);
		contentPane.add(txtDDD);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(84, 328, 116, 20);
		contentPane.add(txtTel);
		
		JLabel lblEx = new JLabel("Ex: 123.345.678-99");
		lblEx.setBounds(35, 277, 221, 14);
		contentPane.add(lblEx);
		
		JLabel lblEx_1 = new JLabel("Ex: 11");
		lblEx_1.setBounds(35, 352, 56, 14);
		contentPane.add(lblEx_1);
		
		JLabel lblEx_2 = new JLabel("Ex: 3232-5656");
		lblEx_2.setBounds(94, 352, 148, 14);
		contentPane.add(lblEx_2);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText(), cpf = txtCpf.getText(), ddd = txtDDD.getText(), tel = txtTel.getText(),
						email = txtEmail.getText(), senha = new String(txtSenha.getPassword());
				
				if(nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || ddd.isEmpty() || tel.isEmpty() || senha.isEmpty())
					JOptionPane.showMessageDialog(null,"Preencha todos os campos!");
				else 
				{
					String telefone = "("+ddd+")"+tel;
					
					try 
					{
						Nutricionista nutri = new Nutricionista(codNutricionista, nome, cpf, email, telefone, senha);
						Nutricionistas.alterar(nutri);
						JOptionPane.showMessageDialog(null,"Alteração realizada com sucesso!");
					}
					catch(Exception ex) 
					{
						JOptionPane.showMessageDialog(null,"Erro ao alterar usuário");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(366, 387, 114, 23);
		contentPane.add(btnNewButton);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSenha.setBounds(266, 328, 214, 20);
		contentPane.add(txtSenha);
	}
	
	
	public void setCodNutricionista(int cod) 
	{
		this.codNutricionista = cod;
	}
	
	public void exibirDados() 
	{
		try 
		{
			nutri = Nutricionistas.getNutricionista(this.codNutricionista);
			txtCod.setText(nutri.getCodigo()+"");
			txtNome.setText(nutri.getNome());
			txtCpf.setText(nutri.getCpf());
			txtEmail.setText(nutri.getEmail());
			txtSenha.setText(nutri.getSenha());
			
			String tel = nutri.getTelefone();
			String ddd = tel.substring(1,3);
			String num = tel.substring(4, 13);
			txtDDD.setText(ddd);
			txtTel.setText(num);
			
		}
		catch(Exception ex) 
		{
			
		}
	}
}
