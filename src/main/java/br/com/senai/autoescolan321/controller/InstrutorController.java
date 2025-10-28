package br.com.senai.autoescolan321.controller;

import br.com.senai.autoescolan321.instrutor.DadosCadastroInstrutor;
import br.com.senai.autoescolan321.instrutor.DadosListagemInstrutor;
import br.com.senai.autoescolan321.instrutor.Instrutor;
import br.com.senai.autoescolan321.instrutor.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @PostMapping
    public void cadastrarInstrutor(@RequestBody @Valid DadosCadastroInstrutor dados) {
        instrutorRepository.save(new Instrutor(dados));
    }

    @GetMapping
    public List<DadosListagemInstrutor> listarInstrutores() {
        return instrutorRepository.findAll().stream().map(DadosListagemInstrutor::new).toList();
    }
}