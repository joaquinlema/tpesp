package com.ungs.tp.views;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class RegistrationPage extends VerticalLayout implements View{
		private static final long serialVersionUID = 1L;
		public static final String NAME = "registration";

		public RegistrationPage(){
			Panel panel = new Panel("Sign Up");
			panel.setSizeUndefined();
			addComponent(panel);

			FormLayout content = new FormLayout();
			
			TextField name = new TextField("Nombre y Apellido");
			name.setIcon(VaadinIcons.USER);
			content.addComponent(name);
			
			TextField email = new TextField("Email");
			email.setIcon(VaadinIcons.MAILBOX);
			content.addComponent(email);
			
			TextField direccion = new TextField("Direccion");
			direccion.setIcon(VaadinIcons.ROAD);
			content.addComponent(direccion);
			
			TextField username = new TextField("Username");
			username.setIcon(VaadinIcons.USER);
			content.addComponent(username);
			
			PasswordField password = new PasswordField("Password");
			password.setIcon(VaadinIcons.PASSWORD);
			content.addComponent(password);
			
			Button send = new Button("Send");
			send.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					//persistir datos a base
				}
				
			});
			
			Button cancel = new Button("Cancel");
			cancel.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					getUI().getNavigator().addView(LoginPage.NAME, LoginPage.class);
					getUI().getNavigator().navigateTo(LoginPage.NAME);
				}
				
			});
			
			HorizontalLayout botonera = new HorizontalLayout();
			botonera.addComponent(send);
			botonera.addComponent(cancel);
			
			content.addComponent(botonera);
			content.setSizeUndefined();
			content.setMargin(true);
			panel.setContent(content);
			setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
		}
		
		@Override
		public void enter(ViewChangeEvent event) {
			
		}

	}

