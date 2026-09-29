import dominio.Produto;

public class ProdutoComSKU {
    private String sku;
    private String nome;
    private String serial;
    private boolean ativo;
    private int estoque;

    public ProdutoComSKU(String sku, String nome, String serial, boolean ativo, int estoque) {
        this.sku = sku;
        this.nome = nome;
        this.serial = serial;
        this.ativo = ativo;
        this.estoque = estoque;
    }

    public String getSku() {
        return sku;
    }

    public String getNome() {
        return nome;
    }

    public String getSerial() {
        return serial;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public int getEstoque() {
        return estoque;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // mesma referência em memória
        if (obj == null || getClass() != obj.getClass()) return false; //tipos diferentes
        ProdutoComSKU produto = (ProdutoComSKU) obj;
        return Objects.equals(sku, produto.sku); // mesmo sku, mesmo produto
    }

    @Override
    public String toString() {
        return "ProdutoComSKU[sku="+sku+", nome="+nome+", serial=***"+serial.substring(3)+"]";
    }
}

static class ProdutoInativoException extends RuntimeException {
    public ProdutoInativoException(String sku) {
        super("Produto inativo não pode ser adicionado ao carrinho: " + sku);
    }
}

static class CarrinhoDeCompras {
    List<ProdutoComSKU> listaDeProdutos;
    public CarrinhoDeCompras() {
        this.listaDeProdutos = new ArrayList<>();
    }
    public void adicionar(ProdutoComSKU produto) {
        if (!produto.ativo) {
            throw new ProdutoInativoException(produto.getSku());
        }
        this.listaDeProdutos.add(produto);
    }
}

class CatalogoService {
    ProdutoComSKU p1 = new ProdutoComSKU("SKU-11", "Mouse", "123456", true, 3);
    ProdutoComSKU p2 = new ProdutoComSKU("SKU-20", "Teclado", "654321", true, 10);
    ProdutoComSKU p3 = new ProdutoComSKU("SKU-03", "Monitor", "333333", true, 5);
    ProdutoComSKU p4 = new ProdutoComSKU("SKU-99", "CPU", "999999", true, 1);

    private List<ProdutoComSKU> catalogo = List.of(p1, p2, p3, p4);

    public Optional<ProdutoComSKU> buscarPorNome(String nome) {
        return catalogo.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}

void main() {
    CatalogoService service = new CatalogoService();
    Optional<ProdutoComSKU> produtoExistente = service.buscarPorNome("teclado");
    produtoExistente.ifPresent(p -> IO.println("Produto encontrado: " + p.getNome()));
    Optional<ProdutoComSKU> produtoInexistente = service.buscarPorNome("violão");
    IO.println(produtoInexistente.isEmpty() ? "Produto não encontrado!" : produtoInexistente.get());

}

//    List<String> produtoEstoqueBaixo = new ArrayList<>();
//    for (ProdutoComSKU produto : catalogo) {
//        if (produto.getEstoque() < 5) {
//            produtoEstoqueBaixo.add(produto.getNome());
//        }
//    }
//    produtoEstoqueBaixo.forEach(IO::println);

//    List<String> produtosEstoqueBaixo = catalogo.stream()
//            .filter(p -> p.getEstoque() < 5)
//            .map(ProdutoComSKU::getNome)
//            .toList();
//    IO.println("Tamanho da lista de estoque baixo: "+produtosEstoqueBaixo.size());
//
//    int estoqueTotal = catalogo.stream()
//            .mapToInt(ProdutoComSKU::getEstoque)
//            .sum();
//    IO.println("Estoque total: "+estoqueTotal);
//
//    boolean existeSku99 = catalogo.stream().anyMatch(p -> p.sku.equals("SKU-99"));
//    IO.println("Existe produto SKU-99? "+existeSku99);
//
//    Map<Boolean, List<ProdutoComSKU>> produtosPorStatus = catalogo.stream()
//            .collect(Collectors.groupingBy(ProdutoComSKU::isAtivo));
//    IO.println("Produtos Ativos: " + produtosPorStatus.get(true));
//    IO.println("Produtos Inativos: " + produtosPorStatus.get(false).size());
//}

//    CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
//    try {
//        carrinho.adicionar(p1);
//        carrinho.adicionar(p2);
//        carrinho.adicionar(p3);
//        carrinho.adicionar(p4);
//    } catch (ProdutoInativoException e) {
//        IO.println(e.getMessage());
//    }

//    carrinho.listaDeProdutos.sort(Comparator.comparing(ProdutoComSKU::getNome));
//    carrinho.listaDeProdutos.forEach(p -> IO.println(p.getNome()));

//    IO.println(p1.toString());
//
//    record ProdutoSKU(String sku, String nome) {}
//    ProdutoSKU p1Record = new ProdutoSKU(p1.getSku(), p1.getNome());
//    IO.println(p1Record.toString());

//    IO.println("p1 == p2 ? " + (p1==p2)); // mesma referência em memória?
//    IO.println("p1.equals(p2) ? " + p1.equals(p2)); // os objetos são iguais?
//
//    Set<ProdutoComSKU> produtos = new HashSet<>();
//    produtos.add(p1);
//    produtos.add(p2);
//    IO.println("Qual o tamanho do set? "+produtos.size());
//}