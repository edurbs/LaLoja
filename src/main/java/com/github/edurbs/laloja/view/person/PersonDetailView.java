package com.github.edurbs.laloja.view.person;

import com.github.edurbs.laloja.entity.Person;
import com.github.edurbs.laloja.entity.PersonType;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.componentfactory.addons.inputmask.InputMask;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.component.SupportsTypedValue;
import io.jmix.flowui.component.datepicker.TypedDatePicker;
import io.jmix.flowui.component.select.JmixSelect;
import io.jmix.flowui.component.textfield.TypedTextField;
import io.jmix.flowui.model.InstanceContainer;
import io.jmix.flowui.view.*;
import org.vaadin.textfieldformatter.DateFieldFormatter;
import org.vaadin.textfieldformatter.phone.PhoneI18nFieldFormatter;

import java.time.LocalDate;

@Route(value = "persons/:id", layout = MainView.class)
@ViewController(id = "Person.detail")
@ViewDescriptor(path = "person-detail-view.xml")
@EditedEntityContainer("personDc")
public class PersonDetailView extends StandardDetailView<Person> {
    @ViewComponent
    private TypedTextField<String> cellPhoneField;
    @ViewComponent
    private TypedTextField<String> docIdField;
    @ViewComponent
    private TypedTextField<String> phoneField;
    @ViewComponent
    private TypedDatePicker<LocalDate> birthDateField;
    @ViewComponent
    private JmixSelect<PersonType> personTypeField;
    @ViewComponent
    private TypedTextField<String> addressZipCodeField;
    @ViewComponent
    private InstanceContainer<Person> personDc;

    @Subscribe
    public void onInit(final InitEvent event) {
        new InputMask("00000-000").extend(addressZipCodeField);
        new InputMask("00/00/0000").extend(birthDateField);
        new PhoneI18nFieldFormatter(PhoneI18nFieldFormatter.REGION_BR).extend(cellPhoneField);
        new PhoneI18nFieldFormatter(PhoneI18nFieldFormatter.REGION_BR).extend(phoneField);
        birthDateField.setMin(LocalDate.now().minusYears(100));
        birthDateField.setMax(LocalDate.now().plusDays(7));
    }

    @Subscribe("personTypeField")
    public void onPersonTypeFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<JmixSelect<PersonType>, PersonType> event) {
        PersonType personType = event.getValue();
        if(personType.equals(PersonType.NATURAL)){
            changeToNaturalPerson();
        }else{
            changeToLegalPerson();
        }
    }

    private void changeToNaturalPerson() {
        docIdField.setLabel("CPF");
        new InputMask(("000.000.000-00")).extend(docIdField);
        birthDateField.setLabel("Data de Nascimento");
    }

    private void changeToLegalPerson() {
        docIdField.setLabel("CNPJ");
        new InputMask(("00.000.000/0000-00")).extend(docIdField);
        birthDateField.setLabel("Data de Fundação");
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        if (personDc.getItem().getPersonType() == null){
            personDc.getItem().setPersonType(PersonType.NATURAL);
        }
    }

}