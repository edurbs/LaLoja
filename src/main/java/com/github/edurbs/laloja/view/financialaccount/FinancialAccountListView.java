package com.github.edurbs.laloja.view.financialaccount;

import com.github.edurbs.laloja.entity.FinancialAccount;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "financialAccounts", layout = MainView.class)
@ViewController(id = "FinancialAccount.list")
@ViewDescriptor(path = "financial-account-list-view.xml")
@LookupComponent("financialAccountsDataGrid")
@DialogMode(width = "64em")
public class FinancialAccountListView extends StandardListView<FinancialAccount> {
}