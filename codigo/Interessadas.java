import java.util.ArrayList;

public class Interessadas {

    public static ArrayList<Interessada> listaDeInteressadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaDeInteressadasRestantes = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoFinal = new ArrayList<Interessada>();
    public static ArrayList<Interessada> listaResultadoProvisorio = new ArrayList<Interessada>();


    public static void adicionarInteressada(Interessada interessada) {
        listaDeInteressadas.add(interessada);
    }

    public static void removerInteressada(Interessada interessada) {
        listaDeInteressadas.remove(interessada);
    }

    public static ArrayList<Interessada> criarInteressadasRestantes(ArrayList<Interessada> lista){
        listaDeInteressadasRestantes=new ArrayList<>(lista);
        return listaDeInteressadasRestantes;
    }

    public static ArrayList<Interessada> criarInteressadas(ArrayList<Interessada> lista){
        listaDeInteressadas=new ArrayList<>(lista);
        return listaDeInteressadas;
    }

    public static void mostrarInteressadas() {
            System.out.println("Interessadas:");
        for (int i = 0; i < listaDeInteressadas.size(); i++) {

            System.out.println(" - Nome: " + listaDeInteressadas.get(i).getNome() + " Quantidade por Lote: "
                    + listaDeInteressadas.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + listaDeInteressadas.get(i).getValorPorLote());
        }
    }

    public static ArrayList<Interessada> retornaInteressadas() {
        return listaDeInteressadas;
    }

    public static ArrayList<Interessada> retornaInteressadasRestantes() {
        return listaDeInteressadasRestantes;
    }
}

