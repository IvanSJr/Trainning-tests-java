package com.navi.clientes;

import com.navi.clientes.exceptions.ClienteSemNomeException;
import com.navi.clientes.exceptions.RemoverClienteQueNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class CadastrarCliente {
    private List<Cliente> clientes;

    public CadastrarCliente() {
        this.clientes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        if (cliente.getNome() == null) {
            throw new ClienteSemNomeException();
        }
        this.clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        if (!this.clientes.contains(cliente)){
            throw new RemoverClienteQueNaoExisteException();
        }
        this.clientes.remove(cliente);
    }
}
