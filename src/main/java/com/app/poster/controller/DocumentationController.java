package com.app.poster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.poster.model.APIBundle;
import com.app.poster.model.APIDocument;
import com.app.poster.service.IAPIDocumentService;

@Controller
public class DocumentationController {

	@Autowired
	IAPIDocumentService apiDocumentService;

	
	public IAPIDocumentService getApiDocumentService() {
		return apiDocumentService;
	}

	public void setApiDocumentService(IAPIDocumentService apiDocumentService) {
		this.apiDocumentService = apiDocumentService;
	}

	


	@RequestMapping(value = "/documentation", method = RequestMethod.GET)
	public ModelAndView documentation(ModelAndView modelAndView) {

		modelAndView.setViewName("documentation");
		List<APIDocument> apiDocumentList = apiDocumentService.readAll();
		modelAndView.addObject("apiDocumentList", apiDocumentList);
		return modelAndView;
	}
	
	@RequestMapping(value = "/documentation/{applicationId}", method = RequestMethod.GET)
	public ModelAndView documentationPerApplication(ModelAndView modelAndView, @PathVariable("applicationId") Integer applicationId) {
		
		APIBundle apiBundle=new APIBundle();
		apiBundle.setId(applicationId);

		modelAndView.setViewName("documentation");
		List<APIDocument> apiDocumentList = apiDocumentService.readPerApplication(apiBundle);
		modelAndView.addObject("apiDocumentList", apiDocumentList);
		return modelAndView;
	}

}
