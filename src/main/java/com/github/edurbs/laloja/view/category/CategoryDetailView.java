package com.github.edurbs.laloja.view.category;

import com.github.edurbs.laloja.entity.Category;
import com.github.edurbs.laloja.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "categories/:id", layout = MainView.class)
@ViewController(id = "Category.detail")
@ViewDescriptor(path = "category-detail-view.xml")
@EditedEntityContainer("categoryDc")
public class CategoryDetailView extends StandardDetailView<Category> {
}