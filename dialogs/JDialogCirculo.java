package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import excecoes.CirculoInvalido;
import formas.Circulo;
import paint.Editor;
import paint.MeuPainel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JColorChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * JDialogCirculo é uma classe que extende JDialog e é chamada para abrir a tela de criação do círculo
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 *
 */
public class JDialogCirculo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private Color cor;


	public JDialogCirculo(int px, int py, Editor editor, MeuPainel painel, DefaultListModel lista) {
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 249, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Raio:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 10, 62, 30);
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			contentPanel.add(lblNewLabel);
		}
		
		/**
		 * Campo de texto onde será digitado o novo raio
		 */
		textField = new JTextField();
		textField.setBounds(59, 13, 96, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor: ");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCor.setBounds(10, 42, 46, 13);
		contentPanel.add(lblCor);
		{
			Label corEscolhida = new Label("Cor Atual");
			corEscolhida.setBackground(Color.LIGHT_GRAY);
			corEscolhida.setBounds(59, 66, 96, 21);
			contentPanel.add(corEscolhida);
			
			JButton colorBTN = new JButton("Escolher Cor");
			colorBTN.addMouseListener(new MouseAdapter() {
				@Override
				/**
				 * Esse método serve para atribuir uma cor no círculo pelo JColorChooser
				 * @param mouseEvent se refere ao clique no botão "Escolher Cor"
				 */
				public void mouseClicked(MouseEvent mouseEvent) {
					cor= JColorChooser.showDialog(JDialogCirculo.this, "Escolha uma cor", cor);
					corEscolhida.setText(toHexString(cor));
				}
			});
			colorBTN.setBounds(59, 41, 96, 19);
			contentPanel.add(colorBTN);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					/**
					 * Esse método irá criar um círulo com o "x" e o "y" de onde ocorreu o clique na tela
					 * A figura só será adicionada na lista se o raio for maior que 0, para garantir que só sejam, adicionadas figuras válidas
					 * @param mouseEvent se refere ao clique feito no botão OK
					 */
					public void mouseClicked(MouseEvent mouseEvent) {
						Circulo c = new Circulo(cor,Integer.toString(px),Integer.toString(py),textField.getText());
						if(c.getRaio()>0) {
						editor.addFigura(c);
						lista.addElement(c);
						painel.repaint();
						dispose();
						}
						
						
					}
				});
				okButton.setVerticalAlignment(SwingConstants.TOP);
				okButton.setHorizontalAlignment(SwingConstants.LEFT);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					/**
					 * Esse método tem como finalidade fechar o JDialog ao clicar em cancelar
					 * @param e se refere ao ativar o botão cancel
					 */
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	/**
	 * Esse método tem como finalidade converter o código de cor de RGB para hexadecimal
	 * @param c recebe uma cor
	 * @return "#"+hex código de c em hexadecimal
	 * @throws NullPointerException 
	 */
	public String toHexString(Color c) throws NullPointerException{ 
        String hex = Integer.toHexString(c.getRGB() & 0xffffff);

        if(hex.length() < 6) {
            hex = "000000".substring(0, 6-hex.length()) + hex;
        }


        return "#"+hex;
    }
}
