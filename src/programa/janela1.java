package programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import bd.daos.Nutricionistas;
import bd.dbos.Nutricionista;
import cripto.Criptografia;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class janela1 {

	private JFrame frame;
	private JTextField txtId;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janela1 window = new janela1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public janela1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 659, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblId.setBounds(198, 136, 91, 14);
		frame.getContentPane().add(lblId);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		lblSenha.setBounds(161, 172, 91, 14);
		frame.getContentPane().add(lblSenha);
		
		txtId = new JTextField();
		txtId.setBounds(262, 135, 152, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton btnLogar = new JButton("Entrar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codStr = txtId.getText();
				String senha = new String(txtSenha.getPassword());
				
				try 
				{
					if(codStr.trim().equals("") || senha.trim().equals(""))
						throw new Exception("Preencha todos os campos!");					
					
					int codigo = Integer.parseInt(codStr);
					
					if(!Nutricionistas.cadastrado(codigo))
						throw new Exception("Código incorreto!");
					
					Nutricionista nutri = Nutricionistas.getNutricionista(codigo);
							
							
					if(!(Criptografia.Cripto(senha).equals(nutri.getSenha())))
						throw new Exception("Senha incorreta!");
						
					Logado1 jan = new Logado1();
					jan.setCodNutriLogado(codigo);
					jan.setVisible(true);
					janela1.this.frame.dispose();																														
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				finally {
					txtId.setText("");
					txtSenha.setText("");
				}
			}
		});
		
		btnLogar.setBounds(298, 211, 89, 23);
		frame.getContentPane().add(btnLogar);
		
		JLabel lblCadastro = new JLabel("N\u00E3o tem uma conta? ");
		lblCadastro.setBounds(198, 332, 247, 14);
		frame.getContentPane().add(lblCadastro);
		
		JButton btnGoCadastro = new JButton("Cadastrar-se");
		btnGoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro janelaCad = new Cadastro();
				janelaCad.setVisible(true);
			}
		});
		btnGoCadastro.setBounds(344, 328, 120, 23);
		frame.getContentPane().add(btnGoCadastro);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(262, 171, 152, 20);
		frame.getContentPane().add(txtSenha);
	}
}
