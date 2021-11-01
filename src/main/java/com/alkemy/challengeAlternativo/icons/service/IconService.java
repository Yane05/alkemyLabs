package com.alkemy.challengeAlternativo.icons.service;

import com.alkemy.challengeAlternativo.icons.dto.IconDTO;

import java.util.List;
import java.util.Set;

public interface IconService {
    IconDTO save (IconDTO dto);
    List<IconDTO> getAllIcons();
    void delete(Long id);
    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);
}
