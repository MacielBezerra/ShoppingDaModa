package br.com.messages;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * @author Maciel B
 *
 */
public class Config {
	//Classe reponsável por ler o conteúdo do arquivo properties
	private static final String BUNDLE_NAME = "br.com.messages.mensagens";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private Config(){

	}
	public static String getString(String key){
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!'+key	+'!';
		}
	}
}
