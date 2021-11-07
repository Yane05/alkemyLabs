package com.alkemy.challengeAlternativo.icons.mapper;

import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;

    public PaisEntity paisDTO2Entity(PaisDTO dto) {
        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setImagen(dto.getImagen());
        paisEntity.setDenominacion(dto.getDenominacion());
        paisEntity.setCantidadHabitantes(dto.getCantidadHabitantes());
        paisEntity.setSuperficie(dto.getSuperficie());
        paisEntity.setContinenteId(dto.getContinenteId());
        return paisEntity;
    }

    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setContinenteId(entity.getContinenteId());
        dto.setSuperficie(entity.getSuperficie());
        if (loadIcons) {
            List<IconDTO> iconDTOS = iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }
        return dto;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public void paisEntityRefreshValues(PaisEntity entity, PaisDTO paisDTO) {
        entity.setImagen(paisDTO.getImagen());
        entity.setDenominacion(paisDTO.getDenominacion());
        entity.setCantidadHabitantes(paisDTO.getCantidadHabitantes());
        entity.setSuperficie(paisDTO.getSuperficie());
        entity.setContinenteId(paisDTO.getContinenteId());
    }
}
