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
		//1.����SAXReader
		SAXReader reader = new SAXReader();
        Document doc = reader.read("src\\com\\xml\\dom4j\\student.xml");
		//2.��ȡ��Ԫ��
        Element rootElement = doc.getRootElement();
		//3.����Ԫ�����Ԫ�غ����ԣ���������ӵ�Ԫ��
        Element stuEle = rootElement.addElement("student").addAttribute("number", "a0003");
		stuEle.addElement("name").setText("����");	 
		stuEle.addElement("age").setText("30");	 
		stuEle.addElement("sex").setText("��");	 
		
		 // Pretty print the document to System.out
        OutputFormat format = OutputFormat.createPrettyPrint();
        Writer wr = new OutputStreamWriter(new FileOutputStream("src/com/xml/dom4j/student.xml"),"UTF-8");
        XMLWriter writer = new XMLWriter(wr, format);
        writer.write( doc );
        wr.close();
		
	}
	
	static void test1() throws Exception {
		//��ȡ����ָ����ǩ����
        //1.����SAXReader
		SAXReader reader = new SAXReader();
        Document doc = reader.read("src\\com\\xml\\dom4j\\student.xml");
        //2.��ȡ��Ԫ��
        Element rootElement = doc.getRootElement();
        //3.�������ƻ�ȡ��Ԫ���µ����б�ǩ
        List<Element> stuList = rootElement.elements("student");
        //4.����ÿһ����Ԫ��
        for (Element stuEle : stuList) {
        	//5.��ȡָ�����Ƶ�Ԫ��
			 //Element nameEle = stuEle.element("name");
			 //System.out.println(nameEle.getText());
            //6.��ȡ��ǩ���е��ı�
        	//����ָ����ǩ��ȡ����
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
