package org.example.dao.custom;



import org.example.dao.CrudDAO;
import org.example.entity.Patient;

import java.io.IOException;
import java.util.List;

public interface PatientDAO extends CrudDAO<Patient> {
    public List<String> getAllIds() throws IOException;
    public List<String> getEnrolledPrograms(String patientId) throws IOException;
}
