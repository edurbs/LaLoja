package com.github.edurbs.laloja.view.incomepayment;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.entity.IncomePayment;
import com.github.edurbs.laloja.view.income.IncomeDetailView;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.Router;
import io.jmix.core.Metadata;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.action.list.CreateAction;
import io.jmix.flowui.component.propertyfilter.PropertyFilter;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "incomePayments", layout = MainView.class)
@ViewController(id = "IncomePayment.list")
@ViewDescriptor(path = "income-payment-list-view.xml")
@LookupComponent("incomePaymentsDataGrid")
@DialogMode(width = "64em")
public class IncomePaymentListView extends StandardListView<IncomePayment> {
    @ViewComponent
    private PropertyFilter<Income> incomePropertyFilter;
    @Autowired
    private Metadata metadata;

    @Install(to = "incomePaymentsDataGrid.create", subject = "newEntitySupplier")
    private IncomePayment incomePaymentsDataGridCreateNewEntitySupplier() {
        IncomePayment incomePayment = metadata.create(IncomePayment.class);
        incomePayment.setIncome(incomePropertyFilter.getValue());
        return incomePayment;
    }

}