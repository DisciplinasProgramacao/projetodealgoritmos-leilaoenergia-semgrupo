import java.util.ArrayList;

public class Executar {
    public static void main(String[] args) {
        int quantidadeDeEnergia = 8000;
        ProcessarEntrada.tratarDadosEntrada();
        //Menu.listaDeInteressadas();
        System.out.println("Quantidade de Energia: "+ quantidadeDeEnergia);
        ArrayList<Interessada> listaDeInteressadas = Interessadas.retornaInteressadas();
        Interessadas.mostrarInteressadas();
        Backtracking.backtrack(listaDeInteressadas, quantidadeDeEnergia);
    }
}
