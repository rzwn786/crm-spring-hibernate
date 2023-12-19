package xyz.rzwn.crmproject.service.impl;

import org.springframework.stereotype.Service;
import xyz.rzwn.crmproject.dto.RoleDto;
import xyz.rzwn.crmproject.model.Role;
import xyz.rzwn.crmproject.repository.RoleRepository;
import xyz.rzwn.crmproject.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){this.roleRepository = roleRepository;};

    @Override
    public List<RoleDto> findAllRole() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map((role) -> mapToRoleDTO(role)).collect(Collectors.toList());
    }

    private RoleDto mapToRoleDTO(Role role) {
        RoleDto roleDto = RoleDto.builder()
                .roleID(role.getRoleID())
                .roleName(role.getRoleName())
                .build();
        return roleDto;
    }
}
