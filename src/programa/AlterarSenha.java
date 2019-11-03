package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import bd.dbos.*;
import bd.daos.*;
import cripto.*;

public class AlterarSenha extends JFrame {

	private JPanel contentPane;
	private int codNutricionista;
	private JPasswordField txtSenhaAtual;
	private JPasswordField txtSenhaNova;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarSenha frame = new AlterarSenha();
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
	public AlterarSenha() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAlterarSenha = new JLabel("Alterar Senha");
		lblAlterarSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlterarSenha.setBounds(151, 35, 252, 39);
		contentPane.add(lblAlterarSenha);
		
		JLabel lblNewLabel = new JLabel("Senha Atual");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(79, 107, 113, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenhaNova = new JLabel("Senha Nova");
		lblSenhaNova.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSenhaNova.setBounds(79, 158, 113, 14);
		contentPane.add(lblSenhaNova);
		
		JButton btnAlterar = new JButton("Alterar");
		/**
		 * Altera a senha do usu�rio.
		 * Primeiro, instancia-se um novo nutricionista chamando o m�todo da dao, passando seu codigo como parametro
		 * Ent�o compara-se a senha atual digitada com a senha real
		 * Caso forem iguais, a senha � alterada para a senha digitada
		 * Caso forem diferentes, � lan�ada uma exce��o que � exibida para o usu�rio
		 * Ap�s alterar a senha, a janela � fechada 
		 */
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					Nutricionista nutri = Nutricionistas.getNutricionista(codNutricionista);
					String senhaAtual = new String(txtSenhaAtual.getPassword());
					
					if(!(Criptografia.Cripto(senhaAtual).equals(nutri.getSenha())))  // se a senha for errada
					{
						throw new Exception("Senha incorreta");
					}
					else 
					{
						String senhaNova = new String(txtSenhaNova.getPassword());
						nutri.setSenha(Criptografia.Cripto(senhaNova));
						Nutricionistas.alterar(nutri);
						JOptionPane.showMessageDialog(null,"Senha alterada com sucesso!");
						AlterarSenha.this.dispose();
					}
				}
				catch(Exception ex) 
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
					txtSenhaAtual.setText("");
					txtSenhaNova.setText("");
				}
			}
		});
		btnAlterar.setBounds(191, 212, 89, 23);
		contentPane.add(btnAlterar);
		
		txtSenhaAtual = new JPasswordField();
		txtSenhaAtual.setBounds(167, 105, 136, 20);
		contentPane.add(txtSenhaAtual);
		
		txtSenhaNova = new JPasswordField();
		txtSenhaNova.setBounds(167, 156, 136, 20);
		contentPane.add(txtSenhaNova);
	}
	
	/**
	 * Seta o atributo do c�digo do nutricionista.
	 * @param codigo do nutricionista que est� utilizando a aplica��o.
	 */
	public void setCodNutricionista(int codigo) 
	{
		this.codNutricionista = codigo;
	}
}
