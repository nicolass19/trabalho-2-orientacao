import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorTest {

    @Test
    void verificaCnpjNulo() {
        try {
            Fornecedor fornecedor = new Fornecedor("Nicolas", null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("CNPJ não informado.", e.getMessage());
        }
    }

}