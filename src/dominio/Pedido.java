package dominio;

import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> itensPedido;
    private StatusPedido status;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public String getMensagemStatus() {
        return switch (this.status) {
            case AGUARDANDO_PAGAMENTO -> "Pedido aguardando pagamento";
            case PAGO -> "Pedido pago";
            case ENVIADO -> "Pedido enviado";
            case ENTREGUE -> "Pedido entregue";
            case CANCELADO -> "Pedido cancelado";
        };
    }
}


