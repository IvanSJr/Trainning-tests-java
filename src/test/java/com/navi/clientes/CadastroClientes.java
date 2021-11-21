package com.navi.clientes;

import com.navi.clientes.CadastrarCliente;
import com.navi.clientes.Cliente;
import com.navi.clientes.exceptions.ClienteSemNomeException;
import com.navi.clientes.exceptions.RemoverClienteQueNaoExisteException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CadastroClientes {

    CadastrarCliente cadastro;

    @BeforeEach
    public void setUp() {
        cadastro = new CadastrarCliente();
    }

    @Test
    @DisplayName("Criando o cadastro de clientes.")
    public void cadastrarCliente() {
        // Verifição
        Assertions.assertThat(cadastro.getClientes()).isEmpty();
    }

    @Test
    @DisplayName("Adicionando um cliente de clientes.")
    public void adicionarCliente() {
        // Cenário
        Cliente cliente = new Cliente();
        cliente.setNome("Ivan");
        cadastro.adicionarCliente(cliente);

        // Verificação
        Assertions.assertThat(cadastro.getClientes())
                .isNotEmpty()
                .hasSize(1)
                .contains(cliente);
    }

    @Test()
    @DisplayName("Não deve adicionar um cliente sem nome.")
    public void naoDeveAdicionarClienteSemNome() {
        // Cenário
        Cliente cliente = new Cliente();

        // Execução
        ;
        org.junit.jupiter.api.Assertions
                .assertThrows(ClienteSemNomeException.class, () -> cadastro.adicionarCliente(cliente));
    }

    @Test
    @DisplayName("Removendo um cliente.")
    public void removerCliente() {
        // Cenário
        Cliente cliente = new Cliente();
        cliente.setNome("Ivan");
        cadastro.adicionarCliente(cliente);

        // Execução
        cadastro.removerCliente(cliente);

        // Verificação
        Assertions.assertThat(cadastro.getClientes()).isEmpty();
    }

    @Test()
    @DisplayName("Removendo um cliente que não existe.")
    public void removerClienteQueNaoExiste() {
        // Cenário
        Cliente cliente = new Cliente();
        cliente.setNome("Teste");

        // Execução
        org.junit.jupiter.api.Assertions
                .assertThrows(RemoverClienteQueNaoExisteException.class, ()-> cadastro.removerCliente(cliente));
    }

}
