package org.example.dao.custom;



import org.example.dao.CrudDAO;
import org.example.entity.TherapyProgram;

import java.io.IOException;
import java.util.List;

public interface TherapyProgramDAO extends CrudDAO<TherapyProgram> {
    public List<String> getAllIds() throws IOException;
    public List<String> getAssignedTherapists(String programId) throws IOException;
    public List<String> getEnrolledPatients(String programId) throws IOException;
}
