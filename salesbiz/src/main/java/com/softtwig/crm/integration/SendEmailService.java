package com.softtwig.crm.integration;

import javax.mail.MessagingException;

import com.softtwig.crm.model.EmailModel;

public interface SendEmailService {

	
	public boolean sendEmail(String emailTo, String subject, String message,EmailModel model) throws MessagingException;

	
}
