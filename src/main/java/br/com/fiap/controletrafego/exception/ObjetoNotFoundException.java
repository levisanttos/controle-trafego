package br.com.fiap.controletrafego.exception;

public class ObjetoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjetoNotFoundException(String mensagem) {
		super(mensagem);
	}

}
