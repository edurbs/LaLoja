package com.github.edurbs.laloja.view.income;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "incomes/:id", layout = MainView.class)
@ViewController(id = "Income.detail")
@ViewDescriptor(path = "income-detail-view.xml")
@EditedEntityContainer("incomeDc")
public class IncomeDetailView extends StandardDetailView<Income> {
}