package com.github.edurbs.laloja.view.income;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.entity.Person;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.flowui.component.propertyfilter.PropertyFilter;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "incomes", layout = MainView.class)
@ViewController(id = "Income.list")
@ViewDescriptor(path = "income-list-view.xml")
@LookupComponent("incomesDataGrid")
@DialogMode(width = "64em")
public class IncomeListView extends StandardListView<Income> {
    @ViewComponent
    private PropertyFilter<Person> personPropertyFilter;
    @Autowired
    private Metadata metadata;

    @Install(to = "incomesDataGrid.create", subject = "newEntitySupplier")
    private Income incomesDataGridCreateNewEntitySupplier() {
        Person person = personPropertyFilter.getValue();
        Income income = metadata.create(Income.class);
        income.setPerson(person);
        return income;
    }
}