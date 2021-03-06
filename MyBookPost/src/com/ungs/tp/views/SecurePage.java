package com.ungs.tp.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SecurePage extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;
	private Label secure;
	private Label currentUser;
	private Button otherSecure;
	private Button cargaDePost;
	private Button logout;
	
	public static final String NAME = "Secure";

	public SecurePage() {
		
		otherSecure = new Button("OtherSecure");
		otherSecure.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
			getUI().getNavigator().addView(OtherSecurePage.NAME,OtherSecurePage.class);
			getUI().getNavigator().navigateTo(OtherSecurePage.NAME);
			}
		});

		cargaDePost= new Button("cargaDePost");
		cargaDePost.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
			getUI().getNavigator().addView(CargaDePost.NAME, CargaDePost.class);
			getUI().getNavigator().navigateTo(CargaDePost.NAME);
			}
		});
	
		logout = new Button("Logout");
		logout.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				getUI().getNavigator().removeView(SecurePage.NAME);
				getUI().getNavigator().removeView(OtherSecurePage.NAME);
				getUI().getNavigator().removeView(CargaDePost.NAME);
				
				VaadinSession.getCurrent().setAttribute("user", null);
				getUI().getNavigator().navigateTo(LoginPage.NAME);
			}
		});
		
		secure = new Label("secure");
		currentUser = new Label("Current User");
		addComponent(secure);
		addComponent(currentUser);
		addComponent(otherSecure);
		addComponent(cargaDePost);
		addComponent(logout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		currentUser.setCaption("Current user : " + VaadinSession.getCurrent().getAttribute("user").toString()); 

	}

}
