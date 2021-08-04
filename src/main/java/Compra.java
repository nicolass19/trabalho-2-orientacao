public class Compra extends Transacao {

    private float precoUnit;
    private Fornecedor fornecedor;

    public Compra(String dataCompra, Produto produto, Fornecedor fornecedor, int qtdeCompra, float precoUnit) {
        super(dataCompra, produto, qtdeCompra);

        if (precoUnit <= 0) {
            throw new IllegalArgumentException("Preço unitário menor ou igual a zero.");
        } else {
            this.precoUnit = precoUnit;
        }

        if (fornecedor == null) {
            throw new IllegalArgumentException("Fornecedor não informado.");
        } else {
            this.fornecedor = fornecedor;
        }
    }

    public boolean comprar(Produto produto, int qtdeCompra) {
        if (produto.verificarEstoqueExcedente(qtdeCompra)) {
            return false;
        } else {
            produto.creditarEstoque(qtdeCompra);
            return true;
        }
    }


}