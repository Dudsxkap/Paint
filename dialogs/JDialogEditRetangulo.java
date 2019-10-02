package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formas.Circulo;
import formas.Figura2D;
import formas.Retangulo;
import paint.Editor;
import paint.MeuPainel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * JDialogEditRetangulo é uma classe que extende JDialog e é chamada para abrir a tela de edição do retângulo
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza* 
 *
 */
public class JDialogEditRetangulo extends JDialog {

	/**
	 * cor se refere à nova cor que o retângulo vai receber
	 * textField será a nova posição X que o retânguo vai receber
	 * textField_1 será a nova posição Y que o retângulo vai receber
	 * textField_1 será a nova base que o retângulo vai receber
	 * textField_1 será a nova altura que o retângulo vai receber
	 */
	private final JPanel contentPanel = new JPanel();
	private Color cor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public JDialogEditRetangulo(MeuPainel painel, Editor editor, DefaultListModel lista, int posicao) {
		Retangulo rVelho= (Retangulo) lista.get(posicao);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPosioX = new JLabel("Posi\u00E7\u00E3o X: ");
			lblPosioX.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPosioX.setBounds(10, 10, 83, 35);
			contentPanel.add(lblPosioX);
		}
		{
			JLabel lblPosioY = new JLabel("Posi\u00E7\u00E3o Y: ");
			lblPosioY.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPosioY.setBounds(10, 48, 83, 35);
			contentPanel.add(lblPosioY);
		}
		{
			JLabel lblLado = new JLabel("Base: ");
			lblLado.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLado.setBounds(10, 93, 83, 20);
			contentPanel.add(lblLado);
		}
		{
			JLabel lblAltura = new JLabel("Altura: ");
			lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAltura.setBounds(10, 123, 83, 20);
			contentPanel.add(lblAltura);
		}
		{
			JLabel lblCor = new JLabel("Cor: ");
			lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCor.setBounds(10, 153, 83, 20);
			contentPanel.add(lblCor);
		}
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(98, 20, 96, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(98, 55, 96, 19);
		contentPanel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(98, 96, 96, 19);
		contentPanel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(98, 123, 96, 19);
		contentPanel.add(textField_3);
		
		
		JLabel lblNovaCor = new JLabel("Nova cor");
		lblNovaCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovaCor.setBackground(Color.GRAY);
		lblNovaCor.setForeground(Color.BLACK);
		lblNovaCor.setBounds(98, 186, 96, 20);
		contentPanel.add(lblNovaCor);
		
		JButton btnEscolherCor = new JButton("Escolher cor");
		btnEscolherCor.addActionListener(new ActionListener() {
			/**
			 * @param e clicar no botão "Escolher cor"
			 */
			public void actionPerformed(ActionEvent e) {
				cor = JColorChooser.showDialog(JDialogEditRetangulo.this, "Escolha uma cor", cor);
				lblNovaCor.setText(toHexString(cor));
			}
		});
		btnEscolherCor.setBounds(98, 155, 96, 21);
		contentPanel.add(btnEscolherCor);
		
		JLabel xAntigo = new JLabel("X Antigo: ");
		xAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		xAntigo.setBounds(231, 10, 83, 35);
		contentPanel.add(xAntigo);
		
		JLabel yAntigo = new JLabel("Y Antigo: ");
		yAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		yAntigo.setBounds(231, 48, 83, 35);
		contentPanel.add(yAntigo);
		
		JLabel lblLadoAntigo = new JLabel("Base Antigo: ");
		lblLadoAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLadoAntigo.setBounds(231, 93, 96, 35);
		contentPanel.add(lblLadoAntigo);
		
		JLabel lblAlturaAntiga = new JLabel("Altura A. : ");
		lblAlturaAntiga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAlturaAntiga.setBounds(231, 138, 96, 35);
		contentPanel.add(lblAlturaAntiga);
		
		JLabel lblCorAntiga = new JLabel("Cor Antiga: ");
		lblCorAntiga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorAntiga.setBounds(231, 180, 96, 28);
		contentPanel.add(lblCorAntiga);
		
		/**
		 * Se refere ao X antigo do retângulo
		 */
		String vx = String.valueOf(rVelho.getX());
		JLabel lblNewLabel = new JLabel(vx);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(342, 14, 84, 26);
		contentPanel.add(lblNewLabel);
		
		/**
		 * Se refere ao Y antigo do retângulo
		 */
		String vy = String.valueOf(rVelho.getY());
		JLabel label0 = new JLabel(vy);
		label0.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label0.setBounds(342, 52, 84, 26);
		contentPanel.add(label0);
		
		/**
		 * Se refere à base antiga do retângulo
		 */
		String vbase = String.valueOf(rVelho.getBase());
		JLabel label_1 = new JLabel(vbase);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(342, 97, 84, 26);
		contentPanel.add(label_1);
		
		/**
		 * Se refere à altura antiga do retângulo
		 */
		String valtura = String.valueOf(rVelho.getAltura());
		JLabel label_2 = new JLabel(valtura);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(342, 142, 84, 26);
		contentPanel.add(label_2);
		
		/**
		 * Se refere à cor antiga do retângulo
		 */
		String vcor = String.valueOf(toHexString(rVelho.getCor()));
		JLabel label_3 = new JLabel(vcor);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(342, 181, 84, 26);
		contentPanel.add(label_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					/**
					 * Esse método irá editar um retângulo já criado
					 * A figura só será adicionada na lista se a base, altura, a posição x e a y  forem maiores que 0, para garantir que só sejam, adicionadas figuras válidas
					 * @param e se refere à clicar no botão "OK"
					 */
					public void actionPerformed(ActionEvent e) {
						Retangulo r = new Retangulo (cor,textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
						if(r.getAltura()>0 && r.getBase()>0 && !cor.equals("") && r.getX()>0 && r.getY()>0) {
							editor.rmFigura((Figura2D) lista.get(posicao));
							lista.remove(posicao);
							editor.addFiguraPosicao(r, posicao);
							lista.add(posicao, r);
							painel.repaint();
							dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					/**
					 * Serve para fechar o JDialog
					 * @param e se refere à clicar no botão cancelar
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
	 * Serve para transformar o código de uma cor de RGB para Hexadecimal
	 * @param c recebe uma cor
	 * @return código em hexadecimal
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
