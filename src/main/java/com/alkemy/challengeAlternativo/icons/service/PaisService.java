package com.alkemy.challengeAlternativo.icons.service;


import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;

import java.util.List;

public interface PaisService {
    PaisDTO save (PaisDTO dto);
    List<PaisDTO> getAllPaises();
}
