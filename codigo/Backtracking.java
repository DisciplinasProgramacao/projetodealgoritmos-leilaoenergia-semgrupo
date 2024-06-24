import java.util.ArrayList;

class Backtracking {
    static int quantidadeProvisoria = 0;
    static int valorProvisorio = 0;
    static int quantidadeFinal = 0;
    static int valorFinal = 0;
    static int i = 0;
    static int quantidadeDeEnergia;
    public static ArrayList<Interessada> listaDeInteressadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasRestantes = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoProvisorio = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoFinal = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasNaoUsadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasExcluidas = new ArrayList<Interessada>();

    public static void backtrack(ArrayList<Interessada> novalistaDeInteressadas, int novaQuantidadeDeEnergia) {
        quantidadeDeEnergia = novaQuantidadeDeEnergia;
        Interessadas.criarInteressadasRestantes(novalistaDeInteressadas);
        listaDeInteressadasRestantes = Interessadas.retornaInteressadasRestantes();
        listaDeInteressadas = new ArrayList<>(novalistaDeInteressadas);
        i = 0;
        tenta(listaDeInteressadasRestantes.get(0));

    }

    public static void tenta(Interessada interessada) {
        if (solucaoAceitavel(interessada)) {
            registraInteressada(interessada);
            listaDeInteressadasRestantes.remove(interessada);

            if (solucaoDefinitiva()) {
                retornaSolucao();
                return;
            }
        } else {
            i++;
            listaDeInteressadasNaoUsadas.add(interessada);
        }

        if (i < listaDeInteressadasRestantes.size()) {
            tenta(listaDeInteressadasRestantes.get(i));
        } else {
            solucaoProvisoria();
            if (listaDeInteressadas.size() > 1) {
                if (listaDeInteressadasNaoUsadas.size() == 0) {
                    retornaSolucao();
                    return;
                } else {
                    valorProvisorio = valorProvisorio- listaResultadoProvisorio.get((listaResultadoProvisorio.size() - 1)).getValorPorLote();
                    quantidadeProvisoria = quantidadeProvisoria - listaResultadoProvisorio.get((listaResultadoProvisorio.size() - 1)).getQuantidadePorLote();
                   // listaDeInteressadasExcluidas.add(listaResultadoProvisorio.get((listaResultadoProvisorio.size() - 1)));
                    listaResultadoProvisorio.remove(listaResultadoProvisorio.size() - 1);
                    listaDeInteressadasNaoUsadas = new ArrayList<Interessada>();
                    i = 0;
                    tenta(listaDeInteressadasRestantes.get(i));
                }

                // listaDeInteressadas.remove(0);
                // backtrack(listaDeInteressadas, quantidadeDeEnergia);
            } else {
                System.out.println("Atingida a Solução ");
                System.out.println(
                        "Valor obtido: R$ " + valorFinal + " Quantidade de energia vendida: " + quantidadeFinal);
                return;
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

    private static boolean solucaoDefinitiva() {
        if (quantidadeProvisoria == quantidadeDeEnergia)
            return true;
        else
            return false;
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
