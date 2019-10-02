package excecoes;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao clicar no botão de limpar e a lista estar vazia
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class ListaVazia extends Exception {

	/**
	 * Construtor padrão para classes que extendem Exception
	 */
	public ListaVazia() {
		super();
	}
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("A lista está vazia, logo, já está limpa.");
		return erro.toString();
		
	}
}
