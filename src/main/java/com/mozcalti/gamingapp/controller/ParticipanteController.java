package com.mozcalti.gamingapp.controller;


import com.mozcalti.gamingapp.model.Participantes;
import com.mozcalti.gamingapp.model.dto.ParticipanteDTO;
import com.mozcalti.gamingapp.model.dto.TablaDTO;
import com.mozcalti.gamingapp.model.dto.TablaParticipantesDTO;
import com.mozcalti.gamingapp.service.ParticipantesService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/participante")
@AllArgsConstructor
public class ParticipanteController {

    private ParticipantesService participantesService;


    @PostMapping(value = "/cargarArchivo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParticipanteDTO> cargarArchivo(@RequestParam(value = "file") MultipartFile file) {
        return participantesService.cargarArchivo(file);
    }

    @PostMapping(value = "/guardar")
    public void guardar(@RequestBody List<Participantes> participantes) {
        participantesService.guardarParticipantes(participantes);
    }

    @GetMapping("/todos")
    public TablaDTO<TablaParticipantesDTO> todosParticipantes(@RequestParam String texto, @RequestParam Integer indice){
        return participantesService.listaParticipantes(texto,indice);
    }

    @GetMapping("/{id}")
    public TablaParticipantesDTO obtenerParticipante(@PathVariable Integer id){
        return participantesService.obtenerParticipante(id);
    }
}