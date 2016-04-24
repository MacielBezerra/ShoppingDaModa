package br.com.messages;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.entity.Estado;

@FacesConverter(value="clienteConverter")
public class ClienteConverter  implements Converter{
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		System.out.println("entrei1");
		if (value != null && !value.isEmpty()) {
			System.out.println("entrei2");
			return (Estado)component.getAttributes().get(value);
		}
		return null;
	}
	public String getAsString(FacesContext ctx, UIComponent component, Object value) {
		System.out.println("entrei3");
		if (value instanceof Estado) {
			System.out.println("entrei4");
			Estado estado = (Estado)value;
			if(estado instanceof Estado && estado.getChaveEstado() != null){
				System.out.println("entrei5");
				component.getAttributes().put(estado.getChaveEstado().toString(),estado);
				return estado.getChaveEstado().toString();
			}
		}
		return "";
	} 
}
