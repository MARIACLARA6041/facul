package q2_MariaNascimento;

import java.io.*;
import java.util.Scanner;

public class SistemaLogin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String login, senha;

		while (true) {
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastre um login e senha");
			System.out.println("2 - Faça o login");
			System.out.println("3 - Sair");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1:
				System.out.print("Digite o login: ");
				login = scanner.nextLine();
				System.out.print("Digite a senha: ");
				senha = scanner.nextLine();

				cadastrarCredencial(login, senha);
				System.out.println("Login cadastrado com sucesso!");
				break;

			case 2:
				System.out.print("Digite o login: ");
				login = scanner.nextLine();
				System.out.print("Digite a senha: ");
				senha = scanner.nextLine();

				if (verificarCredencial(login, senha)) {
					System.out.println("SUCESSO - Login efetuado com sucesso!");
				} else {
					System.out.println("FRACASSO - Login ou senha incorretos.");
				}
				break;

			case 3:
				System.out.println("Saindo do programa.");
				return;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	private static void cadastrarCredencial(String login, String senha) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("credenciais.txt", true))) {
			writer.println(login + " " + senha);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean verificarCredencial(String login, String senha) {
		try (Scanner scanner = new Scanner(new File("credenciais.txt"))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(" ");
				if (parts.length == 2 && parts[0].equals(login) && parts[1].equals(senha)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}