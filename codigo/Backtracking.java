import java.util.ArrayList;

class Backtracking {
    static int valorProvisorio = 0;
    static int valorFinal = 0;
    static int i = 0;
    static int quantidadeDeEnergia;
    static ArrayList<Interessada> ListaDeInteressadas = new ArrayList<Interessada>();
    static ArrayList<Interessada> ListaDeInteressadasRestantes = new ArrayList<Interessada>();
    static ArrayList<Interessada> ListaResultadoProvisorio = new ArrayList<Interessada>();
    static ArrayList<Interessada> ListaResultadoFinal = new ArrayList<Interessada>();

    public static void backtrack(ArrayList<Interessada> ListaDeInteressadas, int novaQuantidadeDeEnergia) {
        quantidadeDeEnergia = novaQuantidadeDeEnergia;
        i = ListaDeInteressadasRestantes.size();
        ListaDeInteressadasRestantes = ListaDeInteressadas;
        Interessadas.mostrarInteressadasRestantes();
        tenta(ListaDeInteressadasRestantes.get(i));
    }

    public static void tenta(Interessada interessada) {

        if (solucaoAceitavel(interessada)) {
            registraInteressada(interessada);

            if (solucaoDefinitiva()) {
                retornaSolucao();
                return;
            }

            i++;
            if (i < ListaDeInteressadasRestantes.size()) {
                tenta(ListaDeInteressadasRestantes.get(i));
            } else {
                solucaoProvisoria();
                ListaDeInteressadas.remove(0);
                backtrack(ListaDeInteressadas, quantidadeDeEnergia);
            }
        } else {
            solucaoProvisoria();
            ListaDeInteressadasRestantes.remove(ListaDeInteressadasRestantes.get(i));
            tenta(ListaDeInteressadas.get(i));
        }
    }

    // Métodos auxiliares
    private static boolean solucaoAceitavel(Interessada interessada) {
        if (interessada.getValorPorLote() + valorProvisorio <= quantidadeDeEnergia)
            return true;
        else
            return false;
    }

    private static void registraInteressada(Interessada interessada) {
        ListaResultadoProvisorio.add(interessada);
        valorProvisorio += interessada.getValorPorLote();
    }

    private static boolean solucaoDefinitiva() {
        if (valorProvisorio == quantidadeDeEnergia)
            return true;
        else
            return false;
    }

    private static void solucaoProvisoria() {
        if (valorFinal < valorProvisorio) {
            valorFinal = valorProvisorio;
            ArrayList<Interessada> listaResultadoFinal = ListaResultadoProvisorio;
        }
    }

    private static void retornaSolucao() {
        valorFinal = valorProvisorio;
        ArrayList<Interessada> listaResultadoFinal = ListaResultadoProvisorio;
        valorFinal = valorProvisorio;
        Interessadas.mostrarResultadoFinal();
        System.out.println("Valor obtido: " + valorFinal);
    }

}
