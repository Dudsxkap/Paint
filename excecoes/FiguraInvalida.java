package excecoes;

import java.awt.Color;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao tentar por um número negativo na Posição X ou na Posição Y
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class FiguraInvalida extends Exception {
	
	/**
	 * vx receberá o valor da posição x
	 * vy receberá o valor da posição y
	 */
	int vx,vy;
	
	/**
	 * Construtor padrão para classes que extendem Exception e além disso atribui x à vx e y à vy
	 * @param vx recebe a posição x da figura
	 * @param vy recebe a posição y da figura
	 */
	public FiguraInvalida(String x,String y) {
		super();
		vx=Integer.parseInt(x);
		vy=Integer.parseInt(y);
	}
	
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Deixe o valor das seguintes coisas maior que 0 para continuar: ");
		if(vx<=0) {
			erro.append(" |X| ");
		}if(vy<=0) {
			erro.append(" |Y| ");
		}
		return erro.toString();
		
	}
}
