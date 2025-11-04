package Main.Aula08.TratamentoExcecoes;

class CadastroCliente {
    void cadastrar(String nome, int idade) throws
            DadosInvalidosException {
        if (nome == null || nome.isEmpty() || idade < 18) {
            throw new DadosInvalidosException("Nome não pode ser vazio e idade deve ser maior que 18.");
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }
}
