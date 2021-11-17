package com.softtwig.crm.integration;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.softtwig.crm.dao.AdminDAO;
import com.softtwig.crm.model.EmailModel;

@SuppressWarnings("deprecation")
@Service("emailManager")
public class SendEmailServiceImpl implements SendEmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private VelocityEngine velocityEngine;

	private static final Logger LOGGER = Logger
			.getLogger(SendEmailServiceImpl.class);

	Map<String, Object> modelValue = null;

	@Override
	public boolean sendEmail(final String toEmail, final String subjects,
			final String messageContent, final EmailModel model)
			throws MessagingException {
		LOGGER.info("Confirmation email sent with out attachment:" + toEmail);
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage,
						true);
				message.setTo(toEmail);
				message.setFrom("Support@myjobkart.com");
				message.setSubject(subjects);
				message.setSentDate(new Date());
				File file = null;
				String imgPathName = null;
				File jobseekerFile = null;
			
				List<String> imgNameList = adminDAO.getImageName();
				String text = getTemplate(messageContent, model,imgNameList);
				message.setText(text, true);
				 
				if (jobseekerFile.exists()) {
					
					if(null != imgNameList && 0 != imgNameList.size()){
						long count = 0;
						for(String companyName : imgNameList){
							count = count +1;
							
							String[] companyImageName = companyName.split(",");
							
							if(null ==companyImageName[0]){
								companyImageName[0] = "companylogo.jpg";
							}
							
					File f = new File(imgPathName + companyImageName[0]);
					message.addInline("jobkart"+count, f);
						}
					}
					FileSystemResource res = new FileSystemResource(file);
					FileSystemResource jobseekerRes = new FileSystemResource(jobseekerFile);
					message.addInline("jobseekerImage", jobseekerRes);
					message.addInline("imagess", res);
					
				}
			}
		};
		try {
			mailSender.send(preparator);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
	
	private String getTemplate(String bodyContent, EmailModel model,List<String> imgNameList) {
		String templateContent = null;
		
		// Job Seeker Register Activation Email Template
		//if (EmailCodes.EMPLOYER_VERIFICATION_MAIL.endsWith(bodyContent)) {
			modelValue = new HashMap<String, Object>();
			if(null != imgNameList && 0 != imgNameList.size()){
				long count = 0;
				for(String companyName : imgNameList){
					count = count +1;
					
					String[] companyImageName = companyName.split(",");
					if(null !=companyImageName[1]){
					modelValue.put("url"+count, model.getUrl()+companyImageName[1]+"&&search=true");
					}
				}
			}
			
			modelValue.put("fname", model.getFirstname());
			modelValue.put("email", model.getEmail());
			//modelValue.put("web", model.getWebSite());
			templateContent = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, "velocity/invitation.vm", "UTF-8",
					modelValue);
		//}
		return templateContent;
	}


}