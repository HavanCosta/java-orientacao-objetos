import dominio.*;

void main() {
    Cliente cliente = new Cliente("Luiz", "luiz@hotmail.com","Luizbourgui", "Rua 1");
    Produto produto = new Produto("Mouse", 35.00, true, 10);
    ItemPedido itemPedido = new ItemPedido(produto, 1);
    List<ItemPedido> itens = new ArrayList<>();
    itens.add(itemPedido);

    Pedido pedido = new Pedido();
    pedido.setCliente(cliente);
    pedido.setItensPedido(itens);
    pedido.setStatus(StatusPedido.ENVIADO);

    IO.println(pedido.getStatus());

    if (StatusPedido.PAGO.equals(pedido.getStatus())) {
        IO.println("O pedido foi pago!");
    }

    IO.println(pedido.getMensagemStatus());

    for (StatusPedido statusPedido : StatusPedido.values()) {
        IO.println("Nome do status: "+statusPedido.name()+ " | Ordem: "+statusPedido.ordinal());
    }

    ResumoPedido resumoPedido = new ResumoPedido(pedido.getCliente().getNome(), -100, pedido.getStatus());

    IO.println(pedido);
    IO.println(resumoPedido);
}
