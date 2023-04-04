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
        var conta = buscarNaCollection(numero);
		
		if (conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
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
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA conta numero: "+conta.getNumero()+" foi atualizada com sucesso!");
		} else {
			System.out.println("\nA conta numero: "+ conta.getNumero()+" nao foi encontrada!");
		}
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta)==true)
				System.out.println("\nA conta numero: "+ numero+ " foi deletada com sucesso!");
			
		}else
			System.out.println("\nA conta numero:"+ numero + " nao foi encontrada!");
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		var conta = buscarNaCollection(numero);
	
		if (conta != null) {
			
			if (conta.sacar(valor)==true)
				System.out.println("\nO saque na conta numero: "+ numero + " foi efetuado com sucesso!");
		}else
			System.out.println("\nA conta numero: "+numero+" nao foi encontrada!");
	
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			
			conta.depositar(valor);
				System.out.println("\nO deposito na conta numero: "+ numero + " foi efetuado com sucesso!");
		}else
			System.out.println("\nA conta numero: "+numero+" nao foi encontrada ou a conta destino nao e uma conta corrente!");
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarNumero() {
		return ++numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
			
		}
		return null;
	}
	public int retornaTipo (int numero) {
		for (var conta : listaContas) {
			
			if (conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}

}

