package util;

import javax.faces.context.FacesContext;

public class JSFHelper {

	public static <T> T findBean(String bean, Class<T> beanClass) {

		FacesContext context = FacesContext.getCurrentInstance();
		T beanObj = context.getApplication().evaluateExpressionGet(
				context, "#{" + bean + "}", beanClass);

		return beanObj;

	}

}
