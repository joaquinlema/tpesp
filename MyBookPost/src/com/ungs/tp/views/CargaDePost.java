package com.ungs.tp.views;

import org.hibernate.services.PostService;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
@Theme("valo")
public class CargaDePost extends VerticalLayout implements View {
	
	public static final String NAME = "cargaPost";

	PostService service = new PostService();

	private TextArea txtPost;
	private Window subWindow;

	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setParent(layout);

		Button button = new Button("Crear Post");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				crearWindowPost();
			}
		});
		layout.addComponent(button);

	}

	private void crearWindowPost() {
		subWindow = new Window("");
		subWindow.setWidth("90%");
		VerticalLayout subContent = new VerticalLayout();
		subContent.setMargin(true);
		subWindow.setContent(subContent);
		txtPost = new TextArea("Post");
		//txtPost.setCursorPosition(getScrollLeft());
		txtPost.setMaxLength(300);
		txtPost.setWidth("100%");
		subContent.addComponent(txtPost);

		Button button = new Button("Crear");
		button.addClickListener(new Button.ClickListener() {
			@SuppressWarnings({ "static-access" })
			public void buttonClick(ClickEvent event) {
				try {
					Notification notificador = new Notification("");
					if (validaPost(txtPost.getValue())){
						service.guardarPost(txtPost.getValue());
						subWindow.close();
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
		subWindow.center();
		addWindow(subWindow);

	}

	private void addWindow(Window subWindow2) {
		this.addWindow(subWindow2);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
		
	}

}