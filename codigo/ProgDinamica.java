import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empresa {
    String nome;
    int megawatts;
    int valor;

    public Empresa(String nome, int megawatts, int valor) {
        this.nome = nome;
        this.megawatts = megawatts;
        this.valor = valor;
    }
}

public class VendaEnergia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Empresa> empresas = new ArrayList<>();
        int capacidade = 8000;

        System.out.println("Digite a lista de empresas interessadas (formato: E16;240;1234) e uma linha vazia para terminar:");
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) break;

            String[] partes = input.split(";");
            if (partes.length != 3) {
                System.out.println("Entrada inválida. Use o formato E16;240;1234");
                continue;
            }

            try {
                String nome = partes[0];
                int megawatts = Integer.parseInt(partes[1]);
                int valor = Integer.parseInt(partes[2]);

                empresas.add(new Empresa(nome, megawatts, valor));
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter números. Verifique a entrada e tente novamente.");
            }
        }

        if (empresas.isEmpty()) {
            System.out.println("Nenhuma empresa interessada foi inserida.");
            return;
        }

        int n = empresas.size();
        int[] dp = new int[capacidade + 1];
        boolean[][] taken = new boolean[n][capacidade + 1];

        for (int i = 0; i < n; i++) {
            Empresa empresa = empresas.get(i);
            for (int j = capacidade; j >= empresa.megawatts; j--) {
                if (dp[j] < dp[j - empresa.megawatts] + empresa.valor) {
                    dp[j] = dp[j - empresa.megawatts] + empresa.valor;
                    taken[i][j] = true;
                }
            }
        }

        List<Empresa> selecionadas = new ArrayList<>();
        int remCapacity = capacidade;
        for (int i = n - 1; i >= 0; i--) {
            if (taken[i][remCapacity]) {
                selecionadas.add(empresas.get(i));
                remCapacity -= empresas.get(i).megawatts;
            }
        }

        System.out.println("O valor máximo que pode ser obtido é: " + dp[capacidade]);
        System.out.println("Empresas selecionadas:");
        for (Empresa empresa : selecionadas) {
            System.out.println("Empresa: " + empresa.nome + ", Megawatts: " + empresa.megawatts + ", Valor: " + empresa.valor);
        }
    }
}
