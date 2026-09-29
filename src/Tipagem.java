import dominio.Produto;

void main() {
    // let quantidade = "dez";
    int quantidade = 0;
    double preco = 24;
    Boolean ativo = true;
    Long quantidade2 = 20L;

    var s1 = "Havan Costa";
    String s2 = new String("texto");

    int frete = preco >= 5 && ativo ? 0 : 2;

//    IO.println(calcularFrete(preco, ativo));
//    IO.println(calcularFrete(10.0, true));
//    IO.println(calcularFrete(70.0, true));
//
//    String regiao = "SP";
//    IO.println(calcularFrete(regiao));
//
//    dominio.Produto pneu = new dominio.Produto();
//    pneu.nome = "";
//    pneu.estoque = 10;
//    pneu.ativo = true;
//    pneu.preco = -200.0;


    Produto pneu = new Produto("Pirelli", 200.0, true, 10);
    Produto oleo = new Produto("Castrol", 45, true, 2);
    IO.println("Regra para frete grátis, valor mínimo: "+ Produto.VALOR_MINIMO_PARA_FRETE_GRATIS);
    IO.println("Pneu Pirelli tem frete grátis? "+ pneu.temFreteGratis());
    IO.println("Óleo Castrol tem frete grátis? "+ oleo.temFreteGratis());
    IO.println("Quantidade de produtos criados: "+ Produto.totalDeProdutosCriados);

//    pneu.baixarEstoque(8);

//    IO.println(calcularFrete(pneu.preco, pneu.ativo));
}


int calcularFrete(double preco, boolean ativo) {
        if (preco >= 50 && ativo) {
            return 0;
        } else if (preco >= 25 && ativo) {
            return 5;
        } else {
            return 10;
        }
    }

int calcularFrete(String regiao) {
    return switch (regiao) {
        case "SP" -> 0;
        case "DF" -> 10;
        default -> 20;
    };
}