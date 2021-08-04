import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {

    @Test
    void verificaDataDaTransacaoNula(){
        try{
            Produto produto = new Produto("Celular", 50, 1000.00f,10,200);
            Transacao trasacao = new Transacao(null, produto, 10);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("Data da transação não informado.", e.getMessage());
        }
    }

    @Test
    void verificaProdutoNulo(){
        try{
            Produto produto = new Produto("Celular", 50, 1000.00f,10,200);
            Transacao trasacao = new Transacao("12/07/2021", null, 10);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("Produto não informado.", e.getMessage());
        }
    }

    @Test
    void verificaQuantidadeMenorOuIgualAZero(){
        try{
            Produto produto = new Produto("Celular", 50, 1000.00f,10,200);
            Transacao trasacao = new Transacao("12/07/2021", produto, 0);
            fail();
        }catch(IllegalArgumentException e){
            assertEquals("Quantidade menor ou igual a zero.", e.getMessage());
        }
    }

}