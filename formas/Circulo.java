package formas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import excecoes.CirculoInvalido;
import excecoes.CirculoVazio;

/**
 * Circulo é uma classe que extende Figura2D e serve para criação de círculos
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 *
 */
public class Circulo extends Figura2D
{
	/**
	 * raio se refere ao raio do círculo
	 */
	  private int raio;
	    
	  /**
	   * Construtor da figura círculo que trata exceções CirculoVazia, CirculoInvalido e NumberFormatException a fim dos valores recebidos serem válidos de todas as maneiras
	   * @param cor recebe uma cor
	   * @param px recebe o valor da posição X
	   * @param py recebe o valor da posição Y
	   * @param raio recebe o valor do raio
	   */
	    public Circulo(Color cor, String px, String py, String raio){
	        super(cor, px, py);
	        try {
	        	if(raio.equals("")) {
	        		throw new CirculoVazio(raio);
	        	}
	        	if(Integer.parseInt(raio)<=0) {
	        		throw new CirculoInvalido(raio);
	        	}
	        	this.raio=Integer.parseInt(raio);
	        }catch(NumberFormatException nfe) {
	        	JOptionPane.showMessageDialog(null, "Utilize somente números nos campos","ERRO",JOptionPane.ERROR_MESSAGE);
	        }catch (CirculoVazio v) {
	        	JOptionPane.showMessageDialog(null, v.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
	        }catch(CirculoInvalido ci) {
	        	JOptionPane.showMessageDialog(null, ci.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    
	    /**
	     * @return valor da área do círculo
	     */
	    public double area(){
	        return Math.PI*Math.pow(raio, 2);
	    }
	    
	    /**
	     * 
	     * @return raio do círculo
	     */
	    public int getRaio() {
			return raio;
		}
	    
	    /**
	     * 
	     * @param raio se refere ao raio do círculo
	     */
		public void setRaio(int raio) {
			this.raio = raio;
		}
		
		/**
		 * Método para mudar o toString do círculo para mostrar as informações
		 * @return informações do círculo
		 */
		public String toString(){
	        
                StringBuffer Buffer = new StringBuffer();
        
                Buffer.append("Círculo\n");
                Buffer.append("| Cor: ");
                Buffer.append(this.getCor());
                Buffer.append("\n| Área: ");
                Buffer.append(this.area());
                Buffer.append("\n| Raio: ");
                Buffer.append(this.raio);
                Buffer.append("\n| Px: ");
                Buffer.append(this.x);
                Buffer.append("\n| Py: ");
                Buffer.append(this.y);
                Buffer.append(" \n");
         
                return Buffer.toString();
            }
            
		/**
		 * Método para desenho do círculo
		 * @param g é um Graphics para desenho no painel
		 */
            public void desenhar(Graphics g){
               g.setColor(cor);
               g.fillOval(x-raio/2, y-raio/2,raio, raio);
            }
}
