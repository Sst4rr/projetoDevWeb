package com.example.projetoDevWeb.dto;

import com.example.projetoDevWeb.model.Navio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NavioDTO {
    private Long id;
    private String nome;
    private String tipo;
    private Double tonelagem;
    private Long portoId;

    public NavioDTO(Navio navio) {
        this.id = navio.getId();
        this.nome = navio.getNomeNavio();
        this.tipo = navio.getTipoNavio();
        this.tonelagem = navio.getTonelagemNavio();
        this.portoId = navio.getPorto() != null ? navio.getPorto().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getTonelagem() {
        return tonelagem;
    }

    public void setTonelagem(Double tonelagem) {
        this.tonelagem = tonelagem;
    }

    public Long getPortoId() {
        return portoId;
    }

    public void setPortoId(Long portoId) {
        this.portoId = portoId;
    }
}
