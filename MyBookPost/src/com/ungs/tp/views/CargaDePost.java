package com.ungs.tp.views;

import org.hibernate.services.PostService;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Theme("valo")
public class CargaDePost extends VerticalLayout implements View {
	
	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "cargaPost";

	PostService service = new PostService();

	private TextArea txtPost;

	public CargaDePost() {
		
		Panel panel = new Panel("Login");
		panel.setSizeUndefined();
		addComponent(panel);

		Button button = new Button("Crear Post");
		button.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				crearWindowPost();
			}
		});
		
		addComponent(button);

	}

	private void crearWindowPost() {
		
		HorizontalLayout subContent = new HorizontalLayout();
		
		txtPost = new TextArea("Post");
		//txtPost.setCursorPosition(getScrollLeft());
		txtPost.setMaxLength(300);
		txtPost.setWidth("100%");
		subContent.addComponent(txtPost);

		Button button = new Button("Crear");
		button.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				try {
					Notification notificador = new Notification("");
					if (validaPost(txtPost.getValue())){
						service.guardarPost(txtPost.getValue());
					}else
						notificador.show("Debe ingresar al menos una letra");
					
				} catch (Exception e) {

					e.printStackTrace();
				}
				
			}

			private boolean validaPost(String value) {
				if (value.trim().isEmpty()) {

					return false;
				}
				return true;
			}
		});

		subContent.addComponent(button);
		addComponent(subContent);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}