import java.util.Scanner;

public class Menu {

    
    public static int quantidadeDeEnergia() {
        try (Scanner ler = new Scanner(System.in)) {
            System.out.println("Informe a quantidade de energia:");
            int quantidadeDeEnergia = ler.nextInt();
            return quantidadeDeEnergia;
        }
    }

    public static void ListaDeInteressadas(){
            String nomeDaInteressada = "I1";
            int quantidadePorLote = 500;
            int valorPorLote = 500;
            float valorPorMega = valorPorLote - quantidadePorLote;
            Interessada interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote, valorPorLote, valorPorMega);
            Interessadas.adicionarInteressada(interessada);
            
            nomeDaInteressada = "I2";
            quantidadePorLote = 500;
            valorPorLote = 510;
            valorPorMega = valorPorLote - quantidadePorLote;
            interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote, valorPorLote, valorPorMega);
            Interessadas.adicionarInteressada(interessada);

            nomeDaInteressada = "I3";
            quantidadePorLote = 400;
            valorPorLote = 520;
            valorPorMega = valorPorLote - quantidadePorLote;
            interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote, valorPorLote, valorPorMega);
            Interessadas.adicionarInteressada(interessada);
            
            nomeDaInteressada = "I4";
            quantidadePorLote = 300;
            valorPorLote = 400;
            valorPorMega = valorPorLote - quantidadePorLote;
            interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote, valorPorLote, valorPorMega);
            Interessadas.adicionarInteressada(interessada);

            nomeDaInteressada = "I5";
            quantidadePorLote = 200;
            valorPorLote = 220;
            valorPorMega = valorPorLote - quantidadePorLote;
            interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote, valorPorLote, valorPorMega);
            Interessadas.adicionarInteressada(interessada);
            
            nomeDaInteressada = "I6";
            quantidadePorLote = 900;
            valorPorLote = 1110;
            valorPorMega = valorPorLote - quantidadePorLote;
            interessada = Interessada.CriarInteressada(nomeDaInteressada, quantidadePorLote, valorPorLote, valorPorMega);
            Interessadas.adicionarInteressada(interessada);

            
        }

    /*
     * Scanner ler = new Scanner(System.in);
     * System.out.println("Informe a quantidade de interessadas:");
     * int quantidadeDeInteressadas = ler.nextInt();
     * for (int i = 0; i < quantidadeDeInteressadas; i++) {
     * int n=i+1;
     * System.out.println("Informe o nome da interessada número "+ n + ":");
     * String nomeDaInteressada = ler.next();
     * System.out.
     * println("Informe a quantidade de energia por lote da interessada número "+ n
     * + ":");
     * int quantidadePorLote = ler.nextInt();
     * System.out.println("Informe o valor por lote da interessada número "+ n +
     * ":");
     * int valorPorLote = ler.nextInt();
     * Interessada interessada = Interessada.CriarInteressada(nomeDaInteressada,
     * quantidadePorLote, valorPorLote);
     * Interessadas.adicionarInteressada(interessada);
     * }
     */
}
