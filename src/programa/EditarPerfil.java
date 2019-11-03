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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarPerfil frame = new EditarPerfil();
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
	public EditarPerfil() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 544, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEditarPerfil = new JLabel("Editar Perfil");
		lblEditarPerfil.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblEditarPerfil.setBounds(176, 79, 364, 91);
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
		/**
		 * Altera os dados do nutricionista.
		 * Armazena-se em variáveis os valores digitados.
		 * Instancia-se então, um novo nutricionista, passando as variáveis como parâmetro
		 * Por fim, chama-se o método da dao que altera os valores
		 * Se não ocorrer erros, uma mensagem de sucesso é exibida
		 * Em caso de erros na instância ou na dao, uma mensagem é exibida ao usuário
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText(), cpf = txtCpf.getText(), ddd = txtDDD.getText(), tel = txtTel.getText(),
						email = txtEmail.getText(), senha = new String(txtSenha.getPassword());
				Nutricionista nutri = null;
				try 
				{
					String telefone = "("+ddd+")"+tel;
					nutri = new Nutricionista(codNutricionista, nome, cpf, email, telefone, senha);
					Nutricionistas.alterar(nutri);
					JOptionPane.showMessageDialog(null,"Alterado com sucesso!");
					EditarPerfil.this.dispose();
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(187, 392, 114, 23);
		contentPane.add(btnNewButton);
		
		txtSenha = new JPasswordField();
		txtSenha.setEditable(false);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSenha.setBounds(266, 327, 94, 20);
		contentPane.add(txtSenha);
		
		JButton btnNewButton_1 = new JButton("Alterar Senha");
		/**
		 * Abre a janela de alteração de senha.
		 * Instancia uma nova janela e a exibe
		 * Por fim, seta o código de nutricionista da janela.
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlterarSenha jan = new AlterarSenha();
				jan.setVisible(true);
				jan.setCodNutricionista(codNutricionista);
			}
		});
		btnNewButton_1.setBounds(370, 327, 148, 23);
		contentPane.add(btnNewButton_1);
	}
	
	
	/**
	 * Seta o atributo do código do nutricionista.
	 * @param codNutricionista código do nutricionista que está utilizando a aplicação.
	 */
	public void setCodNutricionista(int cod) 
	{
		this.codNutricionista = cod;
	}
	
	/**
	 * Exibe os dados do nutricionista.
	 * Instancia-se um novo nutricionista com o método da Dao, passando o código como parâmetro
	 * Se ocorrer erro ao instanciar, é exibida uma mensagem ao usuário, e sai do método
	 * Senão, exibe os valores ex textbox
	 */
	public void exibirDados() 
	{
		Nutricionista nutri = null;
		try 
		{
			nutri = Nutricionistas.getNutricionista(this.codNutricionista);
		}
		catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
			return;
		}
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
}
