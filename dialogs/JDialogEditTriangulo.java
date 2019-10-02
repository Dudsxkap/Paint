package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import formas.Figura2D;
import formas.Retangulo;
import formas.Triangulo;
import paint.Editor;
import paint.MeuPainel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * JDialogEditTriangulo é uma classe que extende JDialog e é chamada para abrir a tela de edição do triângulo
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 *
 */
public class JDialogEditTriangulo extends JDialog {
	/**
	 * cor receberá a nova cor
	 * textField receberá o novo X
	 * textField_1 receberá o novo Y
	 * textField_2 receberá a nova base
	 * textField_3 receberá a nova altura
	 */
	private final JPanel contentPanel = new JPanel();
	private Color cor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	public JDialogEditTriangulo(MeuPainel painel, Editor editor, DefaultListModel lista, int posicao) {
		Triangulo tVelho = (Triangulo) lista.get(posicao);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPosioX = new JLabel("Posição X: ");
			lblPosioX.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPosioX.setBounds(10, 10, 93, 20);
			contentPanel.add(lblPosioX);
		}
		{
			JLabel lblPosioY = new JLabel("Posição Y:  ");
			lblPosioY.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPosioY.setBounds(10, 40, 93, 20);
			contentPanel.add(lblPosioY);
		}
		{
			JLabel lblBase = new JLabel("Base:  ");
			lblBase.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBase.setBounds(10, 70, 93, 20);
			contentPanel.add(lblBase);
		}
		{
			JLabel lblAltura = new JLabel("Altura: ");
			lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAltura.setBounds(10, 100, 93, 20);
			contentPanel.add(lblAltura);
		}
		{
			JLabel lblCor = new JLabel("Cor:  ");
			lblCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCor.setBounds(10, 130, 93, 20);
			contentPanel.add(lblCor);
		}
		{
			JLabel lblXAntigo = new JLabel("X Antigo: ");
			lblXAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblXAntigo.setBounds(220, 10, 93, 20);
			contentPanel.add(lblXAntigo);
		}
		{
			JLabel lblYAntigo = new JLabel("Y Antigo: ");
			lblYAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblYAntigo.setBounds(220, 40, 93, 20);
			contentPanel.add(lblYAntigo);
		}
		{
			JLabel lblBaseAntigo = new JLabel("Base Antigo:");
			lblBaseAntigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBaseAntigo.setBounds(220, 70, 93, 20);
			contentPanel.add(lblBaseAntigo);
		}
		{
			JLabel lblNewLabel = new JLabel("Altura A. : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(220, 100, 93, 19);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblCorAntiga = new JLabel("Cor Antiga: ");
			lblCorAntiga.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCorAntiga.setBounds(220, 130, 93, 20);
			contentPanel.add(lblCorAntiga);
		}
		{
			textField = new JTextField();
			textField.setBounds(95, 10, 96, 19);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(95, 39, 96, 19);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(95, 70, 96, 19);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(95, 100, 96, 19);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblNovaCor = new JLabel("Nova Cor");
			lblNovaCor.setForeground(Color.BLACK);
			lblNovaCor.setBackground(Color.GRAY);
			lblNovaCor.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNovaCor.setBounds(95, 160, 96, 20);
			contentPanel.add(lblNovaCor);
		
		
			JButton btnEscolhaCor = new JButton("Escolher Cor");
			btnEscolhaCor.addActionListener(new ActionListener() {
				/**
				 * Atribuir uma cor pelo JColorChooser para a variável cor
				 * @param e se refere ao clique no botão "Escolher Cor"
0				 */
				public void actionPerformed(ActionEvent e) {
					cor= JColorChooser.showDialog(JDialogEditTriangulo.this, "Escolha uma cor", cor);
					lblNovaCor.setText(toHexString(cor));
				}
			});
			btnEscolhaCor.setBounds(95, 130, 96, 21);
			contentPanel.add(btnEscolhaCor);
		}
		{
			/**
			 * Se refere ao valor antigo de X
			 */
			String vx = String.valueOf(tVelho.getX());
			JLabel lblNewLabel_1 = new JLabel(vx);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(323, 10, 93, 19);
			contentPanel.add(lblNewLabel_1);
		}
		{
			/**
			 * Se refere ao valor antigo de Y
			 */
			String vy = String.valueOf(tVelho.getY());
			JLabel label1 = new JLabel(vy);
			label1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label1.setBounds(323, 41, 93, 19);
			contentPanel.add(label1);
		}
		{
			/**
			 * Se refere ao valor antigo de Base
			 */
			String vbase = String.valueOf(tVelho.getBase());
			JLabel label2 = new JLabel(vbase);
			label2.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label2.setBounds(323, 71, 93, 19);
			contentPanel.add(label2);
		}
		{
			/**
			 * Se refere ao valor antigo de Altura
			 */
			String valtura = String.valueOf(tVelho.getAltura());
			JLabel label3 = new JLabel(valtura);
			label3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label3.setBounds(323, 100, 93, 19);
			contentPanel.add(label3);
		}
		{
			/**
			 * Se refere ao valor antigo de Cor
			 */
			String vcor = String.valueOf(toHexString(tVelho.getCor()));
			JLabel label4 = new JLabel(vcor);
			label4.setFont(new Font("Tahoma", Font.PLAIN, 16));
			label4.setBounds(323, 130, 93, 19);
			contentPanel.add(label4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					/**
					 * Esse método editará um triângulo ja criado
					 * A figura só será adicionada na lista se a base, altura, a posição x e a y  forem maiores que 0, para garantir que só sejam, adicionadas figuras válidas
					 * @param e se refere ao clique no botão "OK"
					 */
					public void actionPerformed(ActionEvent e) {
						Triangulo t = new Triangulo (cor,textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText());
						if(t.getAltura()>0 && t.getBase()>0 && !cor.equals("") && t.getX()>0 && t.getY()>0) {
							editor.rmFigura((Figura2D) lista.get(posicao));
							lista.remove(posicao);
							editor.addFiguraPosicao(t, posicao);
							lista.add(posicao, t);
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
					 * Fecha o JDialog 
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
	 * Tem como serventia transformar o código de uma cor de RGB para hexadecimal
	 * @param c recebe uma cor
	 * @return o código de uma cor em hexadecimal
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
