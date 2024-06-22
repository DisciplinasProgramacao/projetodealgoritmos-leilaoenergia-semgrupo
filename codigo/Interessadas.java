import java.util.ArrayList;

public class Interessadas {

    public static ArrayList<Interessada> ListaDeInteressadas = new ArrayList<Interessada>();
    public static ArrayList<Interessada> ListaDeInteressadasRestantes = new ArrayList<Interessada>();
    public static ArrayList<Interessada> ListaResultadoFinal = new ArrayList<Interessada>();
    public static ArrayList<Interessada> ListaResultadoProvisorio = new ArrayList<Interessada>();


    public static void adicionarInteressada(Interessada interessada) {
        ListaDeInteressadas.add(interessada);
    }

    public static void removerInteressada(Interessada interessada) {
        ListaDeInteressadas.remove(interessada);
    }

    public static void mostrarInteressadas() {
        System.out.println("Interessadas:");
        for (int i = 0; i < ListaDeInteressadas.size(); i++) {

            System.out.println(" - Nome: " + ListaDeInteressadas.get(i).getNome() + " Quantidade por Lote: "
                    + ListaDeInteressadas.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + ListaDeInteressadas.get(i).getValorPorLote());
        }
    }

    public static void mostrarInteressadasRestantes() {
        System.out.println("Interessadas Restantes:");
        for (int i = 0; i < ListaDeInteressadasRestantes.size(); i++) {

            System.out.println(" - Nome: " + ListaDeInteressadasRestantes.get(i).getNome() + " Quantidade por Lote: "
                    + ListaDeInteressadasRestantes.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + ListaDeInteressadasRestantes.get(i).getValorPorLote());
        }
    }

    public static void mostrarResultadoFinal() {

        System.out.println("Interessadas Restantes:");
        for (int i = 0; i < ListaResultadoFinal.size(); i++) {

            System.out.println(" - Nome: " + ListaResultadoFinal.get(i).getNome() + " Quantidade por Lote: "
                    + ListaResultadoFinal.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + ListaResultadoFinal.get(i).getValorPorLote());
        }
    }



    public static ArrayList<Interessada> retornaInteressadas() {
        return ListaDeInteressadas;
    }
}

