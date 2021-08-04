import java.util.ArrayList;
import java.util.List;

// Dupla : Marcus Vinicius e Nícolas Moraes

public class Produto {
    private String nome;
    private int qtdeEstoque;
    private float precoUnit;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico;

    public Produto(String nome, int qtdeEstoque, float precoUnit, int estoqueMinimo, int estoqueMaximo) {
        if (nome != null)
            this.nome = nome;

        else if (nome == null)
            throw new IllegalArgumentException("Nome do produto não informado.");

        if (qtdeEstoque < 0)
            throw new IllegalArgumentException("Quantidade de estoque menor que zero.");

        else if (qtdeEstoque >= 0)
            this.qtdeEstoque = qtdeEstoque;

        if (precoUnit <= 0)
            throw new IllegalArgumentException("Preço unitário menor ou igual a zero.");

        else if (precoUnit > 0)
            this.precoUnit = precoUnit;

        if (estoqueMinimo < 0)
            throw new IllegalArgumentException("Estoque mínimo menor que zero.");
        else if (estoqueMinimo >= 0)
            this.estoqueMinimo = estoqueMinimo;

        if (estoqueMaximo <= estoqueMinimo)
            throw new IllegalArgumentException("Estoque máximo menor ou igual ao estoque mínimo.");

        else if (estoqueMaximo < 0)
            throw new IllegalArgumentException("Estoque menor que zero.");

        else if (estoqueMaximo > 0 && estoqueMaximo > estoqueMinimo)
            this.estoqueMaximo = estoqueMaximo;

        this.historico = new ArrayList<String>();
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public boolean debitarEstoque(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade menor que zero.");
        }
        if (quantidade > qtdeEstoque) {
            throw new IllegalArgumentException("Quantidade maior que o estoque.");
        }
        else
            this.qtdeEstoque -= quantidade;
        return true;
    }

    public boolean creditarEstoque(int quantidade) {
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade menor que zero.");

        else
            this.qtdeEstoque += quantidade;
        return true;
    }

    public boolean verificarEstoqueBaixo() {
        if (qtdeEstoque < estoqueMinimo) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarEstoqueInsuficiente(int quantidade) {
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade menor que zero.");

        else if (quantidade > qtdeEstoque)
            return true;

        else
            return false;
    }

    public boolean verificarEstoqueExcedente(int quantidade) {
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade menor que zero.");
        if (quantidade + qtdeEstoque > estoqueMaximo)
            return true;
        else {
            return false;
        }
    }

    public float calcularValorVenda(int quantidade) {
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade menor que zero.");

        return precoUnit * quantidade;
    }

    public void vender(String dataVenda, Cliente cliente, int qtdeVendida) {
        if (qtdeVendida < 0) {
            throw new IllegalArgumentException("Quantidade menor que zero.");
        }
        if (dataVenda == null) {
            throw new NullPointerException("Data não informada.");
        }
        if (cliente == null) {
            throw new NullPointerException("Cliente nao informado.");
        }
        Venda venda = new Venda(dataVenda, cliente, Produto.this, qtdeVendida);
        if (venda.vender(this, qtdeVendida) == true) {
            this.registrarHistorico(venda);
        }
    }

    public void comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, float precoUnit) {
        if (qtdeCompra < 0) {
            throw new IllegalArgumentException("Quantidade inferior a zero.");
        }
        if (precoUnit < 0) {
            throw new IllegalArgumentException("Preço unitário inferior a zero.");
        }
        if (dataCompra == null) {
            throw new NullPointerException("Data não informada.");
        }
        if (fornecedor == null) {
            throw new NullPointerException("Fornecedor nao informado.");
        }
        Compra compra = new Compra(dataCompra, Produto.this, fornecedor, qtdeCompra, precoUnit);
        if (compra.comprar(this, qtdeCompra) == true) {
            this.registrarHistorico(compra);
        }
    }

    public void registrarHistorico(Transacao transacao) {
        if (historico == null) {
            throw new NullPointerException("Transacao não informada.");
        }
        this.historico.add(transacao.getDataTransacao() + ", " + transacao.getQtde() + ", " + transacao.getProduto().nome);
    }

    public List<String> exibirHistorico() {
        if (historico == null) {
            throw new NullPointerException("Historico não informado.");
        }
        return this.historico;
    }


}