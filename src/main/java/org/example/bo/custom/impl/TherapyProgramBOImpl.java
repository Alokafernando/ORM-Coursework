package org.example.bo.custom.impl;


import org.example.bo.custom.TherapyProgramBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.TherapyProgramDAO;
import org.example.dto.TherapyProgramDTO;
import org.example.entity.TherapyProgram;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TherapyProgramBOImpl implements TherapyProgramBO {
    TherapyProgramDAO therapyProgramDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return therapyProgramDAO.getNextId();
    }

    @Override
    public boolean save(TherapyProgramDTO therapyProgramDTO) throws SQLException, ClassNotFoundException {
        return therapyProgramDAO.save(new TherapyProgram(therapyProgramDTO.getProgramId(), therapyProgramDTO.getName(), therapyProgramDTO.getDurationInWeeks(), therapyProgramDTO.getCost()));
    }

    @Override
    public List<TherapyProgramDTO> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<TherapyProgramDTO> therapyProgramDTOS = new ArrayList<>();
        List<TherapyProgram> therapyPrograms = therapyProgramDAO.getAll();
        for (TherapyProgram therapyProgram : therapyPrograms) {
            therapyProgramDTOS.add(new TherapyProgramDTO(therapyProgram.getProgramId(), therapyProgram.getName(), therapyProgram.getDurationInWeeks(), therapyProgram.getCost()));
        }
        return therapyProgramDTOS;
    }

    @Override
    public boolean update(TherapyProgramDTO therapyProgramDTO) throws SQLException, ClassNotFoundException {
        return therapyProgramDAO.update(new TherapyProgram(therapyProgramDTO.getProgramId(), therapyProgramDTO.getName(), therapyProgramDTO.getDurationInWeeks(), therapyProgramDTO.getCost()));
    }

    @Override
    public boolean delete(String therapyProgramId) throws SQLException, ClassNotFoundException {
        return therapyProgramDAO.deleteById(therapyProgramId);
    }

    @Override
    public Optional<TherapyProgramDTO> findById(String selectedTherapyProgramId) throws SQLException, ClassNotFoundException, IOException {
        Optional<TherapyProgram> therapyProgramOpt = therapyProgramDAO.findById(selectedTherapyProgramId);
        return therapyProgramOpt.map(therapyProgram -> new TherapyProgramDTO(therapyProgram.getProgramId(), therapyProgram.getName(), therapyProgram.getDurationInWeeks(), therapyProgram.getCost()));
    }

    @Override
    public List<String> getAllIds() throws SQLException, ClassNotFoundException, IOException {
        return therapyProgramDAO.getAllIds();
    }
}
