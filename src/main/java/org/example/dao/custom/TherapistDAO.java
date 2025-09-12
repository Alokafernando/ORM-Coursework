package org.example.dao.custom;



import org.example.dao.CrudDAO;
import org.example.entity.Therapist;

import java.io.IOException;
import java.util.List;

public interface TherapistDAO extends CrudDAO<Therapist> {
    public List<String> getAllIds() throws IOException;
}
