package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import entities.ContaBancaria;

public class Main {

	public static void main(String[] args) {
		String opcaoSelecionada = "";
		Scanner sc = new Scanner(System.in);
		ContaBancaria contaAutenticada = null;
		String erro = "";

		List<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();

		String sair = "3";
		while (!opcaoSelecionada.equals(sair)) {
			if (contaAutenticada == null) {
				System.out.println("Selecione uma opção: ");
				System.out.println("1 - Registro");
				System.out.println("2 - Login");
				System.out.println("3 - Sair");

				opcaoSelecionada = sc.next();

				if (opcaoSelecionada.equals("1")) {
					ContaBancaria newContaBancaria = new ContaBancaria();
					System.out.println("Digite o nome: ");
					sc.nextLine();
					newContaBancaria.setNome(sc.nextLine());
					
					System.out.println("Digite o login: ");
					newContaBancaria.setLogin(sc.nextLine());

					System.out.println("Digite a senha: ");
					newContaBancaria.setSenha(sc.nextLine());

					while (!opcaoSelecionada.equals("s") && !opcaoSelecionada.equals("n")) {
						System.out.println("A conta tem saldo inicial? (S/N)");
						opcaoSelecionada = sc.next().toLowerCase();
					}
					double saldoInicial = 0;
					if (opcaoSelecionada.equals("s")) {
						System.out.println("Digite o saldo inicial: ");
						saldoInicial = sc.nextDouble();
					}

					try {
						newContaBancaria.depositar(saldoInicial);

						System.out.println();
					} catch (RuntimeException e) {
						System.out.println();
						System.err.println(e.getMessage());
					}
					contasBancarias.add(newContaBancaria);
					System.out.println("Conta bancária registrada com sucesso!");

					System.out.println();
				} else if (opcaoSelecionada.equals("2")) {
					System.out.println("Digite o login:");
					sc.nextLine();
					String login = sc.nextLine();

					System.out.println("Digite a senha:");
					String senha = sc.nextLine();

					contaAutenticada = fazerLogin(contasBancarias, login, senha);

					if (contaAutenticada == null) {
						System.err.println("Login ou senha incorretos.");
					}
				}

			} else {
				System.out.println("Olá " + contaAutenticada.getNome());
				System.out.println("Saldo: " + contaAutenticada.getSaldo());

				System.out.println("Digite uma opção: ");
				System.out.println("1 - Sacar");
				System.out.println("2 - Depositar");
				System.out.println("3 - Logout");

				opcaoSelecionada = sc.next();
				System.out.println();

				switch (opcaoSelecionada) {
				case "1":
					System.out.println("Digite o valor do saque: ");
					double saque = sc.nextDouble();
					try {
						contaAutenticada.sacar(saque);

						System.out.println();
						System.out.println("Valor sacado com sucesso!");

					} catch (RuntimeException e) {
						System.out.println();
						System.err.println(e.getMessage());
					}

					break;
				case "2":
					System.out.println("Digite o valor do depósito: ");
					double deposito = sc.nextDouble();
					try {
						contaAutenticada.depositar(deposito);

						System.out.println();
						System.out.println("Valor depositado com sucesso!");

					} catch (RuntimeException e) {
						System.out.println();
						System.err.println(e.getMessage());
					}

					break;
				case "3":
					opcaoSelecionada = "";
					contaAutenticada = null;
					break;
				}
			}
		}

	}

	private static ContaBancaria fazerLogin(List<ContaBancaria> contasBancarias, String login, String senha) {
		ContaBancaria contaBancaria = null;
		for (ContaBancaria tempContaBancaria : contasBancarias) {
			if (tempContaBancaria.getLogin().equals(login) && tempContaBancaria.getSenha().equals(senha)) {
				contaBancaria = tempContaBancaria;
			}
		}

		return contaBancaria;
	}

}
