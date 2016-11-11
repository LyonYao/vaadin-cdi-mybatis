package cn.ilyon.vaadin.vaadin_study;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Qualifier;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import cn.ilyon.vaadin.vaadin_study.services.UserService;

@Theme("mytheme")
@CDIUI("user")
public class UserUI extends UI {
	@Inject
    private CDIViewProvider viewProvider;
	@Inject  @Any @Default  private  UserService userService;//@Named("defaultUserService")
	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
      
      final TextField name = new TextField();
      name.setCaption("Type your name here:");

      Button button = new Button("Click Me");
      button.addClickListener( e -> {
    	  String userName=name.getValue();
    	  try {
			userService.updateName(userName);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
          layout.addComponent(new Label("Thanks " + name.getValue() 
                  + ", it works!"));
      });
      
      layout.addComponents(name, button);
      layout.setMargin(true);
      layout.setSpacing(true);
      
      setContent(layout);
		
	}

}
