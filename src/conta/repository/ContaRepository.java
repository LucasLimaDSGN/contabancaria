package conta.repository;

import conta.model.Conta;

public interface ContaRepository {

	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrarConta(Conta conta);
	public void atualizarConta(Conta conta);
	public void deletar(int numero);
	
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
}
