package formas;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import excecoes.RetanguloInvalido;
import excecoes.RetanguloVazio;

/**
 * Retangulo é uma classe que extende Figura2D e serve para criação de retângulos
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 *
 */
public class Retangulo extends Figura2D
{
	/**
	 * base é a base do retângulo
	 * altura é a altura do retângulo
	 */
    private int base;
    private int altura;
    
    /**
     * Construtor do retângulo que trata das exceções RetanguloVazio, RetanguloInvalido, NumberFormatException a fim dos valores recebidos serem validos de todas as maneiras
     * @param cor recebe uma cor
     * @param px  recebe o valor da posição X
     * @param py  recebe o valor da posição Y
     * @param base  recebe o valor da base
     * @param altura  recebe o valor da altura
     */
    public Retangulo(Color cor, String px, String py, String base, String altura){
        super(cor, px, py);
        try {
        	if(base.equals("") || cor==null || altura.equals("")) {
        		throw new RetanguloVazio(cor,altura,base);
        	}
        	if(Integer.parseInt(base)<=0 || Integer.parseInt(altura)<=0) {
        		throw new RetanguloInvalido(altura,base);
        	}
        	this.base=Integer.parseInt(base);
        	this.altura=Integer.parseInt(altura);
        }catch(NumberFormatException nfe) {
        	JOptionPane.showMessageDialog(null, "Utilize somente números nos campos","ERRO",JOptionPane.ERROR_MESSAGE);
        }catch (RetanguloVazio v) {
        	JOptionPane.showMessageDialog(null, v.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }catch(RetanguloInvalido ci) {
        	JOptionPane.showMessageDialog(null, ci.getMessage(),"ERRO",JOptionPane.ERROR_MESSAGE);
        }
    }
     /**
      * Método que calcula a área do retângulo
      * @return área do retângulo
      */
    public double area(){
        return base*altura;
    }
    /**
     * Modifica o toString do Retangulo
     * @return informações do retângulo
     */
    public String toString(){
	        
	StringBuffer Buffer = new StringBuffer();
        
        Buffer.append("Retângulo\n");
        Buffer.append("| Cor: ");
        Buffer.append(this.getCor());
        Buffer.append("\n| Área: ");
        Buffer.append(this.area());
        Buffer.append("\n| Base: ");
        Buffer.append(this.base);
        Buffer.append("\n| Altura: ");
        Buffer.append(this.altura);
        Buffer.append("\n| Px: ");
        Buffer.append(this.x);
        Buffer.append("\n| Py: ");
        Buffer.append(this.y);
        Buffer.append(" \n");
         
        return Buffer.toString();
    }
    
    /**
     * Retorna o valor da base do retângulo
     * @return valor da base
     */
    public int getBase() {
		return base;
	}

    /**
     * Atribui o valor da base da figura
     * @param base valor da base
     */
	public void setBase(int base) {
		this.base = base;
	}
	
	/**
	 * Retorna o valor da altura
	 * @return valor da altura do retângulo
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Atribui o valor da altura do retângulo
	 * @param altura valor da altura
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * Método para desenhar o retângulo
	 * @param g é um Graphics para desenho do retângulo
	 */
	public void desenhar (Graphics g){
    	g.setColor(cor);
        g.fillRect(x-base/2, y-altura/2, base, altura);
    }
    
}
