package programa;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.daos.Usuarios;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bd.daos.*;
import bd.dbos.*;


public class DietaJanela extends JFrame {

	private JPanel contentPane;
	private ButtonGroup grupoDias;
	private JTextField txtCodUsuario;
	private int codNutricionista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietaJanela frame = new DietaJanela();
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
	public DietaJanela() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dieta e Dicas:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setBounds(29, 11, 166, 32);
		contentPane.add(lblNewLabel);
		
		txtCodUsuario = new JTextField();
		txtCodUsuario.setColumns(10);
		txtCodUsuario.setBounds(29, 89, 86, 20);
		contentPane.add(txtCodUsuario);
		
		JLabel lblCod = new JLabel("Escolha o c\u00F3digo do usu\u00E1rio:");
		lblCod.setBounds(29, 64, 207, 14);
		contentPane.add(lblCod);
		
		JLabel lblCasoNoSaiba = new JLabel("Caso n\u00E3o saiba o c\u00F3digo do usu\u00E1rio");
		lblCasoNoSaiba.setBounds(281, 64, 243, 14);
		contentPane.add(lblCasoNoSaiba);
		
		JButton btnVerCdigos = new JButton("Ver c\u00F3digos");
		/**
		 * Abre a janela que exibe todos usuários.
		 * Instancia-se a nova janela e logo em seguida, a exibe
		 * Então, seta o atributo do código de nutricionista da janela para o código do nutricionista atual
		 * Por fim, chama o método que exibe os valores no JTable da janela
		 */
		btnVerCdigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodosUsuarios tdsUsers = new TodosUsuarios();
				tdsUsers.setResizable(false);
				tdsUsers.setVisible(true);
				tdsUsers.setCodNutricionista(codNutricionista);
				tdsUsers.inserirValores();
			}
		});
		btnVerCdigos.setBounds(315, 88, 122, 23);
		contentPane.add(btnVerCdigos);
		
		JTextPane txtDieta = new JTextPane();
		txtDieta.setBounds(58, 182, 379, 158);
		contentPane.add(txtDieta);
		
		JLabel lblDigiteSuaDietamx = new JLabel("Digite sua dieta(m\u00E1x 300 caracteres):");
		lblDigiteSuaDietamx.setBounds(58, 157, 288, 14);
		contentPane.add(lblDigiteSuaDietamx);
		
		JRadioButton rdbtnSeg = new JRadioButton("Seg");
		rdbtnSeg.setBounds(58, 385, 52, 23);
		contentPane.add(rdbtnSeg);
		
		JRadioButton rdbtnTer = new JRadioButton("Ter");
		rdbtnTer.setBounds(112, 385, 52, 23);
		contentPane.add(rdbtnTer);
		
		JRadioButton rdbtnQua = new JRadioButton("Qua");
		rdbtnQua.setBounds(166, 385, 52, 23);
		contentPane.add(rdbtnQua);
		
		JRadioButton rdbtnQui = new JRadioButton("Qui");
		rdbtnQui.setBounds(220, 385, 52, 23);
		contentPane.add(rdbtnQui);
		
		JRadioButton rdbtnSex = new JRadioButton("Sex");
		rdbtnSex.setBounds(280, 385, 52, 23);
		contentPane.add(rdbtnSex);
		
		JRadioButton rdbtnSab = new JRadioButton("S\u00E1b");
		rdbtnSab.setBounds(334, 385, 52, 23);
		contentPane.add(rdbtnSab);
		
		JRadioButton rdbtnDom = new JRadioButton("Dom");
		rdbtnDom.setBounds(388, 385, 52, 23);
		contentPane.add(rdbtnDom);
		
		JLabel lblSelecioneODia = new JLabel("Selecione o dia para a dieta ser implementada:");
		lblSelecioneODia.setBounds(58, 364, 367, 14);
		contentPane.add(lblSelecioneODia);
		
		JButton btnEnviar = new JButton("Enviar");
		/**
		 * Envia a dieta digitada para o usuário
		 * Primeiro, verifica-se se o código digitado é válido
		 * Depois, pega-se o dia desejado, através de qual radio button foi selecionado
		 * Se nenhum dia foi escolhido, é lançada exceção
		 * Transofrma-se em inteiro o código digitado pelo usuário
		 * Por fim, chama o método da dao que insere a dieta, passando o código, a dieta, e o dia a ser inserida
		 * Em caso de sucesso, uma mensagame é exibida ao usuário.
		 */
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(codigoValido(txtCodUsuario.getText()))
				{
					try 
					{
						String dia = "";
						if(rdbtnSeg.isSelected())
							dia = "seg";
						else if(rdbtnTer.isSelected())
							dia = "ter";
						else if(rdbtnQua.isSelected())
							dia = "qua";
						else if(rdbtnQui.isSelected())
							dia = "qui";
						else if(rdbtnSex.isSelected())
							dia = "sex";
						else if(rdbtnSab.isSelected())
							dia = "sab";
						else if(rdbtnDom.isSelected())
							dia = "dom";
						if(dia.equals(""))
							throw new Exception("Selecione o dia para implementar a dieta!");
						
						int codUsuario = Integer.parseInt(txtCodUsuario.getText());
						Dietas.inserir(codUsuario, txtDieta.getText(), dia);
						JOptionPane.showMessageDialog(null,"Dieta inserida com sucesso!");
						
					}
					catch(Exception ex) 
					{
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}		

			}
		});
		
		
		grupoDias = new ButtonGroup();
		grupoDias.add(rdbtnSeg);
		grupoDias.add(rdbtnTer);
		grupoDias.add(rdbtnQua);
		grupoDias.add(rdbtnQui);
		grupoDias.add(rdbtnSex);
		grupoDias.add(rdbtnSab);
		grupoDias.add(rdbtnDom);
		
		btnEnviar.setBounds(194, 433, 89, 23);
		contentPane.add(btnEnviar);
	}
	/**
	 * Seta o atributo do código do nutricionista.
	 * @param codNutricionista código do nutricionista que está utilizando a aplicação.
	 */
	public void setCodNutriLogado(int codNutricionista) {
		this.codNutricionista = codNutricionista;
	}
	
	/**
	 * Valida o código passado como parâmetro.
	 * Primeiro, converte-se o código para inteiro. Se a conversão falhar, o catch da exceção exibirá o erro e retornará false
	 * Depois, verifica-se se o código é negativo. Se sim, exibe mensagem de erro e retorna-se false
	 * E por fim, os métodos da dao são chamados para ver se o usuário está cadastrado e se pertence ao nutricionista 
	 * Se essas ultimas verificações forem falsas, é lançada exceção, que no catch exibirá o erro e retornará false.
	 * Por fim, se todas verificações deram certo, retorna-se true
	 * @param codigo código a ser validado
	 * @return true se estiver certo, false se estiver falho
	 */
	private boolean codigoValido(String codigo) {
		int codigoInt = 0;
		try 
		{
			codigoInt = Integer.parseInt(codigo);
		}
		catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(null,"Código inválido!");
			return false;
		}
		
		if(codigoInt < 0) 
		{
			JOptionPane.showMessageDialog(null,"Código inválido!");
			return false;
		}
		
		try 
		{
			if(!(Usuarios.cadastrado(codigoInt)))
			{
				throw new Exception("Código de usuário não cadastrado!");
			}
			Usuario selecionado = Usuarios.getUsuario(codigoInt);
			
			if(selecionado.getCodNutricionista() != this.codNutricionista) 
			{
				throw new Exception("Este usuário pertence à outro nutricionista!");			
			}
		}
		catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
			return false;
		}
			
			return true;			
		}
	}

