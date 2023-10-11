import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após o número.

            if (escolha == 1) {
                Livro livro = new Livro();
                Livro.CadastrarLivro(livro);


            } else if (escolha == 2) {
                Livro.ListarLivros();

            } else if (escolha == 3) {
                System.out.println("Encerrando o programa.");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
