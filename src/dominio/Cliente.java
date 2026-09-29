package dominio;

public class Cliente extends Usuario {
    private String endereco;

    public Cliente(String nome, String email, String login, String endereco) {
        super(nome, email, login);
        this.endereco = endereco;
    }

    @Override
    public void exibirPerfil() {
        super.exibirPerfil();
        IO.println("Endereço: "+this.endereco);
    }

    @Override
    public double calcularDesconto(double valorTotal) {
        return valorTotal * 0.10;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
