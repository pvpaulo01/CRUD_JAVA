import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Produto> listaProdutos = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("0 - Sair do sistema");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Editar produto");
            System.out.println("3 - Deletar produto");
            System.out.println("4 - Visualizar lista de produtos");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    editarProduto();
                    break;
                case 3:
                    deletarProduto();
                    break;
                case 4:
                    visualizarProdutos();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    static void cadastrarProduto() {
        System.out.println("Digite o ID do produto:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Digite o valor do produto:");
        float valor = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.println("Digite a data do produto:");
        String data = scanner.nextLine();

        Produto novoProduto = new Produto(id, nome, quantidade, (int) valor, data);
        listaProdutos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    static void editarProduto() {
        System.out.println("Digite o ID do produto que deseja editar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        Produto produtoParaEditar = null;

        // Procurar o produto na lista
        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                produtoParaEditar = produto;
                break;
            }
        }

        if (produtoParaEditar != null) {
            System.out.println("Digite o novo nome do produto:");
            String novoNome = scanner.nextLine();
            produtoParaEditar.setNome(novoNome);

            System.out.println("Digite a nova quantidade do produto:");
            int novaQuantidade = scanner.nextInt();
            produtoParaEditar.setQuantidade(novaQuantidade);

            System.out.println("Digite o novo valor do produto:");
            float novoValor = scanner.nextFloat();
            produtoParaEditar.setValor((int) novoValor);

            System.out.println("Digite a nova data do produto:");
            String novaData = scanner.next();
            produtoParaEditar.setData(novaData);

            System.out.println("Produto editado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    static void deletarProduto() {
        System.out.println("Digite o ID do produto que deseja deletar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado

        Produto produtoParaDeletar = null;

        // Procurar o produto na lista
        for (Produto produto : listaProdutos) {
            if (produto.getId() == id) {
                produtoParaDeletar = produto;
                break;
            }
        }

        if (produtoParaDeletar != null) {
            listaProdutos.remove(produtoParaDeletar);
            System.out.println("Produto deletado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    static void visualizarProdutos() {
        System.out.println("Lista de Produtos:");

        for (Produto produto : listaProdutos) {
            System.out.println("--------------------");
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Valor: " + produto.getValor() + " R$");
            System.out.println("Data: " + produto.getData());
            System.out.println("--------------------");
            System.out.println("--------------------");
            System.out.println("--------------------");
            System.out.println("--------------------");
        }
    }
}
