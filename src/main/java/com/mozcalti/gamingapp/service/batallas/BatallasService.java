package com.mozcalti.gamingapp.service.batallas;

import com.mozcalti.gamingapp.commons.GenericServiceAPI;
import com.mozcalti.gamingapp.exceptions.UtilsException;
import com.mozcalti.gamingapp.exceptions.ValidacionException;
import com.mozcalti.gamingapp.model.BatallaParticipantes;
import com.mozcalti.gamingapp.model.Batallas;
import com.mozcalti.gamingapp.model.batallas.BatallasDTO;
import com.mozcalti.gamingapp.model.batallas.ParticipantesDTO;
import com.mozcalti.gamingapp.model.batallas.RobotParticipanteDTO;
import com.mozcalti.gamingapp.model.catalogos.EtapasDTO;
import com.mozcalti.gamingapp.model.catalogos.InstitucionDTO;
import com.mozcalti.gamingapp.model.catalogos.ParticipanteDTO;

import java.util.List;

public interface BatallasService extends GenericServiceAPI<Batallas, Integer> {
    void ejecutaBatalla();

    RobotParticipanteDTO numeroRobotsActivos(List<BatallaParticipantes> batallaParticipantes);

    List<EtapasDTO> getEtapas() throws ValidacionException;

    List<InstitucionDTO> getInstituciones() throws ValidacionException;

    List<ParticipanteDTO> getParticipantesByIdInstitucion(Integer idInstitucion) throws ValidacionException;

    BatallasDTO generaBatallas(Integer idEtapa, Integer idInstitucion);

    void saveBatallas(BatallasDTO batallasDTO) throws ValidacionException;

    BatallasDTO getBatallas(Integer idEtapa);

    void updateBatallas(BatallasDTO batallasDTO) throws ValidacionException;

    void deleteBatallas(Integer idEtapa) throws ValidacionException;

    void reenvioCorreoBatalla(ParticipantesDTO participantesDTO) throws ValidacionException, UtilsException;

}
