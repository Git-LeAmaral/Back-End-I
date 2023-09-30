package br.com.clientes.api.handler;

public record Problema(Integer status,
                       String message,
                       String detail) {
}
