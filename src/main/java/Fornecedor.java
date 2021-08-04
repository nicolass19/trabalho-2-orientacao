public class Fornecedor extends Pessoa {

    private String cnpj;

    Fornecedor(String nome, String cnpj) {
        super(nome);

        if (cnpj == null) {
            throw new IllegalArgumentException("CNPJ não informado.");
        } else {
            this.cnpj = cnpj;
        }
    }
}