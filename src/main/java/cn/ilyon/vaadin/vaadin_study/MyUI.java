package cn.ilyon.vaadin.vaadin_study;

import javax.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;


@Theme("mytheme")
@CDIUI("")
public class MyUI extends UI {
	@Inject
    private CDIViewProvider viewProvider;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("My");
        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);
        navigator.navigateTo("login");
//final VerticalLayout layout = new VerticalLayout();
//        
//        final TextField name = new TextField();
//        name.setCaption("Type your name here:");
//
//        Button button = new Button("Click Me");
//        button.addClickListener( e -> {
//            layout.addComponent(new Label("Thanks " + name.getValue() 
//                    + ", it works!"));
//        });
//        
//        layout.addComponents(name, button);
//        layout.setMargin(true);
//        layout.setSpacing(true);
//        
//        setContent(layout);
    }

   
}
