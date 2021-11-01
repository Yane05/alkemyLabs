package com.alkemy.challengeAlternativo.icons.service.impl;

import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import com.alkemy.challengeAlternativo.icons.mapper.PaisMapper;
import com.alkemy.challengeAlternativo.icons.repository.PaisRepository;
import com.alkemy.challengeAlternativo.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl implements PaisService {

    @Autowired
    private PaisMapper paisMapper;
    @Autowired
    private PaisRepository paisRepository;

    public PaisDTO save (PaisDTO dto){
        PaisEntity entity = paisMapper.paisDTO2Entity(dto);
        PaisEntity entitySaved = paisRepository.save(entity);
        PaisDTO result = paisMapper.paisEntity2DTO(entitySaved,false);
        return result;
    }

    public List<PaisDTO> getAllPaises() {
        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities, false);
        return result;
    }
}
