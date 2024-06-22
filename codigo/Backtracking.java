import java.util.ArrayList;

class Backtracking {
    static int valorProvisorio = 0;
    static int valorFinal = 0;
    static int i = 0;
    static int quantidadeDeEnergia;
    public static ArrayList<Interessada> listaDeInteressadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasRestantes = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoProvisorio = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoFinal = new ArrayList<Interessada>();

    public static void backtrack(ArrayList<Interessada> NovalistaDeInteressadas, int novaQuantidadeDeEnergia) {
        quantidadeDeEnergia = novaQuantidadeDeEnergia;
        Interessadas.criarInteressadasRestantes(NovalistaDeInteressadas);
        listaDeInteressadasRestantes = Interessadas.retornaInteressadasRestantes();
        listaDeInteressadas=new ArrayList<>(NovalistaDeInteressadas);
        i=0;     
        tenta(listaDeInteressadasRestantes.get(0));

    }

    public static void tenta(Interessada interessada) {
            if (solucaoAceitavel(interessada)) {
            registraInteressada(interessada);
            System.out.println("Interessada Registrada");

            if (solucaoDefinitiva()) {
                retornaSolucao();
                return;
            }
            System.out.println("I antes " + i);

            i++;

            System.out.println("I depois " + i);
            System.out.println("Tamanho lista " + listaDeInteressadasRestantes.size());

    
            if (i < listaDeInteressadasRestantes.size()) {
                tenta(listaDeInteressadasRestantes.get(i));
            }
            else {
                solucaoProvisoria();
                listaDeInteressadas.remove(0);
                backtrack(listaDeInteressadas, quantidadeDeEnergia);
            }
            
        }
        /*else {
            solucaoProvisoria();
            listaDeInteressadasRestantes.remove(listaDeInteressadasRestantes.get(i));
            tenta(listaDeInteressadas.get(i));
        }*/
    }
    
    // Métodos auxiliares
    private static boolean solucaoAceitavel(Interessada interessada) {
        if (interessada.getValorPorLote() + valorProvisorio <= quantidadeDeEnergia)
            return true;
        else
            return false;
    }

    private static void registraInteressada(Interessada interessada) {
        listaResultadoProvisorio.add(interessada);
        valorProvisorio += interessada.getValorPorLote();

        System.out.println("listaResultadoProvisorio:");
        for (int i = 0; i < listaResultadoProvisorio.size(); i++) {

            System.out.println(" - Nome: " + listaResultadoProvisorio.get(i).getNome() + " Quantidade por Lote: "
                    + listaResultadoProvisorio.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + listaResultadoProvisorio.get(i).getValorPorLote());
        }

        System.out.print("Valor Restante: " );
        System.out.println(quantidadeDeEnergia - valorProvisorio);

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
            listaResultadoFinal = new ArrayList<>(listaResultadoProvisorio);
        }
    }

    private static void retornaSolucao() {
        valorFinal = valorProvisorio;
        listaResultadoFinal = new ArrayList<>(listaResultadoProvisorio);
        valorFinal = valorProvisorio;
        Interessadas.mostrarResultadoFinal();
        System.out.println("Atingida a Solução ");
        System.out.println("Valor obtido: " + valorFinal);
    }

}
    
