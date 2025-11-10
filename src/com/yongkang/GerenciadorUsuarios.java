package com.yongkang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe responsável por gerenciar os usuários do sistema.
 * Oferece métodos para adicionar, remover e listar usuários.
 */
public class GerenciadorUsuarios {

    private List<Usuario> usuarios;

    // Construtor: inicia a lista de usuários
    public GerenciadorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Adiciona um novo usuário se ainda não existir outro com o mesmo email.
     */
    public void adicionarUsuario(String nome, String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("⚠️ Já existe um usuário cadastrado com este email!");
                return;
            }
        }
        usuarios.add(new Usuario(nome, email));
        System.out.println("✅ Usuário adicionado com sucesso!");
    }

    /**
     * Remove um usuário pelo nome.
     */
    public void removerUsuario(String nome) {
        Iterator<Usuario> it = usuarios.iterator();
        boolean removido = false;

        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getNome().equalsIgnoreCase(nome)) {
                it.remove();
                removido = true;
                System.out.println("🗑️ Usuário removido com sucesso!");
                break;
            }
        }

        if (!removido) {
            System.out.println("❌ Nenhum usuário encontrado com esse nome.");
        }
    }

    /**
     * Lista todos os usuários cadastrados.
     */
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("📭 Nenhum usuário cadastrado no sistema.");
            return;
        }

        System.out.println("\n📋 Lista de Usuários Cadastrados:");
        for (Usuario u : usuarios) {
            System.out.println("- " + u);
        }
    }
}