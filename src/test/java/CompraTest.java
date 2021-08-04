import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompraTest {

    @Test
    void verificaFornecedorNulo() {
        try {
            Produto produto = new Produto("Mesa", 10, 300.00f, 10, 100);
            Compra compra = new Compra("07/05/2021", produto, null, 1, 300.00f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Fornecedor não informado.", e.getMessage());
        }
    }

    @Test
    void verificaPrecoUnitMenorOuIgualAZero() {
        try {
            Produto produto = new Produto("Mesa", 10, -1.00f, 10, 100);
            Fornecedor fornecedor = new Fornecedor("Nicolas", "0987654321");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Preço unitário menor ou igual a zero.", e.getMessage());
        }
    }

    @Test
    void verficarEstoqueExcedente(){
        Fornecedor fornecedor = new Fornecedor("Marcus","0987654321");
        Produto produto = new Produto("Mesa", 100, 200.f, 50, 200 );
        Compra compra = new Compra("25/07/2019",produto ,fornecedor, 101,200.0f);

        produto.verificarEstoqueExcedente(201);


        assertEquals(true , produto.verificarEstoqueExcedente(201));
    }

    @Test
    void verificarCreditarEstoque(){
        Fornecedor fornecedor = new Fornecedor("Marco","0987654321");
        Produto produto = new Produto("Mesa", 100, 200.f, 50, 200 );
        Compra compra = new Compra("25/07/2019",produto ,fornecedor, 99,200.0f);

        produto.creditarEstoque(199);

        assertEquals(true , produto.creditarEstoque(199));

    }

}