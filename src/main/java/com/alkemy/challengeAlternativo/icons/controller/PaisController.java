package com.alkemy.challengeAlternativo.icons.controller;

import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<PaisDTO>> getAll(){
        List<PaisDTO> paises = paisService.getAllPaises();
        return ResponseEntity.ok().body(paises);
    }

    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais){
        //guardar pais
        PaisDTO paisSaved = paisService.save(pais);

        //devolver 201 xq fue creado y el pais guardado xq va a tener el id de la BD
        return ResponseEntity.status(HttpStatus.CREATED).body(paisSaved);
    }
}
