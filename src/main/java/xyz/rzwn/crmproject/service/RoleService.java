package xyz.rzwn.crmproject.service;

import xyz.rzwn.crmproject.dto.RoleDto;
import xyz.rzwn.crmproject.model.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAllRole();
}
