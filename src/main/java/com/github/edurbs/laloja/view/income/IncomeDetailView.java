package com.github.edurbs.laloja.view.income;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.flowui.component.datepicker.TypedDatePicker;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.textfieldformatter.NumeralFieldFormatter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Route(value = "incomes/:id", layout = MainView.class)
@ViewController(id = "Income.detail")
@ViewDescriptor(path = "income-detail-view.xml")
@EditedEntityContainer("incomeDc")
public class IncomeDetailView extends StandardDetailView<Income> {
    @ViewComponent
    private TypedDatePicker<LocalDate> referenceDateField;
    @ViewComponent
    private TypedTextField<BigDecimal> totalField;
    @ViewComponent
    private InstanceContainer<Income> incomeDc;
    @Autowired
    private Metadata metadata;

    @Subscribe
    public void onInit(final InitEvent event) {
        new InputMask("00/00/0000").extend(referenceDateField);
        new NumeralFieldFormatter.Builder()
                .delimiter(".")
                .decimalMark(",")
                .decimalScale(2)
                .build()
                .extend(totalField);
    }

    @Subscribe
    public void onInitEntity(final InitEntityEvent<Income> event) {
        event.getEntity().setReferenceDate(LocalDate.now());
    }
}