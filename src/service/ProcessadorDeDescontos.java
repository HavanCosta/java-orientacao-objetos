package service;

import dominio.Usuario;

public class ProcessadorDeDescontos {
    public void processar(Usuario usuario, double valorCompra) {
        double desconto = usuario.calcularDesconto(valorCompra);
        double valorFinal = valorCompra - desconto;
        IO.println("=== Processando Desconto ===");
        IO.println("Usuário: "+usuario.getNome());
        IO.println("Valororiginal: "+valorCompra);
        IO.println("Desconto: "+desconto);
        IO.println("Valor final: "+valorFinal);
    }
}
