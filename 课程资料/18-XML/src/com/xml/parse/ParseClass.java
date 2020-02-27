package com.xml.parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseClass {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, Exception {
		/**
		 * 
		1.创建解析器工厂
		2.通过解析器工厂得到解析器
		3.通过解析器得到document对象
		4.获取具体的节点内容
		 * */
		// 1.创建解析器工厂
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// 2.通过解析器工厂得到解析器
		DocumentBuilder db = dbf.newDocumentBuilder();
		// 3.通过解析器得到document对象
		Document doc = db.parse("src/com/xml/parse/student.xml");
		// 获取具体的节点内容
		/*test1(doc);
		test2(doc);
		test3(doc);*/
		/*test4(doc);*/
		test5(doc);
	}

	static void test5(Document doc) throws Exception, TransformerFactoryConfigurationError {
		//1.获取要添加属性的节点
		Node stu = doc.getElementsByTagName("student").item(1);
		//2.把获取的节点强制转换成element
		Element ele = (Element)stu;
		//3.设置属性
		ele.setAttribute("ID", "00001");
		//4.从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/xml/parse/student.xml"));	
	}
	
	// 删除节点
	static void test4(Document doc) throws Exception, TransformerFactoryConfigurationError {
		// 1.获取一个节点
		Node addressNode = doc.getElementsByTagName("address").item(0);
		// 2.获取该节点的父节点，从父节点当中移除
		addressNode.getParentNode().removeChild(addressNode);
		// 3.从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/xml/parse/student.xml"));
	}

	// 添加节点
	static void test3(Document doc) throws Exception, TransformerFactoryConfigurationError {
		// 1.创建一个节点
		Element addressEle = doc.createElement("address");
		// 2.设置元素内容
		addressEle.setTextContent("地址1");
		// 3.获取要添加元素的父结点
		Node stuNode = doc.getElementsByTagName("student").item(0);
		// 4.添加节点
		stuNode.appendChild(addressEle);
		// 5.从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/xml/parse/student.xml"));
	}

	// 修改元素的内容
	static void test2(Document doc) throws TransformerFactoryConfigurationError, Exception {

		// 1.获取所有指定节点
		NodeList ageList = doc.getElementsByTagName("age");
		// 2.获取要修改的节点
		Node ageNode = ageList.item(1);
		// 3.修改元素内容
		ageNode.setTextContent("300");
		// 4.从内存写到文档做同步操作
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.transform(new DOMSource(doc), new StreamResult("src/com/xml/parse/student.xml"));
	}

	// 获取具体的节点内容
	static void test1(Document doc) {
		// 4.获取具体的节点内容
		NodeList list = doc.getElementsByTagName("name");
		Node name = list.item(1);
		System.out.println(name.getTextContent());
	}

}
