package com.app.poster.model;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Documentation documentation = new Documentation();
		//documentation.setId(1);
		//documentation.setDocumentName("TestDocument");

		Section section = new Section();
		section.setId(1);
		section.setSectionName("section1");
		section.setSectionDetail("This is section1 details");
		section.setSectionOrder(1);

		Section section2 = new Section();
		section2.setId(1);
		section2.setSectionName("section1");
		section2.setSectionDetail("This is section1 details");
		section2.setSectionOrder(1);

		documentation.getSections().add(section);
		documentation.getSections().add(section2);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Documentation.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter xmlStr = new StringWriter();
			jaxbMarshaller.marshal(documentation, xmlStr);

			System.out.println(xmlStr);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
