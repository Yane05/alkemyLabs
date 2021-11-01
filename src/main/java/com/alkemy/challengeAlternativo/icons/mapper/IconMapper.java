package com.alkemy.challengeAlternativo.icons.mapper;

import com.alkemy.challengeAlternativo.icons.dto.IconBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class IconMapper {

    @Autowired
    private PaisMapper paisMapper;

    public IconEntity iconDTO2Entity (IconDTO dto){
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setFechaCreacion(dto.getFechaCreacion());
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadPaises) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        if (loadPaises){
            List<PaisDTO> paisesDTO = paisMapper.paisEntityList2DTOList(entity.getPaises(), false);
            dto.setPaises(paisesDTO);
        }
        return dto;
    }

    public IconBasicDTO iconBasicEntity2DTO(IconEntity entity) {
        IconBasicDTO basicDTO = new IconBasicDTO();
        basicDTO.setId(entity.getId());
        basicDTO.setImagen(entity.getImagen());
        basicDTO.setDenominacion(entity.getDenominacion());
        return basicDTO;
    }

    public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadPaises) {
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity : entities){
            dtos.add(iconEntity2DTO(entity, loadPaises));
        }
        return dtos;
    }

    public List<IconBasicDTO> iconBasicEntitySet2DTOList(Collection<IconEntity> entities) {
        List<IconBasicDTO> basicDTO = new ArrayList<>();
        for (IconEntity entity : entities){
            basicDTO.add(iconBasicEntity2DTO(entity));
        }
        return basicDTO;
    }
}
