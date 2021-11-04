package com.alkemy.challengeAlternativo.icons.service;


import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;

import java.util.List;
import java.util.Set;

public interface PaisService {
    PaisDTO save(PaisDTO dto);

    List<PaisDTO> getAllPaises();

    void delete(Long id);

    List<PaisDTO> getByFilters(String name, Set<Long> idContinente, String order);

    PaisEntity getEntityById(Long id);

    PaisDTO update(Long id, PaisDTO paisDTO);
}
