package dominio;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String login;

    public Usuario() {
    }

    public Usuario(String nome, String email, String login) {
        this.nome = nome;
        this.email = email;
        this.login = login;
    }

    public void exibirPerfil() {
        IO.println("Nome: "+this.nome+" | Email: "+this.email+" |Login: "+this.login);
    }

    public abstract double calcularDesconto(double valorTotal);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
