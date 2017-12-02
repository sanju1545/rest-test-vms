/**
 * 
 */
package com.proj.test.vms.resource.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 * @author sanjayprasad.burnwal
 *
 */
@Provider
@Produces("text/shortdate") //Custom Media Type
public class DataMessageBodyWriter implements MessageBodyWriter<Date>{

	/**
	 * 
	 */
	public DataMessageBodyWriter() {
		// TODO Auto-generated constructor stub
	}

	public long getSize(Date arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4) {
		return -1;
	}

	public boolean isWriteable(Class<?> rawType, Type arg1, Annotation[] arg2, MediaType arg3) {
		/*if(rawType.getName().equals(Date.class.getName())) {
			return true;
		}
		return false;*/
		return Date.class.isAssignableFrom(rawType);
	}

	public void writeTo(Date date, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> httpHeaders, OutputStream outStream)
			throws IOException, WebApplicationException {
		String dateStr = Calendar.getInstance().getTime().toString();
		outStream.write(dateStr.getBytes());
	}

}
