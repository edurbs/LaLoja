package com.github.edurbs.laloja.view.incomepayment;

import com.github.edurbs.laloja.entity.IncomePayment;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.genericfilter.GenericFilter;
import io.jmix.flowui.view.*;

@Route(value = "incomePayments", layout = MainView.class)
@ViewController(id = "IncomePayment.list")
@ViewDescriptor(path = "income-payment-list-view.xml")
@LookupComponent("incomePaymentsDataGrid")
@DialogMode(width = "64em")
public class IncomePaymentListView extends StandardListView<IncomePayment> {
    @ViewComponent
    private GenericFilter genericFilter;


}