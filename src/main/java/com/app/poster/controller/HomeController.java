package com.app.poster.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.poster.model.APIBundle;
import com.app.poster.service.IAPIBundleService;

@Controller
public class HomeController {

	@Autowired
	IAPIBundleService apiBundleService;

	public IAPIBundleService getApiBundleService() {
		return apiBundleService;
	}

	public void setApiBundleService(IAPIBundleService apiBundleService) {
		this.apiBundleService = apiBundleService;
	}

	

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		List<APIBundle> apiBundleList = apiBundleService.readAll();
		model.addObject("apiBundleList", apiBundleList);
		model.setViewName("index");
		return model;
	}

}
