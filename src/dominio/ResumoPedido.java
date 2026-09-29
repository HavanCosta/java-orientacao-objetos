package dominio;

public record ResumoPedido(String cliente, double total, StatusPedido status) {
    public  ResumoPedido {
        if (total < 0) {
            IO.println("O pedido não pode ter total negativo!");
        }
    }
}
