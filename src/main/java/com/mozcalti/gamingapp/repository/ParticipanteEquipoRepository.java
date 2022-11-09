package com.mozcalti.gamingapp.repository;

import com.mozcalti.gamingapp.model.ParticipanteEquipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipanteEquipoRepository extends CrudRepository<ParticipanteEquipo, Integer> {

    void deleteByIdEquipo(Integer idEquipo);

    ParticipanteEquipo findByIdParticipante(Integer idParticipante);

}
