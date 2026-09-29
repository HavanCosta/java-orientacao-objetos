import dominio.*;
import service.ProcessadorDeDescontos;

void main() {
    IO.println("=== Perfil Usuário ===");
    //Usuario u1 = new Usuario("Havan", "havan39@hotmail.com", "HavanCosta");
    //u1.exibirPerfil();

    IO.println("=== Perfil Cliente ===");
    Cliente c1 = new Cliente( "Luiz Carlos", "lcbourgui@hotmail.com", "Luiz", "Rua 1");
    //c1.exibirPerfil();

    IO.println("=== Perfil Admin ===");
    Admin a1 = new Admin("Lena", "lena@hotmail.com", "Lena", 2);
    //a1.exibirPerfil();
    //IO.println(a1.exportarJson());

    ProcessadorDeDescontos processadorDeDescontos = new ProcessadorDeDescontos();
    //processadorDeDescontos.processar(c1, 2000);
    //processadorDeDescontos.processar(a1, 2000);

//    Testando referências -> em cada interação, a JVM decide o métod correto em tempo de execução
    IO.println("=== Loop de Usuarios ===");
    List<Usuario> usuarios = new ArrayList<>();
    usuarios.add(c1);
    usuarios.add(a1);
    for (Usuario u : usuarios) {
 //       u.exibirPerfil();
 //       processadorDeDescontos.processar(u, 2000);
    }

    List<Exportavel> itensExportaveis = new ArrayList<>();
    itensExportaveis.add(new Produto("Pneu", 200.00, true, 10));
    itensExportaveis.add(a1);
    for (Exportavel item :itensExportaveis) {
        IO.println(item.exportarJson());
        if (item instanceof Admin) {
            IO.println("Este item exportavel é um Admin");
        }
    }
}
