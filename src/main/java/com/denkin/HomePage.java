package com.denkin;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.Application;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;
	
	public HomePage(final PageParameters parameters) {
		super(parameters);
		Application.get().getMarkupSettings().getMarkupFactory().getMarkupCache().clear();

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		
		add(new Label("message", "Welcome to my calculator\n"));
		
		final Model<String> resModel = Model.of("0.0");
		final Label resultLabel = new Label("resultLabel", resModel);
		resultLabel.setOutputMarkupId(true);
		add(resultLabel);
		
		final Model<String> inpModel = Model.of("0");
		final TextField<String> inputField = new TextField<String>("inputField", inpModel);
		inputField.setOutputMarkupId(true);
		inputField.add(new AjaxFormComponentUpdatingBehavior("onchange") {
			  protected void onUpdate(AjaxRequestTarget target) {
			      inpModel.setObject(inputField.getValue());
			  }
			});
		add(inputField);


		
		Form form= new Form<Void>("form");
		
		final MyAjaxButton plus = new MyAjaxButton("plus", new Model<String>("+"), "+", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton minus = new MyAjaxButton("minus", new Model<String>("-"), "-", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton multiply = new MyAjaxButton("multiply", new Model<String>("*"), "*", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton divide = new MyAjaxButton("divide", new Model<String>("/"), "/", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton reset = new MyAjaxButton("reset", new Model<String>("C"), "reset", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton delete = new MyAjaxButton("delete", new Model<String>("<-"), "delete", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton comma = new MyAjaxButton("comma", new Model<String>(","), ",", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton changeSgn = new MyAjaxButton("changeSgn", new Model<String>("±"), "±", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton zero = new MyAjaxButton("zero", new Model<String>("0"), "0", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton one = new MyAjaxButton("one", new Model<String>("1"), "1", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton two = new MyAjaxButton("two", new Model<String>("2"), "2", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton three = new MyAjaxButton("three", new Model<String>("3"), "3", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton four = new MyAjaxButton("four", new Model<String>("4"), "4", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton five = new MyAjaxButton("five", new Model<String>("5"), "5", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton six = new MyAjaxButton("six", new Model<String>("6"), "6", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton seven = new MyAjaxButton("seven", new Model<String>("7"), "7", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton eight = new MyAjaxButton("eight", new Model<String>("8"), "8", resModel, inpModel, resultLabel, inputField);
		final MyAjaxButton nine = new MyAjaxButton("nine", new Model<String>("9"), "9", resModel, inpModel, resultLabel, inputField);
    /*    final AjaxButton plus1 = new AjaxButton("plus", new Model<String>("+")) {

            private static final long serialVersionUID = 530608535790823587L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
            	double res = Double.parseDouble(resModel.getObject());
            	String changeS = inpModel.getObject();
            	changeS = changeS.replaceAll(",", ".");
            	System.out.println(changeS);
            	double change = Double.parseDouble(changeS);
            	resModel.setObject(""+(res+change));         	
            	target.add(resultLabel);
            }
            
        };*/
 /*       final AjaxButton minus = new AjaxButton("minus", new Model<String>("-")) {

            private static final long serialVersionUID = 530608535790823587L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
            	double res = Double.parseDouble(resModel.getObject());
            	String changeS = inpModel.getObject();
            	changeS = changeS.replaceAll(",", ".");
            	System.out.println(changeS);
            	double change = Double.parseDouble(changeS);
            	resModel.setObject(""+(res-change));         	
            	target.add(resultLabel);
            }
            
        };*/
   /*     final AjaxButton multiply = new AjaxButton("multiply", new Model<String>("*")) {

            private static final long serialVersionUID = 530608535790823587L;

            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
            	double res = Double.parseDouble(resModel.getObject());
            	String changeS = inpModel.getObject();
            	changeS = changeS.replaceAll(",", ".");
            	System.out.println(changeS);
            	double change = Double.parseDouble(changeS);
            	resModel.setObject(""+(res*change));         	
            	target.add(resultLabel);
            }
            
        };*/
        form.add(plus);
        form.add(minus);
        form.add(multiply);
        form.add(divide);
        form.add(delete);
        form.add(reset);
        form.add(changeSgn);
        form.add(comma);
        form.add(zero);
        form.add(one);
        form.add(two);
        form.add(three);
        form.add(four);
        form.add(five);
        form.add(six);
        form.add(seven);
        form.add(eight);
        form.add(nine);

		add(form);
		// TODO Add your page's components here

    }
	
}
