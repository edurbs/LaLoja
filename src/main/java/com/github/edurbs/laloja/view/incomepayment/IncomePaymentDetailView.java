package com.github.edurbs.laloja.view.incomepayment;

import com.github.edurbs.laloja.entity.IncomePayment;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "incomePayments/:id", layout = MainView.class)
@ViewController(id = "IncomePayment.detail")
@ViewDescriptor(path = "income-payment-detail-view.xml")
@EditedEntityContainer("incomePaymentDc")
public class IncomePaymentDetailView extends StandardDetailView<IncomePayment> {
}