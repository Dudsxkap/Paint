package paint;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import dialogs.JDialogEditCirculo;
import dialogs.JDialogEditRetangulo;
import dialogs.JDialogEditTriangulo;
import excecoes.BotaoFiguraDeselecionado;
import excecoes.FiguraListaDeselecionada;
import excecoes.ListaVazia;
import formas.Circulo;
import formas.Figura2D;
import formas.Retangulo;
import formas.Triangulo;

import java.awt.event.ActionListener;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 * Classe principal do projeto e extende JFrame para ser o centro da interface, funciona como o aplicativo Paint do computador
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class Paint extends JFrame {

	/**
	 * contentPane painel principal onde serão colocados os outros componentes
	 * formaDesejada recebe um "código" para criaçao de uma forma específica
	 * e é um Editor para adicionar as figuras
	 * lista é uma List do tipo DefaultListModel para adicionar ao lado do painel
	 */
	private JPanel contentPane;
	private final Action action = new SwingAction();
	private int formaDesejada;
	private Editor e = new Editor();
	private DefaultListModel lista;

	/**
	 * Inicializa a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paint frame = new Paint();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame.
	 */
	public Paint() {
		lista = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		/**
		 * Painel para barra de rolagem na JList
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 39, 255, 387);
		contentPane.add(scrollPane);
		
		/**
		 * JList coloca os elementos de lista ao lado do painel para serem selecionados e modificado
		 */
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setModel(lista);
		
		/**
		 * Painel para desenho
		 */
		MeuPainel panel = new MeuPainel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 39, 369, 349);
		contentPane.add(panel);

		/**
		 * Passagem de referência para utilização de métodos na classe MeuPainel
		 */
		panel.passagem(e, panel, lista);
		
		/**
		 * scrollmeuPainel coloca uma barrra de rolagem no painel
		 */
		JScrollPane scrollmeuPainel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollmeuPainel.setBackground(Color.white);
		panel.setBackground(Color.white);
		scrollmeuPainel.setBounds(0, 39, 369, 349);
		contentPane.add(scrollmeuPainel);
		
		/**
		 * Botão para criação do Retângulo
		 */
		JToggleButton BQuadrado = new JToggleButton("Retângulo");
		BQuadrado.setBounds(0, 0, 99, 38);
		contentPane.add(BQuadrado);
		
		/**
		 * Botão para criação do Trinagulo
		 */
		JToggleButton BTriangulo = new JToggleButton("Triângulo");
		BTriangulo.setBounds(96, 0, 99, 38);
		contentPane.add(BTriangulo);
		
		/**
		 * Botão para criação do Círculo
		 */
		JToggleButton BBola = new JToggleButton("Círculo");
		BBola.setBounds(188, 0, 99, 38);
		contentPane.add(BBola);
		
		/**
		 * Botão para salvar em um .figuras
		 */
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					e.salvarFiguras();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(0, 388, 99, 38);
		contentPane.add(btnSalvar);
		
		/**
		 * Botão para carregamento de figuras
		 */
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				e.carregarFiguras(panel,lista);
			}
		});
		btnCarregar.setBounds(104, 388, 86, 38);
		contentPane.add(btnCarregar);
		
		/**
		 * Botão de remover uma figura, lança FiguraListaDeselecionada caso necessário
		 */
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					int f=list.getSelectedIndex();
					if(f==-1) {
						throw new FiguraListaDeselecionada();
					}
					Figura2D fig;
					fig=(Figura2D) lista.getElementAt(f);
					e.rmFigura(fig);
					//lista.remove(f);
					lista.removeElement(fig);
					panel.repaint();
				}catch(FiguraListaDeselecionada fd) {
					JOptionPane.showMessageDialog(null, fd.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemover.setBounds(371, 0, 94, 38);
		contentPane.add(btnRemover);
		
		/**
		 * Botão para limpar a lista, lança ListaVazia caso necessário
		 */
		JButton btnRemoverTodos = new JButton("Limpar");
		btnRemoverTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if(lista.isEmpty()) {
						throw new ListaVazia();
					}
					lista.removeAllElements();
					e.rmTodas();
					panel.repaint();
				}catch(ListaVazia lv) {
					JOptionPane.showMessageDialog(null, lv.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemoverTodos.setBounds(465, 0, 86, 38);
		contentPane.add(btnRemoverTodos);
		
		/**
		 * Botão para editar uma figura seleciona, lança FiguraListaDeselecionada caso necessário
		 */
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					int f=list.getSelectedIndex();
					if (f==-1) {
						throw new FiguraListaDeselecionada();
					}
					Figura2D fig;
					fig=(Figura2D) lista.getElementAt(f);
					if(fig instanceof Circulo) {
						JDialogEditCirculo jdec = new JDialogEditCirculo(panel,e,lista, f);
						jdec.setVisible(true);
					} else if (fig instanceof Retangulo){
						JDialogEditRetangulo jder = new JDialogEditRetangulo(panel,e,lista,f);
						jder.setVisible(true);
					}else if (fig instanceof Triangulo) {
						JDialogEditTriangulo jdet = new JDialogEditTriangulo(panel,e,lista,f);
						jdet.setVisible(true);
					}
					panel.repaint();
				}catch(FiguraListaDeselecionada fsd) {
					JOptionPane.showMessageDialog(null, fsd.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditar.setBounds(551, 0, 75, 38);
		contentPane.add(btnEditar);
		
		/**
		 * Botão para seleção do retângulo. Ao ser escolhido utiliza da função setFormaPainel da classe MeuPainel, mandando como formaDesejada 4
		 */
		BQuadrado.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					formaDesejada=4;
					panel.setFormaPainel(formaDesejada,BQuadrado.isSelected(),BTriangulo.isSelected(),BBola.isSelected());
					BBola.setSelected(false);
					BTriangulo.setSelected(false);
				}
				else if(e.getStateChange()==ItemEvent.DESELECTED) {
					BQuadrado.setSelected(false);
					panel.setFormaPainel(formaDesejada,BQuadrado.isSelected(),BTriangulo.isSelected(),BBola.isSelected());
				}
			}
		});
		
		/**
		 * Botão para seleção do triângulo. Ao ser escolhido utiliza da função setFormaPainel da classe MeuPainel, mandando como formaDesejada 3
		 */
		BTriangulo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					formaDesejada=3;
					panel.setFormaPainel(formaDesejada,BQuadrado.isSelected(),BTriangulo.isSelected(),BBola.isSelected());
					BBola.setSelected(false);
					BQuadrado.setSelected(false);
				}
				else if(e.getStateChange()==ItemEvent.DESELECTED) {
					BTriangulo.setSelected(false);
					panel.setFormaPainel(formaDesejada,BQuadrado.isSelected(),BTriangulo.isSelected(),BBola.isSelected());
				}
			}
		});
		
		/**
		 * Botão para seleção do círculo. Ao ser escolhido utiliza da função setFormaPainel da classe MeuPainel, mandando como formaDesejada 0
		 */
		BBola.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					formaDesejada=0;
					panel.setFormaPainel(formaDesejada,BQuadrado.isSelected(),BTriangulo.isSelected(),BBola.isSelected());
					BTriangulo.setSelected(false);
					BQuadrado.setSelected(false);
				}
				else if(e.getStateChange()==ItemEvent.DESELECTED) {
					BBola.setSelected(false);
					panel.setFormaPainel(formaDesejada,BQuadrado.isSelected(),BTriangulo.isSelected(),BBola.isSelected());
				}
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
