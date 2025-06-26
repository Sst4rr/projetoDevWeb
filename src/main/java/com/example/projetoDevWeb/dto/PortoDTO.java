package com.example.projetoDevWeb.dto;

import com.example.projetoDevWeb.model.Porto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PortoDTO {
    private Long id;
    private String nome;
    private String cidade;
    private String pais;

    public PortoDTO() {}

    public PortoDTO( String pais, String nome, String cidade) {
        this.pais = pais;
        this.nome = nome;
        this.cidade = cidade;
    }

    public PortoDTO(Porto porto) {
        this.id = porto.getId();
        this.nome = porto.getNome();
        this.cidade = porto.getCidade();
        this.pais = porto.getPais();
    }

    // Getters e Setters
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
