package com.github.edurbs.laloja.view.financialaccount;

import com.github.edurbs.laloja.entity.FinancialAccount;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.datepicker.TypedDatePicker;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.view.*;
import org.vaadin.textfieldformatter.NumeralFieldFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Route(value = "financialAccounts/:id", layout = MainView.class)
@ViewController(id = "FinancialAccount.detail")
@ViewDescriptor(path = "financial-account-detail-view.xml")
@EditedEntityContainer("financialAccountDc")
public class FinancialAccountDetailView extends StandardDetailView<FinancialAccount> {
    @ViewComponent
    private TypedDatePicker<LocalDate> balanceDateField;

    @ViewComponent
    private TypedTextField<BigDecimal> balanceField;

    @Subscribe
    public void onInit(final InitEvent event) {
        new InputMask("00/00/0000").extend(balanceDateField);
        balanceDateField.setValue(LocalDate.now());
        new NumeralFieldFormatter.Builder()
                .delimiter(".")
                .decimalMark(",")
                .decimalScale(2)
                .build()
                .extend(balanceField);
    }
}