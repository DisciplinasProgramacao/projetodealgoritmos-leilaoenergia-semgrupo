import java.util.Scanner;

public class ProcessarEntrada {

    public static void tratarDadosEntrada() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cole os dados de entrada abaixo (pressione Enter duas vezes para finalizar):");
        StringBuilder inputBuilder = new StringBuilder();
        String line;

        // Lendo os dados de entrada até que uma linha em branco seja inserida
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            inputBuilder.append(line).append("\n");
        }

        String dadosEntrada = inputBuilder.toString();

        // Verificar se o método processarDados existe e está acessível
        processarDados(dadosEntrada);

        scanner.close();
    }

    public static void processarDados(String dados) {
        // Dividir os dados por linhas
        String[] linhas = dados.split("\n");

        // Processar cada linha
        for (String linha : linhas) {
            // Dividir cada linha pelos ponto e vírgula
            String[] partes = linha.split(";");

            // Verificar se a linha tem os três componentes esperados
            if (partes.length == 3) {
                try {
                    String nomeDaInteressada = partes[0];
                    int quantidadePorLote = Integer.parseInt(partes[1]);
                    int valorPorLote = Integer.parseInt(partes[2]);

                    // Reavalie a fórmula para calcular valorPorMega
                    float valorPorMega = calcularValorPorMega(quantidadePorLote, valorPorLote);

                    // Criar objeto Interessada e adicionar à lista
                    Interessada interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote,
                            valorPorLote, valorPorMega);
                    Interessadas.adicionarInteressada(interessada);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter número na linha: " + linha);
                }
            } else {
                System.err.println("Formato inválido para a linha: " + linha);
            }
        }
    }

    // Método para calcular valorPorMega
    public static float calcularValorPorMega(int quantidadePorLote, int valorPorLote) {
        return valorPorLote / (float) quantidadePorLote;
    }

}
