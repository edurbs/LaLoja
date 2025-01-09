package com.github.edurbs.laloja.view.financialaccount;

import com.github.edurbs.laloja.entity.FinancialAccount;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "financialAccounts/:id", layout = MainView.class)
@ViewController(id = "FinancialAccount.detail")
@ViewDescriptor(path = "financial-account-detail-view.xml")
@EditedEntityContainer("financialAccountDc")
public class FinancialAccountDetailView extends StandardDetailView<FinancialAccount> {
}