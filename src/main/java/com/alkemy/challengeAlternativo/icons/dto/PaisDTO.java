package com.alkemy.challengeAlternativo.icons.dto;

import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter

public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Set<IconEntity> icons;
}
