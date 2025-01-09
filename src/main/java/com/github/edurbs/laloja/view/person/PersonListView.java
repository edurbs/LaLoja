package com.github.edurbs.laloja.view.person;

import com.github.edurbs.laloja.entity.Person;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "persons", layout = MainView.class)
@ViewController(id = "Person.list")
@ViewDescriptor(path = "person-list-view.xml")
@LookupComponent("personsDataGrid")
@DialogMode(width = "64em")
public class PersonListView extends StandardListView<Person> {
}