package com.denkin;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class MyAjaxButton extends AjaxButton{
	String action;
	Model<String> sourceModel;
	Model<String> targetModel;
	Label resL;
	TextField<String> sourceF;
	public MyAjaxButton(String id, Model<String> m, String action, Model<String> targetModel, Model<String> sourceModel, Label resL, TextField<String> sourceF) {
		super(id, m);
		this.sourceModel = sourceModel;
		this.targetModel = targetModel;
		this.action = action;
		this.resL = resL;
		this.sourceF = sourceF;
	}

	protected void onSubmit(final AjaxRequestTarget target, final Form<?> form) {
		String src = sourceModel.getObject();
		String trgt = targetModel.getObject();
		if (action.length()==1 && Character.isDigit(action.charAt(0))){
			if (src.equals("0")){
				sourceModel.setObject(action);   
			}
			else{
				sourceModel.setObject(src+action);  
			}
			target.add(sourceF);
		}
		else{
			double res = Double.parseDouble(trgt);
			double change;
			try {
				String changeS = src;
				changeS = changeS.replaceAll(",", ".");
				System.out.println(changeS);
				change = Double.parseDouble(changeS);
			}
			catch (NumberFormatException e){
				change = 0;
			}

			switch(action){
			case "+" : targetModel.setObject(""+(res+change)); sourceModel.setObject("0"); break;
			case "-" : targetModel.setObject(""+(res-change)); sourceModel.setObject("0"); break;
			case "*" : targetModel.setObject(""+(res*change)); sourceModel.setObject("0"); break;
			case "/" : targetModel.setObject(""+(res/change)); sourceModel.setObject("0"); break;
			case "reset" : targetModel.setObject("0"); sourceModel.setObject("0"); break;
			case "delete" : deleteSymbol(); break;
			case "," : if(!src.contains(",")) sourceModel.setObject(src+","); break;
			case "±" : if(!(trgt.charAt(0)=='-')) targetModel.setObject("-"+trgt);
						else targetModel.setObject(trgt.substring(1,trgt.length())); break;
			}    
			target.add(sourceF);
			target.add(resL);
		}
	}
	
	private void deleteSymbol(){
		String src = sourceModel.getObject();
		if (src.length()==1)
			sourceModel.setObject("0");
		else
			sourceModel.setObject(src.substring(0, src.length()-1));
	}
}

