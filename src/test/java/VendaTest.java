import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    @Test
    void verificaClienteNulo() {
        try {
            Produto produto = new Produto("Tênis", 20, 1200.00f, 5, 50);
            Venda venda = new Venda("12/06/2021", null, produto, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Cliente não informado.", e.getMessage());
        }
    }

    @Test
    void verificarVendaEstoqueInsuficiente(){
        Fornecedor fornecedor = new Fornecedor("Marcus","0987654321");
        Produto produto = new Produto("Notebook", 100, 200.f, 50, 200 );
        Compra compra = new Compra("25/07/2019",produto ,fornecedor, 120,200.0f);

        produto.verificarEstoqueInsuficiente(120);

        assertEquals(true , produto.verificarEstoqueInsuficiente(120));

    }

    @Test
    void verificarVendaEstoqueSuficiente(){
        Fornecedor fornecedor = new Fornecedor("Marcus","0987654321");
        Produto produto = new Produto("Notebook", 100, 200.f, 50, 200 );
        Compra compra = new Compra("25/07/2019",produto ,fornecedor, 99,200.0f);

        produto.debitarEstoque(1);
        assertEquals(true , produto.debitarEstoque(1));



    }
}