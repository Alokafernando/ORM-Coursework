package org.example.bo.custom.impl;

import org.example.bo.custom.PaymentBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.PatientDAO;
import org.example.dao.custom.PaymentDAO;
import org.example.dto.PatientDTO;
import org.example.dto.PaymentDTO;
import org.example.entity.Patient;
import org.example.entity.Payment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentBOImpl implements PaymentBO {
    PaymentDAO paymentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PAYMENT);
    PatientDAO patientDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return paymentDAO.getNextId();
    }

    @Override
    public boolean save(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException, IOException {
        // Convert PatientDTO → Patient entity
        Patient patient = patientDAO.findById(paymentDTO.getPatient().getPId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Payment payment = new Payment(
                paymentDTO.getPayId(),
                paymentDTO.getAmount(),
                paymentDTO.getPaymentDate(),
                paymentDTO.getPaymentMethod(),
                paymentDTO.getStatus(),
                patient   // ✅ pass entity
        );

        return paymentDAO.save(payment);
    }

    @Override
    public List<PaymentDTO> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        List<Payment> payments = paymentDAO.getAll();
        for (Payment payment : payments) {
            paymentDTOS.add(new PaymentDTO(
                    payment.getPayId(),
                    payment.getAmount(),
                    payment.getPaymentDate(),
                    payment.getPaymentMethod(),
                    payment.getStatus(),
                    payment.getPatient() != null
                            ? new PatientDTO(payment.getPatient().getPId(), payment.getPatient().getName(), payment.getPatient().getPhone(), payment.getPatient().getEmail(), payment.getPatient().getStatus())
                            : null
            ));
        }
        return paymentDTOS;
    }


    @Override
    public boolean update(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        return paymentDAO.update(new Payment(paymentDTO.getPayId(), paymentDTO.getAmount(), paymentDTO.getPaymentDate(), paymentDTO.getPaymentMethod(), paymentDTO.getStatus()));
    }

    @Override
    public boolean delete(String paymentId) throws SQLException, ClassNotFoundException {
        return paymentDAO.deleteById(paymentId);
    }

    @Override
    public Optional<PaymentDTO> findById(String selectedPaymentId) throws SQLException, ClassNotFoundException, IOException {
        Optional<Payment> paymentOpt = paymentDAO.findById(selectedPaymentId);
        return paymentOpt.map(payment -> new PaymentDTO(payment.getPayId(), payment.getAmount(), payment.getPaymentDate(), payment.getPaymentMethod(), payment.getStatus()));
    }
}
