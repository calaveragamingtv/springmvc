package ar.com.xxxx.entities.base;

/**
 * <p>Clase abstracta de los BO</p>
 * @author nconde
 * @since 27/03/2017
 *
 */
public abstract class AbstractBO {

	/**
	 * <p>Muestra los valores de las propiedades que tiene el objeto</p>
	 * @author nconde
	 * @since 27/03/2017
	 */
	public  <T> String   printFieldValue()
	{
	    StringBuffer objeto = new StringBuffer();
	    objeto.append("###" + this.getClass().getName() + "###%n");
	    for (final java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
	        field.setAccessible(true);
	        final String name = field.getName();
	        Object value = null;
	        try{
	            value = field.get(this);
	        }catch(Throwable e){}
	        objeto = objeto.append("#Field name: "+ name+ "\t=> "+ value);
	    }
	    return objeto.toString();
	}

}
