package paint;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dialogs.JDialogCirculo;
import dialogs.JDialogRetangulo;
import dialogs.JDialogTriangulo;
import excecoes.BotaoFiguraDeselecionado;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MeuPainel é uma classe que extende JPanel e serve para utilizar funções próprias para essa painel que não são apresentados num JPanel comum
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class MeuPainel extends JPanel {

	/**
	 * px receberá o valor de x
	 * py receberá o valor de y
	 * formaPainel receberá um valor diferente dependendo da figura selecionada para criação da mesma. Começa com 1 que não representa nenhuma figura implementada
	 * painel receberá um MeuPainel
	 * editor receberá um editor
	 * lista receberá uma list do tipo DefaultListModel
	 * br receberá o estado do botão retângulo
	 * bt receberá o estado do botão triângulo
	 * bc receberá o estado do botão círculo
	 */
	private int px;
	private int py;
	private int formaPainel=1;
	private MeuPainel painel;
	private Editor editor;
	private DefaultListModel lista;
	private boolean br,bt,bc;
	
	public MeuPainel() {
		setPreferredSize(new Dimension(5000,5000));
		addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * Esse método chamará o dialog correto para a criação da figura desejada e chama BotaoFiguraDeselecionado caso tente criar um figura sem nenhum botão selecionado
			 * As posições x e y serão atribuidas pelo clique na tela
			 * @param e recebe o x e y do clique em tela 
			 */
			public void mouseClicked(MouseEvent e) {
				try {
					px=e.getX();
					py=e.getY();
					
					System.out.println(formaPainel);
					System.out.println(bt);
					System.out.println(br);
					System.out.println(bc);
					if(bt==false && br==false && bc==false) {
						throw new BotaoFiguraDeselecionado();
					}
					switch (formaPainel) {
					case 4:
						JDialogRetangulo jdr = new JDialogRetangulo(px,py,editor,painel,lista);
						jdr.setVisible(true);
						break;
					case 3:
						JDialogTriangulo jdt = new JDialogTriangulo(px,py,editor,painel,lista);
						jdt.setVisible(true);
						break;
					
					case 0:
						JDialogCirculo jdc = new JDialogCirculo(px,py,editor,painel,lista);
						jdc.setVisible(true);
						break;
					}
					painel.repaint();
				}catch(BotaoFiguraDeselecionado bfd) {
					JOptionPane.showMessageDialog(null, bfd.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
	/**
	 * Esse método é sobrescrito  do JPanel e chamará o desenhar do editor
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		editor.desenhar(g);		
	}
	/**
	 * Atribui o valor de formaPainel para criação da figura
	 * @param formaDesejada recebe o "código" para criação da figura desejada
	 * @param br estado do botão retângulo
	 * @param bt estado do botão triângulo
	 * @param bc estado do botão círculo
	 */
	public void setFormaPainel(int formaDesejada, boolean br,boolean bt, boolean bc) {
		this.formaPainel=formaDesejada;
		this.br=br;
		this.bc=bc;
		this.bt=bt;
	}
	/**
	 * Método para passagem de referência para implementação de outros métodos no MeuPainel
	 * @param editor recebe um editor
	 * @param painel recebe um MeuPainel
	 * @param lista recebe uma DefaultListModel
	 */
	public void passagem (Editor editor, MeuPainel painel, DefaultListModel lista ) {
		this.editor=editor;
		this.painel=painel;
		this.lista=lista;
	}
}
