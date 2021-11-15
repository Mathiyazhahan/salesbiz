/**
 * 
 */
package com.softtwig.crm.utils;

import java.io.FileNotFoundException;

import com.softtwig.crm.service.MySalesResourceBundle;

/**
 * @author Administrator
 * 
 */
public class EmailTemplates {

	public static String activationTemaplate(String name, String emailId)
			throws FileNotFoundException {
		/*final MySalesResourceBundle jobtrolleyResourceBundle = null;*/
		String str =MySalesResourceBundle.getValue("JobSeekerActivation");
		final String bodyContent = "Dear "
				+ name
				+ ","
				+ "\n\n\tClick here to Confirmation Your Registration in Myjobkart:\n"
				+ str
				+ emailId
				+ "\n"
				+ "\n\n\n\n\nRegards,\n Customer Support,\nMyjobkart Consultancy Services.";
		return bodyContent;
	}

}
