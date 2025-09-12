package org.example.bo.custom.impl;

import org.example.bo.custom.TherapySessionBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.TherapySessionDAO;
import org.example.dto.TherapySessionDTO;
import org.example.entity.TherapySession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TherapySessionBOImpl implements TherapySessionBO {
    TherapySessionDAO therapySessionDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_SESSION);

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return therapySessionDAO.getNextId();
    }

    @Override
    public boolean save(TherapySessionDTO therapySessionDTO) throws SQLException, ClassNotFoundException {
        return therapySessionDAO.save(new TherapySession(therapySessionDTO.getTsId(), therapySessionDTO.getSessionDate()));
    }

    @Override
    public List<TherapySessionDTO> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<TherapySessionDTO> therapySessionDTOS = new ArrayList<>();
        List<TherapySession> therapySessions = therapySessionDAO.getAll();
        for (TherapySession therapySession : therapySessions) {
            therapySessionDTOS.add(new TherapySessionDTO(therapySession.getTsId(), therapySession.getSessionDate()));
        }
        return therapySessionDTOS;
    }

    @Override
    public boolean update(TherapySessionDTO therapySessionDTO) throws SQLException, ClassNotFoundException {
        return therapySessionDAO.update(new TherapySession(therapySessionDTO.getTsId(), therapySessionDTO.getSessionDate()));
    }

    @Override
    public boolean delete(String therapySessionId) throws SQLException, ClassNotFoundException {
        return therapySessionDAO.deleteById(therapySessionId);
    }

    @Override
    public Optional<TherapySessionDTO> findById(String selectedTherapySessionId) throws SQLException, ClassNotFoundException, IOException {
        Optional<TherapySession> therapySessionOpt = therapySessionDAO.findById(selectedTherapySessionId);
        return therapySessionOpt.map(therapySession -> new TherapySessionDTO(therapySession.getTsId(), therapySession.getSessionDate()));
    }
}
