package com.github.edurbs.laloja.security;

import com.github.edurbs.laloja.entity.Address;
import com.github.edurbs.laloja.entity.Person;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "UserRole", code = UserRole.CODE, scope = "UI")
public interface UserRole {
    String CODE = "user-role";

    @MenuPolicy(menuIds = "Person.list")
    @ViewPolicy(viewIds = {"Person.list", "Person.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Address.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Address.class, actions = EntityPolicyAction.ALL)
    void address();

    @EntityAttributePolicy(entityClass = Person.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Person.class, actions = EntityPolicyAction.ALL)
    void person();
}