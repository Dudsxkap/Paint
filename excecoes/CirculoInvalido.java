package excecoes;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao tentar por um número negativo no raio
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */

import java.awt.Color;

public class CirculoInvalido extends Exception {

	/**
	 * vraio receberá o valor do raio do círculo
	 */
	String vraio;
	
	/**
	 * Construtor padrão para classes que extendem Exception e além disso atribui raio à vraio
	 * @param raio recebe o raio do círculo
	 */
	public CirculoInvalido(String raio) {
		super();
		vraio=raio;
	}
	
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Deixe o valor das seguintes coisas maior que 0 para continuar: ");
		if(Integer.parseInt(vraio)<=0) {
			erro.append(" |Raio| ");
		}
		return erro.toString();
		
	}
}
