package org.example.bo.custom;



import org.example.bo.SuperBO;
import org.example.dto.PaymentDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PaymentBO extends SuperBO {
    public String getNextId() throws SQLException, ClassNotFoundException;
    public boolean save(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException, IOException;
    public List<PaymentDTO> getAll() throws SQLException, ClassNotFoundException, IOException;
    public boolean update(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException;
    public boolean delete(String paymentId) throws SQLException, ClassNotFoundException;
    public Optional<PaymentDTO> findById(String selectedPaymentId) throws SQLException, ClassNotFoundException, IOException;
}
