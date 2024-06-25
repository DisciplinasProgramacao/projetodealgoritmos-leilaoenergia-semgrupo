import java.util.ArrayList;

class Backtracking {
    final static double NANO_TO_MS = 1_000_000d; // para converter de nano a milissegundos
    final static double MS_TO_SEC = 1_000d;
    public static long ini;

    static int quantidadeProvisoria = 0;
    static int valorProvisorio = 0;
    static int quantidadeFinal = 0;
    static int valorFinal = 0;
    static int i = 0;
    static int k = 0;

    static int quantidadeDeEnergia;
    public static ArrayList<Interessada> listaDeInteressadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasRestantes = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasRestantes2 = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoProvisorio = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoFinal = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasNaoUsadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasExcluidas = new ArrayList<Interessada>();

    public static void backtrack(ArrayList<Interessada> novalistaDeInteressadas, int novaQuantidadeDeEnergia) {
        quantidadeDeEnergia = novaQuantidadeDeEnergia;
        Interessadas.criarInteressadasRestantes(novalistaDeInteressadas);
        listaDeInteressadasRestantes = Interessadas.retornaInteressadasRestantes();
        listaDeInteressadasRestantes2 = new ArrayList<>();
        listaDeInteressadasExcluidas = new ArrayList<>();
        listaDeInteressadas = new ArrayList<>(novalistaDeInteressadas);
        i = 0;

        ini = System.nanoTime(); // início da marcação de tempo

        tenta(listaDeInteressadasRestantes.get(0));

    }

    public static void tenta(Interessada interessada) {
        if (solucaoAceitavel(interessada)) {
            registraInteressada(interessada);
            listaDeInteressadasRestantes.remove(interessada); // remove interessadas registradas da lista

        } else {
            listaDeInteressadasRestantes2.add(interessada);
            listaDeInteressadasRestantes.remove(interessada);

        }

        if (listaDeInteressadasRestantes.size() > 0) { // se ainda tiverem interessadas elas são analisadas
            tenta(listaDeInteressadasRestantes.get(0));
        } else {
            if (listaResultadoProvisorio.size() > 0) {
                solucaoProvisoria(); // grava a solução caso tenham sido analisadas todas as interessadas
                
                if (listaDeInteressadasRestantes2.size() > 0) { // exclui último valor da lista de Resultado provisório
                                                                // e
                                                                // tenta valores não utilizados
                    listaDeInteressadasRestantes = new ArrayList<>(listaDeInteressadasRestantes2);
                    listaDeInteressadasRestantes2 = new ArrayList<>();
                    k++;
                    if (listaDeInteressadasRestantes.size() - k > 0) {

                        for (int j = k; j > 0; j--) {
                            valorProvisorio = valorProvisorio
                                    - listaResultadoProvisorio.get((listaResultadoProvisorio.size() - j))
                                            .getValorPorLote();
                            quantidadeProvisoria = quantidadeProvisoria
                                    - listaResultadoProvisorio.get((listaResultadoProvisorio.size() - j))
                                            .getQuantidadePorLote();

                            // listaDeInteressadasExcluidas.add(0,

                            if (listaDeInteressadasRestantes.size() > 0)
                                tenta(listaDeInteressadasRestantes.get(0));
                        }
                    }
                } else {
                    retornaSolucao();

                    long fim = System.nanoTime(); // fim da marcação de tempo
                    double tempoMs = (fim - ini) / NANO_TO_MS; // conversões e, em seguida, impressão do resultado
                    double tempoSeg = tempoMs / MS_TO_SEC;

                    System.out.println("Finalizado em " + String.format("%.2f", tempoMs) + " ms ("
                            + String.format("%.4f", tempoSeg) + " segundos).");

                    return;
                }
            }
        }

    }

    // Métodos auxiliares
    private static boolean solucaoAceitavel(Interessada interessada) {
        if (interessada.getQuantidadePorLote() + quantidadeProvisoria <= quantidadeDeEnergia)
            return true;
        else
            return false;
    }

    private static void registraInteressada(Interessada interessada) {
        listaResultadoProvisorio.add(interessada);
        quantidadeProvisoria += interessada.getQuantidadePorLote();
        valorProvisorio += interessada.getValorPorLote();

        System.out.println("Lista Provisória:");
        for (int i = 0; i < listaResultadoProvisorio.size(); i++) {

            System.out.println(" - Nome: " + listaResultadoProvisorio.get(i).getNome() + " Quantidade por Lote: "
                    + listaResultadoProvisorio.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + listaResultadoProvisorio.get(i).getValorPorLote());
        }

        System.out.print("Quantidade de Energia Restante: ");
        System.out.println(quantidadeDeEnergia - quantidadeProvisoria);
        System.out.print("Valor até o momento: ");
        System.out.println(valorProvisorio);

    }

    private static void solucaoProvisoria() {
        if (valorFinal < valorProvisorio) {
            valorFinal = valorProvisorio;
            quantidadeFinal = quantidadeProvisoria;
            listaResultadoFinal = new ArrayList<>(listaResultadoProvisorio);
            // listaResultadoProvisorio = new ArrayList<>();
            System.out.println("Lista Provisória:");
            for (int i = 0; i < listaResultadoFinal.size(); i++) {

                System.out.println(" - Nome: " + listaResultadoFinal.get(i).getNome() + " Quantidade por Lote: "
                        + listaResultadoFinal.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                        + listaResultadoFinal.get(i).getValorPorLote());
            }
            System.out.println("Solução ");
            System.out.println("Valor obtido: R$ " + valorFinal + " - Quantidade de energia vendido: " + quantidadeFinal);
        }
    }

    private static void retornaSolucao() {
        if (valorFinal < valorProvisorio) {
            valorFinal = valorProvisorio;
            quantidadeFinal = quantidadeProvisoria;
            listaResultadoFinal = new ArrayList<>(listaResultadoProvisorio);
        }
        System.out.println("Atingida a Solução ");

        for (int i = 0; i < listaResultadoFinal.size(); i++) {

            System.out.println(" - Nome: " + listaResultadoFinal.get(i).getNome() + " Quantidade por Lote: "
                    + listaResultadoFinal.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + listaResultadoFinal.get(i).getValorPorLote());
        }
        System.out.println("Atingida a Solução ");
        System.out.println("Valor obtido: R$ " + valorFinal + " - Quantidade de energia vendido: " + quantidadeFinal);
    }

}
