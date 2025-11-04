package Main.Aula08.TratamentoExcecoes;

class DadosInvalidosException extends Exception {
    public DadosInvalidosException(String mensagem) {
        super(mensagem);
    }
}
