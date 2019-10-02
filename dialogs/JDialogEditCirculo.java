package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import formas.Circulo;
import formas.Figura2D;
import paint.Editor;
import paint.MeuPainel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * JDialogEditCirculo é uma classe que extende JDialog e é chamada para abrir a tela de edição do círculo
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 *
 */
public class JDialogEditCirculo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField textField;
	private Color cor;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	

	/**
	 * Create the dialog.
	 */
	public JDialogEditCirculo(MeuPainel painel, Editor editor, DefaultListModel lista, int posicao ) {
		Circulo cVelho = (Circulo) lista.get(posicao);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPosioX = new JLabel("Posição X: ");
		lblPosioX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosioX.setBounds(10, 10, 78, 29);
		contentPanel.add(lblPosioX);
		
		JLabel lblPosioY = new JLabel("Posição Y: ");
		lblPosioY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPosioY.setBounds(10, 49, 78, 29);
		contentPanel.add(lblPosioY);
		
		JLabel lblRaio = new JLabel("Raio: ");
		lblRaio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaio.setBounds(10, 88, 78, 29);
		contentPanel.add(lblRaio);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCor.setBounds(10, 127, 78, 29);
		contentPanel.add(lblCor);
		
		/**
		 *  Campo de texto onde será posta a nova posição X
		 */
		textField_1 = new JTextField();
		textField_1.setBounds(98, 10, 96, 29);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		
		/**
		 * Campo de texto onde será posta a nova posição Y
		 */
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(98, 51, 96, 29);
		contentPanel.add(textField_2);
		
		
		/**
		 * Campo de texto onde será posto o novo raio
		 */
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(98, 88, 96, 29);
		contentPanel.add(textField_3);
		
		/**
		 * Label onde será mostrada a cor nova
		 */
		JLabel lblNovaCor = new JLabel("Nova Cor");
		lblNovaCor.setBackground(Color.GRAY);
		lblNovaCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovaCor.setBounds(98, 163, 96, 21);
		contentPanel.add(lblNovaCor);
		
		JButton btnSelecionarCor = new JButton("Escolher cor");
		btnSelecionarCor.addActionListener(new ActionListener() {
			/**
			 * Esse método tem a serventia de atribuir uma cor pelo JColorChooser à variável cor
			 * @param e se refere à clicar no botão "Escolher cor"
			 */
			public void actionPerformed(ActionEvent e) {
				cor= JColorChooser.showDialog(JDialogEditCirculo.this, "Escolha uma cor", cor);
				lblNovaCor.setText(toHexString(cor));
			}
		});
		btnSelecionarCor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSelecionarCor.setBounds(98, 133, 96, 21);
		contentPanel.add(btnSelecionarCor);
		
		JLabel lblXAntigo = new JLabel("X antigo: ");
		lblXAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblXAntigo.setBounds(253, 10, 78, 23);
		contentPanel.add(lblXAntigo);
		
		JLabel lblYAntigo = new JLabel("Y antigo: ");
		lblYAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblYAntigo.setBounds(253, 49, 78, 29);
		contentPanel.add(lblYAntigo);
		
		JLabel lblRaioAntigo = new JLabel("Raio antigo:");
		lblRaioAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaioAntigo.setBounds(253, 86, 88, 29);
		contentPanel.add(lblRaioAntigo);
		
		JLabel lblCorAntiga = new JLabel("Cor antiga: ");
		lblCorAntiga.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorAntiga.setBounds(253, 127, 88, 23);
		contentPanel.add(lblCorAntiga);
		
		/**
		 * Se refere ao X antigo do círculo
		 */
		String npx = String.valueOf(cVelho.getX());
		JLabel lblNPx = new JLabel(npx);
		lblNPx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNPx.setBounds(329, 10, 63, 21);
		contentPanel.add(lblNPx);
		
		
		/**
		 * Se refere ao Y antigo do círculo
		 */
		String npy = String.valueOf(cVelho.getY());
		JLabel lblNPy = new JLabel(npy);
		lblNPy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNPy.setBounds(329, 53, 63, 21);
		contentPanel.add(lblNPy);
		
		/**
		 * Se refere ao raio antigo do círculo
		 */
		String npr = String.valueOf(cVelho.getRaio());
		JLabel lblNR = new JLabel(npr);
		lblNR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNR.setBounds(351, 88, 63, 21);
		contentPanel.add(lblNR);
		
		
		/**
		 * Se refere à cor antiga do círculo
		 */
		String npc = String.valueOf(toHexString(cVelho.getCor()));
		JLabel lblNC = new JLabel(npc);
		lblNC.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNC.setBounds(346, 127, 68, 23);
		contentPanel.add(lblNC);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					/**
					 * Esse método irá editar um círculo já criado
					 * A figura só será adicionada na lista se o raio, a posição x e a y  forem maiores que 0, para garantir que só sejam, adicionadas figuras válidas
					 * @param mouseEvent se refere ao clique feito no botão OK
					 */
					public void actionPerformed(ActionEvent e) {
						Circulo c = new Circulo (cor,textField_1.getText(),textField_2.getText(),textField_3.getText());
						if(c.getRaio()>0 && !cor.equals("") && c.getX()>0 && c.getY()>0) {
							editor.rmFigura((Figura2D) lista.get(posicao));
							lista.remove(posicao);
							editor.addFiguraPosicao(c, posicao);
							lista.add(posicao, c);
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
					 * @param e se refere ao clique no botão
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
	 * Esse método tem como serventia transformar o código de uma cor de RGB para hexadecimal
	 * @param c recebe uma cor
	 * @return "#"+hex retorna um código de cor em hexadecimal
	 * @throws NullPointerException
	 */
	public String toHexString(Color c) throws NullPointerException{ //Método para converter a cor RGB em hexadecimal
        String hex = Integer.toHexString(c.getRGB() & 0xffffff);

        if(hex.length() < 6) {
            hex = "000000".substring(0, 6-hex.length()) + hex;
        }


        return "#"+hex;
    }
}
