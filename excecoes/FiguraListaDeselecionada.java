package excecoes;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao clicar em um botão de mudança da lista sem clicar em nenhuma figura da lista
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class FiguraListaDeselecionada extends Exception {
	
	/**
	 * Construtor padrão para classes que extendem Exception
	 */
	public FiguraListaDeselecionada(){
		super();
	}
	/**
	 * Forma a mensagem à ser mandada pelo erro dependendo dos valores que estão dando erro
	 * @return Mensagem à ser mostrada para o usuário em caso de erro
	 */
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Selecione uma figura da lista para proceder com essa ação");
		return erro.toString();
		
	}
}
