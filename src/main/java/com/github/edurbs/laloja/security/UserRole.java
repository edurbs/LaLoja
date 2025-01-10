package com.github.edurbs.laloja.security;

import com.github.edurbs.laloja.entity.*;
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

    @MenuPolicy(menuIds = {"Person.list", "Income.list", "IncomePayment.list", "FinancialAccount.list", "Category.list"})
    @ViewPolicy(viewIds = {"Person.list", "Person.detail", "Income.list", "IncomePayment.list", "FinancialAccount.list", "Category.list", "Category.detail", "FinancialAccount.detail", "Income.detail", "IncomePayment.detail", "MainView", "LoginView"})
    void screens();

    @EntityAttributePolicy(entityClass = Address.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Address.class, actions = EntityPolicyAction.ALL)
    void address();

    @EntityAttributePolicy(entityClass = Person.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Person.class, actions = EntityPolicyAction.ALL)
    void person();

    @EntityAttributePolicy(entityClass = IncomePayment.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = IncomePayment.class, actions = EntityPolicyAction.ALL)
    void incomePayment();

    @EntityAttributePolicy(entityClass = Income.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Income.class, actions = EntityPolicyAction.ALL)
    void income();

    @EntityAttributePolicy(entityClass = Category.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Category.class, actions = EntityPolicyAction.ALL)
    void category();

    @EntityAttributePolicy(entityClass = FinancialAccount.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = FinancialAccount.class, actions = EntityPolicyAction.ALL)
    void financialAccount();
}