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
public class APIBundleController {

	@Autowired
	IAPIBundleService apiBundleService;

	public IAPIBundleService getApiBundleService() {
		return apiBundleService;
	}

	public void setApiBundleService(IAPIBundleService apiBundleService) {
		this.apiBundleService = apiBundleService;
	}

	@RequestMapping(value = "/bundles/{id}", method = RequestMethod.GET)
	public ModelAndView getAPIBundles(ModelAndView model,
			@PathVariable("id") String APIBundleId) {

		return model;
	}

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView home(ModelAndView model) {
		List<APIBundle> apiBundleList = apiBundleService.readAll();
		model.addObject("apiBundleList", apiBundleList);
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public ModelAndView application(ModelAndView model) {
		model.setViewName("application");
		model.addObject("apiBundle", new APIBundle());
		return model;
	}

	@RequestMapping(value = "/bundles", method = RequestMethod.GET)
	public ModelAndView getAPIBundles(ModelAndView model) {

		model.setViewName("applicationTable");

		List<APIBundle> apiBundleList = apiBundleService.readAll();
		model.addObject("apiBundleList", apiBundleList);
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAPIBundle(APIBundle apiBundle, ModelAndView model) {
		apiBundleService.create(apiBundle);

		return "redirect:/bundles";

	}

	@RequestMapping(value = "/modifyBundles", method = RequestMethod.POST)
	public String modifyAPIBundle(APIBundle apiBundle, ModelAndView model) {
		apiBundleService.modify(apiBundle);
		return "redirect:/bundles";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteAPIBundle(APIBundle apiBundle, ModelAndView model) {
		apiBundleService.delete(apiBundle);
		return "redirect:/bundles";
	}
}
