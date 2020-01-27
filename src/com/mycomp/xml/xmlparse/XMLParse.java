package com.mycomp.xml.xmlparse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLParse {
    public static void main(String[] args)
            throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read("src/my.xml");
        Element rootElement = doc.getRootElement();
        Element stuEle = rootElement.addElement("student")
                .addAttribute("stuId", "s003");
        stuEle.addElement("name").setText("zzq3");
        stuEle.addElement("age").setText("86");
        stuEle.addElement("gender").setText("male");

        OutputFormat format = OutputFormat.createPrettyPrint();
        Writer wr = new OutputStreamWriter(new FileOutputStream("src/my.xml"),
                "UTF-8");
        XMLWriter writer = new XMLWriter(wr, format);
        writer.write(doc);
        wr.close();
    }
}
