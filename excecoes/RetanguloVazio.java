package excecoes;

import java.awt.Color;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao tentar criar um retângulo com altura, base ou cor vazia
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class RetanguloVazio extends Exception {
	
	/**
	 * valtura receberá o valor da altura do triângulo
	 * vbase receberá o valor da base do triângulo
	 * vc receberá a cor do triângulo
	 */
	String valtura,vbase;
	Color vc;
	
	/**
	 * Construtor padrão para classes que extendem Exception e além disso atribui cor à vcor, altura à valtura e base à vbase
	 * @param altura recebe a altura do retângulo
	 * @param base recebe a base do retângulo
	 * @param cor recebe a cor do retângulo
	 */
	public RetanguloVazio(Color cor, String altura,String base) {
		super();
		valtura=altura;
		vbase=base;
		vc=cor;
	}
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Preencha os seguintes valores para criar seu Retângulo: ");
		if(valtura.equals("")) {
			erro.append(" |Altura| ");
		}
		if(vbase.equals("")) {
			erro.append(" |Base| ");
		}
		if(vc==null) {
			erro.append(" |Cor| ");
		}
		return erro.toString();
		
	}
}
