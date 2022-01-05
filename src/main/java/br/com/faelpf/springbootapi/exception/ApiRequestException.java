package br.com.faelpf.springbootapi.exception;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(String mensagem) {
        super(mensagem);
    }

    public ApiRequestException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

}
