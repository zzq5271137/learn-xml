package com.xml.dom4j;


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {
	public static void main(String[] args) throws Exception {
		//1.创建SAXReader
		SAXReader reader = new SAXReader();
        Document doc = reader.read("src\\com\\xml\\dom4j\\student.xml");
		//2.获取根元素
        Element rootElement = doc.getRootElement();
		//3.给根元素添加元素和属性，并返回添加的元素
        Element stuEle = rootElement.addElement("student").addAttribute("number", "a0003");
		stuEle.addElement("name").setText("王五");	 
		stuEle.addElement("age").setText("30");	 
		stuEle.addElement("sex").setText("男");	 
		
		 // Pretty print the document to System.out
        OutputFormat format = OutputFormat.createPrettyPrint();
        Writer wr = new OutputStreamWriter(new FileOutputStream("src/com/xml/dom4j/student.xml"),"UTF-8");
        XMLWriter writer = new XMLWriter(wr, format);
        writer.write( doc );
        wr.close();
		
	}
	
	static void test1() throws Exception {
		//获取所有指定标签内容
        //1.创建SAXReader
		SAXReader reader = new SAXReader();
        Document doc = reader.read("src\\com\\xml\\dom4j\\student.xml");
        //2.获取根元素
        Element rootElement = doc.getRootElement();
        //3.根据名称获取根元素下的所有标签
        List<Element> stuList = rootElement.elements("student");
        //4.遍历每一个子元素
        for (Element stuEle : stuList) {
        	//5.获取指定名称的元素
			 //Element nameEle = stuEle.element("name");
			 //System.out.println(nameEle.getText());
            //6.获取标签当中的文本
        	//根据指定标签获取内容
        	String name = stuEle.elementText("name");
        	String age = stuEle.elementText("age");
        	String sex = stuEle.elementText("sex");
        	System.out.println(name);
        	System.out.println(age);
        	System.out.println(sex);
        	String num = stuEle.attributeValue("number");
        	System.out.println(num);
        	System.out.println("------");
        	
		}
	}
	
	
}
