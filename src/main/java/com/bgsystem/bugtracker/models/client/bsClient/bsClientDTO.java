package com.bgsystem.bugtracker.models.client.bsClient;

import com.bgsystem.bugtracker.models.client.business.BusinessMiniDTO;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class bsClientDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Set<String> roles;

    private String username;

    private Boolean isActive;

    private Date dateCreated;

    private Date lastLoginDate;

    private BusinessMiniDTO business;

}
