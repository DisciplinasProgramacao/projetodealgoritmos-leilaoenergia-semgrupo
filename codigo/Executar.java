import java.util.ArrayList;

public class Executar {
    public static void main(String[] args) {
        int quantidadeDeEnergia = Menu.quantidadeDeEnergia();
        Menu.ListaDeInteressadas();
        Interessadas.mostrarInteressadas();
        ArrayList<Interessada> ListaDeInteressadas = Interessadas.retornaInteressadas();
        Backtracking.backtrack(ListaDeInteressadas, quantidadeDeEnergia);
    }
}
