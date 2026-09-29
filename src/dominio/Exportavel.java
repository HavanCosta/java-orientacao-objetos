package dominio;

public interface Exportavel {
    String exportarJson();

    default void imprimirAuditoriaExportacao() {
        IO.println("[AUDITORIA] Informações prontas para serem exportadas:");
    }
}
