package conta;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ContaController contas = new ContaController();
		
	
		
		Scanner read = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo=0, limite, valor;
		
		while (true) {

			System.out.println(cores.TEXT_YELLOW + cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + cores.TEXT_RESET);
			try {
			opcao = read.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros");
				read.nextLine();
				
				opcao = 0;
			}
			if (opcao == 9) {
				System.out.println(cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				read.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");

				System.out.println("Digite o numero da Agencia: ");
				agencia = read.nextInt();
				
				System.out.println("Digite o nome do Titular: ");
				read.skip("\\R");
				titular = read.nextLine();
				
				do {
					System.out.println("Digite o tipo de conta(1-CC ou 2-CP): ");
					tipo = read.nextInt();					
					
				}while(tipo <1 && tipo>2);
				
				System.out.println("Digite o saldo da conta (R$):");
				
				switch(tipo){
				case 1 ->{
					System.out.println("Digite o Limite de Credito (R$): ");
					limite = read.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, limite));
				}
				case 2 ->{
					System.out.println("Digite o dia do aniversario da conta: ");
					aniversario = read.nextInt();
					contas.cadastrar(new ContaPoupanca(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));
					
					
				}
				
				
				}
				keyPress();
				break;
			case 2:
				System.out.println(cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o numero da conta: ");
				numero = read.nextInt();
				
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");

				System.out.println("Digite o numero da conta: ");
				numero = read.nextInt();
				
				if(contas.buscarNaCollection(numero) != null){
					
					System.out.println("Digite o numero da agencia: ");
					agencia = read.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					read.skip("\\R");
					titular = read.nextLine();
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = read.nextFloat();
					
					tipo = contas.retornaTipo(numero);
					
					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Lmite de Credito (R$): ");
						limite = read.nextFloat();
						contas.atualizarConta(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversario da Conta: ");
						aniversario = read.nextInt();
						contas.atualizarConta(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						
					}
					default -> {
						System.out.println("Tipo de conta Invalido!");
						
					}
					}
				}else
					System.out.println("\nConta nao encontrada!");
				
				keyPress();
				break;
			case 5:
				System.out.println(cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o numero da conta: ");
				
				numero = read.nextInt();
				
				contas.deletar(numero);
				
				
				keyPress();
				break;
			case 6:
				System.out.println(cores.TEXT_WHITE_BOLD + "Saque\n\n");
				
				System.out.println("Digite o Numero da conta: ");
				numero = read.nextInt();
				
				do {
					System.out.println("Digite o Valor do Saque (R$): ");
					valor = read.nextFloat();
					
				}while (valor <=0);
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				
				System.out.println("Digite o Numero da conta: ");
				numero = read.nextInt();
				
				do {
					System.out.println("Digite o Valor do Deposito (R$): ");
					valor = read.nextFloat();
					
				}while (valor <=0);
				
				contas.depositar(numero, valor);
				keyPress();
				break;
			case 8:
				System.out.println(cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");

				System.out.println("Digite o numero da conta de origem: ");
				numero = read.nextInt();
				System.out.println("Digite o numero da conta de destino: ");
				numeroDestino = read.nextInt();
				
				do {
					System.out.println("Digite o Valor da Transferencia (R$): ");
					valor = read.nextFloat();
				}while (valor <=0);
				
				contas.transferir(numero, numeroDestino, valor);
				
				
				keyPress();
				break;
			default:
				System.out.println(cores.TEXT_RED_BOLD + "\nOpção Inválida!\n");
				keyPress();
				break;
			
			}
			
		}
	}
	
	public static void keyPress() {
		try {
			
			System.out.println(cores.TEXT_RESET +"\n\nPressione Enter para continuar.");
			System.in.read();
		}catch(IOException e){
			System.out.println("Voce pressionou uma tecla diferente de Enter");
		}
		
	}
}

