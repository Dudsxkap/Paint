package excecoes;

import java.awt.Color;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao tentar por um número negativo na base ou na altura
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class RetanguloInvalido extends Exception {

	/**
	 * valtura receberá o valor da altura do retângulo
	 * vbase receberá o valor da base do retângulo
	 */
	String valtura,vbase;
	
	/**
	 * Construtor padrão para classes que extendem Exception e além disso atribui altura à valtura e base à vbase
	 * @param altura recebe a altura do retângulo
	 * @param base recebe a base do retângulo
	 */
	public RetanguloInvalido(String altura, String base) {
		super();
		valtura=altura;
		vbase=base;
	}
	
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Deixe o valor das seguintes coisas maior que 0 para continuar: ");
		if(Integer.parseInt(vbase)<=0) {
			erro.append(" |Base| ");
		}if(Integer.parseInt(valtura)<=0) {
			erro.append(" |Altura| ");
		}
		return erro.toString();
		
	}
}
