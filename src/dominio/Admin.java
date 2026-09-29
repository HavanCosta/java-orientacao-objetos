package dominio;

public class Admin extends Usuario implements Exportavel {
    private int nivelDeAcesso;

    public Admin(String nome, String email, String login, int nivelDeAcesso) {
        super(nome, email, login);
        this.nivelDeAcesso = nivelDeAcesso;
    }

    @Override
    public void exibirPerfil() {
        super.exibirPerfil();
        IO.println("Nível de acesso: "+this.nivelDeAcesso);
    }

    @Override
    public double calcularDesconto(double valorTotal) {
        return valorTotal * 0.20;
    }

    public int getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(int nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    @Override
    public String exportarJson() {
        this.imprimirAuditoriaExportacao();
        String json = """
{
    "nome": "%s",
    "email": "%s",
    "login": "%s",
    "nivelDeAcesso": %d
}
""".formatted(nome, email, login, nivelDeAcesso);
        return json;
    }
}
