import java.util.ArrayList;

public class Executar {
    public static void main(String[] args) {
        int quantidadeDeEnergia = Menu.quantidadeDeEnergia();
        Menu.listaDeInteressadas();
        System.out.println("Quantidade de Energia: "+ quantidadeDeEnergia);
        ArrayList<Interessada> listaDeInteressadas = Interessadas.retornaInteressadas();
        Interessadas.mostrarInteressadas();
        Backtracking.backtrack(listaDeInteressadas, quantidadeDeEnergia);
    }
}
