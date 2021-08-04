public class Transacao {

    private String dataTransacao;
    private int qtde;
    private Produto produto;

    public Transacao(String dataTransacao, Produto produto, int qtde) {

        if (dataTransacao == null) {
            throw new IllegalArgumentException("Data da transação não informado.");
        } else {
            this.dataTransacao = dataTransacao;
        }

        if (produto == null) {
            throw new IllegalArgumentException("Produto não informado.");
        } else {
            this.produto = produto;
        }

        if (qtde <= 0) {
            throw new IllegalArgumentException("Quantidade menor ou igual a zero.");
        } else {
            this.qtde = qtde;
        }
    }

    public String getDataTransacao() {
        return this.dataTransacao;
    }

    public int getQtde() {
        return this.qtde;
    }

    public Produto getProduto() {
        return this.produto;
    }
}