import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void verificaNomeNulo() {
        try {
            Pessoa pessoa = new Pessoa(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Nome não informado.", e.getMessage());
        }
    }

}