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

//    private final InputMask phoneMaskSmall = new InputMask("(00)0000-00000");
//    private final InputMask phoneMaskFull = new InputMask("(00)00000-0000");
//    private final InputMask cellPhoneMaskSmall = new InputMask("(00)0000-00000");
//    private final InputMask cellPhoneMaskFull = new InputMask("(00)00000-0000");

    @Subscribe
    public void onInit(final InitEvent event) {
        new InputMask("00000-000").extend(addressZipCodeField);
        new InputMask("00/00/0000").extend(birthDateField);
//        setPhoneMask(false);
//        setCellPhoneMask(false);
        new PhoneI18nFieldFormatter(PhoneI18nFieldFormatter.REGION_BR).extend(cellPhoneField);
        new PhoneI18nFieldFormatter(PhoneI18nFieldFormatter.REGION_BR).extend(phoneField);
        birthDateField.setMin(LocalDate.now().minusYears(100));
        birthDateField.setMax(LocalDate.now().plusDays(7));
    }
//
//    private void setPhoneMask(boolean fullSize) {
//        if(fullSize){
//            phoneMaskFull.extend(phoneField);
//        }else{
//            phoneMaskSmall.extend(phoneField);
//        }
//    }
//
//    private void setCellPhoneMask(boolean fullSize) {
//        if(fullSize){
//            cellPhoneMaskFull.extend(cellPhoneField);
//        }else{
//            cellPhoneMaskSmall.extend(cellPhoneField);
//        }
//    }
//
//    @Subscribe("phoneField")
//    public void onPhoneFieldTypedValueChange(final SupportsTypedValue.TypedValueChangeEvent<TypedTextField<String>, String> event) {
//        String value = event.getValue();
//        setPhoneMask(isPhoneSizeFull(value));
//    }
//
//    @Subscribe("cellPhoneField")
//    public void onCellPhoneFieldTypedValueChange(final SupportsTypedValue.TypedValueChangeEvent<TypedTextField<String>, String> event) {
//        String value = event.getValue();
//        setCellPhoneMask(isPhoneSizeFull(value));
//    }
//
//    @Subscribe("cellPhoneField")
//    public void onCellPhoneFieldKeyPress(final KeyPressEvent event) {
//        String value = cellPhoneField.getValue();
//        setCellPhoneMask(isPhoneSizeFull(value));
//    }
//
//    @Subscribe("cellPhoneField")
//    public void onCellPhoneFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<TypedTextField<String>, String> event) {
//        String value = event.getValue();
//        setCellPhoneMask(isPhoneSizeFull(value));
//        String newValue = event.getSource().getValue();
//        event.getSource().executeValidators();
//    }
//
//
//    private boolean isPhoneSizeFull(String value) {
//        if(value == null) return false;
//        int length = value.length();
//        return length > 13;
//    }

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
        //docIdField.setPlaceholder("000.000.000-00");
        new InputMask(("000.000.000-00")).extend(docIdField);
        birthDateField.setLabel("Data de Nascimento");
    }

    private void changeToLegalPerson() {
        docIdField.setLabel("CNPJ");
        //docIdField.setPlaceholder("00.000.000/0000-00");
        new InputMask(("00.000.000/0000-00")).extend(docIdField);
        birthDateField.setLabel("Data de Fundação");
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        if (personDc.getItem().getPersonType() == null){
            personDc.getItem().setPersonType(PersonType.NATURAL);
        }
    }

    // TODO CPF/CNPJ validation


}