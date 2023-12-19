package xyz.rzwn.crmproject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {
    private int roleID;
    private String roleName;
}
