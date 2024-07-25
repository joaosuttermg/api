package com.api.aulaapi;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("clientes")
public class ClientController {
    @GetMapping
    public String getAll() {
        if (Cliente.clientes.isEmpty()) {
            return "Não há clientes cadastrados.";
        } else {
            String resposta = Cliente.clientes.toString();
            return resposta;
        }
    }

    // Criar um cliente - create
    @PostMapping
    public String create(@RequestBody Cliente cliente) {
        Cliente.clientes.add(cliente);
        return "Cliente cadastrado com sucesso!";
    }

    // Buscar um cliente por id - getById
    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    // Atualizar um cliente - update
    @PutMapping
    public String update(@PathVariable UUID id,@RequestBody Cliente cliente) {
            for (Cliente clientenovo : Cliente.clientes) {
                if (clientenovo.getId().equals(id)) {
                    return clientenovo.toString();
                }
            }
            return "Cliente não encontrado.";
    }

    // Deletar um cliente - delete
    @PostMapping
    public String delete(@RequestBody Cliente cliente) {
        Cliente.clientes.remove(cliente);
        return "Cliente removido com sucesso!";
    }


}


