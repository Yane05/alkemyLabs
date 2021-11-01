package com.alkemy.challengeAlternativo.icons.service.impl;

import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconFiltersDTO;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import com.alkemy.challengeAlternativo.icons.mapper.IconMapper;
import com.alkemy.challengeAlternativo.icons.repository.IconRepository;
import com.alkemy.challengeAlternativo.icons.repository.specifications.IconSpecification;
import com.alkemy.challengeAlternativo.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {

    //Repo
    private IconRepository iconRepository;
    private IconSpecification iconSpecification;

    //Mapper
    private IconMapper iconMapper;

    @Autowired
    public IconServiceImpl(
            IconRepository iconRepository,
            IconSpecification iconSpecification,
            IconMapper iconMapper) {
        this.iconRepository = iconRepository;
        this.iconSpecification = iconSpecification;
        this.iconMapper = iconMapper;
    }

    public IconDTO save (IconDTO dto){
        IconEntity entity = iconMapper.iconDTO2Entity(dto);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

    public List<IconDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconEntitySet2DTOList(entities, false);
        return result;
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }

    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO (name,date,cities,order);
        List<IconEntity> entities = iconRepository.findAll(iconSpecification.getByFilters(filtersDTO));
        List<IconDTO> dtos = iconMapper.iconEntitySet2DTOList(entities,true);
        return dtos;
    }
}
