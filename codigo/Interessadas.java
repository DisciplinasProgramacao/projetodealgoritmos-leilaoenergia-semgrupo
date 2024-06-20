import java.util.ArrayList;

public class Interessadas {

    public static ArrayList<Interessada> ListaDeInteressadas = new ArrayList<Interessada>();

    public static void adicionarInteressada(Interessada interessada) {
        ListaDeInteressadas.add(interessada);
    }

    public static void mostrarInteressadas() {
        System.out.println("Interessadas:");
        for (int i = 0; i < ListaDeInteressadas.size(); i++) {

            System.out.println(" - Nome: " + ListaDeInteressadas.get(i).getNome() + " Quantidade por Lote: "
                    + ListaDeInteressadas.get(i).getQuantidadePorLote() + " - Valor por Lote: "
                    + ListaDeInteressadas.get(i).getValorPorLote());
        }
    }







  /* { for (int i = 0; i < conjuntoDeTeste.size(); i++) {
        int[] rotas = conjuntoDeTeste.get(i);
        mergeSort(rotas, 0, rotas.length - 1);
        conjuntoDeTesteOrdenado.add(rotas);
    }
    System.out.println("Conjuntos de rotas ordenadas:");
    mostrarRotas(conjuntoDeTesteOrdenado);
    return conjuntoDeTesteOrdenado;
   }

   */

public static void mergeSort(int[] array, int inicio, int fim) {
    if (inicio < fim) {
        int meio = (inicio + fim) / 2;

        mergeSort(array, inicio, meio);
        mergeSort(array, meio + 1, fim);

        merge(array, inicio, meio, fim);
    }
}

public static void merge(int[] array, int inicio, int meio, int fim) {
    int n1 = meio - inicio + 1;
    int n2 = fim - meio;

    int[] arrayEsquerda = new int[n1];
    int[] arrayDireita = new int[n2];

    for (int i = 0; i < n1; ++i) {
        arrayEsquerda[i] = array[inicio + i];
    }
    for (int j = 0; j < n2; ++j) {
        arrayDireita[j] = array[meio + 1 + j];
    }

    int i = 0, j = 0;

    int k = inicio;
    while (i < n1 && j < n2) {
        if (arrayEsquerda[i] <= arrayDireita[j]) {
            array[k] = arrayEsquerda[i];
            i++;
        } else {
            array[k] = arrayDireita[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        array[k] = arrayEsquerda[i];
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = arrayDireita[j];
        j++;
        k++;
    }
}
}

