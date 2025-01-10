package com.github.edurbs.laloja.view.income;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "incomes", layout = MainView.class)
@ViewController(id = "Income.list")
@ViewDescriptor(path = "income-list-view.xml")
@LookupComponent("incomesDataGrid")
@DialogMode(width = "64em")
public class IncomeListView extends StandardListView<Income> {
}