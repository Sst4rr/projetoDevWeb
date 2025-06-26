package com.example.projetoDevWeb.service;

import com.example.projetoDevWeb.dto.NavioDTO;
import com.example.projetoDevWeb.dto.PortoDTO;
import com.example.projetoDevWeb.model.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projetoDevWeb.repository.PortoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PortoService {

    @Autowired
    private PortoRepository portoRepository;

    public List<PortoDTO> listarTodos() {
        return portoRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<PortoDTO> buscarPorId(Long id) {
        return portoRepository.findById(id).map(this::toDTO);
    }

    public PortoDTO salvar(PortoDTO dto) {
        Porto porto = new Porto();
        porto.setNome(dto.getNome());
        porto.setCidade(dto.getCidade());
        porto.setPais(dto.getPais());
        return toDTO(portoRepository.save(porto));
    }

    public PortoDTO atualizarPorto(Long id, PortoDTO portoDTO) {
        Porto porto = portoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não encontardo!"));
        porto.setNome(portoDTO.getNome());
        porto.setCidade(portoDTO.getCidade());
        porto.setPais(portoDTO.getPais());

        return new PortoDTO(porto);
    }

    public void deletar(Long id) {
        portoRepository.deleteById(id);
    }

    private PortoDTO toDTO(Porto porto) {
        PortoDTO dto = new PortoDTO();
        dto.setId(porto.getId());
        dto.setNome(porto.getNome());
        dto.setCidade(porto.getCidade());
        dto.setPais(porto.getPais());
        return dto;
    }
}