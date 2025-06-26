package com.example.projetoDevWeb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "navios")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Navio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeNavio;
    private String tipoNavio;
    private Double tonelagemNavio;

    @ManyToOne
    @JoinColumn(name = "porto_id")
    private Porto porto;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeNavio() { return nomeNavio; }
    public void setNome(String nomeNavio) { this.nomeNavio = nomeNavio; }

    public String getTipoNavio() { return tipoNavio; }
    public void setTipoNavio(String tipoNavio) { this.tipoNavio = tipoNavio; }

    public Double getTonelagemNavio() { return tonelagemNavio; }
    public void setTonelagemNavio(Double tonelagemNavio) { this.tonelagemNavio = tonelagemNavio; }

    public Porto getPorto() { return porto; }
    public void setPorto(Porto porto) { this.porto = porto; }
}

