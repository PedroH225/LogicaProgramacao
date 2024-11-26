package entities;

public class ContaBancaria {
	
	String nome;
	
	String login;
	
	String senha;
	
	double saldo = 0;

	public ContaBancaria() {
	}

	public ContaBancaria(String nome, String login, String senha, double saldo) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar(double deposito) {
		if (deposito < 0) {
			throw new RuntimeException("Valor de depósito inválido.");
		}
		this.saldo += deposito;
	}
	
	public void sacar(double saque) {
		if (saque > saldo) {
			throw new RuntimeException("Saldo insuficiente.");
		} else if (saque <= 0) {
			throw new RuntimeException("Valor de saque inválido.");
		}
		this.saldo -= saque;
	}

	@Override
	public String toString() {
		return "ContaBancaria [nome=" + nome + ", login=" + login + ", senha=" + senha + ", saldo=" + saldo + "]";
	}
	
	
	
}
