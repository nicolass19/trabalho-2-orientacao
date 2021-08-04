
public class Cliente extends Pessoa {

    private String cpf;

    Cliente(String nome, String cpf) {
        super(nome);

        if (cpf == null) {
            throw new IllegalArgumentException("CPF não informado.");
        } else {
            this.cpf = cpf;
        }
    }

}