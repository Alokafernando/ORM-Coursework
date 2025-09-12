package org.example.bo.custom.impl;

import org.example.bo.custom.UserBO;
import org.example.dao.DAOFactory;
import org.example.dao.custom.UserDAO;
import org.example.dto.UserDTO;
import org.example.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOType.USER);

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return userDAO.getNextId();
    }

    @Override
    public boolean save(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(userDTO.getUserId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getRole()));
    }

    @Override
    public List<UserDTO> getAll() throws SQLException, ClassNotFoundException, IOException {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<User> users = userDAO.getAll();
        for (User user : users) {
            userDTOs.add(new UserDTO(user.getUserId(), user.getName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getPassword(), user.getRole()));
        }
        return userDTOs;
    }

    @Override
    public boolean update(UserDTO userDTO) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(userDTO.getUserId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhone(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getRole()));
    }

    @Override
    public boolean delete(String userId) throws SQLException, ClassNotFoundException {
        return userDAO.deleteById(userId);
    }

    @Override
    public Optional<UserDTO> findById(String selectedUserId) throws SQLException, ClassNotFoundException, IOException {
        Optional<User> userOpt = userDAO.findById(selectedUserId);
        return userOpt.map(user -> new UserDTO(user.getUserId(), user.getName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getPassword(), user.getRole()));
    }

}
