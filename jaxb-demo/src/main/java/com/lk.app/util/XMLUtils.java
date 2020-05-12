package com.lk.app.util;

import com.lk.app.formatter.JaxbDateFormatter;
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.XMLWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLUtils {

	public static JAXBContext getJAXBContext(Object obj) throws JAXBException {
		JAXBContext jaxbContext = null;

		return JAXBContext.newInstance(obj.getClass());
	}

	/**
	 * 使用jaxb将对象转换为xml字符串
	 * @param obj
	 * @return
	 */
	public static String objToXML(Object obj) throws JAXBException {
		JAXBContext jaxbContext = getJAXBContext(obj);
		StringWriter writer = new StringWriter();

		Marshaller marshaller = jaxbContext.createMarshaller();
		//设置编码格式
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		//设置否是格式化xml
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//是否省略头信息
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		//设置schema约束的命名空间
		marshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", new NamespacePrefixMapper() {
			@Override
			public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
				if (XMLSchemaDict.NAMESPACE_S1.equals(namespaceUri)) {
					return XMLSchemaDict.NAMESPACE_S1_PREFIX;
				}
				if (XMLSchemaDict.NAMESPACE_S2.equals(namespaceUri)) {
					return XMLSchemaDict.NAMESPACE_S2_PREFIX;
				}
				return suggestion;
			}
		});

		marshaller.setAdapter(new JaxbDateFormatter.MillisecondDateFormatter());
		marshaller.setAdapter(new JaxbDateFormatter.YearDateFormatter());

		marshaller.marshal(obj, writer);

		return writer.toString();
	}

	/**
	 * 使用jaxb将字符串转换为对象
	 * @param xmlStr
	 * @param obj
	 * @return
	 */
	public static Object xmlToObj(String xmlStr,Object obj) throws JAXBException {
		JAXBContext jaxbContext = getJAXBContext(obj);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(xmlStr);

		return unmarshaller.unmarshal(reader);
	}

	/**
	 * 将xml字符串转为Document对象
	 * @param xmlStr
	 * @return
	 * @throws DocumentException
	 */
	public static Document strToDoc(String xmlStr) throws DocumentException {
		return DocumentHelper.parseText(xmlStr);
	}

	/**
	 * 生产xml文件
	 * @param document
	 * @param path
	 * @throws IOException
	 */
	public static void generatorFile(Document document, String path) throws IOException {
		XMLWriter xmlWriter = new XMLWriter(new FileWriter(path));
		xmlWriter.write(document);
		xmlWriter.close();
	}

	/**
	 * 生产xml文件
	 * @param xmlStr
	 * @param path
	 * @throws IOException
	 */
	public static void generatorFile(String xmlStr, String path) throws IOException, DocumentException {
		Document document = DocumentHelper.parseText(xmlStr);
		XMLWriter xmlWriter = new XMLWriter(new FileWriter(path));
		xmlWriter.write(document);
		xmlWriter.close();
	}
}
