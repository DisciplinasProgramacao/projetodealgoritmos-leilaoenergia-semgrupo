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
            // Aqui você deve definir a lógica para o movimentoBemSucedido
            movimentoBemSucedido = definirMovimentoSucedido(); // Implementação necessária
        } while (!movimentoBemSucedido && existemInteressadas());
    }

    // Métodos auxiliares (você precisa implementar esses métodos de acordo com a
    // lógica específica)
    private boolean solucaoAceitavel(Interessada interessada) {
        if (interessada.getValorPorLote() + valorAtual <= quantidadeDeEnergia)  )
        return false;
    }

    private void registraInteressada(Interessada interessada) {
        // Implementação do registro do interessada
    }

    private boolean solucaoDefinitiva(Interessada interessada) {
        // Implementação da verificação se a solução é definitiva
        return false; // Placeholder
    }

    private List<Interessada> gerarInteressadasRestantes(Interessada interessada) {
        // Implementação da geração dos interessadas restantes
        return new ArrayList<>(); // Placeholder
    }

    private boolean encontrouSolucao() {
        // Implementação para verificar se encontrou a solução
        return false; // Placeholder
    }

    private void apagaRegistroAnterior(Interessada interessada) {
        // Implementação para apagar o registro anterior
    }

    private void retornaSolucao(Interessada interessada) {
        // Implementação para retornar a solução encontrada
    }

    private boolean definirMovimentoSucedido() {
        // Implementação da lógica para definir se o movimento foi sucedido
        return false; // Placeholder
    }

    private boolean existemInteressadas() {
        // Implementação da verificação se ainda existem interessadas
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