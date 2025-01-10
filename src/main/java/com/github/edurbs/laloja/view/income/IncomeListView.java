package com.github.edurbs.laloja.view.income;

import com.github.edurbs.laloja.entity.Income;
import com.github.edurbs.laloja.entity.IncomePayment;
import com.github.edurbs.laloja.entity.Person;
import com.github.edurbs.laloja.view.incomepayment.IncomePaymentDetailView;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import io.jmix.core.Metadata;
import io.jmix.flowui.ViewNavigators;
import io.jmix.flowui.component.grid.DataGrid;
import io.jmix.flowui.component.propertyfilter.PropertyFilter;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.kit.component.button.JmixButton;
import io.jmix.flowui.view.*;
import io.jmix.flowui.view.navigation.ViewNavigator;
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
    @ViewComponent
    private DataGrid<Income> incomesDataGrid;
    @Autowired
    private ViewNavigators viewNavigators;
    @ViewComponent
    private JmixButton payButton;

    @Install(to = "incomesDataGrid.create", subject = "newEntitySupplier")
    private Income incomesDataGridCreateNewEntitySupplier() {
        Person person = personPropertyFilter.getValue();
        Income income = metadata.create(Income.class);
        income.setPerson(person);
        return income;
    }

    @Subscribe("incomesDataGrid.addPayment")
    public void onIncomesDataGridAddPayment(final ActionPerformedEvent event) {
        Income income = incomesDataGrid.getSingleSelectedItem();
        if (income == null ) return ;
        viewNavigators.detailView(this, IncomePayment.class)
                .newEntity()
                .withQueryParameters(QueryParameters.of("income", income.getId().toString()))
                .navigate();

    }

    @Subscribe("incomesDataGrid")
    public void onIncomesDataGridSelection(final SelectionEvent<DataGrid<Income>, Income> event) {
        event.getFirstSelectedItem().ifPresentOrElse(
                income -> payButton.setEnabled(true),
                () -> payButton.setEnabled(false));
    }
}