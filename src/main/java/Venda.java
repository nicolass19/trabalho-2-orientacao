public class Venda extends Transacao {

    private Cliente cliente;

    public Venda(String dataVenda, Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda, produto, qtdeVendida);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não informado.");
        } else {
            this.cliente = cliente;
        }
    }

    public boolean vender(Produto produto, int qtdeVendida) {
        if (produto.verificarEstoqueInsuficiente(qtdeVendida) == true) {
            return false;
        } else {
            produto.debitarEstoque(qtdeVendida);
            System.out.println(produto.calcularValorVenda(qtdeVendida));
            if (produto.verificarEstoqueBaixo());
            return true;
        }
    }
}