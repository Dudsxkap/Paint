package excecoes;

import java.awt.Color;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao tentar criar uma figura com posição x, posição y ou cor vazia
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class FiguraVazia extends Exception {
	
	/**
	 * vx receberá o valor da posição x
	 * vy receberá o valor da posição y
	 * vc receberá a cor
	 */
	String vx,vy;
	Color vc;
	
	/**
	 * Construtor padrão para classes que extendem Exception e além disso atribui cor à vcor, posição x à vx e posição y à vy
	 * @param x recebe a posição x da figura
	 * @param y recebe a posição y da figura
	 * @param cor recebe a cor da figura
	 */
	public FiguraVazia(String x, String y,Color cor) {
		super();
		vx=x;
		vy=y;
		vc=cor;
	}
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Preencha os seguintes valores para criar sua Figura: ");
		if(vx.equals("")) {
			erro.append(" |X| ");
		}
		if(vy.equals("")) {
			erro.append(" |Y| ");
		}
		if(vc==null) {
			erro.append(" |Cor| ");
		}
		return erro.toString();
		
	}
	
}
