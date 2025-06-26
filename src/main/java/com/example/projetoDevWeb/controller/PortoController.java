package com.example.projetoDevWeb.controller;

import com.example.projetoDevWeb.dto.PortoDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projetoDevWeb.service.PortoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/portos")
@Tag(name = "Porto", description = "Operações relacionadas aos portos")
public class PortoController {

    @Autowired
    private PortoService portoService;

    @GetMapping
    public List<PortoDTO> listarTodos() {
        return portoService.listarTodos();
    }

    @GetMapping(value = "/{id}")
    public Optional<PortoDTO> buscarPorId(@PathVariable Long id) {
        return portoService.buscarPorId(id);
    }

    @PostMapping
    public PortoDTO salvar(@RequestBody PortoDTO dto) {
        return portoService.salvar(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PortoDTO> atualizarPorto(@PathVariable Long id, @RequestBody PortoDTO portoDTO) {
        portoDTO = portoService.atualizarPorto(id, portoDTO);

        return ResponseEntity.ok().body(portoDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deletar(@PathVariable Long id) {
        portoService.deletar(id);
    }
}