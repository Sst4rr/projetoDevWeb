package com.example.projetoDevWeb.controller;

import com.example.projetoDevWeb.dto.NavioDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projetoDevWeb.service.NavioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/navios")
@Tag(name = "Navios", description = "Operações relacionadas aos navios")
public class NavioController {

    @Autowired
    private NavioService navioService;

    @GetMapping
    public List<NavioDTO> listarTodos() {
        return navioService.listarTodos();
    }

    @GetMapping(value = "/{id}")
    public Optional<NavioDTO> buscarPorId(@PathVariable Long id) {
        return navioService.buscarPorId(id);
    }

    @PostMapping
    public NavioDTO salvar(@RequestBody NavioDTO dto) {
        return navioService.salvar(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NavioDTO> atulaizarNavio(@PathVariable Long id, @RequestBody NavioDTO navioDTO) {
        navioDTO = navioService.atualizarNavio(id, navioDTO);

        return ResponseEntity.ok().body(navioDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deletar(@PathVariable Long id) {
        navioService.deletar(id);
    }
}
