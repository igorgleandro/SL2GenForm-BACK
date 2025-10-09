package com.sl2genform.mappers;

import com.sl2genform.dto.MyFormsDTO;
import com.sl2genform.dto.UserDTO;
import com.sl2genform.entities.MyForms;
import com.sl2genform.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {

        if (user == null) {
            return null;
        }


        return  UserDTO.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .theme(user.getTheme())
                .avatar(user.getAvatar())
                .build();

    }

    public List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return User.builder()
                .user_id(userDTO.getUser_id())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .theme(userDTO.getTheme())
                .avatar(userDTO.getAvatar())
                .build();
    }

}