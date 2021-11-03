package com.alkemy.challengeAlternativo.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PaisFiltersDTO {
    private String name;
    private Long idContinente;
    private String order;

    public PaisFiltersDTO(String name, Long idContinente, String order) {
        this.name = name;
        this.idContinente = idContinente;
        this.order = order;
    }

    public boolean isASC(){ return this.order.compareToIgnoreCase("ASC")==0;}

    public boolean isDESC(){ return this.order.compareToIgnoreCase("DESC")==0;}
}
