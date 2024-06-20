import java.util.ArrayList;
import java.util.List;

class Backtracking {
    public void tenta(ArrayList<Interessada> ListaDeInteressadas) {
        boolean movimentoBemSucedido;
        ArrayList<Interessada> interessadasRestantes;

        do {
            if (solucaoAceitavel(interessada)) {
                registraInteressada(interessada);

                if (!solucaoDefinitiva(interessada)) {
                    interessadasRestantes = gerarInteressadasRestantes(interessada);

                    for (Interessada interessadaRestante : interessadasRestantes) {
                        tenta(interessadaRestante);

                        if (!encontrouSolucao()) {
                            apagaRegistroAnterior(interessadaRestante);
                        }
                    }
                } else {
                    retornaSolucao(interessada);
                    return;
                }
            }
            movimentoBemSucedido = definirMovimentoSucedido(); 
        } while (!movimentoBemSucedido && existemInteressadas());
    }

 
    private boolean solucaoAceitavel(Interessada interessada) {
        if (interessada.getValorPorLote() + valorAtual <= quantidadeDeEnergia)  )
        return false;
    }

    private void registraInteressada(Interessada interessada) {
    }

    private boolean solucaoDefinitiva(Interessada interessada) {
        return false; // Placeholder
    }

    private List<Interessada> gerarInteressadasRestantes(Interessada interessada) {
        return new ArrayList<>(); // Placeholder
    }

    private boolean encontrouSolucao() {
        return false; // Placeholder
    }

    private void apagaRegistroAnterior(Interessada interessada) {
    }

    private void retornaSolucao(Interessada interessada) {
    }

    private boolean definirMovimentoSucedido() {
        return false; // Placeholder
    }

    private boolean existemInteressadas() {
        return false; // Placeholder
    }
}

/*
 * public class Backtracking{
 * void backtrack(Interessada interessada) {
 * int valorPorLote = interessada.getValorPorLote();
 * 
 * if (promissor(valorPorLote)) {
 * if (existe_solucao(valorPorLote)) {
 * armazena_solucao(valorPorLote);
 * } else {
 * for (Interessada filho : v.getFilhos()) {
 * backtrack(filho);
 * }
 * }
 * }
 * }
 * }
 */
