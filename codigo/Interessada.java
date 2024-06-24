public class Interessada {
    private String nome;
    private int quantidadePorLote;
    private int valorPorLote;
    private float valorPorMega;
    static Interessada interessada;

    public Interessada(String nome, int quantidadePorLote, int valorPorLote, float valorPorMega) {
        setNome(nome);
        setQuantidadePorLote(quantidadePorLote);
        setValorPorLote(valorPorLote);
        setValorPorMega(valorPorMega);
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setQuantidadePorLote(int quantidadePorLote) {
        this.quantidadePorLote = quantidadePorLote;
    }

    private void setValorPorLote(int valorPorLote) {
        this.valorPorLote = valorPorLote;
    }

    private void setValorPorMega(float valorPorMega) {
        this.valorPorMega = valorPorMega;
    }

    public static Interessada CriarInteressada(String nome, int quantidadePorLote, int valorPorLote, float valorPorMega) {
        interessada = new Interessada(nome, quantidadePorLote, valorPorLote, valorPorMega);
        return interessada;
    }
    

    public String getNome() {
        return this.nome;
    }

    public int getQuantidadePorLote() {
        return this.quantidadePorLote;
    }

    public int getValorPorLote() {
        return this.valorPorLote;
    }

    public float getValorPorMega() {
        return this.valorPorMega;
    }
}
