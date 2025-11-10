package com.yongkang;

import java.util.Scanner;

public class MainRefatorado {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorUsuarios manager = new GerenciadorUsuarios();
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE GERENCIAMENTO DE USUÁRIOS =====");
            System.out.println("1 - Adicionar Usuário");
            System.out.println("2 - Listar Usuários");
            System.out.println("3 - Remover Usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é um número
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, digite um número válido!");
                sc.next(); // descarta entrada inválida
                System.out.print("Escolha uma opção: ");
            }

            opcao = sc.nextInt();
            sc.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    manager.adicionarUsuario(nome, email);
                    break;

                case 2:
                    manager.listarUsuarios();
                    break;

                case 3:
                    System.out.print("Nome para remover: ");
                    String nomeRemover = sc.nextLine();
                    manager.removerUsuario(nomeRemover);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
