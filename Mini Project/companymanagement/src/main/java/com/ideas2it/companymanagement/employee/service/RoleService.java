package com.ideas2it.companymanagement.employee.service;

import com.ideas2it.companymanagement.employee.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto addRole(RoleDto roleDto);

    List<RoleDto> getRoleDetails();

    RoleDto getRoleDetailsById(int id);

    boolean deleteRoleDetailsById(int id);

    RoleDto updateRoleDetails(RoleDto roleDto);
}
