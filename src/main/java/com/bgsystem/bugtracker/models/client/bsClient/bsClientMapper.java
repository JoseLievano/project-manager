package com.bgsystem.bugtracker.models.client.bsClient;

import com.bgsystem.bugtracker.models.client.business.BusinessMapper;
import com.bgsystem.bugtracker.shared.mapper.DefaultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class bsClientMapper implements DefaultMapper <bsClientDTO, bsClientMiniDTO, bsClientForm, bsClientEntity> {

    @Lazy
    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public bsClientDTO toDTO(bsClientEntity entity) {

        if (entity == null)
            return null;

        return bsClientDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .roles(entity.getRoles())
                .username(entity.getUsername())
                .isActive(entity.getIsActive())
                .dateCreated(entity.getDateCreated())
                .lastLoginDate(entity.getLastLogin())
                .business(businessMapper.toSmallDTO(entity.getBusiness()))
                .build();

    }

    @Override
    public bsClientMiniDTO toSmallDTO(bsClientEntity entity) {

        if (entity == null)
            return null;

        return bsClientMiniDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .username(entity.getUsername())
                .isActive(entity.getIsActive())
                .dateCreated(entity.getDateCreated())
                .lastLoginDate(entity.getLastLogin())
                .build();

    }

    @Override
    public bsClientEntity toEntity(bsClientForm form) {

        if (form == null)
            return null;

        return bsClientEntity.bsClientBuilder()
                .id(form.getId())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .username(form.getUsername())
                .password(form.getPassword())
                .isActive(form.getIsActive())
                .dateCreated(form.getDateCreated())
                .lastLogin(form.getLastLoginDate())
                .build();
    }
}
