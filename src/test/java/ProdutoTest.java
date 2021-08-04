import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void verificaNomeDoProdutoNulo() {
        try {
            Produto produto = new Produto(null, 5, 100.00f, 10, 1000);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome do produto não informado.", e.getMessage());
        }
    }

    @Test
    void verificaQtdeEstoqueDoProdutoMenorQueZero() {
        try {
            Produto produto = new Produto("Mochila", -1, 50.00f, 10, 500);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de estoque menor que zero.", e.getMessage());
        }
    }

    @Test
    void verificaPrecoUnitDoProdutoMenorOuIgualAZero() {
        try {
            Produto produto = new Produto("Mochila", 100, 0.00f, 10, 500);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço unitário menor ou igual a zero.", e.getMessage());
        }
    }

    @Test
    void verificaEstoqueMinimoDoProdutoMenorQueZero() {
        try {
            Produto produto = new Produto("Mochila", 100, 50.00f, -1, 500);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque mínimo menor que zero.", e.getMessage());
        }
    }

    @Test
    void verificaEstoqueMaximoDoProdutoMenorQueEstoqueMinimo() {
        try {
            Produto produto = new Produto("Monitor", 100, 600.00f, 500, 100);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque máximo menor ou igual ao estoque mínimo.", e.getMessage());
        }
    }

    @Test
    void verificaEstoqueMaximoDoProdutoMenorQueZero() {
        try {
            Produto produto = new Produto("Monitor", 100, 600.00f, 10, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque máximo menor ou igual ao estoque mínimo.", e.getMessage());
        }
    }

    @Test
    void verificaEstoqueMenorQueZero() {
        try {
            Produto produto = new Produto("Monitor", 5, 60.00f, 10, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque máximo menor ou igual ao estoque mínimo.", e.getMessage());
        }
    }

    @Test
    void verificaDebitarEstoque1() {
        try {
            Produto produto = new Produto("Teclado", 200, 200.00f, 10, 1000);
            produto.debitarEstoque(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade menor que zero.", e.getMessage());
        }
    }

    @Test
    void verificaDebitarEstoque2() {
        try {
            Produto produto = new Produto("Teclado", 200, 200.00f, 10, 1000);
            produto.debitarEstoque(201);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade maior que o estoque.", e.getMessage());
        }
    }

    @Test
    void verificaDebitarEstoque3() {
        Produto produto = new Produto("Teclado", 200, 200.00f, 10, 1000);
        produto.debitarEstoque(1);
        assertEquals(199, produto.getQtdeEstoque());
    }

    @Test
    void verificaCreditarEstoque1() {
        try {
            Produto produto = new Produto("Mouse", 100, 100.00f, 10, 1000);
            produto.creditarEstoque(-1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade menor que zero.", e.getMessage());
        }
    }

    @Test
    void verificaCreditarEstoque2() {
        Produto produto = new Produto("Mouse", 100, 100.00f, 10, 1000);
        produto.creditarEstoque(1);
        assertEquals(101, produto.getQtdeEstoque());
    }

    @Test
    void verificaEstoqueBaixo1() {
        Produto produto = new Produto("Mouse", 3, 100.00f, 10, 1000);
        assertTrue(produto.verificarEstoqueBaixo());
    }

    @Test
    void verificaEstoqueBaixo2() {
        Produto produto = new Produto("Mouse", 20, 100.00f, 10, 1000);
        assertFalse(produto.verificarEstoqueBaixo());
    }

    @Test
    void verificaEstoqueInsuficiente1() {
        try {
            Produto produto = new Produto("Placa de Vídeo", 50, 1000.00f, 10, 1000);
            produto.verificarEstoqueInsuficiente(-2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade menor que zero.", e.getMessage());
        }
    }

    @Test
    void verificaEstoqueInsuficiente2() {
        Produto produto = new Produto("Placa de Vídeo", 50, 1000.00f, 10, 1000);
        assertTrue(produto.verificarEstoqueInsuficiente(51));
    }

    @Test
    void verificaEstoqueInsuficiente3() {
        Produto produto = new Produto("Placa de Vídeo", 50, 1000.00f, 10, 1000);
        assertFalse(produto.verificarEstoqueInsuficiente(49));
    }

    @Test
    void verificaEstoqueExcedente1() {
        try {
            Produto produto = new Produto("Notebook", 100, 3000.00f, 10, 2000);
            produto.verificarEstoqueExcedente(-2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade menor que zero.", e.getMessage());
        }
    }

    @Test
    void verificaEstoqueExcedente2() {
        Produto produto = new Produto("Notebook", 100, 3000.00f, 10, 200);
        assertTrue(produto.verificarEstoqueExcedente(101));
    }

    @Test
    void verificaEstoqueExcedente3() {
        Produto produto = new Produto("Notebook", 100, 3000.00f, 10, 2000);
        assertFalse(produto.verificarEstoqueInsuficiente(2));
    }

    @Test
    void verificaCalcularValorVenda1() {
        try {
            Produto produto = new Produto("Notebook", 100, 3000.00f, 10, 2000);
            produto.calcularValorVenda(-2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade menor que zero.", e.getMessage());
        }
    }

    @Test
    void vericaCalcularValorVenda2() {
        Produto produto = new Produto("Notebook", 100, 3000.00f, 10, 2000);
        assertEquals(3000.00f, produto.calcularValorVenda(1));
    }

    @Test
    public void verificaRetornarHistoricoCompra() {
        Produto produto = new Produto("Notebook", 10, 3000.00f, 20, 2000);
        Fornecedor fornecedor = new Fornecedor("Dell", "0987654321");
        produto.comprar("03/03/21", fornecedor, 1, 2500.00f);

        List<String> lista = new ArrayList<String>();
        lista.add("03/03/21, 1, Notebook");

        assertEquals(lista, produto.exibirHistorico());
    }

    @Test
    public void verificaRetornarHistoricoVenda() {
        Produto produto = new Produto("Notebook", 10, 3500.00f, 20, 2000);
        Cliente cliente = new Cliente("Marcus", "0987654321");
        produto.vender("03/03/21", cliente, 1);

        List<String> lista = Arrays.asList("03/03/21, 1, Notebook");

        assertEquals(lista, produto.exibirHistorico());
    }
}