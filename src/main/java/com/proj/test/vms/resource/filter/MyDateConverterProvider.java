/**
 * 
 */
package com.proj.test.vms.resource.filter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.proj.test.vms.resource.MyDate;

/**
 * @author sanjayprasad.burnwal
 *
 */
@Provider
public class MyDateConverterProvider implements ParamConverterProvider {

	public <T> ParamConverter<T> getConverter(final Class<T> rawType, Type genericType, Annotation[] annotations) {
		if(rawType.getName().equals(MyDate.class.getName())) {
			return new ParamConverter<T>() {
				public T fromString(String value) {
					Calendar calendar = Calendar.getInstance();
					if("tomorrow".equalsIgnoreCase(value)) {
						calendar.add(Calendar.DATE, 1);
					} else if("yesterday".equals(value)) {
						calendar.add(Calendar.DATE, -1);
					}
					MyDate date = new MyDate();
					date.setDate(calendar.get(Calendar.DATE));
					date.setMonth(calendar.get(Calendar.MONTH)+1);
					date.setYear(calendar.get(Calendar.YEAR));
					return rawType.cast(date);
				}

				public String toString(T myBean) {
					if(myBean==null) {
						return null;
					}
					return myBean.toString();
				}
			};
		}
		return null;
	}

}
