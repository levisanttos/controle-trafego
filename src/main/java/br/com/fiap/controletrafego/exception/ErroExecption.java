package br.com.fiap.controletrafego.exception;

import java.time.LocalDateTime;

public record ErroExecption(String mensagem, LocalDateTime dataErro) {

}
