package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formas.Retangulo;
import formas.Triangulo;
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
 * JDialogTriangulo é uma classe que extende JDialog e é chamada para abrir a tela de criação do triângulo
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 *
 */
public class JDialogTriangulo extends JDialog {

	/**
	 * textFieldBase receberá o valor da base
	 * textFieldAltura receberá o valor da altura
	 * cor receberá o valor da cor
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldBase;
	private JTextField textFieldAltura;
	private Color cor;


	public JDialogTriangulo(int px, int py, Editor editor, MeuPainel painel, DefaultListModel lista) {
		setModalityType(DEFAULT_MODALITY_TYPE);
		setBounds(100, 100, 249, 219);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Base: ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 10, 62, 30);
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblAltura = new JLabel("Altura: ");
			lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAltura.setBounds(10, 35, 62, 30);
			contentPanel.add(lblAltura);
		}
		
		textFieldBase = new JTextField();
		textFieldBase.setBounds(59, 13, 96, 19);
		contentPanel.add(textFieldBase);
		textFieldBase.setColumns(10);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(59, 43, 96, 19);
		contentPanel.add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor: ");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCor.setBounds(10, 75, 46, 13);
		contentPanel.add(lblCor);
		{
			Label corEscolhida = new Label("Cor Atual");
			corEscolhida.setBackground(Color.LIGHT_GRAY);
			corEscolhida.setBounds(59, 98, 96, 21);
			contentPanel.add(corEscolhida);
			
			JButton colorBTN = new JButton("Escolher Cor");
			colorBTN.addMouseListener(new MouseAdapter() {
				@Override
				/**
				 * Serve para atribuir uma cor por meio do JColorChooser para a variável cor
				 * @param e se refere ao clicar no botão "Escolher Cor"
				 */
				public void mouseClicked(MouseEvent e) {
					cor= JColorChooser.showDialog(JDialogTriangulo.this, "Escolha uma cor", cor);
					corEscolhida.setText(toHexString(cor));
				}
			});
			colorBTN.setBounds(59, 73, 96, 19);
			contentPanel.add(colorBTN);
		}
		{
			Label corEscolhida = new Label("Cor Atual");
			corEscolhida.setBackground(Color.LIGHT_GRAY);
			corEscolhida.setBounds(59, 98, 96, 21);
			contentPanel.add(corEscolhida);
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
					 * Cria um triângulo com a posição X e Y do clique em tela, e se certificará de colocar na lista triângulos válidos 
					 * @param e se refere ao clique no botão "OK"
					 */
					public void mouseClicked(MouseEvent e) {
						Triangulo t = new Triangulo(cor,Integer.toString(px),Integer.toString(py),textFieldBase.getText(),textFieldAltura.getText());
						if(t.getBase()>0 && t.getAltura()>0) {
							editor.addFigura(t);
							lista.addElement(t);
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
					 * Serve para fechar o JDialog
					 * @param e se refere ao clique no botão "Cancel"
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
	 * Transforma o código de cor do formato RGB para hexadecimal
	 * @param c recebe uma cor
	 * @return "#"+hex retorna um código em hexadecimal
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
