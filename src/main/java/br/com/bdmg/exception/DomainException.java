package br.com.bdmg.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message, null, true, false);
    }
}
