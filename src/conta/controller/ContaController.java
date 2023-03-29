package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository{
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;
	
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
		listaContas.add(conta);
		System.out.println("\nA conta numero: "+conta.getNumero()+" foi criada com sucesso!");
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		for (var conta: listaContas)
		conta.visualizar();
	}

	@Override
	public void cadastrarConta(Conta conta) {
		// TODO Auto-generated method stub
		listaContas.add(conta);
		System.out.println("\nA conta numero: "+conta.getNumero()+" foi criada com sucesso!");
		
	}

	@Override
	public void atualizarConta(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarNumero() {
		return ++numero;
	}

}
