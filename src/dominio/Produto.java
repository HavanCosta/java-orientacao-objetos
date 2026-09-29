package dominio;

public class Produto implements Exportavel {
    public static final double VALOR_MINIMO_PARA_FRETE_GRATIS = 50;
    public static int totalDeProdutosCriados = 0;

    private String nome;
    private double preco;
    private boolean ativo;
    private int estoque;

    public Produto() {
    }

    public Produto(String nome, double preco, boolean ativo, int estoque) {
        this.nome = nome;
        setPreco(preco);
        this.ativo = ativo;
        this.estoque = estoque;
        totalDeProdutosCriados++;
    }

    public boolean temFreteGratis() {
        return this.preco >= VALOR_MINIMO_PARA_FRETE_GRATIS;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        } else {
            this.preco = 0;
            IO.println("O preço do produto não pode ser negativo");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getEstoque() {
        return estoque;
    }

    private void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void baixarEstoque(int quantidade) {
        if (quantidade <= this.estoque) {
            this.estoque -= quantidade;
        } else {
            IO.println("Não existe quantidade suficiente em estoque para dar baixa");
        }
    }

    @Override
    public String exportarJson() {
        this.imprimirAuditoriaExportacao();
        String json = """
{
    "nome": "%s",
    "preco": %f,
    "ativo": %b,
    "estoque": %d
}
""".formatted(nome, preco, ativo, estoque);
            return json;
    }
}
