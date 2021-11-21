package com.navi;

import com.navi.clientes.CadastrarCliente;
import com.navi.clientes.Cliente;
import com.navi.clientes.exceptions.ClienteSemNomeException;
import com.navi.clientes.exceptions.RemoverClienteQueNaoExisteException;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CadastroClientes {

    CadastrarCliente cadastro;

    @Before
    public void setUp() {
        cadastro = new CadastrarCliente();
    }

    @Test
    public void cadastrarCliente() {
        // Verifição
        Assertions.assertThat(cadastro.getClientes()).isEmpty();
    }

    @Test
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

    @Test(expected = ClienteSemNomeException.class)
    public void naoDeveAdicionarClienteSemNome() {
        // Cenário
        Cliente cliente = new Cliente();

        // Execução
        cadastro.adicionarCliente(cliente);
    }

    @Test
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

    @Test(expected = RemoverClienteQueNaoExisteException.class)
    public void removerClienteQueNaoExiste() {
        // Cenário
        Cliente cliente = new Cliente();
        cliente.setNome("Teste");

        // Execução
        cadastro.removerCliente(cliente);
    }

}
