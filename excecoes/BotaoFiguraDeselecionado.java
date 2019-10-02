package excecoes;

/**
 * Essa classe extende Exception e é uma exceção criada para ser lançada ao clicar na tela e não ter selecionado nenhuma figura antes
 * @author Eduardo Amorim dos Santos Araujo
 * @author Guilherme Trindade Souza
 */
public class BotaoFiguraDeselecionado extends Exception {
	
	/**
	 * Construtor padrão para classes que extendem Exception
	 */
	public BotaoFiguraDeselecionado(){
		super();
	}
	public String getMessage() {
		StringBuffer erro = new StringBuffer();
		erro.append("Selecione uma figura para ser criada");
		return erro.toString();
		
	}
}
