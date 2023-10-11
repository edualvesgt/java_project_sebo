import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Livro {
    public String Titulo;
    public float Preco;

    public Date DataLancamento;

    public static List<Livro> listaLivros = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    Autor Autor = new Autor();

    public static void CadastrarLivro(Livro livro) {
        System.out.print("Título do Livro: ");
        livro.Titulo = scanner.nextLine();

        System.out.print("Autor do Livro: ");
        livro.Autor.Nome = scanner.nextLine();

        System.out.print("Local de Nascimento do Autor: ");
        livro.Autor.LocalNascimento = scanner.nextLine();

        System.out.print("Preço do Livro: ");
        livro.Preco = scanner.nextFloat();
        scanner.nextLine(); // Consumir a quebra de linha.

        System.out.print("Data de Lançamento (dd-MM-yyyy): ");
        String dataString = scanner.nextLine();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            livro.DataLancamento = dateFormat.parse(dataString);

            int Lancamento = VerificarTempo(livro.DataLancamento);

            if (Lancamento > 5) {
                listaLivros.add(livro);
                System.out.println("Livro cadastrado com sucesso.");
            } else {
                System.out.println("O livro não pode ser cadastrado, pois tem 5 anos ou menos de lançamento.");
            }
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. O livro não foi cadastrado.");
        }
    }

    public static List<Livro> ListarLivros() {
        System.out.println("Livros Cadastrados:");
        for (Livro livro : listaLivros) {
            System.out.println("Título: " + livro.Titulo);
            System.out.println("Autor: " + livro.Autor.Nome);
            System.out.println("Nascimento: " + livro.Autor.LocalNascimento);
            System.out.println("Preço: R$" + livro.Preco);
            System.out.println();
        }
        return listaLivros;
    }

    public static int VerificarTempo(Date dataLancamento) {
        //Essa linha converte o objeto Date (dataLancamento) em um objeto LocalDate
        LocalDate dataLancamentoLocalDate = dataLancamento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dataAtual = LocalDate.now();

        int anosDiferenca = dataAtual.getYear() - dataLancamentoLocalDate.getYear();

        return anosDiferenca;

    }
}
