package paint;

import formas.Figura2D;

import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.EOFException;
import java.io.File;

/**
 *  Essa classe serve como um "controle" para que sejam desenhadas e removidas as figuras
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class Editor{
	
	/**
	 *figuras é uma List de Figura2D 
	 */
    private List<Figura2D> figuras;
    
    /**
     * Construtor que instancia figuras como um ArrayList de Figura2D
     */
    public Editor(){
        figuras = new ArrayList <Figura2D>(); 
    }
    
    /**
     * Adiciona uma figura na lista figuras
     * @param f é uma Figura2D
     */
    public void addFigura(Figura2D f){
        figuras.add(f);
    }
    
    /**
     * Adiciona uma figura em uma posição específica
     * @param f é uma Figura2D
     * @param posicao é um inteiro que mostra a posição desejada
     */
    public void addFiguraPosicao(Figura2D f, int posicao){
        figuras.add(posicao, f);
    }
    /**
     * Remove uma figura da lista
     * @param f será um objeto que será removido de figuras
     */
    public void rmFigura(Object f){
    	Figura2D del = (Figura2D) f;
        figuras.remove(del);
    }
    
    /**
     * Método que deleta todas as figuras da lista figuras
     */
    public void rmTodas() {
    	figuras.removeAll(figuras);
    }
    
    /**
     * Método que salva as suas figuras em um arquivo .figuras
     * @throws IOException
     */
    public void salvarFiguras() throws IOException{
    	try {
			JFileChooser fc = new JFileChooser();
			File arquivo = null;
			FileOutputStream file;
			
			 fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			 FileNameExtensionFilter filter = new FileNameExtensionFilter("Figuras MeuPaint (.figuras)", new String[]{"figuras"});
			 fc.setFileFilter(filter);    
			 fc.setMultiSelectionEnabled(false); 
			 fc.setAcceptAllFileFilterUsed(false);
			 
	         int nmr = fc.showSaveDialog(null); 
	         if (nmr!=1){
	        	 arquivo = fc.getSelectedFile();
	        	 file = new FileOutputStream(arquivo.getPath()+".figuras");
	        	 ObjectOutputStream arqObj = new ObjectOutputStream(file);
        
	        	 for (Figura2D f : figuras) { 
	        		 arqObj.writeObject(f);
	        	 }
	        	 
	        	 arqObj.close();
	        }
		}
		catch(IOException e) {
			
		}										//
    }


    /**
     * Método que carrega um arquivo .figuras
     * @param panel Painel onde serão desenhadas as figuras
     * @param lista A lista que será mostrada ao lado do painel
     */
    public void carregarFiguras(MeuPainel panel, DefaultListModel lista){
    	JFileChooser fileChooser = new JFileChooser();    
		fileChooser.setDialogTitle("Escolha o arquivo para carregar");    
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);    

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Figuras MeuPaint", new String[]{"figuras"});    
		fileChooser.setFileFilter(filter);    
		fileChooser.setAcceptAllFileFilterUsed(false);  
		fileChooser.setMultiSelectionEnabled(false);    
		File arquivo = null;
		int opcao = fileChooser.showOpenDialog(null); //abre o FileChooser para o usuário poder escolher o arquivo
		
        if (opcao!=1){
        	arquivo = fileChooser.getSelectedFile();
        
       	 	try (ObjectInputStream f = new ObjectInputStream(new FileInputStream(arquivo.getPath()))) {
       	 		
       	 		while(true) { //adiciona as formas do arquivo no ArrayList
       	 			figuras.add((Figura2D) f.readObject());
       	 		}
       	 		
			}
        	catch(EOFException e){
        	
        	} 
			catch(Exception e) {
        		e.printStackTrace();
        	}
       	 	lista.clear();
	 		for(Figura2D imagens : figuras) {
	 			lista.addElement(imagens);
	 		}
       	 	panel.repaint();
        }
    }
    

    /**
     * Chama o desenhar de todas as figuras na lista figuras
     * @param g Graphics para desenhar as figuras na lista figuras
     */
    public void desenhar(Graphics g){
    	for(Figura2D f : figuras){
            f.desenhar(g);
        }
    }
}
