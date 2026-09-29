void main() {
//    int[] array = new int[5];
    //IO.println(array.length);

    List<String> listaProdutos = new ArrayList<>();
    listaProdutos.add("Mouse");
    listaProdutos.add("Teclado");
//    IO.println(listaProdutos.size());
//    IO.println(listaProdutos.getFirst());

    try (BufferedReader leitor = new BufferedReader(new FileReader("src\\produtos.txt"))) {
        String linha;
        while ((linha = leitor.readLine()) != null) {
            listaProdutos.add(linha);
        }
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    IO.println(listaProdutos.size());

//    try {
//        IO.println(listaProdutos.get(1)); // Aqui gera uma exceção IndexOutOfBoundsException
//    } catch (IndexOutOfBoundsException e) {
//        IO.println("Você tentou acessar um elemento inexistente da lista");
//    } catch (Exception e) {
//        IO.println("Erro desconhecido");
//    } finally {
//        IO.println("Passamos por todo o bloco try/catch");
//    }

//    A linha abaixo gera erro de índice fora dos limites do Array
//    IO.println(listaProdutos.get(5));
//    IO.println(listaProdutos.contains("Mouse"));
//    listaProdutos.remove(0);
//    IO.println(listaProdutos.contains("Mouse"));


//    Set<String> cuponsDesconto = new HashSet<>();
//   cuponsDesconto.add("CUPOM10");
//    cuponsDesconto.add("CUPOM!)");
//    IO.println(cuponsDesconto.size());

//    Set<String> listaDeEmails = new HashSet<>();
//    IO.println("Inseriu? " + listaDeEmails.add("luiz@hotmail.com"));
//    IO.println("Inseriu? " + listaDeEmails.add("lena@hotmail.com"));
//    IO.println("Inseriu? " + listaDeEmails.add("luiz@hotmail.com"));
//    IO.println(listaDeEmails.size());
//
//
//    Map<String, Integer> estoquePorCodigoProduto = new HashMap<>();
//    estoquePorCodigoProduto.put("PROD1", 10);
//    estoquePorCodigoProduto.put("PROD2", 20);
//    estoquePorCodigoProduto.put("PROD3", 15);
//    estoquePorCodigoProduto.put("PROD4", 5);
//
//    if (estoquePorCodigoProduto.containsKey("PROD3")) {
//        IO.println(estoquePorCodigoProduto.get("PROD3"));
//    }


}

