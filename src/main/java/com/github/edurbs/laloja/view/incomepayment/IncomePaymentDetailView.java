package com.github.edurbs.laloja.view.incomepayment;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.entity.IncomePayment;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.Metadata;
import io.jmix.flowui.component.datepicker.TypedDatePicker;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.textfieldformatter.NumeralFieldFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Route(value = "incomePayments/:id", layout = MainView.class)
@ViewController(id = "IncomePayment.detail")
@ViewDescriptor(path = "income-payment-detail-view.xml")
@EditedEntityContainer("incomePaymentDc")
public class IncomePaymentDetailView extends StandardDetailView<IncomePayment> {
    @ViewComponent
    private TypedDatePicker<Date> paymentDateField;

    @ViewComponent
    private TypedTextField<BigDecimal> totalField;
    @Autowired
    private Metadata metadata;
    @Autowired
    private DataManager dataManager;

    private Income income;
    @ViewComponent
    private EntityPicker<Income> incomeField;

    @Subscribe
    public void onInit(final InitEvent event) {
        new InputMask("00/00/0000").extend(paymentDateField);
        paymentDateField.setValue(LocalDate.now());
        new NumeralFieldFormatter.Builder()
                .delimiter(".")
                .decimalMark(",")
                .decimalScale(2)
                .build()
                .extend(totalField);
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        incomeField.setValue(income);
    }

    @Subscribe
    public void onInitEntity(final InitEntityEvent<IncomePayment> event) {
        event.getEntity().setPaymentDate(LocalDate.now());
    }

    @Subscribe
    public void onQueryParametersChange(final QueryParametersChangeEvent event) {
        List<String> messageParams = event.getQueryParameters().getParameters().get("income");
        if (messageParams != null && !messageParams.isEmpty()) {
            String uuid = messageParams.getFirst();
            this.income = dataManager.load(Income.class).id(UUID.fromString(uuid)).one();
        }
    }



    
}