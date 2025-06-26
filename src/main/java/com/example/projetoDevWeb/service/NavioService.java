package com.example.projetoDevWeb.service;

import com.example.projetoDevWeb.dto.NavioDTO;
import com.example.projetoDevWeb.model.Navio;
import com.example.projetoDevWeb.model.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projetoDevWeb.repository.NavioRepository;
import com.example.projetoDevWeb.repository.PortoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NavioService {

    @Autowired
    private NavioRepository navioRepository;

    @Autowired
    private PortoRepository portoRepository;

    public List<NavioDTO> listarTodos() {
        return navioRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<NavioDTO> buscarPorId(Long id) {
        return navioRepository.findById(id).map(this::toDTO);
    }

    public NavioDTO salvar(NavioDTO dto) {
        Navio navio = new Navio();
        navio.setNome(dto.getNome());
        navio.setTipoNavio(dto.getTipo());
        navio.setTonelagemNavio(dto.getTonelagem());

        Porto porto = portoRepository.findById(dto.getPortoId())
                .orElseThrow(() -> new RuntimeException("Porto não encontrado!"));
        navio.setPorto(porto);

        return toDTO(navioRepository.save(navio));
    }

    public NavioDTO atualizarNavio(Long id, NavioDTO navioDTO) {
        Navio navio = new Navio();
        navio.setNome(navioDTO.getNome());
        navio.setTipoNavio(navioDTO.getTipo());
        navio.setTonelagemNavio(navioDTO.getTonelagem());

        Porto porto = portoRepository.findById(navioDTO.getPortoId())
                .orElseThrow(() -> new RuntimeException("Porto não encontrado!"));
        navio.setPorto(porto);

        return  new NavioDTO(navio);
    }

    public void deletar(Long id) {
        navioRepository.deleteById(id);
    }

    private NavioDTO toDTO(Navio navio) {
        NavioDTO dto = new NavioDTO();
        dto.setId(navio.getId());
        dto.setNome(navio.getNomeNavio());
        dto.setTipo(navio.getTipoNavio());
        dto.setTonelagem(navio.getTonelagemNavio());
        dto.setPortoId(navio.getPorto().getId());
        return dto;
    }
}

