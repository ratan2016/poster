package com.app.poster.controller;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.poster.model.APIBundle;
import com.app.poster.model.APIDocument;
import com.app.poster.model.Documentation;
import com.app.poster.model.Section;
import com.app.poster.service.IAPIBundleService;
import com.app.poster.service.IAPIDocumentService;

@Controller
public class APIDocumentController {

	@Autowired
	IAPIDocumentService apiDocumentService;

	@Autowired
	IAPIBundleService apiBundleService;

	public IAPIDocumentService getApiDocumentService() {
		return apiDocumentService;
	}

	public void setApiDocumentService(IAPIDocumentService apiDocumentService) {
		this.apiDocumentService = apiDocumentService;
	}

	public void setApiBundleService(IAPIBundleService apiBundleService) {
		this.apiBundleService = apiBundleService;
	}

	public IAPIBundleService getApiBundleService() {
		return apiBundleService;
	}

	@RequestMapping(value = "/api", method = RequestMethod.GET)
	public ModelAndView application(ModelAndView model) {
		model.setViewName("apiDocument");
		model.addObject("apiDocument", new APIDocument());
		model.addObject("apiBundleMap", apiBundleMap());
		return model;
	}

	@RequestMapping(value = "/documents/{id}", method = RequestMethod.GET)
	public ModelAndView getAPIDocument(ModelAndView model,
			@PathVariable("id") Integer id) throws JAXBException {
		APIDocument apiDocument = new APIDocument();
		apiDocument.setId(id);
		model.setViewName("document_template");
		APIDocument resultDocument = apiDocumentService.read(apiDocument);
		Documentation documentation = null;
		if (resultDocument.getDocumentContent() != null
				&& !("".equals(resultDocument.getDocumentContent()))) {
			documentation = (Documentation) createDocumentation(resultDocument
					.getDocumentContent());
		}
		resultDocument.setDocumentation(documentation);

		model.addObject("resultDocument", resultDocument);
		return model;
	}

	@RequestMapping(value = "/editor", method = RequestMethod.POST)
	public ModelAndView loadEditor(@RequestBody String jsonString,
			ModelAndView model) throws JSONException, JAXBException {
		JSONObject jsonObject = new JSONObject(jsonString);
		model.setViewName("documentEditor");
		Section section = null;
		String operation = jsonObject.getString("operation");
		if ("createSection".equals(operation)) {
			section = new Section();
		} else {
			APIDocument apiDocument = new APIDocument();
			apiDocument.setId(jsonObject.getInt("applicationId"));
			APIDocument resultDocument = apiDocumentService.read(apiDocument);
			Documentation resultDocumentation = createDocumentation(resultDocument
					.getDocumentContent());

			Integer sectionId = jsonObject.getInt("id");
			Set<Section> sections = resultDocumentation.getSections();
			for (Section sectionResult : sections) {
				if (sectionId.equals(sectionResult.getId())) {
					section = sectionResult;
				}
			}
		}
		model.addObject("section", section);
		model.addObject("operation", operation);
		return model;
	}

	@RequestMapping(value = "/createSection", method = RequestMethod.POST)
	public String createSection(@RequestBody String jsonString)
			throws JSONException, JAXBException {
		JSONObject jsonObject = new JSONObject(jsonString);
		APIDocument apiDocument = new APIDocument();
		apiDocument.setId(jsonObject.getInt("applicationId"));
		APIDocument resultDocument = apiDocumentService.read(apiDocument);
		Documentation resultDocumentation = createDocumentation(resultDocument
				.getDocumentContent());
		resultDocument.setDocumentation(resultDocumentation);

		Documentation documentation = null;
		Section newlyCreatedSection = new Section();
		if (resultDocument.getDocumentation() == null) {
			documentation = new Documentation();
			documentation.setId(resultDocument.getId());
			documentation.setDocumentName(resultDocument.getDocumentName());
			newlyCreatedSection.setId(1);
			newlyCreatedSection.setSectionOrder(1);

		} else {
			documentation = resultDocument.getDocumentation();
			newlyCreatedSection.setSectionOrder(documentation.getSections()
					.size()+1);
			newlyCreatedSection.setId(documentation.getSections()
					.size()+1);
		}

		newlyCreatedSection.setSectionName(jsonObject.getString("sectionName"));
		newlyCreatedSection.setSectionDetail(jsonObject
				.getString("sectionDetail"));

		documentation.getSections().add(newlyCreatedSection);

		String xmlStr = createXmlString(documentation);
		resultDocument.setDocumentContent(xmlStr);
		apiDocumentService.modifyWithContent(resultDocument);

		return "redirect:/documents/"+jsonObject.getInt("applicationId");
	}

	@RequestMapping(value = "/updateSection", method = RequestMethod.POST)
	public String updateSection(@RequestBody String jsonString)
			throws JSONException, JAXBException {
		JSONObject jsonObject = new JSONObject(jsonString);
		APIDocument apiDocument = new APIDocument();
		apiDocument.setId(jsonObject.getInt("applicationId"));
		APIDocument resultDocument = apiDocumentService.read(apiDocument);
		Documentation resultDocumentation = createDocumentation(resultDocument
				.getDocumentContent());

		Integer sectionId = jsonObject.getInt("id");
		Set<Section> sections = resultDocumentation.getSections();
		for (Section section : sections) {
			if (sectionId.equals(section.getId())) {
				section.setSectionDetail(jsonObject.getString("sectionDetail"));
				section.setSectionName(jsonObject.getString("sectionName"));
				section.setSectionOrder(jsonObject.getInt("sectionOrder"));
			}
		}
		resultDocumentation.setSections(sections);
		String xmlStr = createXmlString(resultDocumentation);
		resultDocument.setDocumentContent(xmlStr);
		apiDocumentService.modifyWithContent(resultDocument);

		return "redirect:/documents/"+jsonObject.getInt("applicationId");
	}

	
	@RequestMapping(value = "/deleteSection", method = RequestMethod.POST)
	public String deleteSection(@RequestBody String jsonString)
			throws JSONException, JAXBException {
		JSONObject jsonObject = new JSONObject(jsonString);
		APIDocument apiDocument = new APIDocument();
		apiDocument.setId(jsonObject.getInt("applicationId"));
		APIDocument resultDocument = apiDocumentService.read(apiDocument);
		Documentation resultDocumentation = createDocumentation(resultDocument
				.getDocumentContent());
		
		Integer sectionId = jsonObject.getInt("id");
		Set<Section> sections = resultDocumentation.getSections();
		Set<Section> updatedSections =new TreeSet<Section>();
		for (Section section : sections) {
			if (!sectionId.equals(section.getId())) {
				updatedSections.add(section);
			}
		}
		resultDocumentation.setSections(updatedSections);
		String xmlStr = createXmlString(resultDocumentation);
		resultDocument.setDocumentContent(xmlStr);
		apiDocumentService.modifyWithContent(resultDocument);

		return "redirect:/documents/"+jsonObject.getInt("applicationId");
	}
	
	@RequestMapping(value = "/loadSections/{documentId}", method = RequestMethod.GET)
	public ModelAndView loadSection(ModelAndView model, @PathVariable Integer documentId) throws JAXBException {
		APIDocument apiDocument = new APIDocument();
		apiDocument.setId(documentId);
		model.setViewName("document_template");
		APIDocument resultDocument = apiDocumentService.read(apiDocument);
		Documentation documentation = null;
		if (resultDocument.getDocumentContent() != null
				&& !("".equals(resultDocument.getDocumentContent()))) {
			documentation = (Documentation) createDocumentation(resultDocument
					.getDocumentContent());
		}
		resultDocument.setDocumentation(documentation);

		model.addObject("resultDocument", resultDocument);
		model.setViewName("sort_order");
		return model;
	}

	@RequestMapping(value = "/reorderSections/{applicationId}", method = RequestMethod.POST)
	public String reorderSection(@RequestBody String jsonString,@PathVariable Integer applicationId)
			throws JSONException, JAXBException {
		JSONObject jsonObject = new JSONObject(jsonString);
		APIDocument apiDocument = new APIDocument();
		apiDocument.setId(applicationId);
		APIDocument resultDocument = apiDocumentService.read(apiDocument);
		Documentation resultDocumentation = createDocumentation(resultDocument
				.getDocumentContent());

		Set<Section> sections = resultDocumentation.getSections();
		for (Section section : sections) {
			Integer sectionId=section.getId();
			section.setSectionOrder(jsonObject.getInt(sectionId.toString()));
		}
		resultDocumentation.setSections(sections);
		String xmlStr = createXmlString(resultDocumentation);
		resultDocument.setDocumentContent(xmlStr);
		apiDocumentService.modifyWithContent(resultDocument);

		return "redirect:/documents/"+applicationId;
	}
	
	@RequestMapping(value = "/documents", method = RequestMethod.GET)
	public ModelAndView getAPIDocuments(ModelAndView model) {

		model.setViewName("apiDocumentTable");

		List<APIDocument> apiDocumentList = apiDocumentService.readAll();
		model.addObject("apiDocumentList", apiDocumentList);
		model.addObject("apiBundleMap", apiBundleMap());
		return model;
	}

	@RequestMapping(value = "/addApi", method = RequestMethod.POST)
	public String addAPIDocument(APIDocument apiDocument, ModelAndView model) {
		apiDocumentService.create(apiDocument);

		return "redirect:/documents";

	}

	@RequestMapping(value = "/modifyDocument", method = RequestMethod.POST)
	public String modifyAPIDocument(APIDocument apiDocument, ModelAndView model) {
		apiDocumentService.modify(apiDocument);
		return "redirect:/documents";
	}

	@RequestMapping(value = "/deleteApi", method = RequestMethod.POST)
	public String deleteAPIDocument(APIDocument apiDocument, ModelAndView model) {
		apiDocumentService.delete(apiDocument);
		return "redirect:/documents";
	}

	private Map<Integer, String> apiBundleMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<APIBundle> apiBundleList = apiBundleService.readAll();
		for (APIBundle apiBundle : apiBundleList) {
			map.put(apiBundle.getId(), apiBundle.getBundleName());
		}

		return map;
	}

	private Documentation createDocumentation(String xmlString)
			throws JAXBException {
		if(xmlString==null || "".equals(xmlString)){
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			stringBuffer.append("<documentation></documentation>");
			xmlString=stringBuffer.toString();
		}
		JAXBContext jaxbContext;
		jaxbContext = JAXBContext.newInstance(Documentation.class);
		Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
		Documentation documentation = null;
		documentation = (Documentation) jaxbUnMarshaller
				.unmarshal(new ByteArrayInputStream(xmlString.getBytes()));
		return documentation;
	}

	private String createXmlString(Documentation documentation)
			throws JAXBException {
		JAXBContext jaxbContext;
		StringWriter xmlStr = new StringWriter();
		jaxbContext = JAXBContext.newInstance(Documentation.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(documentation, xmlStr);
		return xmlStr.toString();
	}
}
