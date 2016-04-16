package org.rssfeed;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class reader {
	String i,j,k;
public void getFeed(){
feeds f=new feeds();
try {
DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
Document doc = docBuilder.parse (new File("Feed.xml"));
doc.getDocumentElement ().normalize ();
System.out.println (doc.getDocumentElement().getNodeName()+"\n");


NodeList listOfFeeds = doc.getElementsByTagName("item");
int totalFeeds = listOfFeeds.getLength();
System.out.println("Total no of Feeds Extracted From XML : " + totalFeeds+"\n");

for(int s=0; s<listOfFeeds.getLength() ; s++)
{
Node firstNews = listOfFeeds.item(s);	

if(firstNews.getNodeType() == Node.ELEMENT_NODE)
{
Element News = (Element)firstNews; 


NodeList titleList = News.getElementsByTagName("title");
Element titleElement = (Element)titleList.item(0);
NodeList title = titleElement.getChildNodes();

NodeList linkList = News.getElementsByTagName("link");
Element linkElement = (Element)linkList.item(0);
NodeList link = linkElement.getChildNodes();


NodeList descriptionList = News.getElementsByTagName("description");
Element descriptionElement = (Element)descriptionList.item(0);
NodeList description = descriptionElement.getChildNodes();

i=title.item(0).getNodeValue();
f.setTitle(i);
f.getTitle();

j=link.item(0).getNodeValue();
f.setLink(j);
f.getLink();

k=description.item(0).getNodeValue();
f.setDescription(k);
f.getDescription();
//System.out.println(f.toString());
f.InsetRecord(i, j, k);

}//end of if clause
}//end of for loop
System.out.println("Successfully Inserted "+totalFeeds+" Records \n");
f.fetchData();
}//end of try
catch (SAXParseException err) 
{
System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
System.out.println(" " + err.getMessage ());
}
catch (SAXException e) 
{
Exception x = e.getException ();
((x == null) ? e : x).printStackTrace ();
}
catch (Throwable t) 
{
t.printStackTrace ();
}
	}//end of method
}//end of class
