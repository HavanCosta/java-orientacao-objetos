import dominio.Produto;

void main() {
    Produto p1 = new Produto("Mouse", 35.00, true, 10);
    Produto p2 = new Produto("Teclado", 200, true, 5);
    Produto p3 = new Produto("Headset", 150.50, true, 2);

    List<Produto> produtos = new ArrayList<>();
    produtos.add(p1);
    produtos.add(p2);
    produtos.add(p3);

    List<String> nomes = new ArrayList<>();
    List<Integer> notas = new ArrayList<>();
    notas.add(10); //auto-boxing

    IO.println("For Tradicional");
    for (int i = 0 ; i < produtos.size() ; i++) {
        IO.println(produtos.get(i).getNome());
    }

    IO.println("for each");
    for (Produto prod : produtos) {
        IO.println(prod.getNome());
    }

    Map<String, Double> tabelaPrecos = new HashMap<>();
    tabelaPrecos.put(p1.getNome(), p1.getPreco());
    tabelaPrecos.put(p2.getNome(), p2.getPreco());
    tabelaPrecos.put(p3.getNome(), p3.getPreco());

    for (Map.Entry<String, Double> entrada : tabelaPrecos.entrySet()) {
        IO.println("Chave: "+ entrada.getKey() + " | Valor: "+ entrada.getValue());
    }
}